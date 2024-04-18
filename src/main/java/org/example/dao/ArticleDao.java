package org.example.dao;

import org.example.dto.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleDao extends Dao {
    public List<Article> articles;
    public ArticleDao() {
        articles = new ArrayList<>();
    }
    public int write(Article article) {
        articles.add(article);
        lastId = article.id;
        return 0;
    }

    public List<Article> getForPrintArticles(String searchKeyword) {
        if (searchKeyword != null && searchKeyword.length() != 0) {
            List<Article> forListArticles = new ArrayList<>();

            for (Article article : articles) {
                if (article.title.contains(searchKeyword)) {
                    forListArticles.add(article);
                }
            }

            return forListArticles;
        }

        return articles;
    }

    public List<Article> getArticles() {
        return null;
    }




    // 원하는 글 찾을때 번호로 찾음
    public Article getArticleById(int id) {
        int index = getArticleIndexById(id);

        if (index != -1) {
            return articles.get(index);
        }

        return null;
    }

    public int getArticleIndexById(int id) {
        int i = 0;

        for (Article article : articles) {
            if (article.id == id) {
                return i;
            }
            i++;
        }

        return -1;
    }

    public void modify(int id, String title, String body) {
//        StringBuilder sb = new StringBuilder();
//
//        sb.append(String.format("UPDATE article "));
//        sb.append(String.format("SET updateDate = NOW(), "));
//        sb.append(String.format("title = '%s', ", title));
//        sb.append(String.format("body = '%s' ", body));
//        sb.append(String.format("WHERE id = %d ", id));
//
//        return dbConnection.update(sb.toString());
    }

    public void delete(int id) {
//        StringBuilder sb = new StringBuilder();
//
//        sb.append(String.format("DELETE FROM article "));
//        sb.append(String.format("WHERE id = %d ", id));
//
//        return dbConnection.delete(sb.toString());
    }

    public Article getArticle(int id) {
//        StringBuilder sb = new StringBuilder();
//
//        sb.append(String.format("SELECT * "));
//        sb.append(String.format("FROM article "));
//        sb.append(String.format("WHERE id = %d ", id));
//
//        Map<String, Object> row = dbConnection.selectRow(sb.toString());
//
//        if ( row.isEmpty() ) {
//            return null;
//        }
//
//        return new Article(row);
        return null;
    }
}
