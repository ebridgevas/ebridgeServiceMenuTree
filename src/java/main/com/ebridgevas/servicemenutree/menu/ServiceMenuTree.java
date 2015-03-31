package com.ebridgevas.servicemenutree.menu;

import com.ebridge.commons.dto.PayloadDTO;
import com.ebridgevas.servicemenutree.dto.UserSession;

/**
 * @author david@tekeshe.com
 */
public interface ServiceMenuTree {

    public void readTree();
    public PayloadDTO process( String payload );
    public UserSession getUserSession( String mobileNumber );
}
