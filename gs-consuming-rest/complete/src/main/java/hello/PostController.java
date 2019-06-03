package hello;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/v1")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostController {
    @Autowired
    RestTemplate restTemplate;
    @PostMapping(path = "/post")
    public Post greeting(@RequestBody Post post) {
        String url ="https://jsonplaceholder.typicode.com/posts";
        Date date = new Date();
        long startTime=date.getTime();
        post = restTemplate.postForEntity(url,post, Post.class).getBody();
        Date date2 = new Date();
        long endTime=date2.getTime();
        post.setRequestTimeInMillis(startTime);
        post.setResponseTimeInMillis(endTime);
        post.setTimeTaken(endTime-startTime);
        return post;
    }
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return new RestTemplate();
    }

}
