package com.springuserapi.service;

import com.springuserapi.model.User;
import lombok.RequiredArgsConstructor;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor 
public class UserService {

    private final RestTemplate restTemplate;

    @Cacheable(value = "usersCache", cacheManager = "cacheManager")
    public List<User> getUsers() {
        String url = "https://jsonplaceholder.typicode.com/users";
        try {
            User[] users = restTemplate.getForObject(url, User[].class);
            return Arrays.asList(users);
        } catch (RestClientException e) {
            throw new RuntimeException("Error al consumir la API externa", e);
        }
    }
}
