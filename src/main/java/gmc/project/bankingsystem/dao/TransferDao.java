package gmc.project.bankingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import gmc.project.bankingsystem.entities.TransferEntity;

public interface TransferDao extends JpaRepository<TransferEntity, String> {

}
