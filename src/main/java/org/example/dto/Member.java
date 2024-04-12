package org.example.dto;

public class Member extends Dto {
    public String adminId;
    public String loginId;
    public String LoginPw;
    public String loginPwConfirm;
    public String memberName;
    public Member(int id, String regDate, String loginId, String loginPw, String loginPwConfirm, String memberName) {
        this.id = id;
        this.regDate = regDate;
        this.loginId = loginId;
        this.LoginPw = loginPw;
        this.loginPwConfirm = loginPwConfirm;
        this.memberName = memberName;
    }

    public Member(int id, String loginId, String loginPw, String memberName) {
        this.id = id;
        this.loginId = loginId;
        this.LoginPw = loginPw;
        this.memberName = memberName;
    }

    public Member(int id, String loginId, String loginPw, String memberName, String adminId) {
        this.id = id;
        this.loginId = loginId;
        this.LoginPw = loginPw;
        this.memberName = memberName;
        this.adminId = adminId;
    }
}