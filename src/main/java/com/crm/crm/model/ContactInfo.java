package com.crm.crm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ContactInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String value;
    private String type;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="client_id")
    @JsonBackReference
    private Client client;
    public ContactInfo(){}
    public Long getId(){
        return id;
    }
    public void setId(Long id){
       this.id = id;
    }
    
    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value = value;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public Client getClient(){
        return client;
    }
    public void setClient(Client client){
        this.client = client;
    }




}
