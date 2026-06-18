package com.skills.hub.service;

import com.skills.hub.model.SkillPack;
import com.skills.hub.repository.SkillPackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillPackServiceImpl implements SkillPackService {

    private final SkillPackRepository packRepository;

    public SkillPackServiceImpl(SkillPackRepository packRepository) {
        this.packRepository = packRepository;
    }

    @Override
    public SkillPack addSkillPack(SkillPack pack) {
        return packRepository.save(pack);
    }

    @Override
    public List<SkillPack> getAllPacks() {
        return packRepository.findAll();
    }

    @Override
    public SkillPack updateSkillPack(SkillPack pack) {
        // If the pack already exists, save will update it
        return packRepository.save(pack);
    }

    @Override
    public void deleteSkillPack(Long id) {
        packRepository.deleteById(id);
    }
}
