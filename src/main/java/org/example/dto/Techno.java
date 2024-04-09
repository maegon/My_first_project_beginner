package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Techno {
    public int id;
    public String musicTitle;
    public String artistName;
    public String memberName;
    public String regdate;
    public int hit;
    public int recommed;
    public Techno(int id, String musicTitle, String artistName, String memberName, String regdate, int hit, int recommed) {
        this.id = id;
        this.musicTitle = musicTitle;
        this.artistName = artistName;
        this.memberName = memberName;
        this.regdate = regdate;
        this.hit = hit;
        this.recommed = recommed;
    }

    public void increaseHit() {
        hit++;
    }
}
