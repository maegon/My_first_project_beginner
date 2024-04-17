package org.example.dao;

import org.example.dto.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberDao extends Dao {
    public List<Member> members;
    public MemberDao() {
        members = new ArrayList<>();
    }

    public void join(Member member) {
        members.add(member);
        lastId = member.id;
    }

    // 회원가입시 아이디 중복 여부 체크
    public boolean isJoinableLoginId(String loginId) {
        int index = getMemberIndexByLoginId(loginId);
        if (index != -1) {
            return true;
        }
        return false;
    }


    // 로그인 일치 여부 확인
    public Member getMemberByLoginId(String loginId) {
        int index = getMemberIndexByLoginId(loginId);
        if (index == -1) {
            return null;
        }
        return members.get(index);
    }

    public int getMemberIndexByLoginId(String loginId) {
        int i = 0;
        for ( Member member : members ) {
            if ( member.loginId.equals(loginId)) {
                return i;
            }
            i++;
        }
        return -1;
    }

}