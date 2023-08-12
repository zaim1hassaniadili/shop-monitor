package com.shop_monitor.back.Repository;

import com.shop_monitor.back.Model.Tick;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TickRepository extends JpaRepository<Tick, Long> {
    Optional<Tick> findTopByOrderByIdDesc();
}
