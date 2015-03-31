package com.ebridgevas.servicemenutree.stub;

import com.ebridge.commons.dto.MenuItemDTO;
import com.ebridge.commons.dto.MenuItemType;
import com.ebridgevas.service.menutree.model.TreeNode;
import com.ebridgevas.servicemenutree.dao.ServiceMenuTreeDAO;
import com.ebridgevas.servicemenutree.factory.ServiceMenuGenerator;
import zw.co.telecel.billing.factory.BalanceEnquiryPayloadGenerator;
import zw.co.telecel.billing.factory.PayloadGenerator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author david@tekeshe.com
 */
public class ServiceMenuTreeDAOStub implements ServiceMenuTreeDAO {

    /*
       public MenuItemDTO(
            String menuId,
            String parentId,
            String itemIndex,
            MenuItemType menuItemType,
            String menuNarration,
            String itemFilter,
            String itemProcessorName,
            String payloadGeneratorName,
            String payloadProcessorEndPoint) {
     */
    @Override
    public void read( Map<String, TreeNode<MenuItemDTO>> trees, Map<String, PayloadGenerator> generators) {

        MenuItemDTO shortCode901
                = new MenuItemDTO("1000000", "0","0", MenuItemType.MENU_FACTORY,"menuNarration","filter",
                                    "", "com.ebridgevas.servicemenutree.factory.ServiceMenuGenerator",
                                    "zw.co.telecel.msc.ussdgw");

        TreeNode<MenuItemDTO> tree = new TreeNode<>(shortCode901);

        tree.addChild(
                new MenuItemDTO("1000001", "1000000","0", MenuItemType.LABEL,
                        "Welcome to Telecel DATA bundles.\nPlease select either 1 or 2\n",
                        "","", "", ""));

        tree.addChild(new MenuItemDTO("1000002", "1000000","1", MenuItemType.EXTERNAL_PROCESSOR,
                "Balance enquiry",
                "filter",
                "BALANCE_ENQUIRY","zw.co.telecel.billing.factory.BalanceEnquiryPayloadGenerator",
                "zw.co.telecel.billing.prepaid.zte@localhost"));

        MenuItemDTO buyBundle =
                    new MenuItemDTO( "1000003", "1000000","2", MenuItemType.MENU_FACTORY,
                                        "Buy my DATA bundle",
                                        "itemField","zw.co.telecel.billing.prepaid.BalanceEnquiry", "", "");
//        tree.addChild(new MenuItemDTO("1000003", "1000000","2", MenuItemType.MENU_FACTORY,
//                "Buy my DATA bundle",
//                "itemField","zw.co.telecel.billing.prepaid.BalanceEnquiry", "", ""));
        tree.addChild( buyBundle );

        TreeNode<MenuItemDTO> buyBundleNode = tree.findTreeNode(buyBundle);
        
        buyBundleNode.addChild(
                new MenuItemDTO("1000004", "1000003", "0", MenuItemType.LABEL,
                        "Select bundle 1 to 8", "", "", "", "" ));

        buyBundleNode.addChild(
                new MenuItemDTO("1000005", "1000000","1", MenuItemType.EXTERNAL_PROCESSOR,
                        "50c for 4.8MB",
                        "filter",
                        "DATA_BUNDLE_PURCHASE","",
                        "zw.co.telecel.billing.prepaid.zte.production"));

        buyBundleNode.addChild(
                new MenuItemDTO("1000006", "1000000","2", MenuItemType.EXTERNAL_PROCESSOR,
                        "$1  for 9.5MB",
                        "filter",
                        "DATA_BUNDLE_PURCHASE","",
                        "zw.co.telecel.billing.prepaid.zte.production"));

        buyBundleNode.addChild(
                new MenuItemDTO("1000007", "1000000","3", MenuItemType.EXTERNAL_PROCESSOR,
                        "$3  for 76MB",
                        "filter",
                        "DATA_BUNDLE_PURCHASE","",
                        "zw.co.telecel.billing.prepaid.zte.production"));

        buyBundleNode.addChild(
                new MenuItemDTO("1000008", "1000000","4", MenuItemType.EXTERNAL_PROCESSOR,
                        "$5  for 142.5MB",
                        "filter",
                        "DATA_BUNDLE_PURCHASE","",
                        "zw.co.telecel.billing.prepaid.zte.production"));

        buyBundleNode.addChild(
                new MenuItemDTO("1000009", "1000000","5", MenuItemType.EXTERNAL_PROCESSOR,
                        "$10 for 304MB",
                        "filter",
                        "DATA_BUNDLE_PURCHASE","",
                        "zw.co.telecel.billing.prepaid.zte.production"));

        buyBundleNode.addChild(
                new MenuItemDTO("1000010", "1000000","6", MenuItemType.EXTERNAL_PROCESSOR,
                        "$20 for 800MB",
                        "filter",
                        "DATA_BUNDLE_PURCHASE","",
                        "zw.co.telecel.billing.prepaid.zte.production"));

        buyBundleNode.addChild(
                new MenuItemDTO("1000011", "1000000","7", MenuItemType.EXTERNAL_PROCESSOR,
                        "$45 for 2000MB",
                        "filter",
                        "DATA_BUNDLE_PURCHASE","",
                        "zw.co.telecel.billing.prepaid.zte.production"));

        buyBundleNode.addChild(
                new MenuItemDTO("1000012", "1000000","8", MenuItemType.EXTERNAL_PROCESSOR,
                        "$75 for 4000MB",
                        "filter",
                        "DATA_BUNDLE_PURCHASE","",
                        "zw.co.telecel.billing.prepaid.zte.production"));
        /*
            expected = "971 33495 263733803480 72 30000 " +
                        "Select bundle 1 to 8 " +
                        "1. 50c for 4.8MB\n" +
                        "2. $1  for 9.5MB\n" +
                        "3. $3  for 76MB\n" +
                        "4. $5  for 142.5MB\n" +
                        "5. $10 for 304MB\n" +
                        "6. $20 for 800MB\n" +
                        "7. $45 for 2000MB\n" +
                        "8. $75 for 4000MB\n";
         */

                        trees.put("901", tree);


    }
}
