package org.example.amwaytest.prize;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Prize {
    String name;
    double probability;
    AtomicInteger quantity;

    public Prize(String name, double probability, int quantity) {
        this.name = name;
        this.probability = probability;
        this.quantity = new AtomicInteger(quantity);
    }
}
