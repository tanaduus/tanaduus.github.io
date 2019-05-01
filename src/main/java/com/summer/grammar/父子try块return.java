package com.summer.grammar;

public class 父子try块return {

    static class Father {
        int value;

        Father(int v) {
            setValue(v);
        }

        public void setValue(int value) {
            this.value = value;
        }

        int getValue() {
            try {
                value++;
                return value;
            } catch (Exception e) {
                System.out.println(e.toString());
            } finally {
                this.setValue(value);
                System.out.println(value);
            }
            return value;
        }
    }

    static class Child extends Father {
        Child() {
            super(5);
            setValue(getValue() - 3);
        }

        @Override
        public void setValue(int value) {
            super.setValue(2 * value);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Child().getValue());
    }
}
