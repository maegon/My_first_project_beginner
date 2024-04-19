package org.example.FirstView;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

public class Music extends Thread {
    private Player player;
    private boolean isLoop;
    private File file;
    private FileInputStream fis;
    private BufferedInputStream bis;

    public Music(String name, boolean isLoop) {
        try {
            this.isLoop = isLoop;

            // 내 노트북 기준(음악 저장 경로)
            file = new File("C:/Users/user/IdeaProjects/My_first_project_beginner/src/main/java/org/example/music/" + name);

            // 학원 기준(음악 저장 경로)
//            file = new File("C:/work/My_first_project_beginner/src/main/java/org/example/music/" + name);
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis); // 음악의 저장경로를 버퍼에 담아서 읽어올 수 있도록 함
            player = new Player(bis);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void close() {
        isLoop = false;
        player.close();
        this.interrupt();
    }

    public void run() {
        try {
            do {
                player.play();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                player = new Player(bis);
            } while (isLoop);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
