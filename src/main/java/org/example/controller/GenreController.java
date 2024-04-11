package org.example.controller;

import lombok.Getter;
import lombok.Setter;
import org.example.container.Container;
import org.example.dto.Genre;
import org.example.dto.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public abstract class GenreController extends Controller {
    public static Scanner sc;
    private static List<Genre> genres;
    private String cmd;
    public GenreController() {
        Scanner sc = Container.getSc();
        genres = new ArrayList<>();
    }

    public void genreList() {
        System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█"); System.out.print("      장르별   목록      "); System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
        System.out.print("\u001B[33m ▌ "); System.out.print("장르 : [테크노] [하우스] [덥스텝] [트랜스] [드럼앤베이스] [하드스타일] [트랩] [풋워크] [다운템포] [뭄바톤]"); System.out.print("     \u001B[33m▌ \n");
        System.out.println("\u001B[33m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
    }


}
