package com.shop_monitor.back.Model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Tick {
    boolean isOpen;
    LocalDateTime dataTime;
}
