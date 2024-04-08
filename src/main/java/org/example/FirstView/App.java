package org.example.FirstView;

import org.example.dto.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class App {
    private List<Member> members;

    public App() {
        members = new ArrayList<>();
    }


    public void start() {

        // 시작화면은 앱에서 제작해야함.
        Scanner sc = new Scanner(System.in);
        int lastMemberId = members.size();

        
        // 메인 로고
        System.out.println("\u001B[38m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        String[] mainLogo = new String[12];
        mainLogo[0] = "         ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄   ▄▄       ▄▄        ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄ ";
        mainLogo[1] = "        ▐░░░░░░░░░░░▌▐░░░░░░░░░░▌ ▐░░▌     ▐░░▌      ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌";
        mainLogo[2] = "        ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░▌░▌   ▐░▐░▌      ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀ ";
        mainLogo[3] = "        ▐░▌          ▐░▌       ▐░▌▐░▌▐░▌ ▐░▌▐░▌      ▐░▌          ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌          ";
        mainLogo[4] = "        ▐░▌          ▐░▌       ▐░▌▐░▌▐░▌ ▐░▌▐░▌      ▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄▄▄ ";
        mainLogo[5] = "        ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌       ▐░▌▐░▌ ▐░▐░▌ ▐░▌      ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌";
        mainLogo[6] = "        ▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░▌  ▐░▌  ▐░▌      ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀ ▐░▌       ▐░▌ ▀▀▀▀▀▀▀▀▀█░▌";
        mainLogo[7] = "        ▐░█▀▀▀▀▀▀▀▀▀ ▐░▌       ▐░▌▐░▌   ▀   ▐░▌      ▐░▌          ▐░▌          ▐░▌       ▐░▌          ▐░▌";
        mainLogo[8] = "        ▐░▌          ▐░▌       ▐░▌▐░▌       ▐░▌      ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌          ▐░█▄▄▄▄▄▄▄█░▌ ▄▄▄▄▄▄▄▄▄█░▌";
        mainLogo[9] = "        ▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌▐░▌       ▐░▌      ▐░░░░░░░░░░░▌▐░▌          ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌";
        mainLogo[10] = "        ▐░░░░░░░░░░░▌▐░░░░░░░░░░▌ ▐░▌       ▐░▌       ▀▀▀▀▀▀▀▀▀▀▀  ▀            ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀ ";
        mainLogo[11] = "         ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀   ▀         ▀";

        for(int i = 0; i < mainLogo.length; i++) {
            System.out.println("\u001B[36m"+mainLogo[i]);
        }


        // 메인 메뉴 출력(공지사항 자유게시판, 장르별 추천 표지, 검색어 입력란, 로그인 접속, 앱 종료)

        //명령어 코멘트 로고 밑에 출력
        System.out.println("\u001B[33m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█"); System.out.print("  메인 화면 명령어 목록  "); System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
        System.out.print("\u001B[33m ▌ "); System.out.print("비회원이 사용할 수 있는 명령어 : [장르별] [회원가입] [로그인] [앱종료]                                         "); System.out.print("\u001B[33m▌ \n");
        System.out.print("\u001B[33m ▌ "); System.out.print("회원이면 사용할 수 있는 명령어가 많아집니다.                                                                   "); System.out.print("\u001B[33m▌ \n");
        System.out.print("\u001B[33m ▌ "); System.out.print("계정이 없다면 명령어 입력 란에 [회원가입]을 입력하여 계정을 생성해주세요.                                      "); System.out.print("\u001B[33m▌ \n");
        System.out.print("\u001B[33m ▌ "); System.out.print("계정이 있으면 명령어 입력 란에 [로그인]을 입력하여 로그인을 해주세요.                                          "); System.out.print("\u001B[33m▌ \n");
        System.out.println("\u001B[33m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");




        //명령어 입력란(맨 마지막 줄에 출력)
        while (true) {
            System.out.println("\u001B[38m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
            System.out.print("\u001B[38m ▌ 명령어 입력 : ");
            String cmd = sc.nextLine();
            cmd = cmd.trim();



            if (cmd.length() == 0) {
                continue;
            }
            if (cmd.equals("앱종료")) {
                break;
            }


            if (cmd.equals("회원가입")) {
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
                        System.out.printf("\u001B[38m ▌ %s(은)는 이미 사용중인 활동 이름입니다.\n", memberName);
                        continue;
                    }
                    break;
                }

                String memberEmail = null;
                while (true) {
                    System.out.print("\u001B[38m ▌ 이메일 : ");
                    memberEmail = sc.nextLine();


                    if (isJoinableMemberEmail(memberEmail)) {
                        System.out.printf("\u001B[38m ▌ %s(은)는 이미 사용중인 이메일입니다.\n", memberEmail);
                        continue;
                    }
                    break;
                }

                
                // 회원가입 완료시 저장 및 출력
                Member member = new Member(id, loginId, loginPw, loginPwConfirm, memberName, memberEmail);
                members.add(member);
                System.out.printf("\u001B[38m ▌ 회원가입이 완료되었습니다.\n\u001B[38m ▌ %s님 환영합니다.\n", memberName);
            }
            
            // 메인 화면에서 존재하지 않는 명령어 입력시 출력
            else {
                System.out.printf("\u001B[38m ▌ %s(은)는 존재하지 않는 명령어 입니다.\n", cmd);
            }

        }

        // 앱 종료
        sc.close();
        System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█"); System.out.print("       앱 종료       "); System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
    }


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
