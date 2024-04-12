package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.dto.Board;
import org.example.dto.Member;

import javax.tools.Diagnostic;

@Getter
@Setter
@AllArgsConstructor

// 현재 사용자가 이용중인 정보.
// 이 안의 정보는 사용자가 프로그램을 사용 할 때 동안은 계속 유지됨.
public class Session {
    private Member loginedMember;
    private Board currentBoard;

    public Member getLoginedMember() {
        return loginedMember;
    }

    public void setLoginedMember(Member loginedMember) {
        this.loginedMember = loginedMember;
    }


    public boolean isLogined() {
        return loginedMember != null;
    }


}