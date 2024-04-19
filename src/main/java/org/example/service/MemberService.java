package org.example.service;

import org.example.container.Container;
import org.example.dao.MemberDao;
import org.example.dto.Member;

public class MemberService {
    private MemberDao memberDao;

    public MemberService() {
        memberDao = Container.memberDao;
    }

    public int join(String loginId, String loginPw, String memberName, String adminId) {
        Member member = new Member(loginId, loginPw, memberName, adminId);
        return memberDao.join(member);
    }

    public Member getMemberByLoginId(String loginId) {
        return memberDao.getMemberByLoginId(loginId);
    }

//    public int getMemberIndexByLoginId(String loginId) {
//        return  memberDao.getMemberIndexByLoginId(loginId);
//    }

    public Member getMember(String memberName) {
        return memberDao.getMember(memberName);
    }

    public Member getMember(int id) {
        return memberDao.getMember(id);
    }

}