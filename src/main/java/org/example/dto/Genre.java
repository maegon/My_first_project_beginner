package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Genre extends Dto {
    public int id;
    public String technoGenre;
    public String houseGenre;
    public String dubstepGenre;
    public String tranceGenre;
    public String drumAndBaseGenre;
    public String hardStyleGenre;
    public String trapGenre;
    public String footWorkGenre;
    public String downTempoGenre;
    public String moombahtonGenre;
    public Genre(int id, String technoGenre, String houseGenre, String dubstepGenre, String tranceGenre, String drumAndBaseGenre, String hardStyleGenre, String trapGenre, String footWorkGenre, String downTempoGenre, String moombahtonGenre) {
        this.id = id;
        this.technoGenre = technoGenre;
        this.houseGenre = houseGenre;
        this.dubstepGenre = dubstepGenre;
        this.tranceGenre = tranceGenre;
        this.drumAndBaseGenre = drumAndBaseGenre;
        this.hardStyleGenre = hardStyleGenre;
        this.trapGenre = trapGenre;
        this.footWorkGenre = footWorkGenre;
        this.downTempoGenre = downTempoGenre;
        this.moombahtonGenre = moombahtonGenre;


    }
}
