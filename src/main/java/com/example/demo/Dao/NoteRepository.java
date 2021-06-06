package com.example.demo.Dao;

import com.example.demo.Entities.TakeNoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NoteRepository extends JpaRepository<TakeNoteEntity,Long> {
    TakeNoteEntity findByTitle(String title);

}
