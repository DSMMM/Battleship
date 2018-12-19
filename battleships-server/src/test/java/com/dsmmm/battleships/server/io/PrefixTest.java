package com.dsmmm.battleships.server.io;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PrefixTest {

    @Test
    public void createChatMessage() {
        // given
        String message = Prefix.CHAT.cipher("message");
        String expectedString = "/chat message";
        // when

        // then
        assertEquals(expectedString, message);
    }

    @Test
    public void createShootMessage() {
        // given
        String message = Prefix.SHOOT.cipher("message");
        String expectedString = "/shoot message";
        // when

        // then
        assertEquals(expectedString, message);
    }

    @Test
    public void getMessageType() {
        // given
        String message = "/shoot something";
        Prefix expectedType = Prefix.SHOOT;
        // when
        Prefix type = Prefix.getType(message);
        // then
        assertEquals(expectedType, type);
    }

    @Test
    public void decipherMessage() {
        // given
        String givenMessage = "/shoot something";
        String expectedMessage = "something";
        // when
        String message = Prefix.decipher(givenMessage);
        // then
        assertEquals(expectedMessage, message);
    }

    @Test(expectedExceptions = MessageTypeException.class)
    public void throwsMessageTypeException() {
        // given
        String givenMessage = "/shhhooott something";
        // when
        Prefix.getType(givenMessage);
        // then
    }

}