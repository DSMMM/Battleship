package com.dsmmm.battleships.server.board;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WaterTest {
    @Test
    public void createWaterNotShot()
    {
        // given
        Field waterAsField = new WaterNotShot();
        // when
        Water waterAsWater = new WaterNotShot();
        // then
        Assert.assertEquals(waterAsField, waterAsWater);
    }

    @Test
    public void createWaterShot()
    {
        // given
        Field waterShotAsField = new WaterShot();
        // when
        Water waterShotAsWater = new WaterShot();
        // then
        Assert.assertEquals(waterShotAsField, waterShotAsWater);
    }

    @Test
    public void transformWaterNotShotToWaterShot()
    {
        // given
        Field waterNotShot = new WaterNotShot();
        WaterShot waterShotExpected = new WaterShot();
        // when
        Field waterShot = waterNotShot.transform();
        // then
        Assert.assertEquals(waterShotExpected, waterShot);
    }

    @Test
    public void tryToTransformWaterNotShot()
    {
        // given
        Field waterShotToTransform = new WaterShot();
        // when
        Field waterShot = waterShotToTransform.transform();
        // then
        Assert.assertEquals(waterShotToTransform, waterShot);
    }

    @Test
    public void waterNotShotNotEqualsWaterShot()
    {
        // given
        WaterShot waterShot = new WaterShot();
        // when
        WaterNotShot waterNotShot = new WaterNotShot();
        // then
        Assert.assertNotEquals(waterShot, waterNotShot);
        Assert.assertFalse(waterNotShot.equals(waterShot));
    }

}
