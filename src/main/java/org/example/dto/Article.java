package org.example.dto;

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

    public Article(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }


    public void increaseHit() {
        hit++;
    }
}