package org.example.FirstView;


import java.util.Scanner;



public class App {
    Scanner sc = new Scanner(System.in);
    public void start() {
        // 시작화면은 앱에서 제작해야함.

        
        // 메인 로고
        System.out.println("\u001B[36m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
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
        System.out.print("\u001B[33m ▌ "); System.out.print("비회원이 사용할 수 있는 명령어 : [공지사항] [장르별 추천] [로그인] [앱종료]                                    "); System.out.print("\u001B[33m▌ \n");
        System.out.print("\u001B[33m ▌ "); System.out.print("회원이시면 사용할 수 있는 명령어가 많아집니다.                                                                 "); System.out.print("\u001B[33m▌ \n");
        System.out.print("\u001B[33m ▌ "); System.out.print("계정이 없으시다면 명령어 입력 란에 [회원가입]을 입력하여 계정을 생성해주세요.                                  "); System.out.print("\u001B[33m▌ \n");
        System.out.print("\u001B[33m ▌ "); System.out.print("계정이 있으시면 명령어 입력 란에 [로그인]을 입력하여 로그인을 해주세요."); System.out.print("\u001B[33m                 ▌ \n");
        System.out.print("\u001B[33m ▌ "); System.out.print("4.     "); System.out.print("\u001B[33m▌ \n");
        System.out.print("\u001B[33m ▌ "); System.out.print("5.     "); System.out.print("\u001B[33m▌ \n");
        System.out.println("\u001B[33m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");

        //명령어 입력란(맨 마지막 줄에 출력)
        System.out.println("\u001B[38m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.print("\u001B[38m ▌ 명령어 입력 : "); String cmd = sc.nextLine(); System.out.println("                                                                    ▌");
        System.out.println("\u001B[37m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");


    }
//    public void doAction(String cmd) {
//        this.cmd = cmd;
//
//        switch ( actionMethodName ) {
//            case "write":
//                doWrite();
//                break;
//            case "list":
//                showList();
//                break;
//            case "detail":
//                showDetail();
//                break;
//            case "modify":
//                doModify();
//                break;
//            case "delete":
//                doDelete();
//                break;
//            case "currentBoard":
//                doCurrentBoard();
//                break;
//            case "changeBoard":
//                doChangeBoard();
//                break;
//            default:
//                System.out.println("존재하지 않는 명령어 입니다.");
//                break;
//        }
//    }

}
