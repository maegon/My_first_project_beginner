package org.example.controller;

import org.example.FirstView.Music;
import org.example.container.Container;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusicController extends Controller {
    public static Scanner sc;
    private static List<Music> musics;

    public MusicController() {
        sc = Container.getSc();
        musics = new ArrayList<>();
        }
    public static void doSearchMusic() {
        try {

            if (isLogined() == false) {
                System.out.println("\u001B[31m ▌ 로그인 상태가 아닙니다.");
                return;
            }

            if (isLogined() == true) {

                List<Music> forListMusics = musics;
                System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
                System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
                System.out.print("  음악 검색 명령어 가이드  ");
                System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
                System.out.print("\u001B[33m ▌ ");
                System.out.print("검색어 : '음악제목'으로 '소문자'로 작성 (예시: hope)                                                    ");
                System.out.print("\u001B[33m▌ \n");
                System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");

                System.out.print("\u001B[38m ▌ 검색어 : ");
                String searchKeyword = sc.nextLine();
                searchKeyword.trim();

//                if (searchKeyword.length() > 0) {
//                    forListMusics = new ArrayList<>();
//                    for (Music music : musics) {
//                        if (music.musicTitle.contains(searchKeyword)) {
//                            forListMusics.add(music);
//                        }
//                    }
//                    if (forListMusics.size() == 0) {
//                        System.out.println("\u001B[35m ▌ 검색 결과가 존재하지 않습니다.");
//                        return;
//                    }
//                }
//                System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
//                System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
//                System.out.print("검색된 음악 목록");
//                System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
//                System.out.print("\u001B[33m ▌ ");
//                System.out.print(" 번호  ░  아티스트명  ░  조회수  ░  제목                                                                           ");
//                System.out.print("\u001B[33m ▌ \n");
//                for (int i = forListMusics.size() - 1; i >= 0; i--) {
//                    Music music = forListMusics.get(i);
//                    System.out.printf("\u001B[33m ▌    %d   ░  %s  ░    %d     ░  %s  \n", music.id, artist.artistName, music.hit, music.musicTitle);
//                }
                
                System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
                System.out.println();

                System.out.println("\u001B[33m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
                System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█"); System.out.print("  음악 듣기 가이드  "); System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
                System.out.print("\u001B[33m ▌ "); System.out.print("위 검색된 음악 목록에서 듣고 싶은 음악의 번호를 입력해주세요. "); System.out.print("\u001B[33m▌ \n");
                System.out.print("\u001B[33m ▌ "); System.out.print("듣고 싶은 음악이 없어 돌아가고 싶으시다면 메인화면을 입력해주세요. "); System.out.print("\u001B[33m▌ \n");
                System.out.println("\u001B[33m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
                System.out.println("\u001B[35m ▌ 몇번째 항목의 음악을 들으시겠습니까?\n\u001B[38m ▌ 명령어 입력 : ");
            }

        } catch (NullPointerException e) {
            System.out.print("\n\u001B[35m ▌ 음악이 없습니다.\n");
        }
    }
}

