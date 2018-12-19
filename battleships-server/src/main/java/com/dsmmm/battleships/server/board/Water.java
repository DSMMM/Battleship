package com.dsmmm.battleships.server.board;

/**
 * Type of field belonging to ocean
 */
public interface Water extends Field {
    /**
     * Transform this field to shot type
     * @return ShotWater
     */
    Water destroy();
}
