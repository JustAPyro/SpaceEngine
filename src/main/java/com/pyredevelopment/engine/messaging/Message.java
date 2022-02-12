package com.pyredevelopment.engine.messaging;

public class Message {

    private MessageType type;
    private MessageTarget target;
    private byte[] data;

    public Message(MessageType type) {
        this.type = type;
    }

    public MessageType type() {
        return type;
    }

}
