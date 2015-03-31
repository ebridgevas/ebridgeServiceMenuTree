//package com.ebridgevas.service.menutree;
//
////import com.ebridge.smpp.pdu.DeliverSM;
////import com.ebridge.smpp.pdu.SubmitSM;
////import com.ebridge.smpp.pdu.WrongLengthOfStringException;
////import com.ebridge.vas.Request;
////import com.ebridge.vas.Response;
////import com.ebridge.vas.dto.ConfigDTO;
////import com.ebridge.vas.dto.MenuItemDTO;
////import com.ebridge.vas.dto.ShortCodeConfigDTO;
////import com.ebridge.vas.factory.UssdPDUFactory;
////import com.ebridge.vas.factory.halys.HalysUssdPDUFactory;
////import com.ebridge.vas.menu.JsonMenuDataWrapper;
////import com.ebridge.vas.menu.MenuDriver;
////import com.ebridge.vas.dto.TreeNode;
////import com.ebridge.vas.parsers.PayloadParser;
////import com.ebridge.vas.parsers.halys.util.PayloadType;
////import com.ebridge.vas.util.JsonConfigurationService;
////import com.ebridge.vas.util.NodeTypeNotFoundException;
////import com.ebridge.vas.util.PDUParseException;
////import org.junit.Before;
////import org.junit.Test;
////
////import java.lang.reflect.Constructor;
////import java.text.SimpleDateFormat;
////import java.util.Date;
////
////import static com.ebridge.vas.util.SmppUtils.deliverSM;
////import static com.ebridge.vas.util.Utils.submitSM;
////import static junit.framework.TestCase.assertEquals;
////import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
////import static org.junit.Assert.assertThat;
//
////import org.junit.Before;
////import org.junit.Test;
//
//import com.ebridgevas.service.menutree.dto.ConfigDTO;
//import com.ebridgevas.service.menutree.dto.ShortCodeConfigDTO;
//import com.ebridgevas.service.menutree.menu.JsonMenuDataWrapper;
//import com.ebridgevas.service.menutree.util.JsonConfigurationService;
//import com.ebridgevas.service.menutree.util.NodeTypeNotFoundException;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.lang.reflect.Constructor;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
//import static org.junit.Assert.assertThat;
//
///**
// * @author david@tekeshe.com
// */
//public class FileBackedServiceMenuTreeTest {
//
//    private JsonMenuDataWrapper menuTreeWrapper;
////
////    private PayloadParser parser;
////    private UssdPDUFactory factory;
////
//    private ConfigDTO vasConfigDTO;
//
//    @Before
//    public void setup() throws NodeTypeNotFoundException {
//
//        String shortCode = System.getProperty("shortCode");
//        String vasConfigFilename = System.getProperty("vasConfigFilename");
//        String menuConfigFilename = System.getProperty("menuConfigFilename");
//
//        JsonConfigurationService configurationService
//                = new JsonConfigurationService();
//
//        vasConfigDTO = configurationService.config(vasConfigFilename);
//
//        menuTreeWrapper = new JsonMenuDataWrapper(menuConfigFilename, "26373");
//
//        ShortCodeConfigDTO shortCodeParameters
//                = vasConfigDTO.getShortCodeParameters().get(shortCode);
//
//        try {
//            Constructor constructor =
//                    Class.forName(shortCodeParameters.getPayloadParser())
//                            .getConstructor(ShortCodeConfigDTO.class);
//            parser = (PayloadParser) constructor.newInstance(shortCodeParameters);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        factory = new HalysUssdPDUFactory();
//    }
//
//    @Test
//    public void testMainMenu( ) {
//
//        String input = "971 33495 263733803480 80";
//
//        String expected = "971 33495 263733803480 72 30000 " +
//                          "Welcome to Telecel DATA bundles.\n" +
//                          "Please select either 1 or 2\n" +
//                          "1. Balance enquiry\n" +
//                          "2. Buy my DATA bundle";
//
//        Response response = menuTreeWrapper.process(request);
////
//        String actual = "";
//        assertThat(actual, equalToIgnoringWhiteSpace(expected));
//    }
//
//    @Test
//    public void testBalanceEnquiry() {
//
//        // main menu
//
//        String input = "971 33495 263733803480 80";
//
//        String expected = "971 33495 263733803480 72 30000 " +
//                "Welcome to Telecel DATA bundles.\n" +
//                "Please select either 1 or 2\n" +
//                "1. Balance enquiry\n" +
//                "2. Buy my DATA bundle";
//        String actual = "";
////        Response response = menuTreeWrapper.process(request);
////
////        SubmitSM actual = factory.submitSM(response);
//        assertThat(actual, equalToIgnoringWhiteSpace(expected));
//
//        // balance enquiry
//
//        input = "971 33495 263733803480 74 1";
//
//        String date = new SimpleDateFormat("15/03/2015").format(new Date());
//
//        expected = "971 33495 263733803480 81 " +
//                        "Airtime bal = 11.49usd. Exp on " + date + ". Data Bundle = 11.49mb. Exp on " + date + ".";
//
////        request = parser.parse(input);
////        response = menuTreeWrapper.process(request);
//        actual = "";
//        assertThat(actual, equalToIgnoringWhiteSpace(expected));
//    }
//
//    @Test
//    public void testDataBundleOfferListing() {
//
//        // main menu
//        String input = "971 33495 263733803480 80";
//
//        String expected = "971 33495 263733803480 72 30000 " +
//                "Welcome to Telecel DATA bundles.\n" +
//                "Please select either 1 or 2\n" +
//                "1. Balance enquiry\n" +
//                "2. Buy my DATA bundle";
//        String actual = "";
////        Response response = menuTreeWrapper.process(request);
////
////        SubmitSM actual = factory.submitSM(response);
//        assertThat(actual, equalToIgnoringWhiteSpace(expected));
//
//        // data bundle price listing
//
//        input = "971 33495 263733803480 74 2";
//        expected = "971 33495 263733803480 72 30000 " +
//                        "Select bundle 1 to 8 " +
//                        "1. 50c for 4.8MB\n" +
//                        "2. $1  for 9.5MB\n" +
//                        "3. $3  for 76MB\n" +
//                        "4. $5  for 142.5MB\n" +
//                        "5. $10 for 304MB\n" +
//                        "6. $20 for 800MB\n" +
//                        "7. $45 for 2000MB\n" +
//                        "8. $75 for 4000MB\n";
//
////        request = parser.parse(input);
////        response = menuTreeWrapper.process(request);
//        actual = "";
//        assertThat(actual, equalToIgnoringWhiteSpace(expected));
//    }
//
//    @Test
//    public void testDataBundlePurchase() {
//
//        // main menu
//        String input = "971 32802 263733803480 80";
//
//        String expected = "971 32802 263733803480 72 30000 " +
//                "Welcome to Telecel DATA bundles.\n" +
//                "Please select either 1 or 2\n" +
//                "1. Balance enquiry\n" +
//                "2. Buy my DATA bundle";
//        String actual = "";
////        Response response = menuTreeWrapper.process(request);
////
////        SubmitSM actual = factory.submitSM(response);
//        assertThat(actual, equalToIgnoringWhiteSpace(expected));
//
//        // data bundle price listing
//
//        input = "971 32802 263733803480 74 2";
//
//        expected = "971 32802 263733803480 72 30000 " +
//                "Select bundle 1 to 8 " +
//                "1. 50c for 4.8MB\n" +
//                "2. $1  for 9.5MB\n" +
//                "3. $3  for 76MB\n" +
//                "4. $5  for 142.5MB\n" +
//                "5. $10 for 304MB\n" +
//                "6. $20 for 800MB\n" +
//                "7. $45 for 2000MB\n" +
//                "8. $75 for 4000MB\n";
//
////        request = parser.parse(input);
////        response = menuTreeWrapper.process(request);
//        actual = "";
//        assertThat(actual, equalToIgnoringWhiteSpace(expected));
//
//        // bundle purchase
//        input = "971 32802 263733803480 74 4";
//
//        expected = "971 32802 263733803480 81 0 " +
//                    "You have bought the 76.00mb bundle. Your main balance is now 6.49usd. " +
//                    "Your data balance is 142.50mb exp on 02/02/2015";
//
////        request = parser.parse(input);
////        response = menuTreeWrapper.process( request );
//        actual = "";
//        assertThat( slice(actual, 10), equalToIgnoringWhiteSpace(slice(expected, 10) ));
//    }
//
//    protected String slice(String input, Integer offset) {
//        return input.substring(0, (input.length() - offset));
//    }
//}