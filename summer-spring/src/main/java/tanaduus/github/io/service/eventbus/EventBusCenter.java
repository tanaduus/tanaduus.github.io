package tanaduus.github.io.service.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import tanaduus.github.io.annotation.EventBusListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

@Component
public class EventBusCenter implements ApplicationContextAware {

    /**
     * 管理同步事件
     */
    private EventBus syncEventBus = new EventBus();

    /**
     * 管理异步事件
     */
    private AsyncEventBus asyncEventBus = new AsyncEventBus(Executors.newCachedThreadPool());

    public void postSync(Object event) {
        syncEventBus.post(event);
    }

    public void postAsync(Object event) {
        asyncEventBus.post(event);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 获取所有带有 @EventBusListener 的 bean，将他们注册为监听者
        List<Object> listeners = new ArrayList<>(applicationContext.getBeansWithAnnotation(EventBusListener.class).values());
        for (Object listener : listeners) {
            asyncEventBus.register(listener);
            syncEventBus.register(listener);
        }
    }
}
