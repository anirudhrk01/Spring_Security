package com.gl.bed.gradedProject4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.bed.gradedProject4.Entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
