package com.song.service;

import com.song.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ISongService {
    Page<Song> findAll(Pageable pageble);

    void save(Song song);

    Optional<Song> findById(Integer id);

    void update(Song song);

    void remove(Song song);
}
