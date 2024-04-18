package org.example.service;

import org.example.container.Container;
import org.example.dao.ArticleDao;
import org.example.dao.TrackDao;
import org.example.dto.Article;
import org.example.dto.Track;

import java.util.List;

public class TrackService {
    private TrackDao trackDao;

    public TrackService() {
        trackDao = Container.trackDao;
    }

    public int importMusic(int id, String importMusicFile, String musicTitle) {
        Track track = new Track(id, importMusicFile, musicTitle);
        return trackDao.importMusic(track);
    }

    public List<Track> getForListMusics(String searchKeyword) {
        return trackDao.getForListMusics(searchKeyword);
    }
}
