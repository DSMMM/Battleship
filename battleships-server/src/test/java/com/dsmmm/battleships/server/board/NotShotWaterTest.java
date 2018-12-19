package com.dsmmm.battleships.server.board;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NotShotWaterTest {
    @Test
    public void createNotShotWater() {
        // given
        Field waterAsField = new NotShotWater();
        // when
        Water waterAsWater = new NotShotWater();
        // then
        Assert.assertEquals(waterAsField, waterAsWater);
    }

    @Test
    public void transformNotShotWaterToShotWater() {
        // given
        Field notShotWater = new NotShotWater();
        ShotWater shotWaterExpected = new ShotWater();
        // when
        Field shotWater = notShotWater.transform();
        // then
        Assert.assertEquals(shotWaterExpected, shotWater);
    }

    @Test
    public void notShotWaterNotEqualsShotWater() {
        // given
        NotShotWater notShotWater = new NotShotWater();
        // when
        ShotWater shotWater = new ShotWater();
        // then
        Assert.assertNotEquals(notShotWater, shotWater);
    }

    @Test
    public void notShotWaterNotEqualsNull() {
        // given
        NotShotWater notShotWater;
        // when
        notShotWater = new NotShotWater();
        // then
        Assert.assertNotEquals(null, notShotWater);
    }
}
