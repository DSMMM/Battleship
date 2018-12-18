package com.dsmmm.battleships.server.ship;

import com.dsmmm.battleships.server.board.Coordinates;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Test
public class OneMastShipTest {


    public void create1mastShip() {
        //given
        Coordinates c1 = new Coordinates(1, 1);
        //when
        Ship twoMast = new OneMastShip(c1);
        //then
        Assert.assertNotNull(twoMast);
    }

    public void countStandingMastsIn2MastShip() {
        // given
        Coordinates c1 = new Coordinates(1, 1);

        Ship oneMastShip = new OneMastShip(c1);
        // when
        int standingMasts = oneMastShip.countStandingMasts();

        // then
        assertEquals(standingMasts, 1);
    }


    public void isMastOnGivenCoordinate() {
        // given
        Coordinates c1 = new Coordinates(1, 1);
        Ship oneMastShip = new OneMastShip(c1);

        // when
        boolean isShipShoot = oneMastShip.checkIfShotOnShip(c1);
        // then

        assertTrue(isShipShoot);
    }

    public void isNotMastOnGivenCoordinate() {
        // given
        Coordinates c1 = new Coordinates(1, 1);
        Coordinates outside = new Coordinates(9, 9);
        Ship oneMastShip = new OneMastShip(c1);

        // when
        boolean isShipShoot = oneMastShip.checkIfShotOnShip(outside);
        // then

        assertFalse(isShipShoot);
    }
}
