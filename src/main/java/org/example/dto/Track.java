package org.example.dto;


public class Track extends Dto {
    public String importMusicFile;
    public int hit;
    public String startMusic;


    public String getStartMusic() {
        return startMusic;
    }

    public Track(int id, String importMusicFile) {
        this.id = id;
        this.regDate = regDate;
        this.importMusicFile = importMusicFile;
        this.hit = hit;
    }
    public Track(String importMusicFile) {
        this.importMusicFile = importMusicFile;
    }

    public Track(int id, String regDate, String importMusicFile, int hit) {
        super();
        this.id = id;
        this.regDate = regDate;
        this.importMusicFile = importMusicFile;
        this.hit = hit;
    }


    public void increaseHit() {
        hit++;
    }

}
