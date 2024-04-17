package org.example.container;


import lombok.Getter;
import lombok.Setter;
import org.example.controller.Session;
import org.example.dao.MemberDao;
import org.example.service.MemberService;

import java.util.Scanner;

@Getter
@Setter

public class Container {
    public static Scanner sc;
    public static Session session;
    public static MemberDao memberDao;
    public static MemberService memberService;

    static {
        memberDao = new MemberDao();
        memberService = new MemberService();
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
}