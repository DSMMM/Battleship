package com.dsmmm.battleships.server.fleet;

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

        oneMastShip.takeShotOnShip(c1);

        standingMasts = oneMastShip.countStandingMasts();
        assertEquals(standingMasts, 0);
    }

    public void isMastOnGivenCoordinate() {
        // given
        Coordinates c1 = new Coordinates(1, 1);
        Ship oneMastShip = new OneMastShip(c1);

        // when
        boolean isShipShoot = oneMastShip.takeShotOnShip(c1);
        // then

        assertTrue(isShipShoot);
    }

    public void isNotMastOnGivenCoordinate() {
        // given
        Coordinates c1 = new Coordinates(1, 1);
        Coordinates outside = new Coordinates(9, 9);
        Ship oneMastShip = new OneMastShip(c1);

        // when
        boolean isShipShoot = oneMastShip.takeShotOnShip(outside);
        // then

        assertFalse(isShipShoot);
    }

    @Test
    public void isShotTrueIfOnShip() {
        //given
        Coordinates c1 = new Coordinates(2,2);
        //when
        Ship oneMastShip = new OneMastShip(c1);
        //then
        assertTrue(oneMastShip.takeShotOnShip(c1));
    }

    @Test
    public void isShotFalseIfOutsideShip() {
        //given
        Coordinates c1 = new Coordinates(2,2);
        //when
        Coordinates c2 = new Coordinates(2,1);
        Ship oneMastShip = new OneMastShip(c1);
        //then
        assertFalse(oneMastShip.takeShotOnShip(c2));
    }
}
