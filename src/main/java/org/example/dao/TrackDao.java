package org.example.dao;

import org.example.FirstView.Music;
import org.example.container.Container;
import org.example.db.DBConnection;
import org.example.dto.Article;
import org.example.dto.Track;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TrackDao extends Dao {
    private DBConnection dbConnection;
    public TrackDao() {
        dbConnection = Container.getDBConnection();
    }

    public int importMusic(Track track) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("INSERT INTO track "));
        sb.append(String.format("SET regDate = NOW(), "));
        sb.append(String.format("updateDate = NOW(), "));
        sb.append(String.format("importMusicFile = '%s', ", track.importMusicFile));
        sb.append(String.format("musicTitle = '%s', ", track.musicTitle));;
        sb.append(String.format("hit = %d ", track.hit));

        return dbConnection.insert(sb.toString());
    }

    public List<Music> getForListMusics(String searchKeyword) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT M.* "));
        sb.append(String.format("FROM `music` AS M "));
        if ( searchKeyword.length() > 0 ) {
            sb.append(String.format("AND M.musicTitle LIKE '%%%s%%' ", searchKeyword));
        }
        sb.append(String.format("ORDER BY A.id DESC"));

        List<Music> tracks = new ArrayList<>();
        List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

        for ( Map<String, Object> row : rows ) {
            tracks.add(new Article((row)));
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
