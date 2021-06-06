package com.example.demo.Service;

import com.example.demo.Dao.UserRepository;
import com.example.demo.Entities.TakeNoteEntity;
import com.example.demo.Entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepo;

    @Override
    public UserEntity register(UserEntity userEntity) {
        BCryptPasswordEncoder bCEncoder = new BCryptPasswordEncoder();

        userEntity.setPassWord(bCEncoder.encode(userEntity.getPassWord()));
        userEntity.setRole("user");
        userEntity.setEnable(true);
        try {
            userRepo.save(userEntity);
            return userEntity;
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public List<UserEntity> findAll() {
        return userRepo.findAll();
    }



}
