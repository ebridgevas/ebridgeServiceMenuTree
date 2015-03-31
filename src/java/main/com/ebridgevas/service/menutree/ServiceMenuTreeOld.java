//package com.ebridgevas.service.menutree;
//
//import com.ebridge.commons.dto.MenuItemDTO;
//import com.ebridge.commons.dto.PayloadType;
//import com.ebridge.commons.dto.Request;
//import com.ebridge.commons.dto.ServiceCommand;
//import com.ebridge.commons.dto.ServiceResponse;
//import com.ebridge.vas.service.ValueAddedService;
//import com.ebridgevas.service.menutree.processor.ServiceCommandProcessor;
//
//import java.util.Dictionary;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
///**
// *
// * @author david@tekeshe.com
// */
//@Component(immediate = true)
//@Provides
//public class ServiceMenuTree implements ServiceCommandProcessor {
//
//    private Map<String, ValueAddedService> services = new HashMap<>();
//
//    private BundleContext context;
//
//    public ServiceMenuTree(BundleContext context) {
//        this.context = context;
//    }
//
//    @Override
//    public ServiceResponse process(ServiceCommand serviceCommand) {
//        System.out.println("Service Menu Tree ... processing ....");
//
//        Request request = new Request(1,"123","440","246","bundle", PayloadType.USSD_ANSWER);
//        Set<MenuItemDTO> items = null;
//
//        ValueAddedService service = services.get("DataBundlePurchaseService");
//        if (service != null) {
//            return new ServiceResponse(service.process(request, items).getShortMessage());
//        }
//
//        return new ServiceResponse(new DefaultValueAddedService(null).process(request, items).getShortMessage());
//    }
//
//    @Validate
//    protected void activate() {
//
//        System.out.println("Service Menu Tree started.");
//        // Load menu tree
////        SwingUtils.invokeAndWait(new Runnable() {
////            public void run() {
////                setVisible(true);
////            }
////        });
////        try {
////            ServiceReference[] references = context.getAllServiceReferences(ValueAddedService.class.getName(), null);
////            if ( references != null ) {
////                for (ServiceReference reference : references) {
////                    System.out.println("Service found. Binding.");
////                    ValueAddedService service = (ValueAddedService) context.getService(reference);
////                    Dictionary params = reference.getBundle().getHeaders();
////                    bindValueAddedService(service, params);
////                }
////            }
////        } catch (InvalidSyntaxException e) {
////            e.printStackTrace();
////        }
//    }
//
//    @Invalidate
//    protected void deactivate() {
//
//        System.out.println("Service Menu Tree stopped.");
//
//        // dispose menu tree
////        SwingUtils.invokeLater(new Runnable() {
////            public void run() {
////                setVisible(false);
////                dispose();
////            }
////        });
//    }
//
//    /**
//     * Injects an available <tt>SimpleShape</tt> into the drawing frame.
//     *
//     * @param service The name of the injected <tt>SimpleShape</tt>.
//     * @param service The injected <tt>SimpleShape</tt> instance.
//     **/
//    @Bind( aggregate = true, id = "valueAddedService")
//    public void bindValueAddedService( ValueAddedService service, Dictionary attributes) {
//
//        System.out.println("bindValueAddedService ... "  );
//
////        Enumeration keys = attributes.keys();
////        while( keys.hasMoreElements()) {
////            String element = (String)keys.nextElement();
////            System.out.println("element : " + element );
////            System.out.println("value : " + attributes.get( element));
////        }
////
////        System.out.println("key : " + ValueAddedService.NAME_PROPERTY );
//
//        final DefaultValueAddedService delegate = new DefaultValueAddedService( service );
//
//        final String name = (String) attributes.get(ValueAddedService.NAME_PROPERTY);
//
//        if ( name == null ) return;
//
//        System.out.println("bound to ... " + name );
//
//        services.put( name, delegate );
////
////        m_shapes.put(name, delegate);
////
////        SwingUtils.invokeAndWait( new Runnable() {
////            public void run() {
////                JButton button = new JButton(icon);
////                button.setActionCommand(name);
////                button.setToolTipText(name);
////                button.addActionListener(m_reusableActionListener);
////
////                if (m_selected == null) {
////                    button.doClick();
////                }
////
////                m_toolbar.add(button);
////                m_toolbar.validate();
////                repaint();
////            }
////        });
//    }
//
//    /**
//     * Removes a no longer available <tt>SimpleShape</tt> from the drawing frame.
//     *
//     * @param service The name of the <tt>SimpleShape</tt> to remove.
//     **/
//    @Unbind(aggregate = true, id = "valueAddedService")
//    public void unbindValueAddedService(ValueAddedService service, Dictionary attributes) {
//
//
//        final String name = (String) attributes.get(service.NAME_PROPERTY);
//        if ( name == null ) return;
//
//        System.out.println("unbinding ... " + name );
//
//        DefaultValueAddedService delegate = null;
//
//        synchronized ( services ) {
//            delegate = (DefaultValueAddedService)services.remove( name );
//        }
//
//        if ( delegate != null ) {
//            delegate.dispose();
//        }
//
////        DefaultShape delegate = null;
////
////        synchronized( m_shapes ) {
////            delegate = (DefaultShape) m_shapes.remove(name);
////        }
////
////        if ( delegate != null ) {
////            delegate.dispose();
////            SwingUtils.invokeAndWait( new Runnable() {
////                public void run() {
////                    if ((m_selected != null) && m_selected.equals(name)) {
////                        m_selected = null;
////                    }
////
////                    for (int i = 0; i < m_toolbar.getComponentCount(); i++) {
////                        JButton sb = (JButton) m_toolbar.getComponent(i);
////                        if (sb.getActionCommand().equals(name)) {
////                            m_toolbar.remove(i);
////                            m_toolbar.invalidate();
////                            validate();
////                            repaint();
////                            break;
////                        }
////                    }
////
////                    if ((m_selected == null) && (m_toolbar.getComponentCount() > 0)) {
////                        ((JButton) m_toolbar.getComponent(0)).doClick();
////                    }
////                }
////            });
////        }
//    }
//}
//
