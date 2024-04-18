package org.example.service;

import org.example.container.Container;
import org.example.dao.ArticleDao;
import org.example.dto.Article;

import java.util.List;

public class ArticleService {
    private ArticleDao articleDao;

    public ArticleService() {
        articleDao = Container.articleDao;
    }

//    public int replyWrite(int articleId, String memberName, String replyBody) {
//        return articleDao.replyWrite(articleId, memberName, replyBody);
//        // 댓글
//    }

    public List<Article> getForPrintArticles(String searchKeyword) {
        return articleDao.getForPrintArticles(searchKeyword);
    }

    public int write(int id, String title, String body) {
        Article article = new Article(id, title, body);
        return articleDao.write(article);
    }

    public List<Article> getArticles() {
        return articleDao.getArticles();
    }

    public Article getArticle(int id) {
        return articleDao.getArticle(id);
    }



    public void modify(int id, String title, String body) {
        articleDao.modify(id, title, body);
    }

    public void delete(int id) {
        articleDao.delete(id);
    }

    public int write(int id, String regDate, String memberName, String title, String body) {
        Article article = new Article(id, regDate, memberName, title, body);
        return articleDao.write(article);
    }

    public void write(Article article) {
        articleDao.write(article);
    }

    public Article getArticleById(int id) {
        return articleDao.getArticleById(id);
    }



//
//    // 댓글 =======================================
//
//    public int replyWrite(int articleId, int memberId, String replyBody) {
//        return articleDao.replyWrite(articleId, memberId, replyBody);
//    }
//
//    public List<ArticleReply> getForPrintArticleReplies(int articleId) {
//        return articleDao.getForPrintArticleReplies(articleId);
//    }

}