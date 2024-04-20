package org.example.FirstView;

import org.example.container.Container;
import org.example.controller.ArticleController;
import org.example.controller.Controller;
import org.example.controller.MemberController;
import org.example.controller.MusicController;
import org.example.db.DBConnection;

public class App {

    public static Music introMusic;

    public App() {
        DBConnection.DB_NAME = "ljw_beginner_pj_sbs";
        DBConnection.DB_USER = "sbsst";
        DBConnection.DB_PASSWORD = "sbs123414";
        DBConnection.DB_PORT = 3306;

        Container.getDBConnection().connect();
    }

    public void AppStart() {
        MemberController memberController = new MemberController();
        ArticleController articleController = new ArticleController();
        MusicController musicController = new MusicController();

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
        Music introMusic = new Music("Jim Yosef & Shiah Maisel - Just Getting Started.mp3", true); // 테스트를 위한 음악 재생
        introMusic.start();
        System.out.println("\u001B[36m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.print("\u001B[36m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█"); System.out.print("  메인 화면 배경 음악  "); System.out.print("\u001B[36m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
        System.out.print("\u001B[36m ▌ "); System.out.print("메인화면 음악 고정  ▶  Jim Yosef & Shiah Maisel - Just Getting Started                                        ");System.out.print("\u001B[36m ▌ \n");
        System.out.println("\u001B[36m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");


        System.out.println("\u001B[33m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█"); System.out.print("  메인 화면 명령어 목록  "); System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
        System.out.print("\u001B[33m ▌ "); System.out.print("비회원이 사용할 수 있는 명령어 : [음악목록] [회원가입] [로그인] [앱종료]                                       "); System.out.print("\u001B[33m▌ \n");
        System.out.print("\u001B[33m ▌ "); System.out.print("회원가입을 권장합니다. 회원이면 사용할 수 있는 명령어가 많아집니다.                                            "); System.out.print("\u001B[33m▌ \n");
        System.out.print("\u001B[33m ▌ "); System.out.print("계정이 없다면 명령어 입력 란에 [회원가입]을 입력하여 계정을 생성해주세요.                                      "); System.out.print("\u001B[33m▌ \n");
        System.out.print("\u001B[33m ▌ "); System.out.print("계정이 있으면 명령어 입력 란에 [로그인]을 입력하여 로그인을 해주세요.                                          "); System.out.print("\u001B[33m▌ \n");
        System.out.println("\u001B[33m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");


        //명령어 입력란(맨 마지막 줄에 출력)
        while (true) {
            System.out.println("\u001B[38m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
            System.out.print("\u001B[38m ▌ 명령어 입력 : ");
            String cmd = Container.getSc().nextLine();
            cmd = cmd.trim();

            Controller controller = null;


            if (cmd.length() == 0) {
                continue;
            }

            // 공통 명령어
            if (cmd.equals("앱종료")) {
                if(introMusic != null) {
                    introMusic.close();
                }
                musicController.stopSelectedMusic();
                break;
            }

            if(cmd.indexOf("회원") != -1 || cmd.indexOf("로그") != -1) {
                controller = memberController;
            }

            else if(cmd.indexOf("글") != -1) {
                controller = articleController;
            }

            else if(cmd.indexOf("음악") != -1) {
                controller = musicController;
            }

            // db에 음악 파일을 그대로 저장하지말고 음악파일이 저장되어있는 경로와 정보들만 저장함.

            // 메인 화면에서 존재하지 않는 명령어 입력시 출력
            else {
                System.out.printf("\u001B[31m ▌ %s(은)는 존재하지 않는 명령어 입니다.\n", cmd);
                continue;
            }


            switch ( cmd ) {
                case "회원가입":
                case "로그인":
                    if (Container.getSession().isLogined() ) {
                        System.out.println("\u001B[31m ▌ 로그아웃 후 이용해주세요.");
                        continue;
                    }
                    break;
                case "글작성":
                case "글삭제":
                case "글수정":
                case "글검색":
                case "글보기":
                case "글목록":
                    if ( Container.getSession().isLogined() == false ) {
                        System.out.println("\u001B[31m ▌ 로그인 후 이용해주세요.");
                        continue;
                    }
                    break;
                case "음악추가":
                    if ( Container.getSession().isLogined() == false ) {
                        System.out.println("\u001B[31m ▌ 로그인 후 이용해주세요.");
                        continue;
                    }
                    if (Container.getSession().isAdminId() == false) {
                        System.out.println("\u001B[31m ▌ 권한이 없습니다.");
                        continue;
                    }
                    break;
                case "음악검색":
                    if ( Container.getSession().isLogined() == false ) {
                        System.out.println("\u001B[31m ▌ 로그인 후 이용해주세요.");
                        continue;
                    }
            }
            controller.doAction(cmd);
        }

        // 앱 종료
        Container.getSc().close();
        System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█"); System.out.print("       앱 종료       "); System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
    }


}

