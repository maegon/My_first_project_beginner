package org.example.FirstView;


import org.example.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class App {

    public void start() {

        // 시작화면은 앱에서 제작해야함.
        Scanner sc = new Scanner(System.in);

//        MemberController memberController = new MemberController(sc);
//        ArticleController articleController = new ArticleController(sc);
//
//
//        articleController.makeTestData();
        
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
        mainLogo[10] = "        ▐░░░░░░░░░░░▌▐░░░░░░░░░░▌ ▐░▌       ▐░▌      ▀▀▀▀▀▀▀▀▀▀▀  ▀            ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀ ";
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


        }
        sc.close();
        System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█"); System.out.print("       앱 종료       "); System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
    }
}
