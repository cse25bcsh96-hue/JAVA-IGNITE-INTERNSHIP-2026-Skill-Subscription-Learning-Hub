package com.skills.hub.service;

import com.skills.hub.model.SkillPack;
import com.skills.hub.repository.SkillPackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillPackService {

    private final SkillPackRepository packRepository;

    public SkillPackService(SkillPackRepository packRepository) {
        this.packRepository = packRepository;
    }

    // Get all skill packs
    public List<SkillPack> getAllPacks() {
        return packRepository.findAll();
    }

    // Add a new skill pack
    public void addSkillPack(SkillPack pack) {
        packRepository.save(pack);
    }

    // Delete a skill pack by ID
    public void deleteSkillPack(Long id) {
        packRepository.deleteById(id);
    }
}
package com.skills.hub.repository;

import com.skills.hub.model.SkillPack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillPackRepository extends JpaRepository<SkillPack, Long> {
}
