package com.example.demo.Service;

import com.example.demo.Dao.NoteRepository;
import com.example.demo.Entities.TakeNoteEntity;
import com.example.demo.Entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{

    @Autowired
    NoteRepository noteRepo;
    @Override
    public TakeNoteEntity submit(TakeNoteEntity note,UserEntity user) {
        note.setUser_Id(user);
        note.setDate_create(LocalDateTime.now());
        noteRepo.save(note);

        return note;
    }

    @Override
    public List<TakeNoteEntity> findAll() {

        return noteRepo.findAll();
    }

    @Override
    public TakeNoteEntity findByTitle(String title){
        return noteRepo.findByTitle(title);
    }
}
