package hello.dao;

import hello.entity.Video;

import java.util.List;
import java.util.Optional;

public interface VideoDao {
    Optional<Video> get(Long id);

    List<Video> getAll();
    Video save(Video video);
    void delete(Video video);
}
