package org.example.controller;

import lombok.Getter;
import lombok.Setter;
import org.example.container.Container;
import org.example.dto.Article;
import org.example.dto.Genre;
import org.example.dto.Member;
import org.example.dto.Techno;

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
        sc = Container.getSc();
        genres = new ArrayList<>();
    }

    public void showGenreList() {
        System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█"); System.out.print("      장르  목록      "); System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
        System.out.print("\u001B[33m ▌ "); System.out.print("추천 장르 : [테크노] [하우스] [덥스텝] [트랜스] [드럼앤베이스] [하드스타일] [트랩] [풋워크] [다운템포] [뭄바톤]"); System.out.print("     \u001B[33m▌ \n");
        System.out.println("\u001B[33m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
    }

    public void doSearchTechno() {
        System.out.print("검색어 : ");
        String search = sc.nextLine();
        String searchKeyword = search;
        System.out.printf("제목 검색 : %s\n", searchKeyword);

        List<Article> forListArticles = articles;

        if (searchKeyword.length() > 0) {
            forListArticles = new ArrayList<>();
            for (Article article : articles) {
                if (article.title.contains(searchKeyword)) {
                    forListArticles.add(article);
                }
            }
            if(forListArticles.size() == 0) {
                System.out.println("검색 결과가 존재하지 않습니다.");
                return;
            }
        }
        for (int i = forListArticles.size() - 1; i >= 0; i--) {
            Article article = forListArticles.get(i);
            System.out.printf("%d번 게시물 | 조회수 %d | 작성자 : %d | 제목 : %s\n", article.id, article.hit, article.memberId, article.title);
        }
    }


}
