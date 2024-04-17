package org.example.FirstView;

import javazoom.jl.player.Player;
import org.example.dto.Track;
import org.example.util.Main;
import org.example.controller.MusicController;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URISyntaxException;
import java.net.URL;


public class Music extends Thread {
    private Player player;
    private boolean isLoop; //현재 곡이 무한반복인지 아니면 한번만 재생되고 꺼지는지에 대한 설정
    private File file;
    private FileInputStream fis;
    private BufferedInputStream bis;
    public Music(String name, boolean isLoop) {
        try {
            this.isLoop = isLoop;
            // 파일 경로를 내 문서에서 노래가 저장된 경로를 그대로 복사해서 역슬래쉬만 그냥 슬래쉬로 변경하면 됨. 하... 노래 재생시키는 것만 총 8일 걸린거 같다.
            // 내 노트북 기준(음악 저장 경로)
//            file = new File("C:/Users/user/IdeaProjects/My_first_project_beginner/src/main/java/org/example/music/" + name);
            // 학원 기준(음악 저장 경로)
            // 학원에 라이브러리도 넣었는데 작동안되면 프로젝트, 메인, 테스트의 모듈에도 적용해볼 것
            file = new File("C:/work/My_first_project_beginner/src/main/java/org/example/music/" + name);
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis); // 음악의 저장경로를 버퍼에 담아서 읽어올 수 있도록 함
            player = new Player(bis);

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


//    public int getTime() { // getTime은 현재 실행되고 있는 음악이 어떤 위치에서 실행되는지 알려줌
//        // 만약 3분짜리 음악을 실행하였고 10초 정도 흘렀다면 이 함수는 10000이라는 숫자를 반환함 => 즉 0.0001초 단위까지 알려줌
//        // 대략 해당음악이 실행되고 난 후의 시간 분석?
//        if(player == null) {
//            return 0;
//        }
//        return player.getPosition();
//    }

    public void close() { // 사용자가 원하면 언제든지 음악 재생이 종료될 수 있도록 하는 함수
        // 사용자가 현재 음악에서 다른 음악으로 새로 재생했을때 현재음악을 종료시킬때 사용
        isLoop = false;
        player.close();
        this.interrupt(); // interrupt() => 해당 스레드(하나의 작은 프로그램)를 중지상태로 만듬
        // 앱 자체의 프로그램이 아닌 단지 음악만 재생하는 기능을 가진 프로그램을 의미
    }
    public void run() { // 스레드를 상속받으면 무조건 실행
        try {
          do {
              player.play();
              fis = new FileInputStream(file);
              bis = new BufferedInputStream(fis);
              player = new Player(bis);
          } while (isLoop); // isLoop가 true값이면 무한반복 재생, false값이면 한번만 재생
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



}
