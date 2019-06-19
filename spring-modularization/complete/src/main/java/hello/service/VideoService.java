package hello.service;

import hello.ResourceNotFoundException;
import hello.entity.Video;

import java.util.List;
import java.util.Optional;

public interface VideoService {
    Optional<Video> get(Long id);

    List<Video> getAll();
    Video save(Video device);
    void delete(Long id) throws ResourceNotFoundException;
    Video updateVideo(Long id,Video device) throws ResourceNotFoundException;
}
