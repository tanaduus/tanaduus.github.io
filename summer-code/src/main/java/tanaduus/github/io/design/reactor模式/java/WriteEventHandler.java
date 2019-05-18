package tanaduus.github.io.design.reactor模式.java;

/**
 * write事件处理器
 */
public class WriteEventHandler extends EventHandler {
    private Selector selector;

    public WriteEventHandler(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void handle(Event event) {
        //处理write的event事件
        if (event.getType() == EventType.WRITE) {

            System.out.println("写"+event.getBuffer());

        }
    }
}