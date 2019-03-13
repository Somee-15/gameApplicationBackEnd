package com.stackroute.fgf.stratup;

import com.stackroute.fgf.domain.Player;
import com.stackroute.fgf.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class StartupApplicationListner implements ApplicationListener<ContextRefreshedEvent> {
    private PlayerRepository playerRepository;

    @Autowired
    public StartupApplicationListner(PlayerRepository playerRepository){
        this.playerRepository=playerRepository;

    }

    @Override
    @Order(2)
    public void onApplicationEvent(ContextRefreshedEvent event) {
        playerRepository.save(new Player(2,"somee",50,"good"));

    }
}
