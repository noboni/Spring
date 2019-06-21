package hello.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;
import java.io.Serializable;

@Document
@Data
public class Book implements Serializable {
    @Id
    private ObjectId _id;
    private String name;
    private String author;
    private double price;
}
