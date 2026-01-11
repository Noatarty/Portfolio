package com.iut.collaborateurs.listener;

import com.iut.collaborateurs.service.DataInitializerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DataInitializerListener {
    
    @Autowired
    private DataInitializerService initialiserDataServiceDev;
    
    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() {
        initialiserDataServiceDev.initialiser();
    }
}
