package edu.austral.dissis.chess;

import lombok.Getter;

@Getter
public class Result<T> {
    private final T value;
    private final String errorMessage;

    private Result(T value, String errorMessage) {
        this.value = value;
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return errorMessage == null;
    }

    public static <T> Result<T> success(T value) {
        return new Result<>(value, null);
    }

    public static <T> Result<T> failure(String errorMessage) {
        return new Result<>(null, errorMessage);
    }
}
