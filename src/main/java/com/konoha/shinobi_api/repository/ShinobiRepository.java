package com.konoha.shinobi_api.repository;

import com.konoha.shinobi_api.model.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ShinobiRepository {
    private final JdbcTemplate jdbcTemplate;

    public ShinobiRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Shinobi s) {
        String sql = "INSERT INTO shinobi (name, chakra_level, dtype) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, s.getName(), s.getChakraLevel(), s.getClass().getSimpleName());
    }

    public List<Shinobi> findAll() {
        return jdbcTemplate.query("SELECT * FROM shinobi", shinobiMapper);
    }

    public Shinobi findById(int id) {
        return jdbcTemplate.queryForStream("SELECT * FROM shinobi WHERE id = ?", shinobiMapper, id)
                .findFirst().orElse(null);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM shinobi WHERE id = ?", id);
    }

    private final RowMapper<Shinobi> shinobiMapper = (rs, rowNum) -> {
        String type = rs.getString("dtype");
        int id = rs.getInt("id");
        String name = rs.getString("name");
        int chakra = rs.getInt("chakra_level");

        if ("MedicNinja".equalsIgnoreCase(type)) {
            return new MedicNinja(id, name, chakra);
        }
        return new WarriorNinja(id, name, chakra);
    };
}