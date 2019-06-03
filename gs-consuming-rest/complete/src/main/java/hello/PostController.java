package hello;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    @GetMapping("/post/{id}")
    public Post greeting(@PathVariable String id) {
        String url = String.format("https://jsonplaceholder.typicode.com/posts/%s", id);
        Date date = new Date();
        long startTime=date.getTime();
        Post post = restTemplate.getForObject(url, Post.class);
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
