package com.yq.service;

import java.util.*;

import  com.yq.domain.Category;
import com.yq.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    private final static Logger LOG = LoggerFactory.getLogger(CategoryService.class);

	private final CategoryRepository categoryRepository;
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}




    @Transactional(readOnly = true)
    public Category findByName(String name) {
		Category result = categoryRepository.findByName(name);
        return result;
    }

    @Transactional(readOnly = true)
    public Collection<Category> findByNameLike(String title) {
        Collection<Category> result = categoryRepository.findByNameLike(title);
        return result;
    }


}
