package org.example.container;


import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter

public class Container {
    public static Scanner sc;

    public static Scanner getSc() {
        if ( sc == null ) {
            sc = new Scanner(System.in);
        }

        return sc;
    }
}