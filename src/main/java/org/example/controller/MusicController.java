package org.example.controller;

import org.example.container.Container;
import org.example.dto.Artist;
import org.example.dto.Music;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class MusicController extends Controller {
    int lastMusicId;
    int lastartistId;
    public static Scanner sc;
    private static List<Music> musics;
    private static List<Artist> artists;
    private String cmd;

    public MusicController() {
        sc = Container.getSc();
        musics = new ArrayList<>();
        artists = new ArrayList<>();
        lastMusicId = musics.size();
        lastartistId = artists.size();
    }
    public static void doSearchMusic() {
        if (isLogined() == false ) {
            System.out.println("\u001B[31m ▌ 로그인 상태가 아닙니다.");
            return;
        }
        if ( musics.size() == 0 ) {
            System.out.println("\u001B[35m ▌ 음악이 없습니다.");
            return;
        }
        if (isLogined() == true ) {
            System.out.println("\u001B[33m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
            System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█"); System.out.print("  음악 검색 명령어 가이드  "); System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
            System.out.print("\u001B[33m ▌ "); System.out.print("음악제목으로 검색 : '음악제목' 형식으로 '소문자'로 작성 (예시: hope)                                                    "); System.out.print("\u001B[33m▌ \n");
            System.out.print("\u001B[33m ▌ "); System.out.print("아티스트명으로 검색 : '아티스트명' 형식으로 '소문자'로 작성 (예시: todu)                                                       "); System.out.print("\u001B[33m▌ \n");
            System.out.println("\u001B[33m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");

            System.out.print("\u001B[38m ▌ 검색어 : ");
            String searchKeyword = sc.nextLine();

            List<Music> forListMusics = musics;
            List<Artist> forListArtists = artists;

            if (searchKeyword.length() > 0) {
                forListMusics = new ArrayList<>();
                forListArtists = new ArrayList<>();
                for (Music music : musics) {
                    if (music.musicTitle.contains(searchKeyword)) {
                        forListMusics.add(music);
                    }
                }
                for (Artist artist : artists) {
                    if(artist.artistName.contains(searchKeyword)) {
                        forListArtists.add(artist);
                    }
                }
                if(forListMusics.size() == 0) {
                    System.out.println("\u001B[35m ▌ 검색 결과가 존재하지 않습니다.");
                    return;
                }
            }
            System.out.println("\u001B[33m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
            System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█"); System.out.print("검색된 음악 목록"); System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
            System.out.print("\u001B[33m ▌ "); System.out.print(" 번호  ░  아티스트명  ░  조회수  ░  제목                                                                           "); System.out.print("\u001B[33m ▌ \n");
            for (int i = forListMusics.size() - 1; i >= 0; i--) {
                Music music = forListMusics.get(i);
                System.out.printf("\u001B[33m ▌    %d   ░  %s  ░    %d     ░  %s  \n", music.id, artist.artistName, music.hit, music.musicTitle);
            }
            System.out.println("\u001B[33m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        }
    }

//    public static void main(String[] args) {
//        MyPlayer mp = new MyPlayer("C:\\Jnathyn - Dioma [NCS Release].mp3");
//        mp.Play();
//        mp.Close()
//    }


//    public void doAction(String cmd, String actionMethodName) {
//        this.cmd = cmd;
//
//        switch ( actionMethodName ) {
}
