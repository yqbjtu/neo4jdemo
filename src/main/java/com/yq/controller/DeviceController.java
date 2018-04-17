package com.yq.controller;

import com.yq.domain.Category;
import com.yq.domain.CategoryModel;
import com.yq.domain.Device;
import com.yq.repository.CategoryModelRepository;
import com.yq.repository.CategoryRepository;
import com.yq.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 */
@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    CategoryRepository  categoryRepository;

    @Autowired
    CategoryModelRepository categoryModelRepository;

    @Autowired
    DeviceRepository  deviceRepository;


    @GetMapping("/all")
    public Iterable<Device> findAll() {
        return deviceRepository.findAll();
    }

    @GetMapping("/init")
    public Iterable<Device> init() {
        //clean work
        Category category = categoryRepository.findByName("Plane");
        CategoryModel cModel = categoryModelRepository.findByName("波音737");


        Device device = new Device("ChinaAir");
        device.setCategoryModel(cModel);
        deviceRepository.save(device);


        return deviceRepository.findAll();
    }

}
