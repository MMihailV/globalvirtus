package com.jdriven.ng2boot.repository;

import com.jdriven.ng2boot.domain.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface AdminRepository extends CrudRepository<Admin, Long> {

    Page<Admin> findAll(Pageable pageable);
}
