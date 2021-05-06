package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Show {

    private String id;
    private String title;
    private int releaseYear;
}
