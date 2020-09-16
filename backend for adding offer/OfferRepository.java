package com.app.customeradmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.customeradmin.model.AddOffer;

@Repository
public interface OfferRepository extends JpaRepository<AddOffer, Integer> 
{

}
