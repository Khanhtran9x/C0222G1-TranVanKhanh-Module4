package com.music.model;

import javax.persistence.*;

@Entity(name = "music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer songId;
    private String songName;
    private String singer;
    private String musicType;
    private String songPath;

    public Music(){
    }

    public Music(Integer songId, String songName, String singer, String musicType, String songPath) {
        this.songId = songId;
        this.songName = songName;
        this.singer = singer;
        this.musicType = musicType;
        this.songPath = songPath;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getMusicType() {
        return musicType;
    }

    public void setMusicType(String musicType) {
        this.musicType = musicType;
    }

    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }
}
