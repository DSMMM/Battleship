package com.dsmmm.battleships.client;

interface Gameable {
    void showFleet(String toDecode);
    void showEnemyMiss(String toDecode);
    void showEnemyHit(String toDecode);
}
