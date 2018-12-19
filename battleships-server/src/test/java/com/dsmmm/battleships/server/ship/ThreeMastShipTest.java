package com.dsmmm.battleships.server.ship;

import com.dsmmm.battleships.server.board.Coordinates;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ThreeMastShipTest {

    @Test
    public void create3mastShip() {
        //given
        Coordinates c1 = new Coordinates(1, 1);
        Coordinates c2 = new Coordinates(1, 1);
        Coordinates c3 = new Coordinates(1, 1);
        //when
        Ship threeMast = new ThreeMastShip(c1, c2, c3);
        //then
        Assert.assertNotNull(threeMast);
        Assert.assertEquals(threeMast.countStandingMasts(),3);
    }
}
