package org.example.advertisement.controller;

import org.example.advertisement.domain.Advertisement;
import org.example.advertisement.service.AdvertisementService;
import org.example.reponse.ResponseDto;
import org.example.reponse.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/advertisements")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping
    public ResponseDto<List<Advertisement>> getAllAdvertisements() {
        List<Advertisement> ret = advertisementService.getAllAdvertisements();

        return ResponseUtil.SUCCESS("광고 조회에 성공하였습니다.", ret);
    }

    @GetMapping("/{id}")
    public ResponseDto<Advertisement> getAdvertisementById(@PathVariable Long id) {
        Advertisement ret = advertisementService.getAdvertisementById(id);

        return ResponseUtil.SUCCESS("광고 조회에 성공하였습니다.", ret);
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