package com.example.demo.Service;

import com.example.demo.Entities.TakeNoteEntity;
import com.example.demo.Entities.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserEntity register(UserEntity userEntity);

    List<UserEntity> findAll();
}
