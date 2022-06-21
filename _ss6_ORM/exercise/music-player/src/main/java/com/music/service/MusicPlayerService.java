package com.music.service;

import com.music.model.Music;
import com.music.repository.IMusicPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicPlayerService implements IMusicPlayerService{
    @Autowired
    private IMusicPlayerRepository musicPlayerRepository;

    @Override
    public List<Music> findAll() {
        return musicPlayerRepository.findAll();
    }

    @Override
    public void save(Music music) {
        musicPlayerRepository.save(music);
    }

    @Override
    public Music findById(int id) {
        return musicPlayerRepository.findById(id);
    }

    @Override
    public void update(Music music) {
        musicPlayerRepository.update(music);
    }

    @Override
    public void remove(Music music) {
        musicPlayerRepository.remove(music);
    }

    @Override
    public List<Music> searchByName(String name) {
        return musicPlayerRepository.searchByName(name);
    }
}
