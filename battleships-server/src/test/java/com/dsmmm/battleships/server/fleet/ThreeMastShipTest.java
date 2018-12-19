package com.dsmmm.battleships.server.fleet;

import com.dsmmm.battleships.server.board.Coordinates;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Test
public class ThreeMastShipTest {

    public void create3mastShip() {
        //given
        Ship threeMast = getDefaultShip();
        //then
        Assert.assertNotNull(threeMast);
    }

    public void countStandingMastsIn3MastShip() {
        // given
        Ship threeMastShip = getDefaultShip();
        // when
        int standingMasts = threeMastShip.countStandingMasts();

        // then
        assertEquals(standingMasts, 3);
    }

    public void isMastOnGivenCoordinate() {
        // given

        Ship threeMast = getDefaultShip();
        Coordinates c1 = new Coordinates(1,1);

        // when
        boolean isShipShoot = threeMast.takeShotOnShip(c1);
        // then

        assertTrue(isShipShoot);
    }

    public void isNotMastOnGivenCoordinate() {
        // given

        Ship threeMast = getDefaultShip();

        // when
        Coordinates outside = new Coordinates(9,9);
        boolean isShipShoot = threeMast.takeShotOnShip(outside);
        // then

        assertFalse(isShipShoot);
    }

    private Ship getDefaultShip() {
        Coordinates c1 = new Coordinates(1, 1);
        Coordinates c2 = new Coordinates(4, 8);
        Coordinates c3 = new Coordinates(2, 6);
        //when
        return new ThreeMastShip(c1, c2, c3);
    }
}
