//package com.ebridgevas.service.menutree.processor.impl;
//
//import com.ebridge.vas.Request;
//import com.ebridge.vas.Response;
//import com.ebridge.vas.dto.BalanceDTO;
//import com.ebridge.vas.dto.ConfigDTO;
//import com.ebridge.vas.dto.LanguageDTO;
//import com.ebridge.vas.dto.MenuItemDTO;
//import com.ebridge.vas.kernel.EBridgeVasKernel;
//import com.ebridge.vas.dto.TreeNode;
//import com.ebridge.vas.dto.UserSession;
//import com.ebridge.vas.processors.ServiceCommandProcessor;
//
//import java.math.RoundingMode;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
///**
// * @author david@tekeshe.com
// */
//public class BalanceEnquiryProcessor implements ServiceCommandProcessor {
//
//    private EBridgeVasKernel ebridgeVasKernel;
//    private ConfigDTO vasConfigDTO;
//    private Map<String, UserSession> userSessions;
//
//    public BalanceEnquiryProcessor( EBridgeVasKernel ebridgeVasKernel,
//                                    ConfigDTO vasConfigDTO,
//                                    Map<String, UserSession> userSessions ) {
//        this.ebridgeVasKernel = ebridgeVasKernel;
//        this.vasConfigDTO = vasConfigDTO;
//        this.userSessions = userSessions;
//    }
//
//    @Override
//    public Response process( Request request, TreeNode<MenuItemDTO> node ) {
//
//        Map<String, String> map = new HashMap<>();
//
//        map.put("service-command", "get-mobile-account-list");
//        map.put("mobile-number", "263733803480");
//
//        Set<BalanceDTO> balances = ebridgeVasKernel.process( map );
//
//        return Response.clone( request, format(balances), null, Boolean.TRUE );
//    }
//
//    protected String format( Set<BalanceDTO> balances ) {
//
//        String formatted = "";
//
//        for (BalanceDTO balance : balances) {
//            LanguageDTO languageDTO = balance.getBalanceName();
//
//            formatted += (  languageDTO.getNormalizedValue() + " = " +
//                            balance.getBalance().setScale(2, RoundingMode.HALF_UP) +
//                            balance.getBalanceName().getUnitOfMeasure() + "." +
//                            String.format(" Exp on %1$te/%1$tm/%1$tY. ", balance.getExpiryDate() ) );
//        }
//
//        return formatted;
//    }
//}
