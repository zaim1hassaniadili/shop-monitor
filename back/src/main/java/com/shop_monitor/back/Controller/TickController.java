package com.shop_monitor.back.Controller;

import com.shop_monitor.back.Model.ShopMonitor;
import com.shop_monitor.back.Model.Tick;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@Slf4j
public class TickController {
    @Autowired
    final ShopMonitor shopMonitor;

    public TickController(ShopMonitor shopMonitor) {
        this.shopMonitor = shopMonitor;
    }

    @GetMapping("/status")
    public ResponseEntity<Tick> sendLastTick(){
        return ResponseEntity.ok(shopMonitor.getLatestTick());
    }

}
