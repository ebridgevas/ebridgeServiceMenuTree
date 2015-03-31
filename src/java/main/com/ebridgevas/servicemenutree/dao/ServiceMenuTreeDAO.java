package com.ebridgevas.servicemenutree.dao;

import com.ebridge.commons.dto.MenuItemDTO;
import com.ebridgevas.service.menutree.model.TreeNode;
import zw.co.telecel.billing.factory.PayloadGenerator;

import java.util.Map;

/**
 * @author david@tekeshe.com
 */
public interface ServiceMenuTreeDAO {

    public void read( Map<String, TreeNode<MenuItemDTO>> serviceMenuTrees,
                        Map<String, PayloadGenerator> payloadGenerators);
}
