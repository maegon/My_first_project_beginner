package org.example.dto;

public class Article extends Dto {
    public int id;
    public String regDate;
    public String title;
    public String body;
    public int hit;

    public Article(int id, String regDate, String title, String body, int hit) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.regDate = regDate;
        this.hit = hit;
    }

    public Article(int id, String regDate, String title, String body) {  // Article 클래스 내부에 있는 hit값을 임의로 넣어주지 않아도 자동으로 가져오는 기능
        this(id, regDate, title, body, 0);
    }

    public void increaseHit() {
        hit++;
    }
}
