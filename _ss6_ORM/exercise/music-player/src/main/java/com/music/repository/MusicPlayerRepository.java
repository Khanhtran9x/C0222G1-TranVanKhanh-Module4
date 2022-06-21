package com.music.repository;

import com.music.model.Music;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class MusicPlayerRepository implements IMusicPlayerRepository{
    @Override
    public List<Music> findAll() {
        String selectAll = "SELECT m FROM music m";
        List<Music> musicList = BaseRepository.entityManager.createQuery(selectAll, Music.class).getResultList();
        return musicList;
    }

    @Override
    public void save(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(music);
        entityTransaction.commit();
    }

    @Override
    public Music findById(int id) {
        String select = "SELECT m FROM music m WHERE m.id = ?1";
        Music music = BaseRepository.entityManager.createQuery(select, Music.class).setParameter(1, id).getSingleResult();
        return music;
    }

    @Override
    public void update(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(music);
        entityTransaction.commit();
    }

    @Override
    public void remove(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(music);
        entityTransaction.commit();
    }

    @Override
    public List<Music> searchByName(String name) {
        String search = "SELECT m FROM music m WHERE m.songName LIKE ?1";
        return BaseRepository.entityManager.createQuery(search, Music.class).setParameter(1, "%" + name + "%").getResultList();
    }
}
