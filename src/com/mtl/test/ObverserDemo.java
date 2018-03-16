package com.mtl.test;

import java.util.HashSet;
import java.util.Set;

/**
 * 观察者模式案例
 */
public class ObverserDemo {
    public static void main(String[] args) {
        Obverser obverser1 = new Obverser1();
        Obverser obverser2 = new Obverser2();
        SubProject pj = new MySubProject();
        pj.addObverser(obverser1);
        pj.addObverser(obverser2);
        pj.operation();
    }
}

/**
 * 观察者接口
 */
interface Obverser{
    public void update();
}

/**
 * 观察者类1
 */
class Obverser1 implements Obverser{
    @Override
    public void update() {
        System.out.println("Obverser1更新了");
    }
}
/**
 * 观察者类1
 */
class Obverser2 implements Obverser{
    @Override
    public void update() {
        System.out.println("Obverser2更新了");
    }
}

/**
 * 被观察者接口
 */
interface SubProject{
    public void addObverser(Obverser obverser);

    public void removeObverser(Obverser obverser);

    public void notifyObversers();

    public void operation();
}
/**
 * 被观察者抽象类
 */
abstract  class AbstractProject implements SubProject{
    private Set<Obverser> set; //维护观察者的实例集合

    public AbstractProject() {
        super();
        this.set = new HashSet<Obverser>();
    }

    @Override
    public void addObverser(Obverser obverser) {
        this.set.add(obverser);
    }

    @Override
    public void removeObverser(Obverser obverser) {
        this.set.remove(obverser);
    }

    /**
     * 通知集合里的所有观察者执行update操作
     */
    @Override
    public void notifyObversers() {
        for (Obverser obverser : this.set ) {
            obverser.update();
        }
    }
}

/**
 * 被观察者实现类
 */
class MySubProject extends AbstractProject{
    @Override
    public void operation() {
        System.out.println("MySubProject更新了");
        this.notifyObversers();
    }
}


