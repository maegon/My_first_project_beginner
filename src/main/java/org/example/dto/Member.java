package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter

public class Member extends Dto {
    public String adminId;
    public String loginId;
    public String loginPw;
    public String memberName;

    public Member(Map<String, Object> row) {
        super(row);
        this.loginId = (String) row.get("loginId");
        this.loginPw = (String) row.get("loginPw");
        this.memberName = (String) row.get("memberName");
        this.adminId = (String) row.get("adminId");
    }

    public Member(String loginId, String loginPw, String memberName, String adminId) {
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.memberName = memberName;
        this.adminId = adminId;
    }

}