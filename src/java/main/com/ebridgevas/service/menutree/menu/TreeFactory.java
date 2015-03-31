//package com.ebridgevas.service.menutree.menu;
//
//import com.ebridgevas.service.menutree.dto.MenuItemDTO;
//import com.ebridgevas.service.menutree.dto.ServiceRequest;
//import com.ebridgevas.service.menutree.dto.TreeNode;
//import com.ebridgevas.service.menutree.util.NodeTypeNotFoundException;
//
//import java.util.Map;
//
///**
// * @author david@tekeshe.com
// */
//public interface TreeFactory {
//
//    public TreeNode<MenuItemDTO> tree();
//
//    public Map<String, Map<String, MenuItemDTO>> map();
//
//    public TreeNode<MenuItemDTO> child(String filter, TreeNode<MenuItemDTO> node)
//                throws NodeTypeNotFoundException;
//
//    public String nodeId(ServiceRequest request);
//}
