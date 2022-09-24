package tanaduus.github.io.design.reactor.java;

public class ReadEventHandler extends EventHandler {
    private Selector selector;

    public ReadEventHandler(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void handle(Event event) {
        //处理READ的event事件
        if (event.getType() == EventType.READ) {

            System.out.println("读"+event.getBuffer());

        }
    }
}