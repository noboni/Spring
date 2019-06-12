package hello.model;

import hello.entity.User;
import lombok.Data;

@Data
public class VideoRequestModel {
    private User user;
    private String filename;
}
