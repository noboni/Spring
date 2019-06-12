package hello.dao;

import hello.entity.Video;
import hello.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class VideoDao {
    @Autowired
    VideoRepository videoRepository;
    public Optional<Video> get(Long id) {
        return videoRepository.findById(id);
    }

    public List<Video> getAll() {
        return videoRepository.findAll();
    }
    public Video save(Video video) {
        return videoRepository.save(video);
    }
    public void delete(Video video) {
        videoRepository.delete(video);
    }
}
