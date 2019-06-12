package hello.api;

import hello.entity.Video;
import hello.model.VideoRequestModel;
import hello.model.VideoResponseModel;
import hello.ResourceNotFoundException;
import hello.service.VideoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/api")
public class VideoController {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    VideoService videoService;
    @GetMapping(path="/videos")
    public Iterable<VideoResponseModel> getAllVideos() {
        return videoService.getAll().stream().map(video -> modelMapper.map(video, VideoResponseModel.class)).collect(Collectors.toList());

    }
    @PostMapping(path="/video")
    public VideoResponseModel addVideo(@RequestBody VideoRequestModel videoRequestModel){
        Video video=modelMapper.map(videoRequestModel,Video.class);
        return modelMapper.map(videoService.save(video),VideoResponseModel.class);
    }
    @GetMapping(path = "/video/{id}")
    public VideoResponseModel getById(@PathVariable Long id) {
        return modelMapper.map(videoService.get(id).get(),VideoResponseModel.class);
    }
    @PutMapping(path="/video/{id}")
    public VideoResponseModel updateVideo(@PathVariable Long id, @RequestBody VideoRequestModel videoRequestModel) throws ResourceNotFoundException {
        Video video=modelMapper.map(videoRequestModel,Video.class);
        return modelMapper.map(videoService.updateVideo(id,video),VideoResponseModel.class);

    }
    @DeleteMapping(path="/video/{id}")
    public void deleteVideo(@PathVariable Long id) throws ResourceNotFoundException {
        videoService.delete(id);
    }
}
