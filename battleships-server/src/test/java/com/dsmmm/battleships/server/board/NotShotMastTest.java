package com.dsmmm.battleships.server.board;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NotShotMastTest {
    @Test
    public void createNotShotMast() {
        // given
        Field mastAsField = new NotShotMast();
        // when
        Mast mastAsMast = new NotShotMast();
        // then
        Assert.assertEquals(mastAsField, mastAsMast);
    }

    @Test
    public void transformNotShotMastToShotMast() {
        // given
        Field notShotMast = new NotShotMast();
        ShotMast shotMastExpected = new ShotMast();
        // when
        Field shotMast = notShotMast.destroy();
        // then
        Assert.assertEquals(shotMastExpected, shotMast);
    }

    @Test
    public void notShotMastNotEqualsShotMast() {
        // given
        NotShotMast notShotMast = new NotShotMast();
        // when
        ShotMast shotMast = new ShotMast();
        // then
        Assert.assertNotEquals(notShotMast, shotMast);
    }

    @Test
    public void notShotMastNotEqualsNull() {
        // given
        NotShotMast notShotMast;
        // when
        notShotMast = new NotShotMast();
        // then
        Assert.assertNotNull(notShotMast);
    }

}
