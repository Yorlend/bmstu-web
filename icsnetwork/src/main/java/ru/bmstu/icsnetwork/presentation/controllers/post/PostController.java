package ru.bmstu.icsnetwork.presentation.controllers.post;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.bmstu.icsnetwork.domain.usecases.post.AddPostUseCase;
import ru.bmstu.icsnetwork.presentation.UseCaseExecutor;
import ru.bmstu.icsnetwork.presentation.requests.PostApiRequest;
import ru.bmstu.icsnetwork.presentation.responses.PostApiResponse;
import ru.bmstu.icsnetwork.presentation.security.CurrentUser;
import ru.bmstu.icsnetwork.presentation.security.UserPrincipal;

@Service
public class PostController implements PostResource {


    private UseCaseExecutor useCaseExecutor;
    private AddPostUseCase addPostUseCase;

    public PostController(
        AddPostUseCase addPostUseCase,
        UseCaseExecutor useCaseExecutor) {
        this.addPostUseCase = addPostUseCase;
        this.useCaseExecutor = useCaseExecutor;
    }

    @Override
    public CompletableFuture<ResponseEntity<PostApiResponse>> addPost(
        @CurrentUser UserPrincipal user,    
        @RequestBody PostApiRequest request) {

        try {
            return useCaseExecutor.execute(
                    addPostUseCase,
                    AddPostInputMapper.map(request, user),
                    (output) -> AddPostOutputMapper.map(output.getPost())
            );
        } catch (Exception e) {
            return CompletableFuture.completedFuture(ResponseEntity.internalServerError().build());
        }
    }
}
