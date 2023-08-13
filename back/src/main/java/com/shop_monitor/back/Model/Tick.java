package com.shop_monitor.back.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@RequiredArgsConstructor
public class Tick {
    @Id
    Long id;
    boolean isOpen;
    LocalDateTime dataTime;


    public Tick(boolean b, LocalDateTime now) {
        this.isOpen = b;
        this.dataTime = now;
    }
}
