package com.springuserapi.service;

import org.springframework.stereotype.Service;
import com.springuserapi.model.PalindromeRequest;
import com.springuserapi.model.PalindromeResponse;

@Service
public class PalindromeService {

    public PalindromeResponse processPalindrome(PalindromeRequest request) {
        String cadena = request.getPalindromo();
        int lengthCadena = cadena.length();
        boolean isPalindromo = isPalindrome(cadena);
        int lengthCaracteresEspeciales = (int) cadena.chars().filter(ch -> !Character.isLetterOrDigit(ch)).count();

        PalindromeResponse response = new PalindromeResponse();
        response.setLengthCadena(lengthCadena);
        response.setPalindromo(isPalindromo);
        response.setLengthCaracteresEspeciales(lengthCaracteresEspeciales);
        return response;
    }

    private boolean isPalindrome(String cadena) {
        String cleaned = cadena.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }
}
