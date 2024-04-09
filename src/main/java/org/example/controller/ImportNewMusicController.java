package org.example.controller;

import org.example.container.Container;
import org.example.dto.Genre;
import org.example.dto.ImportNewMusic;
import org.example.dto.Techno;
import org.example.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ImportNewMusicController extends Controller {
    String regDate = Util.getNowDateStr();

    int lastImportNewMusicsId;

    public static Scanner sc;
    private static List<Genre> genres;
    private static List<Techno> technos;
    private static List<ImportNewMusic> importNewMusics;
    private String cmd;
    public ImportNewMusicController() {
        Scanner sc = Container.getSc();
        importNewMusics = new ArrayList<>();
    }
    public void ImportNewMusic() {
        int id = importNewMusics.size() + 1;
        lastImportNewMusicsId = id;
        System.out.print("노래제목 : ");
        String musicTitle = sc.nextLine();

        ImportNewMusic importNewMusic = new ImportNewMusic(id, musicTitle, loginedMember.memberName, regDate, genres);
        importNewMusics.add(importNewMusic);

        System.out.printf("%d번 음악이 추가되었습니다.", id);
    }
}
