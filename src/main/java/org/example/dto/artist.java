package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class artist extends Dto {
    public int id;
    public String artistName;
    public String artistImage;

    public artist(int id, String artistName, String artistImage) {
        this.id = id;
        this.artistName = artistName;
        this.artistImage = artistImage;
    }
}
