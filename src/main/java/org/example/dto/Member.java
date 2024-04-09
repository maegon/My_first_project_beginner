package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Member extends Dto {
    public String loginId;
    public String loginPw;
    public String memberName;
    public String memberEmail;
    public Member(Map<String, Object> row) {
//        super(row);
        this.id = (int) row.get("id");
        this.loginId = (String) row.get("loginId");
        this.loginPw = (String) row.get("loginPw");
        this.memberName = (String) row.get("memberName");
        this.memberEmail = (String) row.get("memberEmail");
    }
}