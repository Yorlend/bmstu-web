package ru.bmstu.icsnetwork.presentation.requests;

import lombok.Value;

@Value
public class PostApiRequest {
    String title;
    String text;
}
