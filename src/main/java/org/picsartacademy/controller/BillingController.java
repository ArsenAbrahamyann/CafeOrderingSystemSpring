package org.picsartacademy.controller;

import org.picsartacademy.entity.Bill;
import org.picsartacademy.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillingController {
    @Autowired
    private BillingService billingService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateBill(@RequestBody Bill bill) {
        billingService.generateBill(bill);
        return ResponseEntity.ok("Bill generated successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Bill>> getAllBills() {
        List<Bill> bills = billingService.getAllBills();
        return ResponseEntity.ok(bills);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable Long id) {
        Bill bill = billingService.getBillById(id);
        if (bill != null) {
            return ResponseEntity.ok(bill);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateBill(@RequestBody Bill bill) {
        Bill existingBill = billingService.getBillById(bill.getId());
        if (existingBill != null) {
            billingService.updateBill(bill);
            return ResponseEntity.ok("Bill updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBill(@PathVariable Long id) {
        Bill existingBill = billingService.getBillById(id);
        if (existingBill != null) {
            billingService.deleteBill(id);
            return ResponseEntity.ok("Bill deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
