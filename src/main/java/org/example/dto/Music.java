package org.example.dto;


public class Music extends Dto {
    public String musicTitle;
    Artist artistName;
    public int hit;
    public String memberName;

    public Music(int id, String regDate, String artistName, String musicTitle, int hit, String memberName) {
        this.id = id;
        this.regDate = regDate;
        this.artistName = new Artist(artistName);
        this.musicTitle = musicTitle;
        this.hit = hit;
        this.memberName = memberName;
    }
    public Music(int id, String artistName, String musicTitle, String memberName) {
        this.id = id;
        this.artistName = new Artist(artistName);
        this.musicTitle = musicTitle;
        this.hit = 0;
        this.memberName = memberName;
    }

    public Music(String musicTitle) {
        this.musicTitle = musicTitle;
    }


    public void increaseHit() {
        hit++;
    }

}
