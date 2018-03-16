package com.mtl.test;

/**
 * 模板方法模式案例
 */
public class TemplateMethodDemo {
    public static void main(String[] args) {
        AbstractContainer container = new MyContainer();
        container.start();
    }
}

/**
 * 抽象类
 */
abstract class AbstractContainer{

    public void start(){
        System.out.println("The container has start begin");
        startInterval();
        System.out.println("The container has start end");
    }

    /**
     * 模板方法，又称为钩子方法
     */
    public abstract void startInterval();
}

/**
 * 实现类，实现模板方法
 */
class MyContainer extends AbstractContainer{
    @Override
    public void startInterval() {
        System.out.println("MyContainer execute interval start method");
    }
}
