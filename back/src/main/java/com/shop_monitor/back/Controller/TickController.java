package com.shop_monitor.back.Controller;

import com.shop_monitor.back.Model.ShopMonitor;
import com.shop_monitor.back.Model.Tick;
import com.shop_monitor.back.Repository.TickRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Slf4j
public class TickController {
    @Autowired
    final ShopMonitor shopMonitor;
    @Autowired
    final TickRepository tickRepository;
    private static Logger log = Logger.getLogger(TickController.class.getName());
    public TickController(ShopMonitor shopMonitor, TickRepository tickRepository) {
        this.shopMonitor = shopMonitor;
        this.tickRepository = tickRepository;
    }

    @GetMapping("/status")
    public ResponseEntity<Tick> sendLastTick(){
        return ResponseEntity.ok(shopMonitor.getLatestTick());
    }


    @PostMapping("/tick")
    public ResponseEntity<?> tick(@RequestBody Tick tick){
        tickRepository.save(tick);
        log.info(tick.toString());
        return ResponseEntity.ok("added");
    }
}
