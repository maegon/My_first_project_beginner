package org.example.FirstView;

import org.example.container.Container;
//import org.example.controller.*;
import org.example.controller.ArticleController;
import org.example.controller.MemberController;
//import org.example.controller.MusicController;
import org.example.dto.Member;

import java.util.ArrayList;
import java.util.List;




public class App {
//    private List<Member> members;

    public App() {
//        members = new ArrayList<>();
    }


    public void start() {
        MemberController memberController = new MemberController();
        ArticleController articleController = new ArticleController();

        // 시작화면은 앱에서 제작해야함.
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


        // 메인 화면 배경음악 출력
        Music introMusic = new Music("Jim Yosef & Shiah Maisel - Just Getting Started [NCS Release] - BGM.mp3", true); // 테스트를 위한 음악 재생
        introMusic.start();
        System.out.println("\u001B[36m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.print("\u001B[36m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█"); System.out.print("  메인 화면 배경 음악  "); System.out.print("\u001B[36m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
        System.out.print("\u001B[36m ▌ "); System.out.println("메인화면 음악 고정  ▶  Jim Yosef & Shiah Maisel - Just Getting Started [NCS Release] - BGM");
        System.out.println("\u001B[36m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");

        // 메인 메뉴 출력(공지사항 자유게시판, 장르별 추천 표지, 검색어 입력란, 로그인 접속, 앱 종료)

        // 명령어 코멘트 로고 밑에 출력
        // 노래 검색에 관하여.. 노래 검색하게 되면 노래제목과 연관된 음악들 표출
        // 표출된 음악들은 누가 만들었는지 아티스트도 같이 표출됨
        // 사용자가 원하는 노래만 실행하려 할때 음악 목록중 '번호'로 숫자만 입력받아 노래 재생해줌
        // 회원은 노래 검색 후 재생시 풀버전으로 재생해줌
        // 앞선 내용 구현되면 반복재생(boolean isLoop)을 걸지 안걸지에 맞춰 루프를 적용시키는 것도 구현해볼 것
        // 비회원은 노래 검색 후 재생시 15초만 재생할수 있도록 음악파일을 초반 15초만 잘라서 1번 재생해줌
        // 회원은 아티스트 검색시 아티스트가 낸 음악 목록 표출 
        // 장르별 추천음악은 나중에 추가
        System.out.println("\u001B[33m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█"); System.out.print("  메인 화면 명령어 목록  "); System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
        System.out.print("\u001B[33m ▌ "); System.out.print("비회원이 사용할 수 있는 명령어 : [회원가입] [로그인] [앱종료]                                                  "); System.out.print("\u001B[33m▌ \n");
        System.out.print("\u001B[33m ▌ "); System.out.print("회원이면 사용할 수 있는 명령어가 많아집니다.                                                                   "); System.out.print("\u001B[33m▌ \n");
        System.out.print("\u001B[33m ▌ "); System.out.print("계정이 없다면 명령어 입력 란에 [회원가입]을 입력하여 계정을 생성해주세요.                                      "); System.out.print("\u001B[33m▌ \n");
        System.out.print("\u001B[33m ▌ "); System.out.print("계정이 있으면 명령어 입력 란에 [로그인]을 입력하여 로그인을 해주세요.                                          "); System.out.print("\u001B[33m▌ \n");
        System.out.println("\u001B[33m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");


        memberController.makeTestData();

        //명령어 입력란(맨 마지막 줄에 출력)
        while (true) {
            System.out.println("\u001B[38m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
            System.out.print("\u001B[38m ▌ 명령어 입력 : ");
            String cmd = Container.getSc().nextLine();
            cmd = cmd.trim();



            if (cmd.length() == 0) {
                continue;
            }
            if (cmd.equals("앱종료")) {
                introMusic.close();
                break;
            }


            if (cmd.equals("회원가입")) {
                memberController.doJoin();
            }

            else if (cmd.equals("로그인")) {
                memberController.doLogin();
            }

            else if (cmd.equals("로그아웃")) {
                memberController.doLogOut();
            }

            else if (cmd.equals("글목록")) {
                articleController.showList();
            }
            else if (cmd.equals("글검색")) {
                articleController.doSearch();
            }
            else if (cmd.equals("글작성")) {
                articleController.doWrite();
            }
            else if (cmd.equals("글수정")) {
                articleController.doModify();
            }
            else if (cmd.equals("글삭제")) {
                articleController.doDelete();
            }
            else if (cmd.equals("글보기")) {
                articleController.showDetail();
            }

//            else if (cmd.equals("음악검색")) {
//                MusicController.doSearchMusic();
//            }

//            else if (cmd.equals("아티스트검색")) {
//                ArtistController.doSearchArtist();
//            }


            // 사용자가 원하는 음악을 선택해 실행하면 메인화면의 인트로 음악 재생 종료됨.
            // 사용자가 원하는 음악이 끝나면 3초있다가 다시 메인화면 인트로 음악 재생됨.

            // db에 음악 파일을 그대로 저장하지말고 음악파일이 저장되어있는 경로와 정보들만 저장함.

            // 메인 화면에서 존재하지 않는 명령어 입력시 출력
            else {
                System.out.printf("\u001B[31m ▌ %s(은)는 존재하지 않는 명령어 입니다.\n", cmd);
            }

        }
//
//
//
//        // 앱 종료
//        Container.getSc().close();
//        System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█"); System.out.print("       앱 종료       "); System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
    }
//
//
//
//
//
}