package com.dsmmm.battleships.server.ship;

import com.dsmmm.battleships.server.board.Coordinates;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class FourMastShipTest {

    public void create4mastShip() {
        //given
        Coordinates c1 = new Coordinates(1, 1);
        Coordinates c2 = new Coordinates(4, 8);
        Coordinates c3 = new Coordinates(2, 6);
        Coordinates c4 = new Coordinates(6, 5);
        //when
        Ship fourMast = new FourMastShip(c1, c2, c3, c4);
        //then
        Assert.assertNotNull(fourMast);
    }

    public void countStandingMastsIn4MastShip(){
    // given
    String whyItFailed = "Źle zliczyło stojące maszty";
        Coordinates c1 = new Coordinates(1, 1);
        Coordinates c2 = new Coordinates(4, 8);
        Coordinates c3 = new Coordinates(2, 6);
        Coordinates c4 = new Coordinates(6, 5);

    Ship fourMast = new FourMastShip(c1,c2,c3,c4);
    // when
    int standingMasts = fourMast.countStandingMasts();

    // then
    assertEquals(standingMasts,4,whyItFailed);
    }
}
