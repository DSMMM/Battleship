package com.dsmmm.battleships.server.board;

/**
 * Field in the board
 */
public interface Field {
    /**
     * Transform this field to shot type
     * @return Shot field
     */
    Field destroy();
}
