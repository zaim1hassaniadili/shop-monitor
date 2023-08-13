package com.shop_monitor.back.Repository;

import com.shop_monitor.back.Model.Tick;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TickRepository extends JpaRepository<Tick, Long> {
    Optional<Tick> findTopByOrderByIdDesc();
    Boolean save(Tick tick);
}
