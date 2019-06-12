package hello.model;

import hello.entity.User;
import lombok.Data;

@Data
public class VideoResponseModel {
    private User user;
    private String filename;
    private int version;
}
