package com.dsmmm.battleships.server.board;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
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

    @Test
    public void createBoardWithFleet() {
        //given
        Board board = new Board();
        int countWater = 0;
        int countMast = 0;
        //when
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (board.getField(new Coordinates(i, j)) instanceof Water) countWater++;
                else countMast++;
            }
        }
        //then
        Assert.assertEquals(countWater, 80);
        Assert.assertEquals(countMast, 20);
    }
}
