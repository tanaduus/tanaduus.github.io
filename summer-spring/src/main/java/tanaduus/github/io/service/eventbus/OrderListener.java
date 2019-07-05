package tanaduus.github.io.service.eventbus;

import com.google.common.eventbus.Subscribe;
import org.springframework.stereotype.Component;
import tanaduus.github.io.annotation.EventBusListener;

@Component
@EventBusListener
public class OrderListener {

    @Subscribe
    public void create(OrderCreateEvent event){
        System.out.println("创建");
    }


    @Subscribe
    public void change(OrderChangeEvent event){
        System.out.println("修改");
    }
}
