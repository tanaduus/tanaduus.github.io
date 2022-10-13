package tanaduus.github.io.timer;

/**
 * @author 夏加龙
 * @date 2022/10/07
 */
public abstract class DelayedTask implements Comparable<DelayedTask>, Runnable {

    abstract long getExecuteTime();

    @Override
    public int compareTo(DelayedTask o) {
        return this.getExecuteTime() < o.getExecuteTime() ? -1 : 1;
    }
}
