package com.stackroute.fgf.stratup;

import com.stackroute.fgf.domain.Player;
import com.stackroute.fgf.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class StartupCommandLineRunner implements CommandLineRunner {
    private PlayerRepository playerRepository;

    @Autowired
    Environment env;

    @Value("${id:default}")
    int id;

    @Value("${name:default}")
    String name;

    @Value("${score:default}")
    int score;


    @Autowired
    public StartupCommandLineRunner(PlayerRepository playerRepository){
        this.playerRepository=playerRepository;
    }
    @Override
    @Order(1)
    public void run(String... args) throws Exception {
        playerRepository.save(new Player(id,name,score,env.getProperty("feedback")));

    }
}
