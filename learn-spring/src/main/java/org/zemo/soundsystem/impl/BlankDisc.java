package org.zemo.soundsystem.impl;

import org.springframework.stereotype.Component;
import org.zemo.soundsystem.CompactDisc;

import java.util.List;

/**
 * @ClassName: BlankDisc
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 29/09/2016 21:36
 * @Description ${TODO}
 */
@Component
public class BlankDisc implements CompactDisc {
    private String title;
    private String artist;
    private List<String> tracks;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
        for (String track : tracks) {
            System.out.println("-Track:" + track);
        }
    }

    public void playTrack(int trackNumber) {
        System.out.println(trackNumber + "-Track:" + tracks.get(trackNumber-1));
    }
}
