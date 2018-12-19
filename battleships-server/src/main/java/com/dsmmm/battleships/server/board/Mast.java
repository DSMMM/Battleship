package com.dsmmm.battleships.server.board;

/**
 * Type of field belonging to ships
 */
public interface Mast extends Field{
    /**
     * Transform this field to shot type
     * @return ShotMast
     */
    Mast destroy();
}
