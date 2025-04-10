package org.example.pattern.structural.adapter;

public class Mp4Player implements  AdvanceMediaPlayer{
    @Override
    public void playVLC(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println(" Playing MP4 File name is : "+ fileName);
    }
}
