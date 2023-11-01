package ru.bmstu.icsnetwork.domain.usecases;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public interface IUseCaseExecutor {
    <RX, I extends UseCase.Input, O extends UseCase.Output> CompletableFuture<RX> execute(
        UseCase<I, O> useCase,
        I input,
        Function<O, RX> outputMapper
    );
}
