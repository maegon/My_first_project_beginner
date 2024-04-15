package org.example.controller;

import org.example.FirstView.Music;
import org.example.dto.Member;
import org.example.dto.Track;
import org.example.container.Container;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusicController extends Controller {
    int lastTrackId;
    public static Scanner sc;
    private static List<Track> tracks;
    private Image playMusicTitle;
    private int nowSelected;

    private Music selectedMusic;


    public MusicController() {
        sc = Container.getSc();
        tracks = new ArrayList<>();
        }
    public void doSearchMusic() {
        try {

            if (isLogined() == false) {
                System.out.println("\u001B[31m ▌ 로그인 상태가 아닙니다.");
                return;
            }

            if (isLogined() == true) {

                List<Track> forListMusics = tracks;
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

                if (searchKeyword.length() > 0) {
                    forListMusics = new ArrayList<>();
                    for (Track track : tracks) {
                        if (track.getPlayMusicTitle().contains(searchKeyword)) {
                            forListMusics.add(track);
                        }
                    }
                    if (forListMusics.size() == 0) {
                        System.out.println("\u001B[35m ▌ 검색 결과가 존재하지 않습니다.");
                        return;
                    }
                }
                System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
                System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
                System.out.print("검색된 음악 목록");
                System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
                System.out.print("\u001B[33m ▌ ");
                System.out.print(" 번호  ░  조회수  ░  아티스트명 - 음악제목                                                                           ");
                System.out.print("\u001B[33m ▌ \n");
                for (int i = forListMusics.size() - 1; i >= 0; i--) {
                    Track track = forListMusics.get(i);
                    System.out.printf("\u001B[33m ▌    %d   ░  %s  ░    %d     ░  %s  \n", track.id, track.hit, track.getPlayMusicTitle());
                }

                System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
                System.out.println();

                System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
                System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
                System.out.print("  음악 듣기 가이드  ");
                System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
                System.out.print("\u001B[33m ▌ ");
                System.out.print("위 검색된 음악 목록에서 듣고 싶은 음악의 번호를 입력해주세요. ");
                System.out.print("\u001B[33m▌ \n");
                System.out.print("\u001B[33m ▌ ");
                System.out.print("듣고 싶은 음악이 없어 돌아가고 싶으시다면 메인화면을 입력해주세요. ");
                System.out.print("\u001B[33m▌ \n");
                System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");

                // 사용자가 원하는 음악 번호 선택
                if (tracks.size() != 0) {
                    System.out.println("\u001B[35m ▌ 몇번째 음악을 들으시겠습니까?");
                    System.out.print("\u001B[38m ▌ 명령어 입력 : ");
                    int listenNum = sc.nextInt();
                    sc.nextLine();
                    int id = listenNum;

                    Track foundTrack = getTrackById(id);
                    if (foundTrack == null) {
                        System.out.printf("\u001B[35m ▌ %d번 음악은 존재하지 않습니다.\n", listenNum);
                        return;
                    }
                    foundTrack.increaseHit();
                }

            }
        }
        catch (NullPointerException e) {
            System.out.print("\n\u001B[35m ▌ 음악이 없습니다.\n");
        }
    }

    public void selectedTrack(int nowSelected) { // 사용자가 곡을 선택했을때 해당 곡의 번호를 정수형태로 받음
        if(selectedMusic != null) { // 만약 곡을 선택했는데 이미 재생중인 곡이 있다면 재생중이던 곡을 종료시킴
            selectedMusic.close();
        }
        // 비회원은 초반 15초만 미리듣기
        // 회원은 풀버전으로 듣기
        playMusicTitle = new ImageIcon("C:/work/My_first_project_beginner/src/main/java/org/example/image/" + tracks.get(nowSelected).getPlayMusicTitle()).getImage();

        selectedMusic = new Music(tracks.get(nowSelected).getStartMusic(), false);
        selectedMusic.start();

    }

    public void importMusic() {
        int id = tracks.size() + 1;
        String regdate;
        if (isLogined() == false) {
            System.out.println("\u001B[31m ▌ 로그인 상태가 아닙니다.");
            return;
        }
        if (loginedMember.adminId.equals("SBS12341499JW") != true ) {
            System.out.println("\u001B[31m ▌ 권한이 없습니다.");
            return;
        }
        else {
            System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
            System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
            System.out.print("  음악 추가 양식  ");
            System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
            System.out.print("\u001B[33m ▌ 음악 파일명 입력 : 음악(mp3) 파일명 (예시 : jnathyn - Clockwork.mp3)                                                 ");
            System.out.print("\u001B[33m ▌ \n");
            System.out.print("\u001B[33m ▌ 음악 표지명 입력 : 음악(jpg) 표지명 (예시 : jnathyn - Dioma img.jpg)                                                 ");
            System.out.print("\u001B[33m ▌ \n");
            System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");

            String importMusicFile;
            while (true) {
                System.out.printf("\u001B[38m ▌ 음악 파일명 입력 : ");
                importMusicFile = sc.nextLine();
                if (isImportMusicFile(importMusicFile)) {
                    System.out.printf("\u001B[38m ▌ %s 곡은 이미 존재합니다.\n", importMusicFile);
                    continue;
                }
                break;
            }
            System.out.printf("\u001B[38m ▌ 음악 표지명 입력 : ");
            String importMusicTitle = sc.nextLine();

            tracks.add(new Track(id, importMusicFile, importMusicTitle));
            System.out.printf("\u001B[35m ▌ %d번 음악이 추가되었습니다.\n", id);
        }
    }


    // 음악 추가시 동일한 파일명이 존재하는지 여부 확인
    private static boolean isImportMusicFile(String importMusicFile) {
        int index = getTrackIndexByImportMusicFile(importMusicFile);
        if (index != -1) {
            return true;
        }
        return false;
    }

    private static int getTrackIndexByImportMusicFile(String importMusicFile) {
        int i = 0;
        for ( Track track : tracks ) {
            if ( track.importMusicFile.equals(importMusicFile)) {
                return i;
            }
            i++;
        }
        return -1;
    }



    // 검색한 음악이 존재하는지 여부 확인
    private int getTrackIndexById(int id) {
        int i = 0;

        for ( Track track : tracks ) {
            if ( track.id == id ) {
                return i;
            }
            i++;
        }

        return -1;
    }

    private Track getTrackById(int id) {
        int index = getTrackIndexById(id);

        if (index != -1) {
            return tracks.get(index);
        }

        return null;
    }
}


