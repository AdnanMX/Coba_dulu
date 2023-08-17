package com.protonema.medical.oms.stock.service;

import java.util.List;
import java.util.Optional;
// import java.util.UUID;

import com.protonema.medical.oms.stock.entitiy.Stock;

public interface StockService {

    void addStock(Stock stock);

    List<Stock> getAllStocks();

    Optional<Stock> getStockById(Long id);

    void updateStock(Stock stock);

    void deleteStock(Long id);

}
