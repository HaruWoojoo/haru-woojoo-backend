package com.example.demo.diary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryService {
    private final DiaryRepository diaryRepository;

    @Autowired
    public DiaryService(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    public Diary getById(Long id) {
        return diaryRepository.findById(id).orElseThrow();
    }

    public List<Diary> getAllByUserId(Long userId) {
        return diaryRepository.findAllByUserId(userId);
    }

    public Diary create(Diary diary) {
        return diaryRepository.save(diary);
    }
}
