package org.example.pattern.structural.adapter;

public class VLCPlayer implements  AdvanceMediaPlayer{
    @Override
    public void playVLC(String fileName) {
        System.out.println(" File name is : "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
