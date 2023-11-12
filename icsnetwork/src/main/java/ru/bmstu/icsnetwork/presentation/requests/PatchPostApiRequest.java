package ru.bmstu.icsnetwork.presentation.requests;

import lombok.Value;

@Value
public class PatchPostApiRequest {
    String title;
    String content;
}
