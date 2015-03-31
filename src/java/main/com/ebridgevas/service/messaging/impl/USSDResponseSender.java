package com.ebridgevas.service.messaging.impl;

import org.apache.log4j.Logger;
import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.packet.Message;

/**
 * @author david@tekeshe.com
 */
public class USSDResponseSender implements MessageListener {

    private static final Logger logger = Logger.getLogger(USSDResponseSender.class);

    @Override
    public void processMessage(Chat chat, Message message) {

        logger.debug("chat.participant : " + chat.getParticipant());
        logger.debug("message.body     : " + message.getBody());
        logger.debug("message.from     : " + message.getFrom());
        logger.debug("message.to       : " + message.getTo());
        logger.debug("message.packetId : " + message.getPacketID());

    }
}
