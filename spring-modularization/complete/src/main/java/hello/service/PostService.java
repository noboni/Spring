package hello.service;

import hello.entity.Post;
import hello.gateway.PostGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class PostService {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    PostGateway postGateway;
    public Post post(Post post){

        Date date = new Date();
        long startTime=date.getTime();
        post = postGateway.post(post);
        Date date2 = new Date();
        long endTime=date2.getTime();
        post.setRequestTimeInMillis(startTime);
        post.setResponseTimeInMillis(endTime);
        post.setTimeTaken(endTime-startTime);
        return post;
    }
}