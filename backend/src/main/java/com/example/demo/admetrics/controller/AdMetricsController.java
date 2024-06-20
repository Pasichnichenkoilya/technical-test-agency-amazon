package com.example.demo.admetrics.controller;

import com.example.demo.model.AdMetrics;
import com.example.demo.service.AdMetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/metrics")
public class AdMetricsController {
    private final AdMetricsService adMetricsService;

    @Autowired
    public AdMetricsController(AdMetricsService adMetricsService) {
        this.adMetricsService = adMetricsService;
    }

    @PostMapping("/ads")
    public AdMetrics createAdMetrics(@RequestBody AdMetrics adMetrics) {
        adMetricsService.createAdMetrics(adMetrics);
        return adMetrics;
    }

    @GetMapping("/ads")
    public Collection<AdMetrics> getAdMetrics() {
        return adMetricsService.getMetricsData();
    }

    @GetMapping("/ads/{id}")
    public ResponseEntity<AdMetrics> getAdMetricsById(@PathVariable("id") String id) {
        Optional<AdMetrics> adMetrics = adMetricsService.getAdMetricsById(id);
        return adMetrics.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/ads")
    public boolean updateAdMetrics(@RequestBody AdMetrics adMetrics) {
        return adMetricsService.updateAdMetrics(adMetrics);
    }

    @DeleteMapping("/ads/{id}")
    public boolean deleteAdMetricsById(@PathVariable("id") String id) {
        return adMetricsService.deleteAdMetricsById(id);
    }
}