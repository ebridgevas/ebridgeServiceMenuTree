package com.ebridgevas.servicemenutree.factory;

import com.ebridge.commons.dto.MenuItemDTO;
import com.ebridge.commons.dto.PayloadDTO;
import com.ebridgevas.service.menutree.model.TreeNode;
import zw.co.telecel.billing.factory.PayloadGenerator;

import java.util.Set;

/**
 * @author david@tekeshe.com
 */
public class ServiceMenuGenerator implements PayloadGenerator<String, PayloadDTO,  TreeNode<MenuItemDTO>> {

    @Override
    public String generate( PayloadDTO input, TreeNode<MenuItemDTO> node) {

        Set<MenuItemDTO> items = node.childSet();

        String menu = null;

        for ( MenuItemDTO item : items ) {

            if ( menu == null ) menu = item.getMenuNarration() + "\n";
            else menu += (item.getItemIndex() + ". " + item.getMenuNarration().trim() + "\n");
        }

        return menu;
    }
}
