package com.crm.crm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.crm.model.Client;
import com.crm.crm.model.ContactInfo;

import jakarta.transaction.Transactional;

public interface ClientRepository extends JpaRepository<Client,Long> {


}
