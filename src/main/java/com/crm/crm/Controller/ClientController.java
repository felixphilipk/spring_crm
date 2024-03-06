package com.crm.crm.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.crm.crm.Service.ClientService;
import com.crm.crm.model.Client;
import com.crm.crm.model.ContactInfo;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




 @RestController
 @RequestMapping("/api/clients") 
 public class ClientController{

  @Autowired
  private ClientService clientService;  
  
  @PostMapping("/")
  public Client addClient(@RequestBody Client client){

    return clientService.addClient(client);

  }

  @PostMapping("/{clientId}/contacts")
  public ContactInfo addContact(@PathVariable Long clientId,@RequestBody ContactInfo contactInfo){

    return clientService.addClientContact(clientId,contactInfo);
  }

  @GetMapping("/")
  public List<Client>getAllClients() {
      return clientService.getAllClients();
  }

  @GetMapping("/{id}")
  public Client getClientById(@PathVariable Long id) {
      return (Client) clientService.getClientById(id);
  }

  @GetMapping("/{clientId}/contacts")
  public List<ContactInfo> getClientContacts(@PathVariable Long clientId){
     return clientService.getClientContacts(clientId);
  }
  
  @GetMapping("/{clientId}/contacts/{type}")
  public List<ContactInfo>getClientContactsByType(@PathVariable Long clientId,@PathVariable String type) {
      return clientService.getClientContactsByType(clientId,type);
  }
  
  
  


 }  
    

