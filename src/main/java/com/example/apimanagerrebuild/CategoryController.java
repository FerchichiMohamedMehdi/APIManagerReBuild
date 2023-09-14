package com.example.apimanagerrebuild;

import com.example.apimanagerrebuild.models.Category;
import com.example.apimanagerrebuild.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired CategoryService catService;

    @PostMapping("/category/add")
    public void ajoutCAtegory (@RequestBody Category c){
        catService.addCategory(c);
    }
}
