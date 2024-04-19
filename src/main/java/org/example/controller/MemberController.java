package org.example.controller;

import lombok.Getter;
import lombok.Setter;
import org.example.container.Container;
import org.example.dto.Member;
import org.example.service.MemberService;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.util.Scanner;


@Getter
@Setter

public class MemberController extends Controller {
    private Scanner sc;
    private String cmd;
    private MemberService memberService;
    private Session session;


    public MemberController() {
        this.sc = Container.getSc();
        memberService = Container.memberService;
        session = Container.getSession();
    }

//    private static int getMemberIndexByMemberName(String memberName) {
//        int i = 0;
//        for (Member member : members) {
//            if (member.memberName.equals(memberName)) {
//                return i;
//            }
//            i++;
//        }
//        return -1;
//    }

    public void doAction(String cmd) {
        this.cmd = cmd;
        switch (cmd) {
            case "로그인":
                doLogin();
                break;
            case "로그아웃":
                doLogOut();
                break;
            case "회원가입":
                doJoin();
                break;
        }
    }

    public void doJoin() {
        int id = Container.memberDao.getNewId();
        String loginId = null;
        while (true) {
            System.out.print("\u001B[38m ▌ 아이디 : ");
            loginId = sc.nextLine();

            if (isJoinableLoginId(loginId) == false) {
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
            memberName = sc.nextLine();

            if (isJoinableMemberName(memberName) == false) {
                System.out.printf("\u001B[35m ▌ %s(은)는 이미 사용중인 활동 이름입니다.\n", memberName);
                continue;
            }
            break;
        }

        String adminId = "null";

        memberService.join(loginId, loginPw, memberName, adminId);
        System.out.printf("\u001B[35m ▌ 회원가입이 완료되었습니다.\n\u001B[35m ▌ %s님 환영합니다.\n", memberName);

    }

    public void doLogin() {
        try {

            System.out.print("\u001B[38m ▌ 아이디 : ");
            String loginId = sc.nextLine();
            System.out.print("\u001B[38m ▌ 패스워드 : ");
            String loginPw = sc.nextLine();

            Member member = memberService.getMemberByLoginId(loginId);

            if (member == null) {
                System.out.println("\u001B[31m ▌ 아이디가 일치하지 않습니다.");
                return;
            }
            if (member.loginPw.equals(loginPw) == false) {
                System.out.println("\u001B[31m ▌ 비밀번호가 일치하지 않습니다.");
                return;
            }

            if (member.id == 1) {
                System.out.print("\u001B[38m ▌ 관리자번호 : ");
                String adminId = sc.nextLine();
                if (adminId.equals("SBS12341499JW") != true) {
                    System.out.println("\u001B[31m ▌ 관리자번호가 일치하지 않습니다.");
                    return;
                }
            }

            session.setLoginedMember(member);
            Member loginedMember = session.getLoginedMember();

            System.out.printf("\u001B[35m ▌ 로그인되었습니다.\n\u001B[35m ▌ %s님 환영합니다.\n", loginedMember.memberName);
            System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
            System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
            System.out.print("  회원 전용 명령어 목록  ");
            System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
            System.out.print("\u001B[33m ▌ ");
            System.out.print("음악 관련 명령어 : [음악목록] [음악검색]                                                                       ");
            System.out.print("\u001B[33m▌ \n");
            System.out.print("\u001B[33m ▌ ");
            System.out.print("게시물 관련 명령어 : [글목록] [글검색] [글보기] [글작성] [글수정] [글삭제]                                     ");
            System.out.print("\u001B[33m▌ \n");
            System.out.print("\u001B[33m ▌ ");
            System.out.print("기능 관련 명령어 : [로그아웃] [앱종료]                                                                         ");
            System.out.print("\u001B[33m▌ \n");
            if (member.adminId.equals("SBS12341499JW") == true) {
                System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
                System.out.print("  관리자 전용 명령어 목록  ");
                System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
                System.out.print("\u001B[33m ▌ ");
                System.out.print("음악 관련 명령어 : [음악추가]                                                                                  ");
                System.out.print("\u001B[33m▌ \n");
            }
            System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        } catch (NullPointerException e) {

        }
    }

    private void doLogOut() {
        session.setLoginedMember(null);
//        musicController.stopMainScreenMusic();
//        musicController.stopSelectedMusic();
        System.out.println("\u001B[35m ▌ 로그아웃 되었습니다.");
    }

    // 회원가입시 활동 이름 중복 여부 체크
//    private boolean isJoinableMemberName(String memberName) {
//        int index = getMemberIndexByMemberName(memberName);
//        if (index != -1) {
//            return true;
//        }
//        return false;
//    }

    private boolean isJoinableLoginId(String loginId) {
        Member member = memberService.getMemberByLoginId(loginId);
        if (member == null) {
            return true;
        }
        return false;
    }

    private boolean isJoinableMemberName(String memberName) {
        Member member = memberService.isJoinableMemberName(memberName);
        if (member == null) {
            return true;
        }
        return false;
    }

}