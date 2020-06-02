package com.web.blosom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.blosom.model.Flowers;

@Repository
public interface FlowerRepository extends JpaRepository<Flowers, Long>{

}
