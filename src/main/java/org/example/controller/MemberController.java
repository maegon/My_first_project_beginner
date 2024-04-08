package org.example.controller;

import lombok.Getter;
import lombok.Setter;
import org.example.container.Container;
import org.example.dto.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter

public class MemberController extends Controller {
    public Scanner sc;
    private List<Member> members;
    public MemberController() {
        sc = Container.getSc();
        members = new ArrayList<>();
    }


    public void doJoin() {
        int id = members.size() + 1;
        String loginId = null;
        while (true) {
            System.out.print("\u001B[38m ▌ 아이디 : ");
            loginId = sc.nextLine();

            if (isJoinableLoginId(loginId)) {
                System.out.printf("\u001B[38m ▌ %s(은)는 이미 사용중인 아이디입니다.\n", loginId);
                continue;
            }
            break;
        }
        String loginPw = null;
        String loginPwConfirm = null;
        while (true) {
            System.out.print("\u001B[38m ▌ 패스워드 : ");
            loginPw = sc.nextLine();
            System.out.print("\u001B[38m ▌ 패스워드 확인 : ");
            loginPwConfirm = sc.nextLine();
            if (loginPw.equals(loginPwConfirm) == false) {
                System.out.println("\u001B[38m ▌ 비밀번호가 일치하지 않습니다.\n재입력해주세요.");
                continue;
            }
            break;
        }

        String memberName = null;
        while (true) {
            System.out.print("\u001B[38m ▌ 활동 이름 : ");
            memberName= sc.nextLine();

            if (isJoinableMemberName(memberName)) {
                System.out.printf("\u001B[31m ▌ %s(은)는 이미 사용중인 활동 이름입니다.\n", memberName);
                continue;
            }
            break;
        }

        String memberEmail = null;
        while (true) {
            System.out.print("\u001B[38m ▌ 이메일 : ");
            memberEmail = sc.nextLine();


            if (isJoinableMemberEmail(memberEmail)) {
                System.out.printf("\u001B[31m ▌ %s(은)는 이미 사용중인 이메일입니다.\n", memberEmail);
                continue;
            }
            break;
        }

        // 회원가입 완료시 저장 및 출력
        Member member = new Member(id, loginId, loginPw, loginPwConfirm, memberName, memberEmail);
        members.add(member);
        System.out.printf("\u001B[38m ▌ 회원가입이 완료되었습니다.\n\u001B[38m ▌ %s님 환영합니다.\n", memberName);
    }



    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    // 회원가입시 아이디 중복 여부 체크
    private boolean isJoinableLoginId(String loginId) {
        int index = getMemberIndexByLoginId(loginId);
        if (index != -1) {
            return true;
        }
        return false;
    }

    private int getMemberIndexByLoginId(String loginId) {
        int i = 0;
        for ( Member member : members ) {
            if ( member.loginId.equals(loginId)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    // 회원가입시 활동 이름 중복 여부 체크
    private boolean isJoinableMemberName(String memberName) {
        int index = getMemberIndexByMemberName(memberName);
        if (index != -1) {
            return true;
        }
        return false;
    }

    private int getMemberIndexByMemberName(String memberName) {
        int i = 0;
        for ( Member member : members ) {
            if ( member.memberName.equals(memberName)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    // 회원가입시 이메일 중복 여부 체크
    private boolean isJoinableMemberEmail(String memberEmail) {
        int index = getMemberIndexByMemberEmail(memberEmail);
        if (index != -1) {
            return true;
        }
        return false;
    }

    private int getMemberIndexByMemberEmail(String memberEmail) {
        int i = 0;
        for ( Member member : members ) {
            if ( member.memberEmail.equals(memberEmail)) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
