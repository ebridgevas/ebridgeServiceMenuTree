package com.ebridgevas.servicemenutree.util;

import com.ebridge.commons.dto.MenuItemDTO;
import com.ebridgevas.service.menutree.model.TreeNode;

import java.util.List;
import java.util.Set;

/**
 * @author david@tekeshe.com
 */
public class MenuTreeUtils {

    public static String menu( TreeNode<MenuItemDTO> node ) {

        Set<MenuItemDTO> items = node.childSet();

        String menu = null;

        for ( MenuItemDTO item : items ) {

            if ( menu == null ) menu = item.getMenuNarration() + "\n";
            else menu += (item.getItemIndex() + ". " + item.getMenuNarration().trim() + "\n");
        }

        return menu;
    }

    public static TreeNode<MenuItemDTO> findNodeByItemIndex(String itemIndex, List<TreeNode<MenuItemDTO>> nodes) {

        for ( TreeNode<MenuItemDTO> node : nodes) {
            if (itemIndex.equals( node.data.getItemIndex())) {
                return node;
            }
        }

        return null;
    }
}
