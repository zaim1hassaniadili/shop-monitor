package com.shop_monitor.back.Model;

import lombok.Data;

@Data
public class ShopMonitor {
    boolean currentStatus;
    Tick latestTick;
}
