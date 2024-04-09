package org.example.controller;

import org.example.container.Container;
import org.example.dto.Genre;
import org.example.dto.Techno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TechnoGenreController extends Controller {
    public static Scanner sc;
    private static List<Techno> technos;
    private String cmd;
    public TechnoGenreController() {
        Scanner sc = Container.getSc();
        technos = new ArrayList<>();
    }

    public void technoShowList() {
        if (technos.size() != 0 ) {
            System.out.println("\u001B[33m ▌   번호  ░  노래제목  ░  아티스트  ░  조회수  ░  추천수  ");
            for (int i = technos.size()-1; i>=0; i--) {
                Techno techno = technos.get(i);
                System.out.printf("\u001B[33m ▌   %d  ░  %s  ░  %s  ░  %d  ░  %d  \n", techno.id, techno.musicTitle, techno.artistName, techno.hit, techno.recommed);
            }
        }
        else {
            System.out.println("\u001B[31m ▌ 게시물이 없습니다.");
        }
    }
}
