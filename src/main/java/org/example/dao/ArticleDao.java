package org.example.dao;

import org.example.container.Container;
import org.example.db.DBConnection;
import org.example.dto.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArticleDao extends Dao {
    private DBConnection dbConnection;
    public ArticleDao() {
        dbConnection = Container.getDBConnection();
    }
    public int write(Article article) {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("INSERT INTO article "));
        sb.append(String.format("SET regDate = NOW(), "));
        sb.append(String.format("updateDate = NOW(), "));
        sb.append(String.format("title = '%s', ", article.title));
        sb.append(String.format("`body` = '%s', ", article.body));
        sb.append(String.format("memberName = %d, ", article.memberName));
        sb.append(String.format("hit = %d ", article.hit));

        return dbConnection.insert(sb.toString());
    }

    public List<Article> getForPrintArticles(String searchKeyword) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT A.* "));
        sb.append(String.format("FROM `article` AS A "));
        if ( searchKeyword.length() > 0 ) {
            sb.append(String.format("AND A.title LIKE '%%%s%%' ", searchKeyword));
        }
        sb.append(String.format("ORDER BY A.id DESC"));

        List<Article> articles = new ArrayList<>();
        List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

        for ( Map<String, Object> row : rows ) {
            articles.add(new Article((row)));
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

    public int modify(int id, String title, String body) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("UPDATE article "));
        sb.append(String.format("SET updateDate = NOW(), "));
        sb.append(String.format("title = '%s', ", title));
        sb.append(String.format("body = '%s' ", body));
        sb.append(String.format("WHERE id = %d ", id));

        return dbConnection.update(sb.toString());
    }

    public int delete(int id) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("DELETE FROM article "));
        sb.append(String.format("WHERE id = %d ", id));

        return dbConnection.delete(sb.toString());
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
