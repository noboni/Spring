package hello;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String os;
    private String mac;
    private String deviceToken;
    private Date createdAt;
    private Date updatedAt;
    @Version
    private int version;
    @PrePersist
    protected void createdOn(){
        createdAt=new Date();
    }
    @PreUpdate
    protected void updatedOn(){
        updatedAt=new Date();
    }
}
