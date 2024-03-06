package com.crm.crm.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.crm.Repository.ClientRepository;
import com.crm.crm.Repository.ContactInfoRepository;
import com.crm.crm.model.Client;
import com.crm.crm.model.ContactInfo;



import java.util.List;

@Service
public class ClientService {

@Autowired
private ClientRepository clientRepository;

@Autowired
private ContactInfoRepository contactInfoRepository;

public Client addClient(Client client){

    return clientRepository.save(client);
  

}

public ContactInfo addClientContact(Long clientId,ContactInfo contactInfo){
    Client client = clientRepository.findById(clientId).orElseThrow(()->new RuntimeException("Client not found"));
    contactInfo.setClient(client);
    return contactInfoRepository.save(contactInfo);
}

public List<Client>getAllClients(){
    return clientRepository.findAll();
}

public Client getClientById(Long id){
    return clientRepository.findById(id).orElseThrow(()-> new RuntimeException());
}

public List<ContactInfo> getClientContacts(Long clientId){
    return contactInfoRepository.findByClientId(clientId);
}

public List<ContactInfo>getClientContactsByType(Long clientId,String type){
    return contactInfoRepository.findByClientIdAndType(clientId, type);
}


    
}
