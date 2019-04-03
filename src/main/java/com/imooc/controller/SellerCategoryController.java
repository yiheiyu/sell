package com.imooc.controller;

import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.form.CategoryForm;
import com.imooc.service.CategoryService;
import com.imooc.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/category")
@Slf4j
public class SellerCategoryController {


    @Autowired
    private CategoryService categoryService;


    /**
     * 获取商品类目列表
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        List<ProductCategory> productCategoryList = categoryService.findAll();
        map.put("productCategoryList", productCategoryList);
        return new ModelAndView("category/list", map);
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm form, BindingResult bindingResult, Map<String, Object> map) {

        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error", map);
        }

        ProductCategory productCategory = new ProductCategory();

        if (!StringUtils.isEmpty(form.getCategoryId())) {
            productCategory = categoryService.findOne(form.getCategoryId());
        }

        BeanUtils.copyProperties(form,productCategory);
        try {
            categoryService.save(productCategory);
        } catch (Exception e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/category/list");
        return new ModelAndView("common/success",map);
    }


    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId", required = false) String categoryId,
                              Map<String, Object> map) {
        if (!StringUtils.isEmpty(categoryId)) {
            ProductCategory productCategory = categoryService.findOne(Integer.valueOf(categoryId));
            map.put("productCategory",productCategory);
        }
        return new ModelAndView("category/index",map);
    }


}
