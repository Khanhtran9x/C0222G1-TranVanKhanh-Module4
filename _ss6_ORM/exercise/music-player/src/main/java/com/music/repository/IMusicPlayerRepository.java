package com.music.repository;

import com.music.model.Music;

import java.util.List;

public interface IMusicPlayerRepository {
    List<Music> findAll();

    void save(Music music);

    Music findById(int id);

    void update(Music music);

    void remove(Music music);

    List<Music> searchByName(String name);
}
