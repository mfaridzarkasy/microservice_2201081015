/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farid.product.controller;

import com.farid.product.enity.Product;
import com.farid.product.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author irfan
 */@RestController
  @RequestMapping("api/v1/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }
    
    @PostMapping
    public void insert(@RequestBody Product product){
        productService.insert(product);
    }
    
    @DeleteMapping(path = "{Id}")
    public void delete(@PathVariable ("Id") Long id){
        productService.delete(id);
    }
    
    @PutMapping(path = "{Id}")
    public void update(@PathVariable ("Id") Long id,
        @RequestParam(required = false) String kode,
        @RequestParam(required = false) String nama,
        @RequestParam(required = false) String satuan,
        @RequestParam(required = false) double harga){
        productService.update(id, kode, nama, satuan,harga);
    }
    
    @GetMapping(path = "{Id}")
    public Product getProductById(@PathVariable("Id")Long id){
        return productService.getProductById(id);
    }
}
