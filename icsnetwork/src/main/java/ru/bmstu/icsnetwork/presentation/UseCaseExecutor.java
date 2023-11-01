package ru.bmstu.icsnetwork.presentation;

import org.springframework.stereotype.Service;
import ru.bmstu.icsnetwork.domain.usecases.IUseCaseExecutor;
import ru.bmstu.icsnetwork.domain.usecases.UseCase;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

@Service
public class UseCaseExecutor implements IUseCaseExecutor {
    @Override
    public <RX, I extends UseCase.Input, O extends UseCase.Output> CompletableFuture<RX> execute(
            UseCase<I, O> useCase, I input, Function<O, RX> outputMapper) {
        return CompletableFuture
                .supplyAsync(() -> input)
                .thenApplyAsync(useCase::execute)
                .thenApplyAsync(outputMapper);
    }
}
