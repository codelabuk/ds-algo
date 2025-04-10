package org.example.pattern.structural.adapter;

public class MediaAdapter implements MediaPlayer {

    private AdvanceMediaPlayer advanceMediaPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advanceMediaPlayer = new VLCPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advanceMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advanceMediaPlayer.playVLC(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advanceMediaPlayer.playMp4(fileName);
        }
    }
}
