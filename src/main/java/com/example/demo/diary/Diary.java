package com.example.demo.diary;

import com.example.demo.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Diary {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private User user;

    private String content;

    private LocalDate targetDate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
