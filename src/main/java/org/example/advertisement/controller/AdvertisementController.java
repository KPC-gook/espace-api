package org.example.advertisement.controller;

import org.example.advertisement.domain.Advertisement;
import org.example.advertisement.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/advertisements")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping
    public List<Advertisement> getAllAdvertisements() {
        return advertisementService.getAllAdvertisements();
    }

    @GetMapping("/{id}")
    public Advertisement getAdvertisementById(@PathVariable Long id) {
        return advertisementService.getAdvertisementById(id);
    }

    @PostMapping
    public Advertisement createAdvertisement(@RequestBody Advertisement user) {
        return advertisementService.createAdvertisement(user);
    }

    @PutMapping("/{id}")
    public Advertisement updateAdvertisement(@PathVariable Long id, @RequestBody Advertisement user) {
        return advertisementService.updateAdvertisement(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        advertisementService.deleteUser(id);
    }
}