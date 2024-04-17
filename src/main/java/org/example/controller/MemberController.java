package org.example.controller;

import lombok.Getter;
import lombok.Setter;
import org.example.container.Container;
import org.example.dto.Article;
import org.example.dto.Member;
import org.example.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



@Getter
@Setter

public class MemberController extends Controller {
    int lastMemberId;
    public static Scanner sc;
    private static List<Member> members;
    private String cmd;


    public MemberController() {
        sc = Container.getSc();
        members = new ArrayList<>();
    }

    public void makeTestData() {
        members.add(new Member(1, "admin", "admin", "관리자", "SBS12341499JW"));
    }

    public static void doJoin() {
        if (isLogined() == true ) {
            System.out.println("\u001B[31m ▌ 로그아웃 상태가 아닙니다.");
            return;
        }
        int id = members.size() + 1;
        String loginId = null;
        while (true) {
            System.out.print("\u001B[38m ▌ 아이디 : ");
            loginId = sc.nextLine();

            if (isJoinableLoginId(loginId)) {
                System.out.printf("\u001B[35m ▌ %s(은)는 이미 사용중인 아이디입니다.\n", loginId);
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
                System.out.println("\u001B[35m ▌ 비밀번호가 일치하지 않습니다.\n재입력해주세요.");
                continue;
            }
            break;
        }

        String memberName = null;
        while (true) {
            System.out.print("\u001B[38m ▌ 활동 이름 : ");
            memberName= sc.nextLine();

            if (isJoinableMemberName(memberName)) {
                System.out.printf("\u001B[35m ▌ %s(은)는 이미 사용중인 활동 이름입니다.\n", memberName);
                continue;
            }
            break;
        }

        // 회원가입 완료시 저장 및 출력
        Member member = new Member(id, loginId, loginPw, loginPwConfirm, memberName);
        members.add(member);
        System.out.printf("\u001B[35m ▌ 회원가입이 완료되었습니다.\n\u001B[35m ▌ %s님 환영합니다.\n", memberName);
    }

    public static void doLogin() {
        if (isLogined() == true ) {
            System.out.println("\u001B[31m ▌ 로그아웃 상태가 아닙니다.");
            return;
        }
        System.out.print("\u001B[38m ▌ 아이디 : ");
        String loginId = sc.nextLine();
        System.out.print("\u001B[38m ▌ 패스워드 : ");
        String loginPw = sc.nextLine();

        Member member = getMemberByLoginId(loginId);
        if (member == null) {
            System.out.println("\u001B[31m ▌ 아이디가 일치하지 않습니다.");
            return;
        }
        if (member.LoginPw.equals(loginPw) == false) {
            System.out.println("\u001B[31m ▌ 비밀번호가 일치하지 않습니다.");
            return;
        }

        if (member.id == 1) {
            System.out.print("\u001B[38m ▌ 관리자번호 : ");
            String adminId = sc.nextLine();
            if(adminId.equals("SBS12341499JW") != true) {
                System.out.println("\u001B[31m ▌ 관리자번호가 일치하지 않습니다.");
                return;
            }
        }

        loginedMember = member;
        System.out.printf("\u001B[35m ▌ 로그인되었습니다.\n\u001B[35m ▌ %s님 환영합니다.\n", loginedMember.memberName);
        System.out.println("\u001B[33m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█"); System.out.print("  회원 전용 명령어 목록  "); System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
        System.out.print("\u001B[33m ▌ "); System.out.print("음악 관련 명령어 : [음악목록] [음악검색]                                                                       "); System.out.print("\u001B[33m▌ \n");
        System.out.print("\u001B[33m ▌ "); System.out.print("게시물 관련 명령어 : [글목록] [글검색] [글보기] [글작성] [글수정] [글삭제]                                     "); System.out.print("\u001B[33m▌ \n");
        System.out.print("\u001B[33m ▌ "); System.out.print("기능 관련 명령어 : [메인화면] [로그아웃] [앱종료]                                                              "); System.out.print("\u001B[33m▌ \n");
        if(member.adminId.equals("SBS12341499JW") == true) {
            System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█"); System.out.print("  관리자 전용 명령어 목록  "); System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
            System.out.print("\u001B[33m ▌ "); System.out.print("음악 관련 명령어 : [음악추가]                                                                                  "); System.out.print("\u001B[33m▌ \n");
        }
        System.out.println("\u001B[33m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
    }


    public static void doLogOut() {
        if (isLogined() == false ) {
            System.out.println("\u001B[31m ▌ 로그인 상태가 아닙니다.");
            return;
        }
        if(isLogined() == true) {
            loginedMember = null;
            System.out.println("\u001B[35m ▌ 로그아웃 되었습니다.");
        }
    }


    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    // 로그인시 아이디 일치 여부 체크
    private static Member getMemberByLoginId(String loginId) {
        int index = getMemberIndexByLoginId(loginId);
        if (index == -1) {
            return null;
        }
        return members.get(index);
    }


    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    // 회원가입시 아이디 중복 여부 체크
    private static boolean isJoinableLoginId(String loginId) {
        int index = getMemberIndexByLoginId(loginId);
        if (index != -1) {
            return true;
        }
        return false;
    }

    private static int getMemberIndexByLoginId(String loginId) {
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
    private static boolean isJoinableMemberName(String memberName) {
        int index = getMemberIndexByMemberName(memberName);
        if (index != -1) {
            return true;
        }
        return false;
    }

    private static int getMemberIndexByMemberName(String memberName) {
        int i = 0;
        for ( Member member : members ) {
            if ( member.memberName.equals(memberName)) {
                return i;
            }
            i++;
        }
        return -1;
    }

}