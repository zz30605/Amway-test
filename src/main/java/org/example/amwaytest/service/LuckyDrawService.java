package org.example.amwaytest.service;

import org.example.amwaytest.constants.ErrorEnum;
import org.example.amwaytest.prize.Prize;
import org.example.amwaytest.util.ExceptionUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class LuckyDrawService {
    public LuckyDrawService() {
        prizes.add(new Prize("prize1", 0.1, 3));
        prizes.add(new Prize("prize2", 0.15, 5));
        prizes.add(new Prize("prize3", 0.2, 10));
    }

    private final List<Prize> prizes = new ArrayList<>();
    private final Random random = new Random();
    private final Map<String, Integer> userDrawCounts = new ConcurrentHashMap<>();
    private static final int MAX_DRAW_PER_USER = 10;

    public List<String> draw(String userId, int times) {
        List<String> results = new ArrayList<>();

        int alreadyDrawn = userDrawCounts.computeIfAbsent(userId, v -> 0);

        if (alreadyDrawn + times > MAX_DRAW_PER_USER) {
            throw ExceptionUtil.createAbstractCustomException(
                    ErrorEnum.DRAW_LIMIT_EXCEEDED, "remaining times: " + (MAX_DRAW_PER_USER - alreadyDrawn));
        }

        for (int t = 0; t < times; t++) {
            String prize = drawOnce();
            results.add(prize);
        }

        userDrawCounts.put(userId, alreadyDrawn + times);
        return results;
    }

    private String drawOnce() {
        double rand = random.nextDouble();
        double cumulative = 0.0;

        for (Prize prize : prizes) {
            cumulative += prize.getProbability();
            if (rand < cumulative) {
                while (true) {
                    int current = prize.getQuantity().get();
                    if (current <= 0) break;

                    if (prize.getQuantity().compareAndSet(current, current - 1)) {
                        return prize.getName();
                    }
                }
                break;
            }
        }
        return "銘謝惠顧";
    }
}