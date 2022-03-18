package com.example.restfulservice2.hellousername;

public class HelloUsername {
    private String message;

    public HelloUsername(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloUsername{" +
                "message='" + message + '\'' +
                '}';
    }
}
