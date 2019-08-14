package tanaduus.github.io.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class BicycleFactory extends BasePooledObjectFactory<Bicycle> {

    private static int i = 0;

    @Override
    public Bicycle create() throws Exception {
        return Bicycle.builder().id(i+++"").power(2).build();
    }

    @Override
    public PooledObject<Bicycle> wrap(Bicycle obj) {
        return new DefaultPooledObject<>(obj);
    }
}
