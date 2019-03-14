/*
package com.stackroute.fgf.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.fgf.domain.Player;
import com.stackroute.fgf.service.PlayerServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PlayerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private Player player;
    @MockBean
    private PlayerServiceImpl playerServiceImpl;
    @InjectMocks
    private PlayerController playerController;

    private List<Player> list = null;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc= MockMvcBuilders.standaloneSetup(playerController).build();
        player = new Player();
        player.setId("1");
        player.setName("ajay");
        player.setScore("150");
        player.setFeedback("good");
        list = new ArrayList<>();
        list.add(player);
    }

    @Test
    public void savePlayer() throws Exception {
        when(playerServiceImpl.savePlayer(any())).thenReturn(player);
        mockMvc.perform(MockMvcRequestBuilders.post("/fgf/api/v1/player")

                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(player))).
                andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }


    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}*/
