package ru.bmstu.icsnetwork.presentation.responses;

import lombok.Value;

@Value
public class ApiResponse {
    Boolean success;
    String message;
}
