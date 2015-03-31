package com.ebridgevas.servicemenutree.menu;

import com.ebridge.commons.dto.MenuItemDTO;
import com.ebridge.commons.dto.MenuItemType;
import com.ebridge.commons.dto.PayloadDTO;
import com.ebridge.commons.dto.PayloadType;
import com.ebridge.commons.util.XmlUtils;
import com.ebridgevas.messaging.MessagingService;
import com.ebridgevas.messaging.xmpp.XmppMessagingService;
import com.ebridgevas.service.menutree.model.TreeNode;
import com.ebridgevas.servicemenutree.inject.ServiceMenuTreeTestModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.jivesoftware.smack.Chat;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import static com.ebridgevas.servicemenutree.util.UssdUtils.prefix;
import static com.ebridgevas.servicemenutree.util.MenuTreeUtils.menu;

import static com.ebridge.commons.util.XmlUtils.toXml;

/**
 * @author david@tekeshe.com
 */
public class ServiceMenuTreeTest {

    ServiceMenuTree serviceMenuTree;

//    MessagingService messagingService;


    @Before
    public void setup() {
        Injector injector = Guice.createInjector(new ServiceMenuTreeTestModule());
        serviceMenuTree = injector.getInstance(ServiceMenuTree.class);
        serviceMenuTree.readTree();
//        messagingService = new XmppMessagingService();
//        messagingService = serviceMenuTree.getMessagingService();
    }

    @Test
    public void testMainMenu( ) {

        String input = "901 33495 263733803480 80";

        String expected = "901 33495 263733803480 72 30000 " +
                          "Welcome to Telecel DATA bundles.\n" +
                          "Please select either 1 or 2\n" +
                          "1. Balance enquiry\n" +
                          "2. Buy my DATA bundle";

        String actual = null;

        PayloadDTO result = serviceMenuTree.process(input);
//        if ( result.data.getMenuItemType() == MenuItemType.MENU_FACTORY ) {
//            actual = prefix() + menu(result);
//        }
//
//        assertThat(actual, equalToIgnoringWhiteSpace(expected));
//        assertEquals("1000000", serviceMenuTree.getUserSession("263733803480").getCurrentNodeId());
    }

    @Test
    public void testBalanceEnquiry() {

        while ( true ) {

            // main menu

            String input = "901 33495 263733803480 80";

            String expected = "" + //901 33495 263733803480 72 30000 " +
                    "Welcome to Telecel DATA bundles.\n" +
                    "Please select either 1 or 2\n" +
                    "1. Balance enquiry\n" +
                    "2. Buy my DATA bundle";

            String actual = null;

            PayloadDTO result = serviceMenuTree.process(input);


    //        assertThat(result.getShortMessage(), equalToIgnoringWhiteSpace(expected));
    //        assertEquals("1000000", serviceMenuTree.getUserSession("263733803480").getCurrentNodeId());

            // balance enquiry

            input = "901 33495 263733803480 74 1";

//        // --- parse user input
//        Payload payload = Payload.instance(input);
//        assertEquals("1", payload.getUssdUserInput() );
//        assertEquals(PayloadType.SESSION_CONTINUE, payload.getPayloadType());


//            result = serviceMenuTree.process(input);
//            String payload = XmlUtils.toXml(result, Payload.class);
//            System.out.println( "--->\n" + payload );
//
//            String participantID = result.getPayloadProcessorEndPoint();
//            System.out.print("Is " + participantID + " online ..... ");
//            Chat chat = serviceMenuTree.getChat(participantID + "/value-added-service");
//            if (chat == null) {
//                System.out.println("No. Bouncing message.");
//                try { Thread.sleep(15000); } catch (InterruptedException e) {}
//                continue;
//            }

            System.out.println("Yes. Sending message message ....");

//            messagingService.sendMessage( payload, chat );

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // TODO implement Router
//        assertEquals( "1000002", result.data.getMenuId() );
//
//        if (result.data.getMenuItemType() == MenuItemType.EXTERNAL_PROCESSOR) {
////            System.out.println( toXml( payload, ) );
//        }

//        String date = new SimpleDateFormat("15/03/2015").format(new Date());
//
//        expected = "971 33495 263733803480 81 " +
//                        "Airtime bal = 11.49usd. Exp on " + date + ". Data Bundle = 11.49mb. Exp on " + date + ".";
//
//        actual = "";
//        assertThat(actual, equalToIgnoringWhiteSpace(expected));
    }

    @Test
    public void testDataBundleOfferListing() {

        // main menu

        String input = "901 33495 263733803480 80";

        String expected = "901 33495 263733803480 72 30000 " +
                "Welcome to Telecel DATA bundles.\n" +
                "Please select either 1 or 2\n" +
                "1. Balance enquiry\n" +
                "2. Buy my DATA bundle";

        String actual = null;

        PayloadDTO result = serviceMenuTree.process(input);
//        if ( result.data.getMenuItemType() == MenuItemType.MENU_FACTORY ) {
//            actual = prefix() + menu(result);
//        }

        assertThat(result.getShortMessage(), equalToIgnoringWhiteSpace(expected));
        // data bundle price listing

        input = "901 33495 263733803480 74 2";
        expected = "901 33495 263733803480 72 30000 " +
                        "Select bundle 1 to 8 " +
                        "1. 50c for 4.8MB\n" +
                        "2. $1  for 9.5MB\n" +
                        "3. $3  for 76MB\n" +
                        "4. $5  for 142.5MB\n" +
                        "5. $10 for 304MB\n" +
                        "6. $20 for 800MB\n" +
                        "7. $45 for 2000MB\n" +
                        "8. $75 for 4000MB\n";

//        result = serviceMenuTree.process(input);
//
//        System.out.println(result.getShortMessage());
//
//        assertThat(result.getShortMessage(), equalToIgnoringWhiteSpace(expected));


    }

    @Test
    public void testDataBundlePurchase() {

        // main menu

        String input = "901 33495 263733803480 80";

        String expected = "901 33495 263733803480 72 30000 " +
                "Welcome to Telecel DATA bundles.\n" +
                "Please select either 1 or 2\n" +
                "1. Balance enquiry\n" +
                "2. Buy my DATA bundle";

        String actual = null;

        PayloadDTO result = serviceMenuTree.process(input);
//        if ( result.data.getMenuItemType() == MenuItemType.MENU_FACTORY ) {
//            actual = prefix() + menu(result);
//        }

        assertThat(result.getShortMessage(), equalToIgnoringWhiteSpace(expected));
        // data bundle price listing

        input = "901 33495 263733803480 74 2";
        expected = "901 33495 263733803480 72 30000 " +
                "Select bundle 1 to 8 " +
                "1. 50c for 4.8MB\n" +
                "2. $1  for 9.5MB\n" +
                "3. $3  for 76MB\n" +
                "4. $5  for 142.5MB\n" +
                "5. $10 for 304MB\n" +
                "6. $20 for 800MB\n" +
                "7. $45 for 2000MB\n" +
                "8. $75 for 4000MB\n";

        result = serviceMenuTree.process(input);

        System.out.println(result.getShortMessage());

        assertThat(result.getShortMessage(), equalToIgnoringWhiteSpace(expected));

        // bundle purchase
        input = "901 32802 263733803480 74 4";

//        expected = "971 32802 263733803480 81 0 " +
//                    "You have bought the 76.00mb bundle. Your main balance is now 6.49usd. " +
//                    "Your data balance is 142.50mb exp on 02/02/2015";
//
//        actual = "";
//        assertThat( slice(actual, 10), equalToIgnoringWhiteSpace(slice(expected, 10) ));

        result = serviceMenuTree.process(input);
        System.out.println( XmlUtils.toXml(result, PayloadDTO.class) );
    }

    protected String slice(String input, Integer offset) {
        return input.substring(0, (input.length() - offset));
    }
}
