//package com.ebridgevas.service.menutree.processor.impl;
//
//import com.ebridgevas.service.menutree.dto.*;
//import com.ebridgevas.service.menutree.dto.TreeNode;
//import com.ebridgevas.service.menutree.dto.UserSession;
//import com.ebridgevas.service.menutree.service.BillingService;
//import com.ebridgevas.service.menutree.util.NodeTypeNotFoundException;
//
//import java.util.Map;
//
///**
//* @author david@tekeshe.com
//*/
//public class NodeChildSelector extends NodeProcessor {
//
//    public NodeChildSelector(
//            BillingService billingService,
//            ConfigDTO configDTO,
//            Map<String, UserSession> userSessions) {
//
//        super(billingService, configDTO, userSessions );
//    }
//
//    public Response process( Request request, TreeNode<MenuItemDTO> node )
//                throws NodeTypeNotFoundException {
//
//        for ( TreeNode<MenuItemDTO> childNode : node.children ) {
//
//            if ( request.getPayload().trim().toLowerCase().startsWith(
//                        childNode.data.getItemFilter().trim().toLowerCase())) {
//                return childNode.data.getServiceCommandProcessor().process(request, childNode );
//            }
//        }
//
//        throw new NodeTypeNotFoundException("Node for filter : " + request.getPayload() +
//                       " for short code : " + request.getDestinationId() + " not found.");
//    }
//
//    @Override
//    public ServiceResponse process(ServiceRequest serviceRequest) throws Exception {
//        return null;
//    }
//}
