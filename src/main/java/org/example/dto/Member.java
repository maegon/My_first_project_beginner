package org.example.dto;

import java.util.Map;

public class Member extends Dto {
    public String adminId;
    public String loginId;
    public String loginPw;
    public String loginPwConfirm;
    public String memberName;

    public Member(int id, String regDate, String loginId, String loginPw, String loginPwConfirm, String memberName) {
        this.id = id;
        this.regDate = regDate;
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.loginPwConfirm = loginPwConfirm;
        this.memberName = memberName;
    }

    public Member(int id, String loginId, String loginPw, String memberName) {
        this.id = id;
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.memberName = memberName;
    }

    public Member(int id, String loginId, String loginPw, String memberName, String adminId) {
        this.id = id;
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.memberName = memberName;
        this.adminId = adminId;
    }

    public Member(Map<String, Object> row) {
        super(row);
        this.loginId = (String) row.get("loginId");
        this.loginPw = (String) row.get("loginPw");
        this.memberName = (String) row.get("memberName");
    }
}