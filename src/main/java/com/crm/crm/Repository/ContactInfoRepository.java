package com.crm.crm.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.crm.model.Client;
import com.crm.crm.model.ContactInfo;




    public interface ContactInfoRepository extends JpaRepository<ContactInfo,Long>{
       List<ContactInfo> findByClientId(Long clientId);
       List<ContactInfo> findByClientIdAndType(Long clientId, String type);

    }

    
