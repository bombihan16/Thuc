package com.example.demo.Entities;

import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "take_note")
public class TakeNoteEntity {

    @Id
    @GeneratedValue
    @Column(name = "take_note_id")
    private Long id;

    @Column(name = "content", nullable = false, length = 999999)
    private String content;

    @Column(name = "date_create", nullable = false)
    private LocalDateTime date_create;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate_create() {
        return date_create;
    }

    public void setDate_create(LocalDateTime date_create) {
        this.date_create = date_create;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserEntity getUser_Id() {
        return user_id;
    }

    public void setUser_Id(UserEntity user_Id) {
        user_id = user_Id;
    }


}
