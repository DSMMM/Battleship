package com.dsmmm.battleships.server.fleet;

import com.dsmmm.battleships.server.board.Coordinates;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Test
public class FleetTest {


    private Fleet fleet;

    @BeforeClass
    void setup() {
        fleet = new Fleet();
    }

    @Test
    public void add4MastShip() {
        //given
        Coordinates c1 = new Coordinates(1, 1);
        Coordinates c2 = new Coordinates(1, 2);
        Coordinates c3 = new Coordinates(1, 3);
        Coordinates c4 = new Coordinates(1, 4);
        Set<Coordinates> coordinates = new HashSet<>(Arrays.asList(c1, c2, c3, c4));
        //when
        fleet.addShip(coordinates);

        //then
        Assert.assertTrue(fleet.takeShotOnFleet(c1));
        Assert.assertTrue(fleet.takeShotOnFleet(c2));
        Assert.assertTrue(fleet.takeShotOnFleet(c3));
        Assert.assertTrue(fleet.takeShotOnFleet(c4));
    }


    @Test
    public void add3MastShip() {
        //given
        Coordinates c1 = new Coordinates(1, 1);
        Coordinates c2 = new Coordinates(1, 2);
        Coordinates c3 = new Coordinates(1, 3);
        Set<Coordinates> coordinates = new HashSet<>(Arrays.asList(c1, c2, c3));

        //when
        fleet.addShip(coordinates);

        //then
        Assert.assertTrue(fleet.takeShotOnFleet(c1));
        Assert.assertTrue(fleet.takeShotOnFleet(c2));
        Assert.assertTrue(fleet.takeShotOnFleet(c3));
    }


    @Test
    public void add2MastShip() {
        //given
        Coordinates c1 = new Coordinates(1, 1);
        Coordinates c2 = new Coordinates(1, 2);
        Set<Coordinates> coordinates = new HashSet<>(Arrays.asList(c1, c2));

        //when
        fleet.addShip(coordinates);

        //then
        Assert.assertTrue(fleet.takeShotOnFleet(c1));
        Assert.assertTrue(fleet.takeShotOnFleet(c2));
    }


    @Test
    public void add1MastShip() {
        //given
        Coordinates c1 = new Coordinates(1, 1);
        Set<Coordinates> coordinates = new HashSet<>(Collections.singletonList(c1));

        //when
        fleet.addShip(coordinates);

        //then
        Assert.assertTrue(fleet.takeShotOnFleet(c1));
        Assert.assertFalse(fleet.takeShotOnFleet(new Coordinates(3, 3)));
    }


}
