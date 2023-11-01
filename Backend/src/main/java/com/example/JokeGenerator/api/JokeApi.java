package com.example.JokeGenerator.api;

import com.example.JokeGenerator.payload.JokeEntity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JokeApi {

    public JokeEntity connectToJokeApi()  {
        String url = "https://v2.jokeapi.dev/joke/Any";
        try {
            URL url1 = new URL(url); // this is the url we are connecting to
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection(); // this is the connection to the url
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode(); // this is the response code

            if (responseCode == HttpURLConnection.HTTP_OK) { // if the response code is 200
                BufferedReader in = new BufferedReader(new java.io.InputStreamReader(connection.getInputStream())); // we are reading the response
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) { // while there is a response
                    response.append(inputLine); // we are appending the response
                }
                in.close(); // we are closing the connection
                // parse the json  and map it to the JokeEntity class
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(response.toString()); // we are reading the response

                JokeEntity jokeEntity = new JokeEntity();
                jokeEntity.setCategory(jsonNode.get("category").asText());
                jokeEntity.setType(jsonNode.get("type").asText());
                jokeEntity.setJoke(jsonNode.get("joke").asText());
                return jokeEntity;
            } else {
                System.out.println("Error: " + responseCode);
            }
            connection.disconnect(); // we are disconnecting from the connection
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
