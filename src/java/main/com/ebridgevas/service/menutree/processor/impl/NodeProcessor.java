//package com.ebridgevas.service.menutree.processor.impl;
//
//import com.ebridgevas.service.menutree.dto.ConfigDTO;
//import com.ebridgevas.service.menutree.dto.MenuItemIndex;
//import com.ebridgevas.service.menutree.dto.UserSession;
//import com.ebridgevas.service.menutree.processor.ServiceCommandProcessor;
//import com.ebridgevas.service.menutree.service.BillingService;
//
//import java.util.Map;
//
///**
//* @author david@tekeshe.com
//*/
//public abstract class NodeProcessor implements ServiceCommandProcessor {
//
//    private BillingService billingService;
//    private ConfigDTO configDTO;
//    private Map<MenuItemIndex, ServiceCommandProcessor> leafInstanceMap;
//    protected Map<String, UserSession> userSessions;
//
//    public NodeProcessor( BillingService billingService,
//                          ConfigDTO configDTO,
//                          Map<String, UserSession> userSessions ) {
//
//        if ( billingService != null ) {
//            this.billingService = billingService;
//        }
//
//        if ( configDTO != null ) {
//            this.configDTO = configDTO;
//        }
//
//        if ( userSessions != null ) {
//            this.userSessions = userSessions;
//        }
//    }
//}
