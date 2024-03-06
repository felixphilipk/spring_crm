package com.crm.crm.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Client {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)    
private Long id;
private String name;

@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
@JsonManagedReference
private Set<ContactInfo> contactInfos = new HashSet<>();


public Client(){}

public Client(String name){
    this.name = name;

}

public Long getId(){

    return id;

}

public void setId(Long id){
  this.id = id;
}

public String getName(){
    return name;
}

public void setName(String name){
    this.name = name;
}

public Set<ContactInfo> getContactInfos(){
  return contactInfos;
}

public void setContactInfos(Set<ContactInfo>contactInfo){
    this.contactInfos= contactInfo;
}

// Utility Methods

public void addContactInfo(ContactInfo contactInfo){
    this.contactInfos.add(contactInfo);
    contactInfo.setClient(this);
}

public void removeContactInfo(ContactInfo contactInfo){
    this.contactInfos.remove(contactInfo);
    contactInfo.setClient(null);

}

@Override
public boolean equals(Object o){
    if  (this ==o) return true;
    if (!(o instanceof Client)) return false;
    Client client = (Client) o;
    return id!= null && Objects.equals(id, client.id);

}

@Override
public int hashCode(){
    return Objects.hash(id);
}
    
}
