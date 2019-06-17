package hello;

import hello.api.DeviceController;
import hello.api.PostController;
import hello.api.UserController;
import hello.api.VideoController;
import hello.dao.DeviceDao;
import hello.dao.UserDao;
import hello.dao.VideoDao;
import hello.entity.Device;
import hello.entity.User;
import hello.gateway.PostGateway;
import hello.repository.CustomerRepository;
import hello.repository.DeviceRepository;
import hello.repository.UserRepository;
import hello.repository.VideoRepository;
import hello.service.DeviceService;
import hello.service.PostService;
import hello.service.UserService;
import hello.service.VideoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private DeviceController deviceController;
    @Autowired
    private PostController postController;
    @Autowired
    private UserController userController;
    @Autowired
    private VideoController videoController;
    @Autowired
    private DeviceDao deviceDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private VideoDao videoDao;
    @Autowired
    private PostGateway postGateway;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @Autowired
    private VideoService videoService;


    @Test
    public void contexLoads() throws Exception {
        assertThat(deviceController).isNotNull();
        assertThat(userController).isNotNull();
        assertThat(videoController).isNotNull();
        assertThat(postController).isNotNull();
        assertThat(deviceDao).isNotNull();
        assertThat(videoDao).isNotNull();
        assertThat(userDao).isNotNull();
        assertThat(postGateway).isNotNull();
        assertThat(customerRepository).isNotNull();
        assertThat(deviceRepository).isNotNull();
        assertThat(userRepository).isNotNull();
        assertThat(videoRepository).isNotNull();
        assertThat(deviceService).isNotNull();
        assertThat(postService).isNotNull();
        assertThat(userService).isNotNull();
        assertThat(videoService).isNotNull();


    }
}