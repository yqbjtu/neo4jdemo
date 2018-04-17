package com.yq.controller;

import com.yq.domain.Category;
import com.yq.domain.CategoryModel;
import com.yq.repository.CategoryModelRepository;
import com.yq.repository.CategoryRepository;
import com.yq.repository.Category2ModelRelationRepository;

import com.yq.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

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
    Category2ModelRelationRepository relationRepository;

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

    @GetMapping("/delRel")
    public Iterable<Category> deleteRalation() {
        //clean work
        //equal to MATCH (n)-[r0:`Category_2_Model`]-() DELETE r0
        relationRepository.deleteAll();
        return categoryRepository.findAll();
    }

    @GetMapping("/init")
    public Iterable<Category> init() {
        //clean work
        relationRepository.deleteAll();
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
        categoryPlane.addModel(cModel);

        cModel = new CategoryModel("空客380" , "EU ");
        categoryModelRepository.save(cModel);

        categoryPlane.addModel(cModel);
        categoryRepository.save(categoryPlane);


        CategoryModel tModel = new CategoryModel("T" , "特快 ");
        categoryTrain.addModel(tModel);

        CategoryModel dModel = new CategoryModel("D" , "动车 ");
        categoryTrain.addModel(dModel);

        CategoryModel gModel = new CategoryModel("G" , "高铁" );
        categoryTrain.addModel(gModel);

        categoryRepository.save(categoryTrain);
        return categoryRepository.findAll();
    }

}
