package dev.igor.webservice.domain;

import java.util.List;

public class ResponseUser {
    private List<User> data;

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseUser{" +
                "data=" + data +
                '}';
    }
}
