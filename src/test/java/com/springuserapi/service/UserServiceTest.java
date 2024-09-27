package com.springuserapi.service;

import com.springuserapi.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getUsers_ShouldReturnUserList_WhenApiCallIsSuccessful() {
        User[] mockUsers = new User[] {
            new User(1, "Name Example", "Username Test","Name.Test@example.com"),
            new User(2, "Name Example2", "Username Test2","Name.Test2@example.com")
        };

        when(restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", User[].class))
                .thenReturn(mockUsers);

        List<User> users = userService.getUsers();

        assertEquals(2, users.size());

        assertEquals("Name Example", users.get(0).getName());
        assertEquals("Name Example2", users.get(1).getName());

        verify(restTemplate, times(1))
                .getForObject("https://jsonplaceholder.typicode.com/users", User[].class);
    }

    @Test
    void getUsers_ShouldThrowException_WhenApiCallFails() {
        when(restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", User[].class))
                .thenThrow(new RuntimeException("Error al consumir la API externa"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> userService.getUsers());

        assertEquals("Error al consumir la API externa", exception.getMessage());

        verify(restTemplate, times(1))
                .getForObject("https://jsonplaceholder.typicode.com/users", User[].class);
    }
}
