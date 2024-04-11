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
    int lastMemberId;
    public static Scanner sc;
    private static List<Member> members;
    private String cmd;

    public MemberController() {
        sc = Container.getSc();
        members = new ArrayList<>();
    }

    public static void doAction(String cmd) {
        switch (cmd) {
            case "회원가입":
                doJoin();
                break;
            case "로그인":
                doLogin();
                break;
            case "로그아웃":
                doLogOut();
                break;
            default:
                System.out.println("\u001B[31m ▌ 존재하지 않는 명령어 입니다.");
                break;
        }
    }

    public static void doJoin() {
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

    public static void doLogin() {
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

        loginedMember = member;
        System.out.printf("\u001B[38m ▌ 로그인되었습니다.\n\u001B[38m ▌ %s님 환영합니다.\n", loginedMember.memberName);
    }

    public static void doLogOut() {
        if(Controller.isLogined() == true) {
            loginedMember = null;
            System.out.println("\u001B[38m ▌ 로그아웃 되었습니다.");
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

    // 회원가입시 이메일 중복 여부 체크
    private static boolean isJoinableMemberEmail(String memberEmail) {
        int index = getMemberIndexByMemberEmail(memberEmail);
        if (index != -1) {
            return true;
        }
        return false;
    }

    private static int getMemberIndexByMemberEmail(String memberEmail) {
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