package com.dsmmm.battleships.server.board;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ShotWaterTest {
    @Test
    public void createShotWater()
    {
        // given
        Field shotWaterAsField = new ShotWater();
        // when
        Water shotWaterAsWater = new ShotWater();
        // then
        Assert.assertEquals(shotWaterAsField, shotWaterAsWater);
    }

    @Test
    public void tryToTransformShotWater()
    {
        // given
        Field shotWaterToTransform = new ShotWater();
        // when
        Field shotWater = shotWaterToTransform.transform();
        // then
        Assert.assertEquals(shotWaterToTransform, shotWater);
    }

    @Test
    public void shotWaterNotEqualsNotShotWater()
    {
        // given
        ShotWater shotWater = new ShotWater();
        // when
        NotShotWater notShotWater = new NotShotWater();
        // then
        Assert.assertNotEquals(shotWater, notShotWater);
    }

    @Test
    public void shotWaterNotEqualsNull()
    {
        // given
        ShotWater shotWater;
        // when
        shotWater = new ShotWater();
        // then
        Assert.assertNotEquals(null, shotWater);
    }
}
