package hello.entity;

import hello.entity.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private User user;
    private String filename;
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
