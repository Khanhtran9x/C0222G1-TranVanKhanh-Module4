package com.song.service;

import com.song.model.Song;
import com.song.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepository songRepository;

    @Override
    public Page<Song> findAll(Pageable pageble) {
        return songRepository.findAll(pageble);
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public Optional<Song> findById(Integer id) {
        return songRepository.findById(id);
    }

    @Override
    public void update(Song song) {
        songRepository.save(song);
    }

    @Override
    public void remove(Song song) {
        songRepository.delete(song);
    }
}
