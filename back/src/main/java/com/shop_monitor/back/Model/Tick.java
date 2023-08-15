package com.shop_monitor.back.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@RequiredArgsConstructor
public class Tick {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    boolean isOpen;
    LocalDateTime dataTime;


    public Tick(boolean b, LocalDateTime now) {
        this.isOpen = b;
        this.dataTime = now;
    }
}
