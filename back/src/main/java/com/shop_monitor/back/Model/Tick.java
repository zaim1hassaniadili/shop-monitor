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
    boolean open;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
    LocalDateTime dateTime;


    public Tick(boolean b, LocalDateTime now) {
        this.open = b;
        this.dateTime = now;
    }

    public String toString(){
        return "date: " + String.valueOf(this.dateTime) + "- Bool: " + String.valueOf(this.open);
    }
}
