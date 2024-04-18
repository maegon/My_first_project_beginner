package org.example.dao;

import org.example.dto.Article;
import org.example.dto.Track;

import java.util.ArrayList;
import java.util.List;

public class TrackDao extends Dao {
    public List<Track> tracks;
    public TrackDao() {
        tracks = new ArrayList<>();
    }

    public int importMusic(Track track) {
        tracks.add(track);
        lastId = track.id;
        return 0;
    }

    public List<Track> getForListMusics(String searchKeyword) {
        if (searchKeyword != null && searchKeyword.length() != 0) {
            List<Track> forListMusics = new ArrayList<>();
            for (Track track : tracks) {
                if (track.musicTitle.contains(searchKeyword)) {
                    forListMusics.add(track);
                }
            }

            return forListMusics;
        }

        return tracks;
    }
    }
}