package com.ebridgevas.servicemenutree.menu.processors.impl;

/**
 * @author david@tekeshe.com
 */

/**
 * Creates a set of menu items for a node.
 * A menu is a defined as a parent and its children.
 */
public class MenuProducer { // implements NodeProcessor {

//    private static final Logger logger = Logger.getLogger(MenuProducer.class);
//
//    /**
//     * Creates a set of menu items for a node.
//     * A menu is a defined as a parent and its children.
//     *
//     * @return set of menu items
//     */
//    @Override
//    public Set<MenuItemDTO> process( TreeNode<MenuItemDTO> node ) {
//
//        Set<MenuItemDTO> items = node.childSet();
//
//        String menu = null;
//
//        for ( MenuItemDTO item : items ) {
//
//            logger.debug( item.getMenuNarration() );
//
//            if ( menu == null ) menu = item.getMenuNarration() + "\n";
//            else menu += (item.getItemIndex() + ". " + item.getMenuNarration().trim() + "\n");
//        }
//
//        return menu;
//    }
}
