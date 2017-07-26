package com.jdriven.ng2boot.repository;

import com.jdriven.ng2boot.domain.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface RoleRepository extends CrudRepository<Role, Long> {

    Page<Role> findAll(Pageable pageable);
}
