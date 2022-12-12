package com.example.sum_number_by_camel;

import org.springframework.stereotype.Component;

@Component
public class TestGit {
    private Long id;
    private String name;

    public TestGit(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestGit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
