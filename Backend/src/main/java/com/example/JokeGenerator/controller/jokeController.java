package com.example.JokeGenerator.controller;

import com.example.JokeGenerator.api.JokeApi;
import com.example.JokeGenerator.payload.JokeEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/joke")
@CrossOrigin(origins = "*")
public class jokeController {
    @GetMapping("/getJoke")
    public ResponseEntity<JokeEntity> sendJokes(){
        JokeApi jokeApi = new JokeApi();
        JokeEntity jokeEntity = jokeApi.connectToJokeApi();
        if (jokeEntity != null){
            return ResponseEntity.ok(jokeEntity);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}