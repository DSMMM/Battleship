package com.dsmmm.battleships.client.io;

/**
 * Cipher and decipher messages between client and server
 */
public enum Prefix {
    CHAT("/chat"),
    SHOOT("/shoot"),
    SHIPS("/ships"),
    HIT("/hit"),
    GENERATE("/generate");

    private final String key;

    Prefix(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key;
    }

    /**
     * Add prefix to message
     * @param toCipher String
     * @return String ciphered message
     */
    public String cipher(String toCipher) {
        return key + " " + toCipher;
    }

    /**
     * Extracts message from ciphered message
     * @param toDecipher String
     * @return String message
     */
    public static String decipher(String toDecipher) {
        Prefix prefix = getType(toDecipher);
        return toDecipher.substring(prefix.toString().length() + 1);
    }


    /**
     * Get type of ciphered message. Throws exception if can't find used type
     * @param message String
     * @return Prefix type
     */
    public static Prefix getType(String message) {
        for (Prefix prefix : Prefix.values()) {
            if (message.startsWith(prefix.toString())) {
                return prefix;
            }
        }
        throw new MessageTypeException(message);
    }
}
