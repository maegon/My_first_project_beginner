package org.example.controller;

import org.example.dto.Member;

public abstract class Controller {
    public static Member loginedMember;
    public static boolean isLogined() {
        return loginedMember != null;
    }


}