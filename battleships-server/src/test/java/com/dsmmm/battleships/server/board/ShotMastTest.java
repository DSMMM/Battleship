package com.dsmmm.battleships.server.board;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ShotMastTest {
    @Test
    public void createShotMast()
    {
        // given
        Field mastShotAsField = new ShotMast();
        // when
        Mast mastShotAsMast = new ShotMast();
        // then
        Assert.assertEquals(mastShotAsField, mastShotAsMast);
    }

    @Test
    public void tryToTransformShotMast()
    {
        // given
        Field shotMastToTransform = new ShotMast();
        // when
        Field shotMast = shotMastToTransform.transform();
        // then
        Assert.assertEquals(shotMastToTransform, shotMast);
    }

    @Test
    public void shotMastNotEqualsNotShotMast()
    {
        // given
        ShotMast shotMast = new ShotMast();
        // when
        NotShotMast notShotMast = new NotShotMast();
        // then
        Assert.assertNotEquals(shotMast, notShotMast);
    }

    @Test
    public void shotMastNotEqualsNull()
    {
        // given
        ShotMast shotMast;
        // when
        shotMast = new ShotMast();
        // then
        Assert.assertNotEquals(null, shotMast);
    }
}
