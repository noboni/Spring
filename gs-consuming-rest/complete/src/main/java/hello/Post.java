package hello;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {

    private Long userId;
    private Long id;
    private String title;
    private String body;
    private long requestTimeInMillis;
    private long responseTimeInMillis;
    private long timeTaken;

}
