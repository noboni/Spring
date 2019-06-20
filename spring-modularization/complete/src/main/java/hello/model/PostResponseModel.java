package hello.model;

import lombok.Data;

@Data
public class PostResponseModel {
    private Long userId;
    private Long id;
    private String title;
    private String body;
    private long requestTimeInMillis;
    private long responseTimeInMillis;
    private long timeTaken;
}
