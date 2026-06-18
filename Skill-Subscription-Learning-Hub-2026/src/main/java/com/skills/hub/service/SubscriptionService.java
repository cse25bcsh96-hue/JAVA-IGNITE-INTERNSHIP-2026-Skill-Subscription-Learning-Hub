package com.skills.hub.service;

import com.skills.hub.model.Subscription;
import com.skills.hub.model.User;
import com.skills.hub.model.SkillPack;
import com.skills.hub.repository.SubscriptionRepository;
import com.skills.hub.repository.UserRepository;
import com.skills.hub.repository.SkillPackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;
    private final SkillPackRepository skillPackRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository,
                                   UserRepository userRepository,
                                   SkillPackRepository skillPackRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.userRepository = userRepository;
        this.skillPackRepository = skillPackRepository;
    }

    @Override
    public Subscription subscribe(Long userId, Long packId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        SkillPack pack = skillPackRepository.findById(packId)
                .orElseThrow(() -> new RuntimeException("Skill Pack not found"));

        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setPack(pack);
        subscription.setStatus("ACTIVE");

        return subscriptionRepository.save(subscription);
    }

    @Override
    public List<Subscription> getUserSubscriptions(Long userId) {
        return subscriptionRepository.findByUserId(userId);
    }
}
