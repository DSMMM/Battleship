package com.dsmmm.battleships.server.board;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class CoordinatesTest {
    @Test
    public void coordinatesEquality() {
        // given
        Coordinates coordinates = new Coordinates(new Column(2), new Row(2));
        Coordinates coordinatesExpected = new Coordinates(new Column(2), new Row(2));
        // when

        // then
        Assert.assertTrue(coordinates.equals(coordinatesExpected));
    }

    @Test
    public void differentCoordinatesAreNotEquals() {
        // given
        Coordinates coordinates = new Coordinates(new Column(2), new Row(2));
        Coordinates coordinatesExpected = new Coordinates(new Column(3), new Row(2));
        // when

        // then
        assertFalse(coordinates.equals(coordinatesExpected));
    }

    @DataProvider
    Object[][] neighbours() {
        return new Object[][]{
                {new Column(1), new Row(1), Side.RIGHT, new Column(2), new Row(1)},
                {new Column(3), new Row(2), Side.BOTTOM, new Column(3), new Row(3)},
                {new Column(2), new Row(2), Side.UP, new Column(2), new Row(1)},
                {new Column(2), new Row(4), Side.LEFT, new Column(1), new Row(4)},
                {new Column(6), new Row(2), Side.UP_RIGHT, new Column(7), new Row(1)},
                {new Column(2), new Row(2), Side.BOTTOM_RIGHT, new Column(3), new Row(3)},
                {new Column(3), new Row(2), Side.UP_LEFT, new Column(2), new Row(1)},
                {new Column(2), new Row(3), Side.BOTTOM_LEFT, new Column(1), new Row(4)},
                {new Column(3), new Row(5), Side.RIGHT, new Column(4), new Row(5)},
        };
    }

    @Test(dataProvider = "neighbours")
    public void getNeighbourCoordinates(Column column, Row row, Side side, Column expectedColumn, Row expectedRow) {
        // given
        Dimension dimension = new Dimension(10);

        Coordinates coordinates = new Coordinates(column, row);
        // when
        Coordinates neighbour = coordinates.getNeighbour(side, dimension);
        Coordinates coordinatesExpected = new Coordinates(expectedColumn, expectedRow);
        // then
        assertEquals(neighbour, coordinatesExpected);
    }
}
