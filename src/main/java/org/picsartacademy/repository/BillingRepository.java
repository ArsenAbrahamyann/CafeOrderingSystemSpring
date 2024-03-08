package org.picsartacademy.repository;

import org.picsartacademy.entity.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends CrudRepository<Bill,Long> {
}
