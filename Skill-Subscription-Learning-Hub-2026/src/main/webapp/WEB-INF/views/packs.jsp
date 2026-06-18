package com.skills.hub.model;

import jakarta.persistence.*;

@Entity
public class SkillPack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private double price;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
package com.skills.hub.repository;

import com.skills.hub.model.SkillPack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillPackRepository extends JpaRepository<SkillPack, Long> {
}
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
        return packRepository.save(pack);
    }

    @Override
    public void deleteSkillPack(Long id) {
        packRepository.deleteById(id);
    }
}
package com.skills.hub.controller;

import com.skills.hub.model.SkillPack;
import com.skills.hub.service.SkillPackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SkillPackController {

    private final SkillPackService packService;

    public SkillPackController(SkillPackService packService) {
        this.packService = packService;
    }

    @GetMapping("/packs")
    public String viewPacks(Model model) {
        model.addAttribute("packs", packService.getAllPacks());
        return "packs"; // JSP file name
    }

    @GetMapping("/add-pack")
    public String showAddPackPage() {
        return "add-pack"; // JSP file name
    }

    @PostMapping("/add-pack")
    public String addPack(@ModelAttribute SkillPack pack) {
        packService.addSkillPack(pack);
        return "redirect:/packs";
    }

    @GetMapping("/delete-pack/{id}")
    public String deletePack(@PathVariable Long id) {
        packService.deleteSkillPack(id);
        return "redirect:/packs";
    }
}
