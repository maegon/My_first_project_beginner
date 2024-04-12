package org.example.dto;

public class Artist extends Dto {
    public String artistName;
    Music musicTitle;
    public int hit;

    public Artist(int id, String regDate, String artistName, int hit, String musicTitle) {
        this.id = id;
        this.regDate = regDate;
        this.artistName = artistName;
        this.hit = hit;
        this.musicTitle = new Music(musicTitle);
    }
    public Artist(String artistName) {
        this.artistName = artistName;
    }

    public void increaseHit() {
        hit++;
    }
}
