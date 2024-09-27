package com.springuserapi.model;

import lombok.Data;

@Data
public class PalindromeResponse {
    private int lengthCadena;
    private boolean isPalindromo;
    private int lengthCaracteresEspeciales;
}