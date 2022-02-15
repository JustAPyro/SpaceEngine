package com.pyredevelopment.engine.framework;

public class DataManagement {

    public static byte toByte(String string) {
        return Byte.parseByte(string, 2);
    }

    public static byte toByte(boolean b1, boolean b2, boolean b3, boolean b4,
                              boolean b5, boolean b6, boolean b7, boolean b8) {
        return (byte)((b1?1<<7:0) + (b2?1<<6:0) + (b3?1<<5:0) +
                (b4?1<<4:0) + (b5?1<<3:0) + (b6?1<<2:0) +
                (b7?1<<1:0) + (b8?1:0));
    }

}
