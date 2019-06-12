package hello.entity;

import hello.entity.Device;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long age;
    @OneToOne
    @JoinColumn(name = "device_id")
    private Device device;
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
