package tanaduus.github.io.pool;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class TestPool2 {

    public static void main(String[] args) {
        GenericObjectPoolConfig<Bicycle> poolConfig = new GenericObjectPoolConfig<>();
//        poolConfig.setMaxTotal();
//        poolConfig.setMaxIdle();
//        poolConfig.setMinIdle();
//        poolConfig.setLifo();
//        poolConfig.setFairness();
//        poolConfig.setMaxWaitMillis();
//        poolConfig.setMinEvictableIdleTimeMillis();
//        poolConfig.setSoftMinEvictableIdleTimeMillis();
//        poolConfig.setNumTestsPerEvictionRun();
//        poolConfig.setEvictorShutdownTimeoutMillis();
//        poolConfig.setTestOnCreate();
//        poolConfig.setTestOnBorrow();
//        poolConfig.setTestOnReturn();
//        poolConfig.setTestWhileIdle();
//        poolConfig.setTimeBetweenEvictionRunsMillis();
//        poolConfig.setEvictionPolicy();
//        poolConfig.setEvictionPolicyClassName();
//        poolConfig.setBlockWhenExhausted();
//        poolConfig.setJmxEnabled();
//        poolConfig.setJmxNameBase();
//        poolConfig.setJmxNamePrefix();
        poolConfig.setMaxTotal(1);

        BicycleFactory factory = new BicycleFactory();

        //对象池的创建依赖于config和factory。前者负责设置池的属性，后者池的元素工厂。
        //config可以不传，会使用默认的GenericObjectPoolConfig<T>
        GenericObjectPool<Bicycle> pool = new GenericObjectPool<>(factory, poolConfig);
//        pool.setMaxIdle();
//        pool.setMinIdle();
//        pool.setConfig();
//        pool.setAbandonedConfig();
//        pool.setMaxTotal();
//        pool.setBlockWhenExhausted();
//        pool.setMaxWaitMillis();
//        pool.setLifo();
//        pool.setTestOnCreate();
//        pool.setTestOnBorrow();
//        pool.setTestOnReturn();
//        pool.setTestWhileIdle();
//        pool.setTimeBetweenEvictionRunsMillis();
//        pool.setNumTestsPerEvictionRun();
//        pool.setMinEvictableIdleTimeMillis();
//        pool.setSoftMinEvictableIdleTimeMillis();
//        pool.setEvictionPolicy();
//        pool.setEvictionPolicyClassName();
//        pool.setEvictionPolicyClassName();
//        pool.setEvictorShutdownTimeoutMillis();
//        pool.setSwallowedExceptionListener();


        try {

            Bicycle bicycle = pool.borrowObject(3000);
            //Bicycle bicycle2 = pool.borrowObject(3000);

            System.out.println(bicycle.toString());

            pool.invalidateObject(bicycle);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
