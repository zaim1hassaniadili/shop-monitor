package com.shop_monitor.back.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    LocalDateTime dataTime;


    public Tick(boolean b, LocalDateTime now) {
        this.isOpen = b;
        this.dataTime = now;
    }
}
