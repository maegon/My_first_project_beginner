package org.example.dto;


import java.util.Map;

public class Track extends Dto {
    public String importMusicFile;
    public String musicTitle;
    public int hit;
    public String startMusic;

    public Track(Map<String, Object> row) {
        super(row);
        this.importMusicFile = (String) row.get("importMusicFile");
        this.musicTitle = (String) row.get("musicTitle");
        this.hit = (int) row.get("hit");
    }


    public String getStartMusic() {
        return startMusic;
    }




    public Track(int id, String importMusicFile, String musicTitle) {
        super();
        this.id = id;
        this.importMusicFile = importMusicFile;
        this.musicTitle = musicTitle;
    }

    public Track(int id, String musicTitle, int hit) {
        this.id = id;
        this.musicTitle = musicTitle;
        this.hit = hit;
    }

    public Track(int id, String regDate, String importMusicFile, int hit) {
        this.id = id;
        this.regDate = regDate;
        this.importMusicFile = importMusicFile;
        this.hit = hit;
    }


    public void increaseHit() {
        hit++;
    }

}
