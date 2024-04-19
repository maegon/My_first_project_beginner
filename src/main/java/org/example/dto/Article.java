package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
@AllArgsConstructor
public class Article extends Dto {
    public String title;
    public String body;
    public int hit;
    public String memmberName;

    public Article(Map<String, Object> row) {
        super(row);
        this.title = (String) row.get("title");
        this.body = (String) row.get("body");
        this.hit = (int) row.get("hit");
        this.memmberName = (String) row.get("memberName");
    }



    public void increaseHit() {
        hit++;
    }
}