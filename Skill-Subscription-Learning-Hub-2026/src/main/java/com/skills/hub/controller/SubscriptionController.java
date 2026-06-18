package com.skills.hub.controller;

import com.skills.hub.model.Subscription;
import com.skills.hub.service.SubscriptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*
=========================================================
WHAT IS THIS FILE?
Handles subscription between user and skill pack
=========================================================
*/

@Controller
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/subscribe")
    public String subscribe(@RequestParam Long userId,
                            @RequestParam Long packId) {
        // STEP 1: call subscriptionService.subscribe(userId, packId)
        // STEP 2: redirect to subscriptions page
        subscriptionService.subscribe(userId, packId);
        return "redirect:/subscriptions/" + userId;
    }

    @GetMapping("/subscriptions/{userId}")
    public String viewSubscriptions(@PathVariable Long userId, Model model) {
        // STEP 1: list = subscriptionService.getUserSubscriptions(userId)
        // STEP 2: model.addAttribute("subs", list)
        // STEP 3: return subscriptions.jsp
        model.addAttribute("subs", subscriptionService.getUserSubscriptions(userId));
        return "subscriptions";
    }

    public SubscriptionService getSubscriptionService() {
        return subscriptionService;
    }
}
