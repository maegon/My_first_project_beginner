package org.example.controller;

import lombok.Getter;
import lombok.Setter;
import org.example.dto.Member;

@Getter
@Setter

// 현재 사용자가 이용중인 정보.
// 이 안의 정보는 사용자가 프로그램을 사용 할 때 동안은 계속 유지됨.
public class Session {
    private Member loginedMember;
    public String adminId = "SBS12341499JW";



    public Member getLoginedMember() {
        return loginedMember;
    }

    public void setLoginedMember(Member loginedMember) {
        this.loginedMember = loginedMember;
    }


    public boolean isLogined() {
        return loginedMember != null;
    }


    public boolean isAdminId() {
        return adminId.equals("SBS12341499JW") == true;
    }
}