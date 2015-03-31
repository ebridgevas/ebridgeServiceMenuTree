//package com.ebridgevas.service.menutree.menu;
//
//import com.ebridgevas.service.menutree.dto.MenuItemDTO;
//import com.ebridgevas.service.menutree.dto.PayloadType;
//import com.ebridgevas.service.menutree.dto.Request;
//import com.ebridgevas.service.menutree.dto.Response;
//import com.ebridgevas.service.menutree.dto.TreeNode;
//import com.ebridgevas.service.menutree.dto.UserSession;
//import com.ebridgevas.service.menutree.processor.impl.NodeChildSelector;
//import com.ebridgevas.service.menutree.util.NodeTypeNotFoundException;
//import com.google.gson.Gson;
//
//import com.google.gson.internal.LinkedTreeMap;
//import com.google.gson.reflect.TypeToken;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.util.*;
//
///**
//* @author david@tekeshe.com
//*/
//public class JsonMenuDataWrapper { // implements MenuDataWrapper<MenuItemDTO> {
//
//    private TreeFactory treeFactory;
//
//    private TreeNode<MenuItemDTO> menuTree;
//
//    private String menuConfigFilename;
//    private String shortCode;
//
//
//    private Map<String, UserSession> userSessions;
//
//    private NodeChildSelector nodeChildSelector;
//
//    public JsonMenuDataWrapper( String menuConfigFilename, String shortCode ) throws NodeTypeNotFoundException {
//
//        userSessions = new HashMap<>();
//
//        this.menuConfigFilename = menuConfigFilename;
//        this.shortCode = shortCode;
//
//        menuTree = load();
//        new MenuTreeInstancesFactory().instantiate( menuTree, userSessions );
//        nodeChildSelector = new NodeChildSelector(null, null, userSessions);
//    }
//
//    public Response process( Request request ) {
//
//        // get node id
//        String nodeId = nodeId( request );
//
//        // find node from the menu tree
//        TreeNode<MenuItemDTO> node = menuTree.findTreeNode(new MenuItemDTO( nodeId ) );
//
//        try {
//            if ( request.getPayloadType() == PayloadType.SESSION_START ) {
//
//                // execute this node.
//                return node.data.getServiceCommandProcessor().process(request, node);
//            } else {
//
//                // if ussd answer. node is previous one.
//                // use payload to pick the selected node amount the children
//                return nodeChildSelector.process( request, node );
//            }
//        } catch (NodeTypeNotFoundException e) {
//            e.printStackTrace();
//            return Response.clone( request, e.getMessage(), "", true );
//        }
//    }
//
//
//    protected String nodeId ( Request request) {
//
//        if (request.getPayloadType() == PayloadType.SESSION_START ) {
//
//            return request.getDestinationId();
//        } else {
//            String nodeId = null;
//            try {
//                nodeId = userSessions.get(request.getSourceId()).getPreviousMenuUuid();
//            } catch (Exception e) {
//            }
//            // if no user session then default to root node.
//            return nodeId != null ? nodeId : request.getDestinationId();
//        }
//    }
//}
