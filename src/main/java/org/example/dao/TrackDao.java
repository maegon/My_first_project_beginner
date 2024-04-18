package org.example.dao;

import org.example.dto.Track;

import java.util.ArrayList;
import java.util.List;

public class TrackDao extends Dao {
    public List<Track> tracks;
    public TrackDao() {
        tracks = new ArrayList<>();
    }

    public void importMusic(Track track) {
        tracks.add(track);
        lastId = track.id;
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

    public Track getTrackById(int listenNum) {
        int index = getTrackIndexById(listenNum);

        if (index != -1) {
            return tracks.get(index);
        }

        return null;
    }

    public int getTrackIndexById(int listenNum) {
        int i = 0;

        for (Track track : tracks) {
            if (track.id == listenNum) {
                return i;
            }
            i++;
        }

        return -1;
    }

}
