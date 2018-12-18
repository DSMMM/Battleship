package com.dsmmm.battleships.server.board;

import com.dsmmm.battleships.server.ship.FourMastShip;
import com.dsmmm.battleships.server.ship.Ship;
import com.dsmmm.battleships.server.ship.ThreeMastShip;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class ThreeMastShipTest {

    @Test
    public void create3mastShip() {
        //given
        Coordinates c1 = new Coordinates(new Column(1), new Row(1));
        Coordinates c2 = new Coordinates(new Column(1), new Row(1));
        Coordinates c3 = new Coordinates(new Column(1), new Row(1));
        //when
        Ship threeMast = new ThreeMastShip(c1, c2, c3);
        //then
        Assert.assertNotNull(threeMast);
    }
}
