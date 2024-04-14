//package org.example.controller;
//
//import org.example.container.Container;
//import org.example.dto.Artist;
//import org.example.dto.Music;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class ArtistController extends Controller {
//    int lastMusicId;
//    int lastartistId;
//    Music musicTitle;
//    public static Scanner sc;
//    private static List<Music> musics;
//    private static List<Artist> artists;
//    private String cmd;
//
//
//    public void makeTestData() {
//        artists.add(new Artist(1, "2024-04-12", "jnathyn"));
//    }
//
//    public ArtistController() {
//        sc = Container.getSc();
//        musics = new ArrayList<>();
//        artists = new ArrayList<>();
//        lastMusicId = musics.size();
//        lastartistId = artists.size();
//    }
//    public static void doSearchArtist() {
//        try {
//            if (isLogined() == false) {
//                System.out.println("\u001B[31m ▌ 로그인 상태가 아닙니다.");
//                return;
//            }
//
//            if (isLogined() == true) {
//                List<Music> forListMusics = musics;
//                List<Artist> forListArtists = artists;
//                System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
//                System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
//                System.out.print(" 아티스트 검색 명령어 가이드  ");
//                System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
//                System.out.print("\u001B[33m ▌ ");
//                System.out.print("검색어 : '아티스트명' 형식으로 '소문자'로 작성 (예시: tobu)                                                    ");
//                System.out.print("\u001B[33m ▌ \n");
//                System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
//
//                System.out.print("\u001B[38m ▌ 검색어 : ");
//                String searchKeyword = sc.nextLine();
//                searchKeyword.trim();
//
//                List<Artist> forListArtist = artists;
//
//                if (searchKeyword.length() > 0) {
//                    forListArtists = new ArrayList<>();
//                    for (Artist artist : artists) {
//                        if (artist.artistName.contains(searchKeyword)) {
//                            forListArtists.add(artist);
//                        }
//                        if (forListArtists.size() == 0) {
//                            System.out.println("\u001B[35m ▌ 검색 결과가 존재하지 않습니다.");
//                            return;
//                        }
//                    }
//                    System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
//                    System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
//                    System.out.print("검색된 아티스트 음악 목록");
//                    System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
//                    System.out.print("\u001B[33m ▌ ");
//                    System.out.print(" 번호  ░  아티스트명  ░  조회수  ░  제목                                                                           ");
//                    System.out.print("\u001B[33m ▌ \n");
//                    for (int i = forListMusics.size() - 1; i >= 0; i--) {
//                        for (int j = forListArtists.size() - 1; j >= 0; j--) {
//                            Music music = forListMusics.get(i);
//                            Artist artist = forListArtists.get(j);
//                            System.out.printf("\u001B[33m ▌    %d   ░  %s  ░    %d     ░  %s  \n", music.id, artist.artistName, music.hit, music.musicTitle);
//                        }
//                    }
//                    System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
//                }
//            }
//        }
//        catch(NullPointerException e){
//            System.out.print("\n\u001B[31m ▌ 아티스트가 없거나 음악이 없습니다.\n");
//        }
//
//    }
//}
