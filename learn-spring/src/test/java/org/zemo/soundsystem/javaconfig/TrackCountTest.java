package org.zemo.soundsystem.javaconfig;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zemo.soundsystem.CompactDisc;
import org.zemo.soundsystem.TrackCounterConfig;
import org.zemo.soundsystem.aspect.TrackCount;

/**
 * @ClassName: TrackCountTest
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 30/09/2016 18:02
 * @Description ${TODO}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TrackCounterConfig.class)
public class TrackCountTest {

    @Autowired
    private CompactDisc compactDisc;
    @Autowired
    private TrackCount trackCount;

    @Test
    public void testTrackCounter(){
        compactDisc.playTrack(1);
        compactDisc.playTrack(2);
        compactDisc.playTrack(3);
        compactDisc.playTrack(3);
        compactDisc.playTrack(3);
        compactDisc.playTrack(3);
        compactDisc.playTrack(7);
        compactDisc.playTrack(7);

        Assert.assertEquals(1,trackCount.getPlayCount(1));
        Assert.assertEquals(1,trackCount.getPlayCount(2));
        Assert.assertEquals(4,trackCount.getPlayCount(3));
        Assert.assertEquals(0,trackCount.getPlayCount(4));
        Assert.assertEquals(0,trackCount.getPlayCount(5));
        Assert.assertEquals(0,trackCount.getPlayCount(6));
        Assert.assertEquals(2,trackCount.getPlayCount(7));

    }
}
