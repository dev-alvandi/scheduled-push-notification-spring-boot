package com.noah.push_notification.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;


public class Post {

    private WebClient webClient = WebClient.create();

    private HashMap<String, String> requestBody;
    private String URI;

    public Post(HashMap<String, String> requestBody, String URI) {
        this.requestBody = requestBody;
        this.URI = URI;
    }

    public String postRequest(){
        return webClient
                .post()
                .uri(URI)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
