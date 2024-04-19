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
    public String memberName;

    public Article(int id, String regDate, String memberName, String title, String body, int hit) {
        this.id = id;
        this.regDate = regDate;
        this.memberName = memberName;
        this.title = title;
        this.body = body;
        this.hit = hit;
    }


    public Article(int id, String regDate, String memberName, String title, String body) {
        this(id, regDate, memberName, title, body, 0);
    }

    public Article(int id, String memberName, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.memberName = memberName;
    }

    public Article(Map<String, Object> row) {
        super(row);
        this.title = (String) row.get("title");
        this.body = (String) row.get("body");
        this.memberName = (String) row.get("memberName");
        this.hit = (int) row.get("hit");
    }


    public void increaseHit() {
        hit++;
    }
}