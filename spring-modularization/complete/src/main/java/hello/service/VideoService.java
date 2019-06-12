package hello.service;

import hello.ResourceNotFoundException;
import hello.dao.DeviceDao;
import hello.dao.VideoDao;
import hello.entity.Device;
import hello.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {
    @Autowired
    VideoDao videoDao;
    @Autowired
    UserService userService;

    public Optional<Video> get(Long id) {
        return videoDao.get(id);
    }

    public List<Video> getAll() {
        return videoDao.getAll();
    }
    public Video save(Video video) {
        video.setUser(userService.save(video.getUser()));
        return videoDao.save(video);
    }
    public void delete(Long id) throws ResourceNotFoundException {
        Video video=videoDao.get(id).orElseThrow(()->new ResourceNotFoundException("Video not found for this id :: " + id));
        videoDao.delete(video);
    }
    public Video updateVideo(Long id,Video video) throws ResourceNotFoundException {
        Video existingVideo=videoDao.get(id).orElseThrow(()->new ResourceNotFoundException("Video not found for this id :: " + id));
        existingVideo.setFilename(video.getFilename());
        existingVideo.setUser(userService.save(video.getUser()));
        return videoDao.save(existingVideo);

    }
}
