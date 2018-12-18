package com.dsmmm.battleships.server.ship;

import com.dsmmm.battleships.server.board.Coordinates;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


@Test
public class TwoMastShipTest {


    public void create2mastShip() {
        //given
        Ship twoMastShip = getDefaultShip();
        //then
        Assert.assertNotNull(twoMastShip);
    }

    public void countStandingMastsIn2MastShip() {
        // given
        Ship twoMastShip = getDefaultShip();
        // when
        int standingMasts = twoMastShip.countStandingMasts();

        // then
        assertEquals(standingMasts, 2);
    }

    public void isMastOnGivenCoordinate() {
        // given
        Coordinates c1 = new Coordinates(1, 1);
        Ship twoMastShip = getDefaultShip();

        // when
        boolean isShipShoot = twoMastShip.checkIfShotOnShip(c1);
        // then

        assertTrue(isShipShoot);
    }

    public void isNotMastOnGivenCoordinate() {
        // given
        Coordinates c1 = new Coordinates(1, 7);
        Ship twoMastShip = getDefaultShip();

        // when
        boolean isShipShoot = twoMastShip.checkIfShotOnShip(c1);
        // then

        assertFalse(isShipShoot);
    }

    private Ship getDefaultShip() {
        Coordinates c1 = new Coordinates(1, 1);
        Coordinates c2 = new Coordinates(1, 2);

        return new TwoMastShip(c1, c2);
    }
}