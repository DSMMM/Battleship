package com.dsmmm.battleships.server.io;

/**
 * @TODO: DOCUMENT ME
 */
enum Prefix {
    CHAT("/chat"),
    SHOOT("/shoot"),
    ENEMY_SHOOT("/enemy_shoot"),
    SHIPS("/ships"),
    GENERATE("/generate"),
    HIT("/hit"),
    ENEMY_HIT("/enemy_hit"),
    MISS("/miss"),
    ENEMY_MISS("/enemy_miss");

    private final String key;

    Prefix(String key) {
        this.key = key;
    }

    static String decipher(String toDecipher) {
        Prefix prefix = getType(toDecipher);
        return toDecipher.substring(prefix.toString().length() + 1);
    }

    static Prefix getType(String message) {
        for (Prefix prefix : Prefix.values()) {
            if (message.startsWith(prefix.toString())) {
                return prefix;
            }
        }
        throw new MessageTypeException(message);
    }

    @Override
    public String toString() {
        return key;
    }

    String cipher(String toCipher) {
        return key + " " + toCipher;
    }
}
