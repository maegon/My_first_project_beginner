package org.example.service;

import org.example.container.Container;
import org.example.dao.ArticleDao;
import org.example.dto.Article;
import org.example.dto.ArticleReply;

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

    public List<Article> getForPrintArticles() {
        return articleDao.getForPrintArticles();
    }

    public int write(String memberName, String title, String body) {
        Article article = new Article(memberName, title, body);
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


//    public Article getArticleById(int id) {
//        return articleDao.getArticleById(id);
//    }

    public Article getForPrintArticle(int id) {
        return articleDao.getForPrintArticle(id);
    }

    public List<ArticleReply> getForPrintArticleReplies(int id) {
        return articleDao.getForPrintArticleReplies(id);
    }




    // 댓글 =======================================

    public int replyWrite(String memberName, String replyBody) {
        return articleDao.replyWrite(memberName, replyBody);
    }

}