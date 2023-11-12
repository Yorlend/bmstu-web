package ru.bmstu.icsnetwork.presentation.controllers.post;

import java.util.concurrent.CompletableFuture;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.bmstu.icsnetwork.presentation.requests.PostApiRequest;
import ru.bmstu.icsnetwork.presentation.responses.PostApiResponse;
import ru.bmstu.icsnetwork.presentation.security.CurrentUser;
import ru.bmstu.icsnetwork.presentation.security.UserPrincipal;

@RestController
@RequestMapping("/posts")
public interface PostResource {
    
    @PostMapping
    CompletableFuture<ResponseEntity<PostApiResponse>> addPost(
        @CurrentUser UserPrincipal user,
        @Valid @RequestBody PostApiRequest request
    );
}
