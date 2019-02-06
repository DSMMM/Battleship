package com.dsmmm.battleships.client;

interface Gameable {
    void showFleet(String toDecode);
    void showEnemyMiss(String toDecode);
    void showEnemyHit(String toDecode);
    void showHit(String decipheredLine);
    void showMiss(String decipheredLine);

    void nowaMetoda(String decipheredLine);
}
