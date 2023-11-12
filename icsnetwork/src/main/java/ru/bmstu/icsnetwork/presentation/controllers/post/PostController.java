package ru.bmstu.icsnetwork.presentation.controllers.post;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.bmstu.icsnetwork.domain.usecases.post.*;
import ru.bmstu.icsnetwork.presentation.UseCaseExecutor;
import ru.bmstu.icsnetwork.presentation.requests.PatchPostApiRequest;
import ru.bmstu.icsnetwork.presentation.requests.PostApiRequest;
import ru.bmstu.icsnetwork.presentation.requests.PostCommentApiRequest;
import ru.bmstu.icsnetwork.presentation.responses.CommentApiResponse;
import ru.bmstu.icsnetwork.presentation.responses.GetAllCommentsApiResponse;
import ru.bmstu.icsnetwork.presentation.responses.GetAllPostsApiResponse;
import ru.bmstu.icsnetwork.presentation.responses.PostApiResponse;
import ru.bmstu.icsnetwork.presentation.security.CurrentUser;
import ru.bmstu.icsnetwork.presentation.security.UserPrincipal;

@Service
public class PostController implements PostResource {


    private UseCaseExecutor useCaseExecutor;
    private AddPostUseCase addPostUseCase;
    private GetAllPostsUseCase getAllPostsUseCase;
    private GetPostUseCase getPostUseCase;
    private PatchPostUseCase patchPostUseCase;
    private AddCommentUseCase addCommentUseCase;
    private GetAllCommentsUseCase getAllCommentsUseCase;
    private DeleteCommentUseCase deleteCommentUseCase;

    public PostController(
        AddPostUseCase addPostUseCase,
        UseCaseExecutor useCaseExecutor,
        GetAllPostsUseCase getAllPostsUseCase,
        GetPostUseCase getPostUseCase,
        PatchPostUseCase patchPostUseCase,
        AddCommentUseCase addCommentUseCase,
        GetAllCommentsUseCase getAllCommentsUseCase,
        DeleteCommentUseCase deleteCommentUseCase) {
        this.addPostUseCase = addPostUseCase;
        this.useCaseExecutor = useCaseExecutor;
        this.getAllPostsUseCase = getAllPostsUseCase;
        this.getPostUseCase = getPostUseCase;
        this.patchPostUseCase = patchPostUseCase;
        this.addCommentUseCase = addCommentUseCase;
        this.getAllCommentsUseCase = getAllCommentsUseCase;
        this.deleteCommentUseCase = deleteCommentUseCase;
    }

    @Override
    public CompletableFuture<ResponseEntity<PostApiResponse>> addPost(
        @CurrentUser UserPrincipal user,    
        @RequestBody PostApiRequest request) {

        return useCaseExecutor.execute(
                addPostUseCase,
                AddPostInputMapper.map(request, user),
                (output) -> AddPostOutputMapper.map(output.getPost())
        );
    }

    @Override
    public CompletableFuture<GetAllPostsApiResponse> getAllPosts() {
        return useCaseExecutor.execute(
                getAllPostsUseCase,
                new GetAllPostsUseCase.Input(),
                (output -> GetAllPostsApiResponse.from(output.getPosts()))
        );
    }

    @Override
    public CompletableFuture<ResponseEntity<PostApiResponse>> getPost(long id) {
        return useCaseExecutor.execute(
                getPostUseCase,
                new GetPostUseCase.Input(id),
                (output) -> GetPostOutputMapper.map(output.getPost())
        );
    }

    @Override
    public CompletableFuture<PostApiResponse> updatePost(long id, PatchPostApiRequest request) {
        return useCaseExecutor.execute(
                patchPostUseCase,
                new PatchPostUseCase.Input(id, request.getTitle(), request.getContent()),
                (output) -> PostApiResponse.from(output.getPost())
        );
    }

    @Override
    public CompletableFuture<ResponseEntity<CommentApiResponse>> addComment(UserPrincipal user, long postId, PostCommentApiRequest request) {
        return useCaseExecutor.execute(
                addCommentUseCase,
                AddCommentInputMapper.map(postId, request, user),
                (output -> AddCommentOutputMapper.map(output.getComment()))
        );
    }

    @Override
    public CompletableFuture<GetAllCommentsApiResponse> getAllComments(long postId) {
        return useCaseExecutor.execute(
                getAllCommentsUseCase,
                new GetAllCommentsUseCase.Input(postId),
                (output -> GetAllCommentsApiResponse.from(output.getComments()))
        );
    }

    @Override
    public CompletableFuture<ResponseEntity<Void>> deleteComment(UserPrincipal user, long commentId) {
        return useCaseExecutor.execute(
                deleteCommentUseCase,
                new DeleteCommentUseCase.Input(user.getId(), commentId),
                (output) -> ResponseEntity.noContent().build()
        );
    }
}
