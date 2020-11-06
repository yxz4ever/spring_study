package com.xrluo.classes;

public class User implements People {
    private Song song;

    public User(Song song) {
        this.song = song;
    }

    @Override
    public String song() {
        return song.toString();
    }
}
