package com.protonema.medical.oms.stock.service.Impl;

import java.util.List;
import java.util.Optional;
// import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protonema.medical.oms.stock.entitiy.Stock;
import com.protonema.medical.oms.stock.repository.StockRepository;
import com.protonema.medical.oms.stock.service.StockService;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    StockRepository stockRepository;
    
    // Post
    @Override
    public void addStock(Stock stock) {
        stockRepository.save(stock);
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Optional<Stock> getStockById(Long id) {
        Optional<Stock> stock = stockRepository.findById(id);

        return stock;
    }

    @Override
    public void updateStock(Stock stock) {
        stockRepository.save(stock);
    }

    @Override
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
     
}
