package hello.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
@Component
public class ServiceLocator {
    @Autowired
    private DeviceServiceImpl deviceServiceImpl;
    @Autowired
    private DeviceServiceImpl2 deviceServiceImpl2;
    private Map<String,DeviceService> beans=new HashMap<String,DeviceService>();
    @PostConstruct
    public void add(){
        beans.put("1",deviceServiceImpl);
        beans.put("2",deviceServiceImpl2);
    }
    public DeviceService get(String value){
        return beans.get(value);
    }

}
