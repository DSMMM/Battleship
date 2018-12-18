package com.dsmmm.battleships.server.board;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BoardTest {
    @Test
    public void createBoard() {
        //given
        Board board;
        //when
        board = new Board(new Dimension(10));
        //then
        Assert.assertNotNull(board);
    }

    @DataProvider
    Object[][] coordinateGenerator() {
        Object[][] objects = new Object[10][1];
        for (int i = 1; i <= 10; i++) {
            objects[i-1] = new Object[]{new Coordinates(new Column(i), new Row(i))};
        }
        return  objects;
    }

    @Test (dataProvider = "coordinateGenerator")
    public void getFieldByCoordinate(Coordinates coordinates) {
        //given
        Board board = new Board(new Dimension(10));
        //when
        Field field = board.getField(coordinates);
        //then
        Assert.assertEquals(field, new NotShotWater());
    }
}
