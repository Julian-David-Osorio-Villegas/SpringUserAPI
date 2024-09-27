package com.springuserapi.controller;

import com.springuserapi.model.PalindromeRequest;
import com.springuserapi.model.PalindromeResponse;
import com.springuserapi.service.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/palindrome")
public class PalindromeController {

    @Autowired
    private PalindromeService palindromeService;

    @PostMapping
    public PalindromeResponse checkPalindrome(@RequestBody PalindromeRequest request) {
        return palindromeService.processPalindrome(request);
    }
}
