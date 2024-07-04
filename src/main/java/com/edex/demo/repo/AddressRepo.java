package com.edex.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edex.demo.model.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

}
