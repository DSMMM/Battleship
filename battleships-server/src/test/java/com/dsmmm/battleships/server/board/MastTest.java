package com.dsmmm.battleships.server.board;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MastTest {
    @Test
    public void createMastNotShot()
    {
        // given
        Field mastAsField = new MastNotShot();
        // when
        Mast mastAsMast = new MastNotShot();
        // then
        Assert.assertEquals(mastAsField, mastAsMast);
    }

    @Test
    public void createShotMast()
    {
        // given
        Field mastShotAsField = new MastShot();
        // when
        Mast mastShotAsMast = new MastShot();
        // then
        Assert.assertEquals(mastShotAsField, mastShotAsMast);
    }

    @Test
    public void transformMastNotShotToMastShot()
    {
        // given
        Field mastNotShot = new MastNotShot();
        MastShot mastShotExpected = new MastShot();
        // when
        Field mastShot = mastNotShot.transform();
        // then
        Assert.assertEquals(mastShotExpected, mastShot);
    }

    @Test
    public void tryToTransformMastNotShot()
    {
        // given
        Field mastShotToTransform = new MastShot();
        // when
        Field mastShot = mastShotToTransform.transform();
        // then
        Assert.assertEquals(mastShotToTransform, mastShot);
    }

    @Test
    public void mastNotShotNotEqualsMastShot()
    {
        // given
        MastShot mastShot = new MastShot();
        // when
        MastNotShot mastNotShot = new MastNotShot();
        // then
        Assert.assertNotEquals(mastShot, mastNotShot);
        Assert.assertFalse(mastNotShot.equals(mastShot));
    }
}
