package org.example.dto;


public class Track extends Dto {
    public String importMusicFile;
    public String musicTitle;
    public int hit;
    public String startMusic;



    public String getStartMusic() {
        return startMusic;
    }




    public Track(int id, String importMusicFile, String musicTitle) {
        super();
        this.id = id;
        this.importMusicFile = importMusicFile;
        this.musicTitle = musicTitle;
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
