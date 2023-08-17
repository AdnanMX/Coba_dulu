package com.protonema.medical.oms.stock.controller;

import java.util.List;
import java.util.Optional;
// import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.protonema.medical.oms.stock.entitiy.Stock;
import com.protonema.medical.oms.stock.service.StockService;

@RestController
@RequestMapping("/api/stock")
public class StockController {
 
    @Autowired
    StockService stockService;
    
    @PostMapping
    public ResponseEntity<?>addStock(@RequestBody Stock stock) {
        stockService.addStock(stock); 
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllStock() {
        List<Stock> stock = stockService.getAllStocks();
        return ResponseEntity.ok(stock);
    } 

    @GetMapping("/id")
    public ResponseEntity getStockById(@RequestParam Long id) {
        Optional<Stock> stock = stockService.getStockById(id);
        return stock.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity updateStock(@RequestParam Long id, @RequestBody Stock stock) {
        Optional<Stock> existingStock = stockService.getStockById(id);

        if (existingStock.isPresent()) {
            Stock updatedStock = existingStock.get();
            updatedStock.setSupplierDesc(stock.getSupplierDesc());

            stockService.updateStock(updatedStock);

            return ResponseEntity.ok(HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity deleteStockById(@RequestParam Long id) {
        stockService.deleteStock(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
