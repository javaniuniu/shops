package com.javaniuniu.shops.service;

import com.javaniuniu.shops.common.Page;
import com.javaniuniu.shops.model.Product;
import com.javaniuniu.shops.model.ProductType;
import com.javaniuniu.shops.repository.ProductRepository;
import com.javaniuniu.shops.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/2/27 7:32 PM
 */
@Service
@Transactional
public class ProductService {

    @Autowired
    ProductTypeRepository productTypeDao;

    @Autowired
    ProductRepository productDao;

    public void saveType(ProductType type) {
        productTypeDao.save(type);
    }

    public List<ProductType> findType() {
        return productTypeDao.findAll();
    }

    public void save(Product product) {
        productDao.save(product);
    }

    public Product findById(Integer id) {
        return productDao.getOne(id);
    }

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public List<Product> findNew() {
        return productDao.findByOrderByCreateTimeDesc();
    }

    public List<Product> findOld() {
        return productDao.findByOrderByCreateTimeAsc();
    }

    public List<Product> findPop() {
        return productDao.findPopProducts();
    }

    public List<Product> findProducts(Page<Product> page) {
        page.setResult(productDao.findAll(page.getPageable()).getContent());
        page.setTotalCount(productDao.count());
        return page.getResult();
    }
}