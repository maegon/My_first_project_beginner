package org.example.controller;

import org.example.container.Container;
import org.example.dto.Article;
import org.example.dto.ArticleReply;
import org.example.dto.Member;
import org.example.service.ArticleService;
import org.example.service.MemberService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArticleController extends Controller {
    private Scanner sc;
    private String cmd;
    private static List<Article> articles;
    private ArticleService articleService;
    private MemberService memberService;
    private Session session;

    public ArticleController() {
        articles = new ArrayList<>();
        this.sc = Container.getSc();
        articleService = Container.articleService;
        session = Container.getSession();
    }

    public void doAction(String cmd) {
        this.cmd = cmd;
        switch (cmd) {
            case "글작성":
                doWrite();
                break;
            case "글수정":
                doModify();
                break;
            case "글보기":
                showDetail();
                break;
            case "글삭제":
                doDelete();
                break;
            case "글목록":
                showList();
                break;
            case "글검색":
                doSearch();
                break;
        }
    }



    public void doWrite() {
        int id = Container.articleDao.getNewId();
        System.out.printf("\u001B[38m ▌ 제목 : ");
        String title = sc.nextLine();
        System.out.printf("\u001B[38m ▌ 내용 : ");
        String body = sc.nextLine();

        String memberName = session.getLoginedMember().memberName;
        int newId = articleService.write(memberName, title, body);

        System.out.printf("\u001B[35m ▌ %d번 게시물이 생성되었습니다.\n", newId);
    }


    public void doSearch() {
        System.out.print("\u001B[38m ▌ 검색어 : ");
        String searchKeyword = sc.nextLine();

        List<Article> forPrintArticles = articleService.getForPrintArticles(searchKeyword);

        if (forPrintArticles.size() == 0) {
            System.out.println("\u001B[35m ▌ 검색 결과가 존재하지 않습니다.");
            return;
        }
        System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
        System.out.print("검색된 글 목록");
        System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
        System.out.print("\u001B[33m ▌ ");
        System.out.print(" 번호  ░  작성자  ░  조회수  ░  제목                                                                           ");
        System.out.print("\u001B[33m ▌ \n");
        for (int i = forPrintArticles.size() - 1; i >= 0; i--) {
            Article article = forPrintArticles.get(i);
            System.out.printf("\u001B[33m ▌    %d   ░  %s  ░    %d     ░  %s  \n", article.id, article.getMemmberName(), article.hit, article.title);
        }
        System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
    }

    public void showList() {
        if (articles.size() == 0) {
            System.out.println("\u001B[35m ▌ 등록된 글이 없습니다.");
            return;
        }
        System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
        System.out.print("  글 목록  ");
        System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
        System.out.print("\u001B[33m ▌ ");
        System.out.print(" 번호  ░  작성자  ░  조회수  ░  제목                                                                           ");
        System.out.print("\u001B[33m ▌ \n");
        for (int i = articles.size() - 1; i >= 0; i--) {
            Article article = articles.get(i);
            System.out.printf("\u001B[33m ▌    %d   ░  %s  ░    %d     ░  %s  \n", article.id, article.getMemmberName(), article.hit, article.title);
        }
        System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
    }


    public void showDetail() {
        if (articles.size() != 0) {
            System.out.println("\u001B[35m ▌ 몇번 게시물을 보시겠습니까?");
            System.out.print("\u001B[38m ▌ 숫자만 입력 : ");
            int watchNum = sc.nextInt();
            sc.nextLine();
            int id = watchNum;

            Article foundArticle = articleService.getForPrintArticle(id);
            if (foundArticle == null) {
                System.out.printf("\u001B[35m ▌ %d번 게시물은 존재하지 않습니다.\n", id);
                return;
            }
            foundArticle.increaseHit();
            System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
            System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
            System.out.print("    현재 글 정보    ");
            System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
            System.out.printf("\u001B[33m ▌ 번호 : %d\n", foundArticle.id);
            System.out.printf("\u001B[33m ▌ 날짜 : %s\n", foundArticle.regDate);
            System.out.printf("\u001B[33m ▌ 작성자 : %s\n", foundArticle.getMemmberName());
            System.out.printf("\u001B[33m ▌ 조회수 : %d\n", foundArticle.hit);
            System.out.printf("\u001B[33m ▌ 제목 : %s\n", foundArticle.title);
            System.out.printf("\u001B[33m ▌ 내용 : %s\n", foundArticle.body);
            System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");

            // db연결때 댓글 기능 구현
            System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
            System.out.printf("  %d번 게시물 댓글 ", id);
            System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
            articleRepliesShowList(id);

            System.out.println("\u001B[35m ▌ 댓글을 작성하시겠습니까? (예/아니오)");
            System.out.printf("\u001B[38m ▌ 입력 : ");
            String replyCheck = sc.nextLine();

            if (replyCheck.equals("네")) {
                if (session.isLogined() == false) {
                    System.out.println("로그인 후 이용 가능합니다.");
                    return;
                }
            } else {
                return;
            }

            System.out.print("\u001B[38m ▌ 댓글 입력 : ");
            String replyBody = sc.nextLine();
            String loginedMemberName = session.getLoginedMember().getMemberName();

            articleService.replyWrite(id, loginedMemberName, replyBody);
            System.out.println("\u001B[38m ▌ 댓글이 작성되었습니다.");

            articleRepliesShowList(id);
        } else {
            System.out.println("\u001B[35m ▌ 게시물이 없습니다.");
        }
    }
    // db연결때 댓글 기능 구현
    private void articleRepliesShowList(int articleId) {
        List<ArticleReply> forPrintArticleReplies = articleService.getForPrintArticleReplies(articleId);

        System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.print("\u001B[33m ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
        System.out.printf("    %d번 글 댓글    ", articleId);
        System.out.print("\u001B[33m █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");

        System.out.print(" 번호  ░  작성자  ░     제목                                                                                ");
        for (int i = forPrintArticleReplies.size() - 1; i >= 0; i--) {
            ArticleReply reply = forPrintArticleReplies.get(i);
            Member replyMember = memberService.getMember(reply.memberId);
            System.out.printf("\u001B[33m ▌     %d    ░    %s    ░    %s      ", reply.id, replyMember.memberName, reply.body);
        }
        System.out.println("\u001B[33m" + " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
    }


    public void doModify() {
        if (articles.size() != 0) {
            System.out.println("\u001B[35m ▌ 몇번 게시물을 수정하시겠습니까?");
            System.out.print("\u001B[38m ▌ 숫자만 입력 : ");
            int checkScNum = sc.nextInt();
            sc.nextLine();
            int id = checkScNum;

            if ( id == 0 ) {
                return;
            }

            Article foundArticle = articleService.getArticle(id);

            if (foundArticle == null) {
                System.out.printf("\u001B[35m ▌ %d번 게시물은 존재하지 않습니다.\n", id);
                return;
            }

            Member loginedMember = session.getLoginedMember();

            if ( foundArticle.getMemmberName() != loginedMember.memberName ) {
                System.out.printf("\u001B[31m ▌ 권한이 없습니다.\n");
                return;
            }

            System.out.printf("\u001B[35m ▌ %d번 게시물은 존재합니다.\n\u001B[35m ▌ 날짜 : %s\n\u001B[35m ▌ 제목 : %s\n", foundArticle.id, foundArticle.regDate, foundArticle.title);
            System.out.print("\u001B[38m ▌ 제목 수정 : ");
            String title = sc.nextLine();
            System.out.print("\u001B[38m ▌ 내용 수정 : ");
            String body = sc.nextLine();

            articleService.modify(foundArticle.id, title, body);

            System.out.printf("\u001B[35m ▌ %d번 게시물이 수정되었습니다.\n", foundArticle.id);
        } else {
            System.out.println("\u001B[35m ▌ 게시물이 없습니다.");
        }
    }



    public void doDelete() {
        if (articles.size() != 0) {
            System.out.println("\u001B[35m ▌ 몇번 게시물을 삭제하시겠습니까?");
            System.out.print("\u001B[38m ▌ 숫자만 입력 : ");
            int checkScNum = sc.nextInt();
            sc.nextLine();
            int id = checkScNum;

            if (id == 0) {
                return;
            }

            Article foundArticle = articleService.getArticle(id);

            if (foundArticle == null) {
                System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
                return;
            }

            Member loginedMember = session.getLoginedMember();

            if (foundArticle.getMemmberName() != loginedMember.memberName) {
                System.out.printf("\u001B[31m ▌ 권한이 없습니다.\n");
                return;
            }

            articleService.delete(foundArticle.id);
            System.out.printf("\u001B[35m ▌ %d번 게시물이 삭제되었습니다.\n", foundArticle.id);
        } else {
            System.out.println("\u001B[35m ▌ 게시물이 없습니다.");
        }
    }


}