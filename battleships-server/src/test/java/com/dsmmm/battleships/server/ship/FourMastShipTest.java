package com.dsmmm.battleships.server.ship;

import com.dsmmm.battleships.server.board.Coordinate;
import com.dsmmm.battleships.server.board.Coordinates;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test
public class FourMastShipTest {




    public void create4mastShip() {
        //given
        Ship fourMast = getDefaultShip();
        //then
        Assert.assertNotNull(fourMast);
    }

    public void countStandingMastsIn4MastShip() {
        // given
        Ship fourMast = getDefaultShip();
        // when
        int standingMasts = fourMast.countStandingMasts();

        // then
        assertEquals(standingMasts, 4);
    }


    public void isMastOnGivenCoordinate() {
        // given
        Coordinates c1 = new Coordinates(1, 1);
        Ship fourMast = getDefaultShip();
        // when
        boolean isShipShoot = fourMast.checkIfShotOnShip(c1);
        // then
        assertTrue(isShipShoot);
    }

    public void isNotMastOnGivenCoordinate() {
        // given
        Coordinates outside = new Coordinates(9,9);
        Ship fourMast = getDefaultShip();
        // when
        boolean isShipShoot = fourMast.checkIfShotOnShip(outside);
        // then
        assertFalse(isShipShoot);
    }

    private Ship getDefaultShip() {
        Coordinates c1 = new Coordinates(1, 1);
        Coordinates c2 = new Coordinates(4, 8);
        Coordinates c3 = new Coordinates(2, 6);
        Coordinates c4 = new Coordinates(6, 5);
        return new FourMastShip(c1, c2, c3, c4);
    }
}
