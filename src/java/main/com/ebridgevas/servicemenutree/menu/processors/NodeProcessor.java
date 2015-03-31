package com.ebridgevas.servicemenutree.menu.processors;

import com.ebridge.commons.dto.MenuItemDTO;
import com.ebridgevas.service.menutree.model.TreeNode;

/**
 * @author david@tekeshe.com
 */
public interface NodeProcessor {

    public String process( TreeNode<MenuItemDTO> node );
}
