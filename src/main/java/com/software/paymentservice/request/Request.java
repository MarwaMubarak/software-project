package com.software.paymentservice.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class Request<T> {
    private T value;

    public Request(T value) {
        this.value = value;
    }
    public Request(){}

    public T getValue() {
        return value;
    }
}
