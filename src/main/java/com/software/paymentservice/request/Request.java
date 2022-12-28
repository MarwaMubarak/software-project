package com.software.paymentservice.request;

public class Request<T> {
    public T value;

    public Request(T value) {
        this.value = value;
    }
    public Request(){}
}
