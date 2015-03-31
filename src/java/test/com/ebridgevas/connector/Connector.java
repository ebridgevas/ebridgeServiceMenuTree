package com.ebridgevas.connector;

import org.jivesoftware.smack.Chat;

import java.util.Map;

/**
 * @author david@tekeshe.com
 */
public class Connector implements Runnable {

    private Map<String, Chat> chatPeers;

    public Connector(Map<String, Chat> chatPeers) {
        this.chatPeers = chatPeers;
    }

    @Override
    public void run() {

    }
}
