package tanaduus.github.io.disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 夏加龙
 * @date 2022/9/27
 */
@Slf4j
public class OrderEventHandler implements EventHandler<OrderEvent>, WorkHandler<OrderEvent> {
    @Override
    public void onEvent(OrderEvent event, long sequence, boolean endOfBatch) {
        log.info("event: {}, sequence: {}, endOfBatch: {}", event, sequence, endOfBatch);
    }

    @Override
    public void onEvent(OrderEvent event) {
        log.info("event: {}", event);
    }
}
