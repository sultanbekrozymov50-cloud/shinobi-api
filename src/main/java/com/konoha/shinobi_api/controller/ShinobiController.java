package com.konoha.shinobi_api.controller;

import com.konoha.shinobi_api.dto.ShinobiRequest;
import com.konoha.shinobi_api.model.Shinobi;
import com.konoha.shinobi_api.pattern.ShinobiFactory;
import com.konoha.shinobi_api.service.ShinobiService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/shinobi")
public class ShinobiController {
    private final ShinobiService service;
    public ShinobiController(ShinobiService service) { this.service = service; }

    @GetMapping
    public List<Shinobi> getAll() { return service.getAll(); }

    @PostMapping
    public String create(@RequestBody ShinobiRequest req) {
        Shinobi s = ShinobiFactory.createShinobi(req.getType(), req.getName(), req.getChakra());
        service.add(s);
        return "Shinobi " + req.getName() + " created!";
    }
}