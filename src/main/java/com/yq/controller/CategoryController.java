package com.yq.controller;

import  com.yq.domain.Category;
import com.yq.domain.CategoryModel;
import com.yq.domain.Model;
import com.yq.repository.CategoryModelRepository;
import com.yq.repository.CategoryRepository;
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
@RequestMapping("/category")
public class CategoryController {

	private final CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
    @Autowired
    CategoryRepository  categoryRepository;

    @Autowired
    CategoryModelRepository categoryModelRepository;
    @Autowired
    ModelRepository  modelRepository;

    @GetMapping("/byName")
    public Category findByName(@RequestParam String name) {
        return categoryService.findByName(name);
    }

    @GetMapping("/likeName")
    public Collection<Category> findByNameLike(@RequestParam String name) {
        return categoryService.findByNameLike(name);
    }

    @GetMapping("/all")
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @GetMapping("/init")
    public Iterable<Category> init() {
        //clean work
        modelRepository.deleteAll();
        categoryRepository.deleteAll();
        categoryModelRepository.deleteAll();

        Category categoryPlane  = new Category("Plane", "http://wwww.plane.com");
        Category categoryTrain = new Category("Train", "http://wwww.train.com");
        Category categoryCar = new Category("Car", "http://wwww.car.com");
        Category categoryBike  = new Category("Bike", "http://wwww.bike.com");

        categoryRepository.save(categoryPlane);
        categoryRepository.save(categoryTrain);
        categoryRepository.save(categoryCar);
        categoryRepository.save(categoryBike);

        CategoryModel cModel = new CategoryModel("波音737" , "US ");
        categoryModelRepository.save(cModel);
        Model model = new Model(cModel, categoryPlane);
        categoryPlane.addModel(model);

        cModel = new CategoryModel("空客380" , "EU ");
        categoryModelRepository.save(cModel);
        model = new Model(cModel, categoryPlane);
        categoryPlane.addModel(model);
        categoryRepository.save(categoryPlane);


        cModel = new CategoryModel("T" , "特快 ");
        categoryModelRepository.save(cModel);
        model = new Model(cModel, categoryTrain);
        categoryTrain.addModel(model);

        cModel = new CategoryModel("D" , "动车 ");
        categoryModelRepository.save(cModel);
        model = new Model(cModel, categoryTrain);
        categoryTrain.addModel(model);

        cModel = new CategoryModel("G" , "高铁" );
        Map<String, Object> myMap = new HashMap<>();
        myMap.put("key1", "value1");
        myMap.put("key2", "value2");
        cModel.setDynamicProps(myMap);
        categoryModelRepository.save(cModel);
        model = new Model(cModel, categoryTrain);
        categoryTrain.addModel(model);

        categoryRepository.save(categoryTrain);
        return categoryRepository.findAll();
    }

}
