package org.example.controller;
import org.example.FirstView.Music;
import org.example.dto.Member;

public abstract class Controller {
    public static Member loginedMember;
    public static Music name;
    public static boolean isLogined() {
        return loginedMember != null;
    }


}