package com.ebridgevas.service.menutree.processor;

        import com.ebridge.commons.dto.MenuItemDTO;
        import com.ebridgevas.service.menutree.dto.Request;
        import com.ebridgevas.service.menutree.dto.Response;
        import com.ebridgevas.service.menutree.model.TreeNode;
        import com.ebridgevas.service.menutree.util.NodeTypeNotFoundException;

/**
 * @author david@tekeshe.com
 */

public interface ServiceCommandProcessor {

    Response process(Request request, TreeNode<MenuItemDTO> node) throws NodeTypeNotFoundException;
}
