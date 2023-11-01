package com.example.JokeGenerator.controller;

import com.example.JokeGenerator.api.JokeApi;
import com.example.JokeGenerator.payload.JokeEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/joke")
public class jokeController {
    @GetMapping("/joke")
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