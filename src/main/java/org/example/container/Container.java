package org.example.container;


import lombok.Getter;
import lombok.Setter;
import org.example.controller.Session;
import org.example.dao.ArticleDao;
import org.example.dao.Dao;
import org.example.dao.MemberDao;
import org.example.dao.TrackDao;
import org.example.db.DBConnection;
import org.example.service.ArticleService;
import org.example.service.ExportService;
import org.example.service.MemberService;
import org.example.service.TrackService;

import java.util.Scanner;

@Getter
@Setter

public class Container {
    public static Scanner sc;
    public static Session session;
    public static MemberDao memberDao;
    public static ArticleDao articleDao;
    public static TrackDao trackDao;
    public static MemberService memberService;
    public static ArticleService articleService;
    public static TrackService trackService;
    public static ExportService exportService;
    public static DBConnection dbConnection;

    static {
        memberDao = new MemberDao();
        memberService = new MemberService();
        articleDao = new ArticleDao();
        articleService = new ArticleService();
        trackDao = new TrackDao();
        trackService = new TrackService();
        exportService = new ExportService();
    }

    public static Scanner getSc() {
        if (sc == null) {
            sc = new Scanner(System.in);
        }

        return sc;
    }

    public static Session getSession() {
        if (session == null) {
            session = new Session();
        }

        return session;
    }

    public static DBConnection getDBConnection() {
        if ( dbConnection == null ) {
            dbConnection = new DBConnection();
        }

        return dbConnection;
    }
}