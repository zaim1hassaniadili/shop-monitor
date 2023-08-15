package com.shop_monitor.back.Model;

import com.shop_monitor.back.Repository.TickRepository;
import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@Data
public class ShopMonitor {
    boolean currentStatus;
    @Autowired
    final TickRepository tickRepository;
    Tick latestTick;


    public Tick getLatestTick() {
        latestTick = tickRepository.findTopByOrderByIdDesc().orElse(new Tick(false, LocalDateTime.now()));
        return latestTick;
    }
    public Tick saveTick(Tick tick){
        this.currentStatus = tick.isOpen;
        this.latestTick = tick;
        log.info("dateTime: " + tick.dataTime.toString() + " isOpen: "+ tick.isOpen);
        return tickRepository.save(tick);
    }
}
