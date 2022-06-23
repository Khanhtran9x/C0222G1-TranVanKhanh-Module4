package com.song.repository;

import com.song.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ISongRepository extends JpaRepository<Song, Integer> {
}
