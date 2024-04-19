package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor

public class Member extends Dto {
    public String adminId;
    public String loginId;
    public String loginPw;
    public String memberName;

    public Member(Map<String, Object> row) {
        super(row);
        this.adminId = (String) row.get("adminId");
        this.loginId = (String) row.get("loginId");
        this.loginPw = (String) row.get("loginPw");
        this.memberName = (String) row.get("memberName");
    }

}