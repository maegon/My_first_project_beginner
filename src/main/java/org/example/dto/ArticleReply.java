package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class ArticleReply extends Dto {
    public String memberName;
    public int id;
    public String body;

    public ArticleReply(Map<String, Object> row) {
        super(row);
        this.id = (int) row.get("id");
        this.memberName = (String) row.get("memberName");
        this.body = (String) row.get("body");
    }

}