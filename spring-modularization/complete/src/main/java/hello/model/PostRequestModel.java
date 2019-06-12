package hello.model;

import lombok.Data;

@Data
public class PostRequestModel {
    private Long userId;
    private String title;
    private String body;
}
