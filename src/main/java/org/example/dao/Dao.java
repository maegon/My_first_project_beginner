package org.example.dao;

import org.example.controller.MemberController;

public class Dao {
    protected int lastId;
    public Dao() {
        lastId = 0;
    }
    public int getNewId() {
        return lastId + 1;
    }

    public int getLastId() {
        return lastId;
    }
}
