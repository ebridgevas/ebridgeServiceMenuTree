package com.ebridgevas.servicemenutree.inject;

import com.ebridgevas.messaging.MessagingService;
import com.ebridgevas.messaging.xmpp.XmppMessagingService;
import com.ebridgevas.servicemenutree.dao.ServiceMenuTreeDAO;
import com.ebridgevas.servicemenutree.menu.ServiceMenuTree;
import com.ebridgevas.servicemenutree.menu.impl.DatabaseBackedServiceMenuTree;
import com.ebridgevas.servicemenutree.stub.ServiceMenuTreeDAOStub;
import com.google.inject.AbstractModule;

/**
 * @author david@tekeshe.com
 */
public class ServiceMenuTreeTestModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ServiceMenuTreeDAO.class).to(ServiceMenuTreeDAOStub.class);
        bind(MessagingService.class).to(XmppMessagingService.class);
        bind(ServiceMenuTree.class).to(DatabaseBackedServiceMenuTree.class);
    }
}
