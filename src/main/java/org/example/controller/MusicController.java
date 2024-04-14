//package org.example.controller;
//
//import org.example.container.Container;
//import org.example.dao.MyPlayer;
//import org.example.dto.Article;
//import org.example.dto.Artist;
//import org.example.dto.Member;
//import org.example.dto.Music;
//import org.example.util.Util;
//
//import javax.swing.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;
//
//public class MusicController extends Controller {
////    private static JInternalFrame music; // 음악이 재생도중 새로운 음악프레임이 열리면 기존에 재생되던 음악 종료 -> 고민 좀 해봐야 할듯
//    int lastMusicId;
//    int lastartistId;
//    public static Scanner sc;
//    private static List<Music> musics;
//    private static List<Artist> artists;
//    private String cmd;
//    private Music selectedMusic;
//
//
//
//    public MusicController() {
//        sc = Container.getSc();
//        musics = new ArrayList<>();
//        artists = new ArrayList<>();
//    }
//    public void makeTestData() {
//        musics.add(new Music(1, "2024-04-12", "jnathyn", "dioma", 10, "관리자"));
//    }
//
//
//    public static void doSearchMusic() {
//        try {
//
//            if (isLogined() == false) {
//                System.out.println("\u001B[31m ▌ 로그인 상태가 아닙니다.");
//                return;
//            }
//
//            if (isLogined() == true) {
//
//                List<Music> forListMusics = musics;
//                List<Artist> forListArtists = artists;
//                System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
//                System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
//                System.out.print("  음악 검색 명령어 가이드  ");
//                System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
//                System.out.print("\u001B[33m ▌ ");
//                System.out.print("검색어 : '음악제목' 형식으로 '소문자'로 작성 (예시: hope)                                                    ");
//                System.out.print("\u001B[33m▌ \n");
//                System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
//
//                System.out.print("\u001B[38m ▌ 검색어 : ");
//                String searchKeyword = sc.nextLine();
//                searchKeyword.trim();
//
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
//                    for (int j = forListArtists.size() - 1; j >= 0; j--) {
//                        Music music = forListMusics.get(i);
//                        Artist artist = forListArtists.get(j);
//                        System.out.printf("\u001B[33m ▌    %d   ░  %s  ░    %d     ░  %s  \n", music.id, artist.artistName, music.hit, music.musicTitle);
//                    }
//                }
//                System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
//
//            }
//        } catch (NullPointerException e) {
//            System.out.print("\n\u001B[31m ▌ 음악이 없습니다.\n");
//        }
//    }
//
//    public static void doImportMusicList() {
//        try {
//            if (isLogined() == false) {
//                System.out.println("\u001B[31m ▌ 로그인 상태가 아닙니다.");
//                return;
//            }
//            if (loginedMember.adminId.equals("SBS12341499JW") != true ) {
//                System.out.println("\u001B[31m ▌ 권한이 없습니다.");
//                return;
//            }
//            else {
//                System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
//                System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
//                System.out.print("  음악 목록 추가 양식  ");
//                System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
//                System.out.print("\u001B[33m ▌ ");
//                System.out.print("입력 : '아티스트명' '음악제목' 형식으로 '소문자'로 작성 (예시: tobu hope)                                                    ");
//                System.out.print("\u001B[33m ▌ \n");
//                System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
//
//                int id = musics.size() + 1;
//                int hit = 0;
//                String regDate = Util.getNowDateStr();
//                System.out.printf("\u001B[38m ▌ 아티스트명 : ");
//                String artistN = sc.nextLine();
//                System.out.printf("\u001B[38m ▌ 음악제목 : ");
//                String musicT = sc.nextLine();
//
//                Music music = new Music(id, regDate, artistN, musicT, hit, loginedMember.memberName);
//                musics.add(music);
//
//                System.out.printf("\u001B[35m ▌ %d번 음악이 추가되었습니다.\n", id);
//            }
//        }
//        catch (NullPointerException e) {}
//    }
//
//
//    public static void doPlayMusic() {
//        if (isLogined() == false) {
//            System.out.println("\u001B[31m ▌ 로그인 상태가 아닙니다.");
//            return;
//        }
//        System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
//        System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
//        System.out.print("  음악 재생 명령어 가이드  ");
//        System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
//        System.out.print("\u001B[33m ▌ ");
//        System.out.print("입력 : '아티스트명' '음악제목' 형식으로 '소문자'로 작성 (예시: tobu hope)                                                    ");
//        System.out.print("\u001B[33m ▌ \n");
//        System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
//
//        System.out.print("\u001B[38m ▌ 입력 : ");
//        String searchKeyword = sc.nextLine();
//
//        String[] searchKeywordBits = searchKeyword.split(" ");
//        String artistNameBits = searchKeywordBits[0];
//        String musicNameBits = searchKeywordBits[1];
//
//        List<Music> forListMusic = musics;
//        List<Artist> forListArtist = artists;
//
//        // 입력받은 아티스트명과 음악제목이 일치하는 음악 및 아티스트 찾기
//        for (Music music : musics) {
//            if (music.getMusicTitle().equalsIgnoreCase(musicNameBits)) {
//                forListMusic.add(music);
//            }
//        }
//        for (Artist artist : artists) {
//            if (artist.getArtistName().equalsIgnoreCase(artistNameBits)) {
//                forListArtist.add(artist);
//            }
//        }
//
//        // 일치하는 음악 및 아티스트가 있는지 확인 후 처리
//        if (!forListMusic.isEmpty() && !forListArtist.isEmpty()) {
//            // 여러 개의 음악 및 아티스트가 있을 경우 일단 첫 번째 항목만 재생
//            Music selectedMusic = forListMusic.get(0);
//            Artist selectedArtist = forListArtist.get(0);
//
//            System.out.println("\u001B[35m ▌ 재생 중인 음악: " + selectedMusic.getMusicTitle() + " - " + selectedArtist.getArtistName());
//
//            // 여기에 음악을 재생하는 코드를 추가하세요.
//            MyPlayer mp = new MyPlayer(getFilePath(selectedMusic, selectedArtist)); // 음악 파일 경로를 이용하여 MyPlayer 객체 생성
//            mp.Play(); // 음악 재생
//            mp.Close(); // 재생이 끝난 후 리소스 해제
//        } else {
//            System.out.println("\u001B[31m ▌ 해당 음악 또는 아티스트가 존재하지 않습니다.");
//            return;
//        }
//        return;
//
//    }
//
//    public static String getFilePath(Music selectedMusic, Artist selectedArtist) {
//        String resultFilePath = "";
////        "C:\\psycho.mp3"
//        resultFilePath += "C:\\";
//        resultFilePath += String.valueOf(selectedArtist);
//        resultFilePath += " - ";
//        resultFilePath += ".mp3";
//        resultFilePath += String.valueOf(selectedMusic);
//        return resultFilePath;
//    }
//
//}
