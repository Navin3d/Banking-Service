package gmc.project.bankingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import gmc.project.bankingsystem.entities.CustomerEntity;

public interface CustomerDao extends JpaRepository<CustomerEntity, String> {

}
