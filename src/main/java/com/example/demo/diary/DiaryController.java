package com.example.demo.diary;

import com.example.demo.diary.dto.DiaryCreateDto;
import com.example.demo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/diary")
@Controller
public class DiaryController {
    private final DiaryService diaryService;

    private final UserService userService;

    @Autowired
    public DiaryController(DiaryService diaryService, UserService userService) {
        this.diaryService = diaryService;
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Diary getById(@PathVariable Long id) {
        return diaryService.getById(id);
    }

    @GetMapping("/{userId}")
    @ResponseBody
    public List<Diary> getByUserId(@PathVariable Long userId) {
        return diaryService.getAllByUserId(userId);
    }

    @PostMapping("")
    @ResponseBody
    public Diary create(@RequestBody DiaryCreateDto dto) {
        Diary diary = new Diary();
        diary.setUser(userService.getById(dto.getUserId()));
        diary.setContent(dto.getContent());
        return diaryService.create(diary);
    }
}
