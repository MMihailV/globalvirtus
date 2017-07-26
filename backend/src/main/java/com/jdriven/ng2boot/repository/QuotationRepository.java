package com.jdriven.ng2boot.repository;

import com.jdriven.ng2boot.domain.Quotation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface QuotationRepository extends CrudRepository<Quotation, Long> {

    Page<Quotation> findAll(Pageable pageable);
}
