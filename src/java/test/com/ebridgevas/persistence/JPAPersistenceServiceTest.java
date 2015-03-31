package com.ebridgevas.persistence;

import com.ebridgevas.model.ServiceMenuNode;
import com.ebridgevas.persistence.impl.JPAPersistenceService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author david@tekeshe.com
 */
public class JPAPersistenceServiceTest {

    private PersistenceService service;

    @Before
    public void setup() {
        service = new JPAPersistenceService();
    }

    @Test
    public void testPersist() {

        ServiceMenuNode node1 = new ServiceMenuNode();
        service.persist( node1 );
        ServiceMenuNode node2 = (ServiceMenuNode)service.findById(ServiceMenuNode.class, node1.getNodeId() );
        assertEquals(node2.getNodeId(), node2.getNodeId());

        List<ServiceMenuNode> list = service.findAll(ServiceMenuNode.class);
        for (ServiceMenuNode user : list) {
            System.out.println(user.getNodeId());
        }
        service.delete(node1);
        ServiceMenuNode user3 = (ServiceMenuNode)service.findById(ServiceMenuNode.class, node1.getNodeId() );
        assertNull( user3 );

        service.deleteAll(ServiceMenuNode.class);
        List<ServiceMenuNode> list2 = service.findAll(ServiceMenuNode.class);
        assertEquals(list2.size(), 0);
    }

    @After
    public void tearDown() {
        service.deleteAll(ServiceMenuNode.class);
    }
}
