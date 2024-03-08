/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farid.order.controller;

import com.farid.order.enity.Order;
import com.farid.order.service.OrderService;
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
 * @author farid
 */@RestController
  @RequestMapping("api/v1/product")
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @GetMapping
    public List<Order> getAll(){
        return orderService.getAll();
    }
    
    @PostMapping
    public void insert(@RequestBody Order product){
        orderService.insert(product);
    }
    
    @DeleteMapping(path = "{Id}")
    public void delete(@PathVariable ("Id") Long id){
        orderService.delete(id);
    }
    
    @PutMapping(path = "{Id}")
    public void update(@PathVariable ("Id") Long id,
        @RequestParam(required = false) Long produkId,
        @RequestParam(required = false) Integer jumlah,
        @RequestParam(required = false) String tanggal,
        @RequestParam(required = false) String status,
        @RequestParam(required = false) double total){
        orderService.update(id, produkId, jumlah, tanggal, status, total);
    }
    
    @GetMapping(path = "{Id}")
    public Order getOrderById(@PathVariable("Id")Long id){
        return orderService.getOrderById(id);
    }
}
