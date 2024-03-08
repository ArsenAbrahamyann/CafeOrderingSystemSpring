package org.picsartacademy.service;


import org.picsartacademy.repository.BillingRepository;
import org.picsartacademy.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BillingService {
    @Autowired
    private BillingRepository billingDao;

    public void generateBill(Bill bill) {
        billingDao.save(bill);
    }

    public List<Bill> getAllBills() {
        return (List<Bill>) billingDao.findAll();
    }

    public Bill getBillById(Long id) {
        return billingDao.findById(id).orElse(null);
    }

    public void updateBill(Bill bill) {
        billingDao.save(bill);
    }

    public void deleteBill(Long id) {
        billingDao.deleteById(id);
    }
}
