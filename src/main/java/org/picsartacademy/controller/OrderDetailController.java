package org.picsartacademy.controller;

import org.picsartacademy.entity.OrderDetail;
import org.picsartacademy.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-detail")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping("/add")
    public ResponseEntity<String> addOrderDetail(@RequestBody OrderDetail orderDetail) {
        orderDetailService.addOrderDetail(orderDetail);
        return ResponseEntity.ok("Order detail added successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderDetail>> getAllOrderDetails() {
        List<OrderDetail> orderDetails = orderDetailService.getAllOrderDetails();
        return ResponseEntity.ok(orderDetails);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetail> getOrderDetailById(@PathVariable Long id) {
        OrderDetail orderDetail = orderDetailService.getOrderDetailById(id);
        if (orderDetail != null) {
            return ResponseEntity.ok(orderDetail);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateOrderDetail(@RequestBody OrderDetail orderDetail) {
        OrderDetail existingOrderDetail = orderDetailService.getOrderDetailById(orderDetail.getId());
        if (existingOrderDetail != null) {
            orderDetailService.updateOrderDetail(orderDetail);
            return ResponseEntity.ok("Order detail updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrderDetail(@PathVariable Long id) {
        OrderDetail existingOrderDetail = orderDetailService.getOrderDetailById(id);
        if (existingOrderDetail != null) {
            orderDetailService.deleteOrderDetail(id);
            return ResponseEntity.ok("Order detail deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
