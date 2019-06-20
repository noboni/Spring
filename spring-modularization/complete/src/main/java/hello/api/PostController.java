package hello.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hello.entity.Post;
import hello.model.PostRequestModel;
import hello.model.PostResponseModel;
import hello.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/v1")
@JsonIgnoreProperties(ignoreUnknown = true)
@EnableAutoConfiguration
public class PostController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    PostService postService;
    @PostMapping(path = "/post")
    public PostResponseModel greeting(@RequestBody PostRequestModel postRequestModel) {
        Post post=modelMapper.map(postRequestModel,Post.class);
        return modelMapper.map(postService.post(post),PostResponseModel.class);
    }

}
