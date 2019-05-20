package tanaduus.github.io.config;

import tanaduus.github.io.service.factorybean.Car;

public class FactoryBeanImpl implements org.springframework.beans.factory.FactoryBean<Car> {

    @Override
    public Car getObject() throws Exception {
        return new Car();
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
