package com.dsmmm.battleships.client;

import javafx.scene.control.TextArea;

class GuiChat implements ClientTalkable {
    private final TextArea chatId;

    GuiChat(TextArea chatId) {
        this.chatId = chatId;
    }

    @Override
    public void appendText(String message) {
        chatId.appendText(message);
    }
}
