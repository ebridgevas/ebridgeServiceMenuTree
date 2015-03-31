//package com.ebridgevas.service.menutree.menu;
//
//import com.ebridgevas.service.menutree.dto.ConfigDTO;
//import com.ebridgevas.service.menutree.dto.MenuItemDTO;
//import com.ebridgevas.service.menutree.dto.TreeNode;
//import com.ebridgevas.service.menutree.dto.UserSession;
//import com.ebridgevas.service.menutree.processor.ServiceCommandProcessor;
//import com.ebridgevas.service.menutree.util.JsonConfigurationService;
//import com.ebridgevas.service.messaging.MessagingService;
//import com.ebridgevas.service.messaging.stub.MessagingServiceStub;
//
//import java.lang.reflect.Constructor;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author david@tekeshe.com
// */
//public class MenuTreeInstancesFactory {
//
//    private final static MessagingService messagingService;
//    private final static ConfigDTO configDTO;
//
//    static {
//        messagingService = new MessagingServiceStub();
//        configDTO = new JsonConfigurationService().config(
//                "/Users/david/workspace/telecel/ebridgeSmppConnector/resources/conf/vas.conf");
//    }
//
//    public void instantiate(TreeNode<MenuItemDTO> root, Map<String, UserSession> userSessions) {
//
//        instantiate( root.data, userSessions );
//        instantiate(root.children, userSessions );
//    }
//
//    protected void instantiate( List<TreeNode<MenuItemDTO>> nodes, Map<String, UserSession> userSessions ) {
//
//        List<TreeNode<MenuItemDTO>> children = new ArrayList<>();
//
//        for ( TreeNode<MenuItemDTO> node : nodes) {
//            instantiate( node.data, userSessions );
//            if ( ! node.isLeaf() ) {
//                children.addAll(node.children);
//            }
//        }
//
//        if ( children.size() > 0 ) {
//            instantiate(children, userSessions);
//        }
//    }
//
//    protected void instantiate(MenuItemDTO item, Map<String, UserSession> userSessions) {
//
//        try {
//
//            Constructor constructor
//                    = Class.forName(item.getItemProcessorName())
//                                .getConstructor(
//                                        MessagingService.class,
//                                        ConfigDTO.class,
//                                        Map.class );
//
//            item.setServiceCommandProcessor((ServiceCommandProcessor)
//                    constructor.newInstance(messagingService, configDTO, userSessions ) );
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
