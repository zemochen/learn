package org.zemo.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.zemo.soundsystem.aspect.TrackCount;
import org.zemo.soundsystem.impl.BlankDisc;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: TrackCounterConfig
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 29/09/2016 23:28
 * @Description ${TODO}
 */
@Configuration
@EnableAspectJAutoProxy
public class TrackCounterConfig {

    @Bean
    public CompactDisc sgtPeppers() {
        BlankDisc cd = new BlankDisc();
        cd.setTitle("Sgt. Pepper's Lonely Hearts Club Band");
        cd.setArtist("The Beatles");
        List<String> tracks = new ArrayList<String>();
        tracks.add("Stg. Pepper's Lonely Hearts Club Band");
        tracks.add("With a Little Help from My Friends");
        tracks.add("Lucy in the Sky with Diamons");
        tracks.add("Getting Better");
        tracks.add("Fixing a Hole");
        tracks.add("....");
        tracks.add("7");
        cd.setTracks(tracks);
        return cd;
    }

    @Bean
    public TrackCount trackCounter() {
        return new TrackCount();
    }
}
