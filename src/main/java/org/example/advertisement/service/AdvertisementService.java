package org.example.advertisement.service;

import org.example.advertisement.domain.Advertisement;
import org.example.advertisement.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    public List<Advertisement> getAllAdvertisements() {
        return advertisementRepository.findAll();
    }

    public Advertisement getAdvertisementById(Long id) {
        return advertisementRepository.findById(id).orElse(null);
    }

    public Advertisement createAdvertisement(Advertisement user) {
        return advertisementRepository.save(user);
    }

    public Advertisement updateAdvertisement(Long id, Advertisement user) {
        Advertisement existingUser = advertisementRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setTitle(user.getTitle());
            existingUser.setUrl(user.getUrl());
            existingUser.setImage(user.getImage());
            return advertisementRepository.save(existingUser);
        }
        return null;
    }

    public void deleteUser(Long id) {
        advertisementRepository.deleteById(id);
    }
}