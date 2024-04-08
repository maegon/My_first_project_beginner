package org.example.dto;

public class Member extends Dto {
    public int id;
    public String loginId;
    public String LoginPw;
    public String loginPwConfirm;
    public String memberName;
    public String memberEmail;
    public Member(int id, String loginId, String loginPw, String loginPwConfirm, String memberName, String memberEmail) {
        this.id = id;
        this.loginId = loginId;
        this.LoginPw = loginPw;
        this.loginPwConfirm = loginPwConfirm;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
    }
}
