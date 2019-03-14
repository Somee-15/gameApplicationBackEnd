package com.stackroute.fgf.stratup;

import com.stackroute.fgf.domain.Player;
import com.stackroute.fgf.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/*class to initialize the database at startup of application*/
@Component
@AllArgsConstructor
public class StartupApplicationListner implements ApplicationListener<ContextRefreshedEvent> {
    private PlayerRepository playerRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        playerRepository.save(new Player(1, "somee", 50, "bad"));
    }
}
