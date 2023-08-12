package com.shop_monitor.back.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Tick {
    @Id
    Long id;
    boolean isOpen;
    LocalDateTime dataTime;
}
