package com.yq.controller;

import com.yq.domain.Category;
import com.yq.domain.CategoryModel;
import com.yq.domain.Device;
import com.yq.domain.Model;
import com.yq.repository.CategoryModelRepository;
import com.yq.repository.CategoryRepository;
import com.yq.repository.DeviceRepository;
import com.yq.repository.ModelRepository;
import com.yq.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
    ModelRepository  modelRepository;
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
        device.setCategory(category);
        device.setCategoryModel(cModel);
        deviceRepository.save(device);


        return deviceRepository.findAll();
    }

}
