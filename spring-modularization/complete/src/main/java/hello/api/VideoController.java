package hello.api;

import hello.ResourceNotFoundException;
import hello.entity.Video;
import hello.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api")
public class VideoController {
    @Autowired
    private VideoRepository videoRepository;
    @GetMapping(path="/videos")
    public Iterable<Video> getAllVideos() {
        return videoRepository.findAll();
    }
    @PostMapping(path="/video")
    public Video addVideo(@RequestBody Video video){
        return videoRepository.save(video);
    }
    @GetMapping(path = "/video/{id}")
    public Video getById(@PathVariable Long id) throws ResourceNotFoundException {
        return videoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Video not found for this id :: " + id));
    }
    @PutMapping(path="/video/{id}")
    public Video updateVideo(@PathVariable Long id, @RequestBody Video video) throws ResourceNotFoundException {
        Video existingVideo=videoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Video not found for this id :: " + id));
        existingVideo.setFilename(video.getFilename());
        existingVideo.setUser(video.getUser());
        return videoRepository.save(existingVideo);

    }
    @DeleteMapping(path="/video/{id}")
    public void deleteVideo(@PathVariable Long id) throws ResourceNotFoundException {
        Video video=videoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Video not found for this id :: " + id));
        videoRepository.delete(video);
    }
}
