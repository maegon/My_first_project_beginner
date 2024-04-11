package org.example.controller;

import org.example.container.Container;
import org.example.dto.Article;
import org.example.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArticleController extends Controller{
    int lastArticleId;
    public static Scanner sc;
    private static List<Article> articles;
    private String cmd;

    public ArticleController() {
        sc = Container.getSc();
        articles = new ArrayList<>();
        lastArticleId = articles.size();
    }

    public void makeTestData() {
        articles.add(new Article(1, Util.getNowDateStr(), "관리자", "테스트 제목", "테스트 내용", 12));
    }


    public void doWrite() {
        if (isLogined() == false ) {
            System.out.println("\u001B[31m ▌ 로그인 상태가 아닙니다.");
            return;
        }
        int id = articles.size() + 1;
        String regDate = Util.getNowDateStr();
        System.out.printf("\u001B[38m ▌ 제목 : ");
        String title = sc.nextLine();
        System.out.printf("\u001B[38m ▌ 내용 : ");
        String body = sc.nextLine();

        Article article = new Article(id, regDate, loginedMember.memberName, title, body);
        articles.add(article);

        System.out.printf("\u001B[35m ▌ %d번 게시물이 생성되었습니다.\n", id);
    }


    public void doSearch() {
        System.out.print("\u001B[38m ▌ 검색어 : ");
        String searchKeyword = sc.nextLine();

        List<Article> forListArticles = articles;

        if (searchKeyword.length() > 0) {
            forListArticles = new ArrayList<>();
            for (Article article : articles) {
                if (article.title.contains(searchKeyword)) {
                    forListArticles.add(article);
                }
            }
            if(forListArticles.size() == 0) {
                System.out.println("\u001B[35m ▌ 검색 결과가 존재하지 않습니다.");
                return;
            }
        }
        System.out.println("\u001B[33m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█"); System.out.print("검색된 글 목록"); System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
        System.out.print("\u001B[33m ▌ "); System.out.print(" 번호  ░  작성자  ░  조회수  ░  제목                                                                           "); System.out.print("\u001B[33m ▌ \n");
        for (int i = forListArticles.size() - 1; i >= 0; i--) {
            Article article = forListArticles.get(i);
            System.out.printf("\u001B[33m ▌    %d   ░  %s  ░    %d     ░  %s  \n", article.id, article.memberName, article.hit, article.title);
        }
        System.out.println("\u001B[33m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
    }

    public void showList() {
        if (isLogined() == false ) {
            System.out.println("\u001B[31m ▌ 로그인 상태가 아닙니다.");
            return;
        }
        if ( articles.size() == 0 ) {
            System.out.println("\u001B[35m ▌ 게시물이 없습니다.");
            return;
        }


        System.out.println("\u001B[33m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█"); System.out.print("  글 목록  "); System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
        System.out.print("\u001B[33m ▌ "); System.out.print(" 번호  ░  작성자  ░  조회수  ░  제목                                                                           "); System.out.print("\u001B[33m ▌ \n");
        for (int i = articles.size()-1; i>=0; i--) {
            Article article = articles.get(i);
            System.out.printf("\u001B[33m ▌    %d   ░  %s  ░    %d     ░  %s  \n", article.id, article.memberName, article.hit, article.title);
        }
        System.out.println("\u001B[33m"+" ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
    }

    public void showDetail() {
        if (articles.size() != 0) {
            System.out.println("\u001B[35m ▌ 몇번 게시물을 보시겠습니까?");
            System.out.print("\u001B[38m ▌ 숫자만 입력 : ");
            int watchNum = sc.nextInt();
            sc.nextLine();
            int id = watchNum;

            Article foundArticle = getArticleById(id);
            if (foundArticle == null) {
                System.out.printf("\u001B[35m ▌ %d번 게시물은 존재하지 않습니다.\n", watchNum);
                return;
            }
            foundArticle.increaseHit();
            System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
            System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
            System.out.print("    현재 글 정보    ");
            System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
            System.out.printf("\u001B[33m ▌ 번호 : %d\n", foundArticle.id);
            System.out.printf("\u001B[33m ▌ 날짜 : %s\n", foundArticle.regDate);
            System.out.printf("\u001B[33m ▌ 작성자 : %s\n", foundArticle.memberName);
            System.out.printf("\u001B[33m ▌ 조회수 : %d\n", foundArticle.hit);
            System.out.printf("\u001B[33m ▌ 제목 : %s\n", foundArticle.title);
            System.out.printf("\u001B[33m ▌ 내용 : %s\n", foundArticle.body);
            System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        }
        else {
            System.out.println("\u001B[35m ▌ 게시물이 없습니다.");
        }
    }

    public void doModify() {
        if (isLogined() == false ) {
            System.out.println("\u001B[31m ▌ 로그인 상태가 아닙니다.");
            return;
        }
        if (articles.size() != 0 ) {
            System.out.println("\u001B[35m ▌ 몇번 게시물을 수정하시겠습니까?");
            System.out.print("\u001B[38m ▌ 숫자만 입력 : ");
            int modifyNum = sc.nextInt();
            sc.nextLine();
            int id = modifyNum;
            Article foundArticle = getArticleById(id);

            if (foundArticle == null) {
                System.out.printf("\u001B[35m ▌ %d번 게시물은 존재하지 않습니다.\n", modifyNum);
                return;
            }
            System.out.printf("\u001B[35m ▌ %d번 게시물은 존재합니다.\n\u001B[35m ▌ 날짜 : %s\n\u001B[35m ▌ 제목 : %s\n", foundArticle.id, foundArticle.regDate, foundArticle.title);
            System.out.print("\u001B[38m ▌ 제목 수정 : ");
            String title = sc.nextLine();
            System.out.print("\u001B[38m ▌ 내용 수정 : ");
            String body = sc.nextLine();

            foundArticle.title = title;
            foundArticle.body = body;

            System.out.printf("\u001B[35m ▌ %d번 게시물이 수정되었습니다.\n", modifyNum);
        }
        else {
            System.out.println("\u001B[35m ▌ 게시물이 없습니다.");
        }
    }


    public void doDelete() {
        if (isLogined() == false ) {
            System.out.println("\u001B[31m ▌ 로그인 상태가 아닙니다.");
            return;
        }
        if (articles.size() != 0 ) {
            System.out.println("\u001B[35m ▌ 몇번 게시물을 삭제하시겠습니까?");
            System.out.print("\u001B[38m ▌ 숫자만 입력 : "); int delNum = sc.nextInt();
            sc.nextLine();
            int id = delNum;
            int foundIndex = getArticleIndexById(id);

            if (foundIndex == -1) {
                System.out.printf("\u001B[35m ▌ %d번 게시물은 존재하지 않습니다.\n", delNum);
            }
            else {
                articles.remove(foundIndex);
                System.out.printf("\u001B[35m ▌ %d번 게시물이 성공적으로 삭제되었습니다.\n", delNum);
            }
        }
        else {
            System.out.println("\u001B[35m ▌ 게시물이 없습니다.");
        }
    }

    private int getArticleIndexById(int id) {
        int i = 0;

        for ( Article article : articles ) {
            if ( article.id == id ) {
                return i;
            }
            i++;
        }

        return -1;
    }

    private Article getArticleById(int id) {
        int index = getArticleIndexById(id);

        if ( index != -1 ) {
            return articles.get(index);
        }

        return null;
    }
}