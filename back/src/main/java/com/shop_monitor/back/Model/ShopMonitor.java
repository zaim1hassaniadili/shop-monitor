package com.shop_monitor.back.Model;

import com.shop_monitor.back.Repository.TickRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class ShopMonitor {
    boolean currentStatus;
    @Autowired
    final TickRepository tickRepository;
    Tick latestTick;


    public Tick getLatestTick() {
        latestTick = tickRepository.findTopByOrderByIdDesc().orElse(()-> {
            latestTick = new Tick(false, LocalDateTime.now());
        });
        
        return latestTick;
    }
}
