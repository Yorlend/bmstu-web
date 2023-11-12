package ru.bmstu.icsnetwork.presentation.controllers.post;

import java.util.concurrent.CompletableFuture;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.bmstu.icsnetwork.presentation.requests.PatchPostApiRequest;
import ru.bmstu.icsnetwork.presentation.requests.PostApiRequest;
import ru.bmstu.icsnetwork.presentation.requests.PostCommentApiRequest;
import ru.bmstu.icsnetwork.presentation.responses.CommentApiResponse;
import ru.bmstu.icsnetwork.presentation.responses.GetAllCommentsApiResponse;
import ru.bmstu.icsnetwork.presentation.responses.GetAllPostsApiResponse;
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

    @GetMapping
    CompletableFuture<GetAllPostsApiResponse> getAllPosts();

    @GetMapping("/{id}")
    CompletableFuture<ResponseEntity<PostApiResponse>> getPost(@PathVariable("id") long id);

    @PatchMapping("/{id}")
    CompletableFuture<PostApiResponse> updatePost(
        @PathVariable("id") long id,
        @Valid @RequestBody PatchPostApiRequest request
    );

    @PostMapping("/{id}/comments")
    CompletableFuture<ResponseEntity<CommentApiResponse>> addComment(
        @CurrentUser UserPrincipal user,
        @PathVariable("id") long postId,
        @Valid @RequestBody PostCommentApiRequest request
    );

    @GetMapping("/{id}/comments")
    CompletableFuture<GetAllCommentsApiResponse> getAllComments(
        @PathVariable("id") long postId
    );
}
