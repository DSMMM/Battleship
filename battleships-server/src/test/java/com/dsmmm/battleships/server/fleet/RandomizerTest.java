package com.dsmmm.battleships.server.fleet;

import com.dsmmm.battleships.server.board.Coordinates;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RandomizerTest {

    @Test
    public void testRandomizerTestGeneratesFleetWith20CoordinatesCoveredByShip() {
        //given
        Randomizer randomizer = new Randomizer();
        Fleet fleet = randomizer.generateRandomFleet();
        int countMasts = 0;
        int countWaters = 0;
        //when
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                Coordinates toShoot = new Coordinates(i, j);
                if (fleet.takeShotOnFleet(toShoot)) countMasts++;
                else countWaters++;
            }
        }
        //then
        assertEquals(countMasts, 20);
        assertEquals(countWaters, 80);


    }

}