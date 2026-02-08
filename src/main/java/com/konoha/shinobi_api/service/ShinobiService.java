package com.konoha.shinobi_api.service;

import com.konoha.shinobi_api.model.Shinobi;
import com.konoha.shinobi_api.repository.ShinobiRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShinobiService {
    private final ShinobiRepository repo;
    public ShinobiService(ShinobiRepository repo) { this.repo = repo; }

    public void add(Shinobi s) { repo.save(s); }
    public List<Shinobi> getAll() { return repo.findAll(); }
}