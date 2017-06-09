package com.kripesh.salesapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kripesh.salesapp.model.Item;

public interface ItemDao extends JpaRepository<Item, Long>{

}
