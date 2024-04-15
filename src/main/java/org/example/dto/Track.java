package org.example.dto;


public class Track extends Dto {
    public String importMusicTitle;
    public String importMusicFile;
    public int hit;
    public String playMusicTitle; // 음악 실행했을때 곡 제목 표지
    public String startMusic;

    public void getPlayMusicTitle(int id, String regDate, String playMusicTitle) {
        this.id = id;
        this.regDate = regDate;
        this.playMusicTitle = playMusicTitle;
    }

    public String getPlayMusicTitle() {
        return playMusicTitle;
    }

    public String getStartMusic() {
        return startMusic;
    }

    public Track(int id, String regDate, String importMusicFile, String importMusicTitle, int hit) {
        this.id = id;
        this.regDate = regDate;
        this.importMusicFile = importMusicFile;
        this.importMusicTitle = importMusicTitle;
        this.hit = hit;
    }
    
    public Track(int id, String importMusicFile, String importMusicTitle) {
        this.id = id;
        this.importMusicFile = importMusicFile;
        this.importMusicTitle = importMusicTitle;
    }
    public Track(String playMusicTitle) {
        this.playMusicTitle = playMusicTitle;
    }

    public Track(int id, String regDate, String importMusicFile, String importMusicTitle) {
        this(id, regDate, importMusicFile, importMusicTitle, 0);
    }

    public void increaseHit() {
        hit++;
    }

}
