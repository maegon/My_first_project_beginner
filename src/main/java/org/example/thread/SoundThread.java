//package org.example.thread;
//import javazoom.jl.player.Player;
//import org.example.util.Main;
//
//import java.io.BufferedInputStream;
//import java.io.File;  // 파일과 디렉터리 경로명을 추상화하는 데 사용
//import java.io.FileInputStream;
//
//public class SoundThread extends Thread {
//    private Player player;  // mp3파일을 재생하는 객체
//    private boolean loop;  // 반복재생 여부 true는 반복, false는 반복안함
//    private File file;  // 재생할 mp3파일을 나타내는 객체
//    private FileInputStream fis;  // 파일에서 데이터를 바이트 단위로 읽는 데 사용
//    private BufferedInputStream bis;  // 데이터를 읽을 때 성능향상
//
//    public SoundThread(String name) {
//        try {
////            this.loop=loop;
//            file=new File(Main.class.getResource("../music/" + name).toURI());
//            fis=new FileInputStream(file);
//            bis=new BufferedInputStream(fis);
//            player=new Player(bis);
//        }catch(Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//}
