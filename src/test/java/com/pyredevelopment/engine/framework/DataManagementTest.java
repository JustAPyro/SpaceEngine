package com.pyredevelopment.engine.framework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataManagementTest {

    @Test
    void toBooleans() {
    }

    @Test
    void toByteBoolean() {

        boolean[] test = new boolean[8];
        System.out.println(Integer.toBinaryString(DataManagement.toByte(test)));

        test = new boolean[8];
        test[0] = true;
        System.out.println(Integer.toBinaryString(DataManagement.toByte(test)));




    }

    @Test
    void testToByteString() {
    }
}