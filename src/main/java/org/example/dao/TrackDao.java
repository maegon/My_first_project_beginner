package org.example.dao;

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

    public List<Track> getForListMusics(String searchKeyword) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT T.* "));
        sb.append(String.format("FROM `track` AS T "));
        if ( searchKeyword.length() > 0 ) {
            sb.append(String.format("WHERE T.musicTitle LIKE '%%%s%%' ", searchKeyword));
        }
        sb.append(String.format("ORDER BY T.id DESC "));

        List<Track> tracks = new ArrayList<>();
        List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

        for ( Map<String, Object> row : rows ) {
            tracks.add(new Track((row)));
        }

        return tracks;
    }

    public Track getTrack(int id) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT * "));
        sb.append(String.format("FROM `track` "));
        sb.append(String.format("WHERE id = %d ", id));

        Map<String, Object> row = dbConnection.selectRow(sb.toString());

        if ( row.isEmpty() ) {
            return null;
        }

        return new Track(row);
    }


    public List<Track> getForAllListMusic() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT T.* "));
        sb.append(String.format("FROM `track` AS T "));
        sb.append(String.format("ORDER BY T.id DESC"));

        List<Track> tracks = new ArrayList<>();
        List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

        for ( Map<String, Object> row : rows ) {
            tracks.add(new Track((row)));
        }

        return tracks;
    }


    public Track getMusicTitle(int id) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT musicTitle "));
        sb.append(String.format("FROM `track` "));
        sb.append(String.format("WHERE id = %d ", id));

        Map<String, Object> row = dbConnection.selectRow(sb.toString());

        if ( row.isEmpty() ) {
            return null;
        }

        return new Track(row);
    }
}
