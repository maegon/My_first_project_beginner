package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
public class Article extends Dto {
    public String title;
    public String body;
    public int hit;
    public String memberName;

    public Article(String memmberName, String title, String body, int hit) {
        this.memberName = memmberName;
        this.title = title;
        this.body = body;
        this.hit = hit;
    }

    public Article(String memberName, String title, String body) {
        this(memberName, title, body, 0);
    }

    public Article(Map<String, Object> row) {
        super(row);
        this.memberName = (String) row.get("memberName");
        this.title = (String) row.get("title");
        this.body = (String) row.get("body");
        this.hit = (int) row.get("hit");
    }



    public void increaseHit() {
        hit++;
    }

}