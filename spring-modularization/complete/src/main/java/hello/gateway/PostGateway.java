package hello.gateway;

import hello.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class PostGateway {
    @Autowired
    RestTemplate restTemplate;
    public Post post(Post post){
        String url ="https://jsonplaceholder.typicode.com/posts";
        post = restTemplate.postForEntity(url,post, Post.class).getBody();
        System.out.println(post);
        return post;
    }
}
