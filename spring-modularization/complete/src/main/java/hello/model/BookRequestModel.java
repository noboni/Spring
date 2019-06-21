package hello.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookRequestModel implements Serializable {
    private String name;
    private String author;
    private double price;
}
