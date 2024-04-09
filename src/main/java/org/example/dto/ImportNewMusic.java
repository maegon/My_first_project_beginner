package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ImportNewMusic extends Dto {
    public int id;
    public String musicTitle;
    public String artistName;
    public String memberName;
    public String regdate;
    String genres;
    public int hit;
    public int recommed;
    public ImportNewMusic(int id, String genres, String musicTitle, String artistName, String memberName, String regdate, int hit, int recommed) {
        this.id = id;
        this.genres = genres;
        this.musicTitle = musicTitle;
        this.artistName = artistName;
        this.memberName = memberName;
        this.regdate = regdate;
        this.hit = hit;
        this.recommed = recommed;
    }


    public ImportNewMusic(int id, String musicTitle, String memberName, String regDate, List<Genre> genres) {
        super();
    }
}
