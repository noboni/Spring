package hello.model;

import lombok.Data;
import org.bson.types.ObjectId;

import java.io.Serializable;

@Data
public class BookResponseModel implements Serializable {
    private String _id;
    private String name;
    private String author;
    private double price;
}
