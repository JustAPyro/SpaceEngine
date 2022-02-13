package com.pyredevelopment.engine.messaging;

public class Message {

    private MessageType type;
    private MessageTarget target;
    private byte[] data;

    public Message(MessageType type) {
        this.type = type;
    }

    public Message(MessageType type, byte[] data) {
        this.type = type;
        this.data = data;
    }

    public MessageType type() {
        return type;
    }

    public byte[] data() {
        return data;
    }

}
