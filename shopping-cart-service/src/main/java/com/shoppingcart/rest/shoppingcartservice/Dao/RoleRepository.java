package com.shoppingcart.rest.shoppingcartservice.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.rest.shoppingcartservice.Model.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    public Role findByRole(String role);
}
