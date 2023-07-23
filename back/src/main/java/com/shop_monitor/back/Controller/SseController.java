package com.shop_monitor.back.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@CrossOrigin(origins = "http://10.18.203.94:4444/")
@RestController
@Slf4j
public class SseController {
    public List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

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
    public void dispatchEventToClients(@RequestParam String info){

        for(SseEmitter emitter : emitters){
            try{
                emitter.send(SseEmitter.event().name("status").data(info));
                log.info("Emitter has been send");
            }catch(IOException e){
                emitters.remove(emitter);
            }
        }

    }
}
