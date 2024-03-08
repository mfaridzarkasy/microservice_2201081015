/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farid.order.service;

import com.farid.order.enity.Order;
import com.farid.order.repository.OrderRepository;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author farid
 */@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    public List<Order> getAll(){
        return orderRepository.findAll();
    }
    
    public Order getOrderById(long id){
        return orderRepository.getReferenceById(id);
    }
    
    public void insert(Order product){
        orderRepository.save(product);
    }
    
    public void update(Long id, Long produkId, Integer jumlah, String tanggal, String status, double total){
        Order order = orderRepository.findById(produkId)
                .orElseThrow(
                        () -> new IllegalStateException("Produk tidak ada")
                );
        
        if (jumlah != null) {
            order.setJumlah(jumlah);
        }
        if(tanggal != null && tanggal.length()>0
                && !Objects.equals(order.getTanggal(), tanggal)){
            order.setTanggal(tanggal);
        }
        if(status != null && status.length()>0
                && !Objects.equals(order.getStatus(), status)){
            order.setStatus(status);
        }
    }
    
    public void delete(Long id){
        orderRepository.deleteById(id);
    }

    public void update(Long id, Long produkId, int jumlah, String tanggal, String status, double total) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

