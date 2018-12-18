package com.dsmmm.battleships.server.board;

import com.dsmmm.battleships.server.ship.FourMastShip;
import com.dsmmm.battleships.server.ship.Ship;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class FourMastShipTest {

    @Test
    public void create4mastShip() {
        //given
        Coordinates c1 = new Coordinates(new Column(1), new Row(1));
        Coordinates c2 = new Coordinates(new Column(4), new Row(8));
        Coordinates c3 = new Coordinates(new Column(2), new Row(6));
        Coordinates c4 = new Coordinates(new Column(6), new Row(5));
        //when
        Ship fourMast = new FourMastShip(c1, c2, c3, c4);
        //then
        Assert.assertNotNull(fourMast);
    }
}
