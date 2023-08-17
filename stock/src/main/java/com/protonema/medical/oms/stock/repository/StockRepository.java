package com.protonema.medical.oms.stock.repository;

// import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.protonema.medical.oms.stock.entitiy.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
    
}
