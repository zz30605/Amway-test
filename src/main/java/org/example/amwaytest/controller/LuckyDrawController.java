package org.example.amwaytest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.example.amwaytest.service.LuckyDrawService;


import java.util.List;

@RestController
@RequestMapping("/luckyDraw")
@RequiredArgsConstructor
class LuckyDrawController {
    private final LuckyDrawService luckyDrawService;

    @PostMapping("/{userId}")
    public List<String> draw(@PathVariable String userId, @RequestParam(defaultValue = "1") int times) {
        return luckyDrawService.draw(userId, times);
    }
}