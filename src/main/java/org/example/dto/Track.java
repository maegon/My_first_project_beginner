package org.example.dto;


public class Track extends Dto {
    private String importMusicTitle;
    private String importMusicFile;
    private String playMusicTitle; // 음악 실행했을때 곡 제목 표지
    private String startMusic;

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
    
    public Track(int id, String importMusicFile, String importMusicTitle) {
        this.id = id;
        this.importMusicFile = importMusicFile;
        this.importMusicTitle = importMusicTitle;
    }
    public Track(String playMusicTitle) {
        this.playMusicTitle = playMusicTitle;
    }

    


}
