package com.ebridgevas.servicemenutree.menu.impl;

import com.ebridge.billingplatform.BillingPlatformInterface;
import com.ebridge.commons.dto.MenuItemDTO;
import com.ebridge.commons.dto.MenuItemType;
import com.ebridge.commons.dto.PayloadDTO;
import com.ebridge.commons.dto.PayloadType;
import com.ebridge.commons.util.ConnectionException;
import com.ebridgevas.messaging.MessagingService;
import com.ebridgevas.service.menutree.model.TreeNode;
import com.ebridgevas.service.messaging.impl.USSDResponseSender;
import com.ebridgevas.servicemenutree.dao.ServiceMenuTreeDAO;

import com.ebridgevas.servicemenutree.dao.stub.ServiceMenuTreeDAOStub;
import com.ebridgevas.servicemenutree.dto.UserSession;
import com.ebridgevas.servicemenutree.menu.ServiceMenuTree;
import static com.ebridgevas.servicemenutree.util.MenuTreeUtils.menu;
import com.google.inject.Inject;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import zw.co.telecel.billing.factory.PayloadGenerator;

import java.util.HashMap;
import java.util.Map;

import static com.ebridgevas.servicemenutree.util.MenuTreeUtils.findNodeByItemIndex;
//import static com.ebridgevas.servicemenutree.util.UssdUtils.prefix;

/**
 * @author david@tekeshe.com
 */
public class DatabaseBackedServiceMenuTree implements ServiceMenuTree {

    private static final Logger logger = Logger.getLogger(DatabaseBackedServiceMenuTree.class);

    private ServiceMenuTreeDAO dao;
    private Map<String, TreeNode<MenuItemDTO>> serviceMenuTrees;
    private Map<String, PayloadGenerator> payloadGenerators;
    private final Map<String, UserSession> userSessions;

//    private BillingPlatformInterface billingPlatformInterface;

    @Inject
    public DatabaseBackedServiceMenuTree(){

        BasicConfigurator.configure();
        userSessions = new HashMap<>();

        dao = new ServiceMenuTreeDAOStub();

        serviceMenuTrees = new HashMap<>();
        payloadGenerators = new HashMap<>();

        dao.read(serviceMenuTrees, payloadGenerators);
    }

    @Override
    public void readTree() {
        serviceMenuTrees = new HashMap<>();
        payloadGenerators = new HashMap<>();

        dao.read(serviceMenuTrees, payloadGenerators);
    }

    @Override
    public PayloadDTO process( String rawPayload ) {

        // Parse payload
        PayloadDTO payload = PayloadDTO.instance(rawPayload);
        if ( payload == null)
            return null;

        // Get menu tree for this short code
        TreeNode<MenuItemDTO> tree = serviceMenuTrees.get(payload.getUssdShortCode());

        // Is session start?
        if ( payload.getPayloadType() == PayloadType.SESSION_START ) {

            // Session start. Return root node.

            // Is short code defined.
            if (tree == null) {
                // TODO read from database
                return null;
            } else {

                return route( payload, tree );
            }
        } else if ( payload.getPayloadType() == PayloadType.SUBSCRIBER_ANSWER ) {

            try {
                // Get previous node
                UserSession userSession = userSessions.get(payload.getMobileNumber());
                if (userSession == null) {

                    return route( payload, tree );
                }

                MenuItemDTO searchToken
                        = new MenuItemDTO( userSession.getCurrentNodeId() );
                TreeNode<MenuItemDTO> previousNode = tree.findTreeNode(searchToken);

                // Find selected node using node index supplied by user
                TreeNode<MenuItemDTO> selectedNode
                        = findNodeByItemIndex(payload.getUssdUserInput(), previousNode.children);

                return route(payload, selectedNode);
            } catch(Exception e) {
                return null;
            }
        } else {
            return null;
        }
    }

    public UserSession getUserSession( String mobileNumber ) {
        return userSessions.get(mobileNumber);
    }

    protected PayloadDTO route(PayloadDTO payload, TreeNode<MenuItemDTO> node) {

        payload.setPayloadProcessorEndPoint(node.data.getPayloadProcessorEndPoint());
        if (node.data.getMenuItemType() == MenuItemType.MENU_FACTORY) {

            payload.setShortMessage(menu(node));
            // Store session in memory
            userSessions.put( payload.getMobileNumber(),
                    new UserSession(payload.getMobileNumber(), node.data.getMenuId()));
        } else if (node.data.getMenuItemType() == MenuItemType.EXTERNAL_PROCESSOR) {
            payload.setTransactionType(node.data.getTransactionType());
            payload.setProductID(node.data.getItemIndex());
            userSessions.remove(payload.getMobileNumber());
        }

        return payload;
    }

    public static void main(String[] args) {

        ServiceMenuTree service = new DatabaseBackedServiceMenuTree();

        String input = "901 33495 263733803480 80";
        PayloadDTO result = service.process(input);

        System.out.println( result.getShortMessage() );

        input = "901 33495 263733803480 74 2";
        result = service.process(input);
        System.out.println( result.getShortMessage() );

        input = "901 33495 263733803480 74 2";
        result = service.process(input);
        System.out.println( result.getShortMessage() );

//        input = "901 32802 263733803480 74 4";
//        result = service.process(input);
//        System.out.println( result );
    }
}
