package org.example.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
@AllArgsConstructor
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


    public void increaseHit() {
        hit++;
    }

}
