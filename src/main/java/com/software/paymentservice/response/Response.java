package com.software.paymentservice.response;


public class Response {

    private String message;
    private Object body;

    Response() {
    }

    public Response(String message, Object object) {
        this.message = message;
        this.body = object;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
