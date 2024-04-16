package org.example.controller;

import org.example.FirstView.Music;
import org.example.container.Container;
import org.example.dto.Track;
import org.example.util.Util;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// 검색한 음악이 존재하는지 여부 확인

public class MusicController extends Controller {
    public static Scanner sc;

    int lastTrackId;
    ArrayList<Track> tracks = new ArrayList<>();
    private Music selectedMusic;
    private boolean loopBoolean;
    private int nowSelected;

    public MusicController() {
        sc = Container.getSc();
        selectedMusic = null;
        nowSelected = 0;
    }


    // 음악 검색 기능(대문자는 소문자로 자동 변환 되어 검색됨
    public void doSearchMusic() {
        if (isLogined() == false) {
            System.out.println("\u001B[31m ▌ 로그인 상태가 아닙니다.");
            return;
        }

        List<Track> forListMusics = tracks;
        System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
        System.out.print("  음악 검색 명령어 가이드  ");
        System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
        System.out.print("\u001B[33m ▌ ");
        System.out.print("검색어 : 음악 제목 또는 아티스트명으로 작성하여 검색                                                           ");
        System.out.print("\u001B[33m▌ \n");
        System.out.print("\u001B[33m ▌ ");
        System.out.print("음악 제목으로 검색할 경우엔 음악 제목의 첫자는 대문자로 작성                                                   ");
        System.out.print("\u001B[33m▌ \n");
        System.out.print("\u001B[33m ▌ ");
        System.out.print("아티스트명으로 검색할 경우에도 아티스트명의 첫자는 대문자로 작성                                               ");
        System.out.print("\u001B[33m▌ \n");
        System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");

        System.out.print("\u001B[38m ▌ 검색어 : ");
        String searchKeyword = sc.nextLine();
        searchKeyword = searchKeyword.trim();

        if (searchKeyword.length() > 0) {
            forListMusics = new ArrayList<>();
            for (Track track : tracks) {
                if (track.importMusicFile.contains(searchKeyword)) {
                    forListMusics.add(track);
                }
            }
            if (forListMusics.size() == 0) {
                System.out.println("\u001B[35m ▌ 검색 결과가 존재하지 않습니다.");
                return;
            }
        }
        System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
        System.out.print(" 검색된 음악 목록 ");
        System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
        System.out.print("\u001B[33m ▌ ");
        System.out.print("   번호    ░   조회수   ░  아티스트명 - 음악제목                                                                           ");
        System.out.print("\u001B[33m ▌ \n");
        for (int i = forListMusics.size() - 1; i >= 0; i--) {
            Track track = forListMusics.get(i);
            System.out.printf("\u001B[33m ▌    %d    ░    %d    ░     %s  \n", track.id, track.hit, track.musicTitle);
        }

        System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.println();


        System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
        System.out.print("  음악 듣기 가이드  ");
        System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
        System.out.print("\u001B[33m ▌ ");
        System.out.print("위 검색된 음악 목록에서 듣고 싶은 음악의 번호를 입력해주세요.                                                    ");
        System.out.print("\u001B[33m▌ \n");
        System.out.print("\u001B[33m ▌ ");
        System.out.print("듣고 싶은 음악이 없으시면 '0' 을 입력해주세요.                                                                   ");
        System.out.print("\u001B[33m▌ \n");
        System.out.print("\u001B[33m ▌ ");
        System.out.print("반복 재생을 원하시면 '예' 를 입력해주세요.                                                                       ");
        System.out.print("\u001B[33m▌ \n");
        System.out.print("\u001B[33m ▌ ");
        System.out.print("반복 재생을 원하지 않으시면 '예'를 제외하고 아무거나 입력해주세요.                                               ");
        System.out.print("\u001B[33m▌ \n");
        System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");


        if (tracks.size() != 0) {
            System.out.println("\u001B[35m ▌ 몇번째 음악을 들으시겠습니까?");
            System.out.print("\u001B[38m ▌ 번호 입력 : ");
            int listenNum = sc.nextInt();
            sc.nextLine();

            if (listenNum == 0) {
                return;
            }


            Track foundTrack = getTrackById(listenNum);
            if (foundTrack == null) {
                System.out.printf("\u001B[35m ▌ %d번 음악은 존재하지 않습니다.\n", listenNum);
                return;
            }
            foundTrack.increaseHit();
            listenNum = listenNum-1;
            System.out.print("\u001B[38m ▌ 반복 재생 여부 : ");
            String loopBooleanCheck = sc.nextLine();
            if (loopBooleanCheck.equals("예")) {
                loopBoolean = true;
            }
            else {
                loopBoolean = false;
            }

            selectedTrack(listenNum);
        }
    }


    public void selectedTrack(int nowSelected) { // 사용자가 곡을 선택했을때 해당 곡의 번호를 정수형태로 받음
        if (selectedMusic != null) { // 만약 곡을 선택했는데 이미 재생중인 곡이 있다면 재생중이던 곡을 종료시킴
            selectedMusic.close();
        }
        // 회원은 풀버전으로 듣기
        selectedMusic = new Music(tracks.get(nowSelected).musicTitle+".mp3", loopBoolean);
        selectedMusic.start();
        System.out.print("\u001B[36m ▌ "); System.out.printf("현재 재생 음악  ▶  %s \n", tracks.get(nowSelected).musicTitle);
    }



    public void showMusicList() {
        if (isLogined() == false) {
            System.out.println("\u001B[31m ▌ 로그인 상태가 아닙니다.");
            return;
        }
        if (tracks.size() == 0) {
            System.out.println("\u001B[35m ▌ 음악이 없습니다.");
            return;
        }

        System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
        System.out.print("  음악 목록  ");
        System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
        System.out.print("\u001B[33m ▌ ");
        System.out.print("     번호      ░      조회수      ░      아티스트명 - 제목                                                    ");
        System.out.print("\u001B[33m ▌ \n");
        for (int i = tracks.size()-1; i >= 0; i--) {
            Track track = tracks.get(i);
            System.out.printf("\u001B[33m ▌     %d      ░       %d       ░      %s  \n", track.id, track.hit, track.musicTitle);
        }
        System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
    }


    public void importMusic() {
        int id = 0;

        if (isLogined() == false) {
            System.out.println("\u001B[31m ▌ 로그인 상태가 아닙니다.");
            return;
        }
        if (loginedMember.adminId.equals("SBS12341499JW") != true) {
            System.out.println("\u001B[31m ▌ 권한이 없습니다.");
            return;
        }
        id = tracks.size() + 1;

        String regdate = Util.getNowDateStr();

        System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
        System.out.print("  음악 추가 양식  ");
        System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
        System.out.print("\u001B[33m ▌ 음악 파일명 입력 : 음악(mp3) 파일명 (예시 : Jnathyn - Clockwork.mp3)                                           ");
        System.out.print("\u001B[33m ▌ \n");
        System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");

        String importMusicFile = null;

        System.out.printf("\u001B[38m ▌ 음악 파일명 입력 : ");
        importMusicFile = sc.nextLine();
        String[] splitMusicTitle = importMusicFile.split("\\.");

        String musicTitle = splitMusicTitle[0];
        tracks.add(new Track(id, importMusicFile, musicTitle));
        System.out.printf("\u001B[35m ▌ %d번 음악이 추가되었습니다.\n", id);
    }

    public void modifyMusicFile() {
        try {
            if (isLogined() == false) {
                System.out.println("\u001B[31m ▌ 로그인 상태가 아닙니다.");
                return;
            }
            if (loginedMember.adminId.equals("SBS12341499JW") != true) {
                System.out.println("\u001B[31m ▌ 권한이 없습니다.");
                return;
            }
            System.out.printf("\u001B[35m ▌ 수정할 음악파일 번호 입력 : ");
            int modifyFileId = sc.nextInt();
            sc.nextLine();

            Track foundTrack = null;
            for (int i = 0; i < tracks.size(); i++) {
                Track track = tracks.get(i);

                if (track.id == modifyFileId) {
                    foundTrack = track;
                    break;
                }
            }

            if (foundTrack == null) {
                System.out.printf("\u001B[31m ▌ %d번 파일은 존재하지 않습니다.\n", modifyFileId);
                return;
            }
            System.out.printf("\u001B[35m ▌ 선택된 수정할 음악 파일명 : %s\n", foundTrack.importMusicFile);


            System.out.printf("\u001B[38m ▌ 수정될 음악 파일명 입력 : ");

            String modifyNewMusicFile = sc.nextLine();
            foundTrack.importMusicFile = modifyNewMusicFile;

            System.out.printf("\u001B[35m ▌ %d번 파일이 수정되었습니다.\n", modifyFileId);
        } catch (InputMismatchException ie) {}
    }

    private int getTrackIndexById(int id) {
        int i = 0;
        for (Track track : tracks) {
            if (track.id == id) {
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




