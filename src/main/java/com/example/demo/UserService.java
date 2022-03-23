package com.example.demo;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class UserService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String demoBaseUrl = "http://localhost:8888/api/v1/";

    private HttpHeaders httpHeaders(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return httpHeaders;
    }

    ResponseEntity<UserResponse> findById(Long id){
        return restTemplate.getForEntity(demoBaseUrl + "find/"+id, UserResponse.class);
    }

    public UserResponse saveUser(UserRequest request){
        return restTemplate.exchange(
                demoBaseUrl + "save",
                HttpMethod.POST,
                new HttpEntity<>(request, httpHeaders()),
                UserResponse.class
        ).getBody();
    }

    public UserResponse updateUser(UserRequest request){
        return restTemplate.exchange(
                demoBaseUrl + "update",
                HttpMethod.PUT,
                new HttpEntity<>(request, httpHeaders()),
                UserResponse.class
        ).getBody();
    }

    public String deleteUser(Long id){
        return restTemplate.exchange(
                demoBaseUrl + "delete/"+id,
                HttpMethod.DELETE,
                new HttpEntity<>(id, httpHeaders()),
                String.class
        ).getBody();
    }
}
