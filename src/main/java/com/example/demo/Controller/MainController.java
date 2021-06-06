package com.example.demo.Controller;

import com.example.demo.Dao.NoteRepository;
import com.example.demo.Dao.UserRepository;
import com.example.demo.Entities.TakeNoteEntity;
import com.example.demo.Entities.UserEntity;
import com.example.demo.Service.NoteServiceImpl;
import com.example.demo.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.server.PathParam;
import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    NoteRepository noteRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    NoteServiceImpl noteServiceImpl;
    @Autowired
    UserServiceImpl userServiceImpl;



    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("listUser", userServiceImpl.findAll());
        return "home";
    }

    @GetMapping("/register")
    public String register(Model model) {
        UserEntity userEntity = new UserEntity();
        model.addAttribute("user", userEntity);
        return "register";
    }

    @PostMapping("/register")
    public String registerProccess(Model model, UserEntity user) {
        UserEntity userEntity = userServiceImpl.register(user);
        if(userEntity != null) {
            return "registerSuccess";
        } else {
            return "registerError";
        }
    }

    @GetMapping("/login")
    public String login(Model model) {
        UserEntity userEntity = new UserEntity();
        model.addAttribute("user", userEntity);
        return "login";
    }

    @GetMapping("/take_note")
    public String take_note(Model model) {
        model.addAttribute("note",noteServiceImpl.findAll());
        return "take_note";
    }

    @PostMapping("/take_note")
    public String note(Principal principal, Model model, TakeNoteEntity takeNoteEntity){
        noteServiceImpl.submit(takeNoteEntity, userRepository.findByUsername(principal.getName()));
        model.addAttribute("note",noteServiceImpl.findAll());
        return "take_note";
    }

    @GetMapping("/find_title")
    public String title(Model model ,String title){
        model.addAttribute("find_note",noteServiceImpl.findByTitle(title));

        return "findByTitle";
    }

}
