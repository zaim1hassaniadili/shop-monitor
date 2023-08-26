package com.shop_monitor.back.Controller;

import com.shop_monitor.back.Model.ShopMonitor;
import com.shop_monitor.back.Model.Tick;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@CrossOrigin(origins = "*")
@RestController
@Slf4j
public class SseController {
    public List<SseEmitter> emitters = new CopyOnWriteArrayList<>();
    @Autowired
    public final ShopMonitor shopMonitor;

    public SseController(ShopMonitor shopMonitor) {
        this.shopMonitor = shopMonitor;
    }

    @RequestMapping(value="/subscribe", consumes = MediaType.ALL_VALUE)
    public SseEmitter subscribe(){
        SseEmitter sseEmitter = new SseEmitter(Long.MAX_VALUE);
        log.info("inside");
        try{
            sseEmitter.send(SseEmitter.event().name("INIT"));
        }catch(Exception e){
            e.printStackTrace();
        }
        sseEmitter.onCompletion(() -> emitters.remove(sseEmitter));
        emitters.add(sseEmitter);
        log.info("before return");
        return sseEmitter;
    }

    @PostMapping(value= "/dispatch")
    public void dispatchEventToClients(@RequestBody Tick info){

        for(SseEmitter emitter : emitters){
            try{
                log.info("INFO ::" + info.toString());
                log.info("HERE !!! " + info.isOpen() );
                emitter.send(SseEmitter.event().name("status").data(String.valueOf(info.isOpen())));
                log.info("Emitter has been send");
                shopMonitor.saveTick(info);
            }catch(IOException e){
                emitters.remove(emitter);
            }
        }

    }
}
