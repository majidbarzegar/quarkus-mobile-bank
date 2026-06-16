package com.bank.mobile.repository;

import com.bank.mobile.entity.MobileCustomer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.Optional;

@ApplicationScoped
public class MobileCustomerRepository implements PanacheRepository<MobileCustomer> {

    @Transactional
        public Optional<MobileCustomer> findByNationalCode(String nationalCode) {
        return find("nationalCode", nationalCode).firstResultOptional();
    }

}
