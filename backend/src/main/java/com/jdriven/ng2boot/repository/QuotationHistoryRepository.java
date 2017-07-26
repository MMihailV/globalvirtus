package com.jdriven.ng2boot.repository;

import com.jdriven.ng2boot.domain.QuotationHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface QuotationHistoryRepository extends CrudRepository<QuotationHistory, Long> {

    Page<QuotationHistory> findAll(Pageable pageable);
}

