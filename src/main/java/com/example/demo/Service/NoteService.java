package com.example.demo.Service;

import com.example.demo.Entities.TakeNoteEntity;
import com.example.demo.Entities.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {

    TakeNoteEntity submit(TakeNoteEntity note,UserEntity user );

    List<TakeNoteEntity> findAll();
    TakeNoteEntity findByTitle(String title);
}
