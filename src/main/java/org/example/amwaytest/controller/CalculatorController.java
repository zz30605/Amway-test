package org.example.amwaytest.controller;

import lombok.RequiredArgsConstructor;
import org.example.amwaytest.service.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
@RequiredArgsConstructor
public class CalculatorController {
    private final CalculatorService calculatorService;

    @GetMapping("/add/{value}")
    public ResponseEntity<Double> add(@PathVariable("value") double val) {
        return ResponseEntity.ok(calculatorService.add(val));
    }

    @GetMapping("/subtract/{value}")
    public ResponseEntity<Double> subtract(@PathVariable("value") double val) {
        return ResponseEntity.ok(calculatorService.subtract(val));
    }

    @GetMapping("/multiply/{value}")
    public ResponseEntity<Double> multiply(@PathVariable("value") double val) {
        return ResponseEntity.ok(calculatorService.multiply(val));
    }

    @GetMapping("/divide/{value}")
    public ResponseEntity<Double> divide(@PathVariable("value") double val) {
        return ResponseEntity.ok(calculatorService.divide(val));
    }

    @GetMapping("/undo")
    public ResponseEntity<Double> undo() {
        return ResponseEntity.ok(calculatorService.undo());
    }

    @GetMapping("/redo")
    public ResponseEntity<Double> redo() {
        return ResponseEntity.ok(calculatorService.redo());
    }
}
