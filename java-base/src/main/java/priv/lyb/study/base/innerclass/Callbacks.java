package priv.lyb.study.base.innerclass;

import sun.applet.Main;

/**
 * @author LiuYingBo 2021/01/21 17:28
 */

interface Incrementtable {
    void increment();
}

class Callee1 implements Incrementtable {
    private int i = 0;

    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}

class MyIncrement {
    static void f(MyIncrement mi) {
        mi.increment();
    }

    public void increment() {
        System.out.println("other operation");
    }
}

class Callee2 extends MyIncrement {
    private int i = 0;

    @Override
    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }

    private class Closure implements Incrementtable {
        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }

    Incrementtable getCallbackReference(){
        return new Closure();
    }
}

class Caller{
    private Incrementtable incrementtable;
    Caller(Incrementtable incrementtable){
        this.incrementtable = incrementtable;
    }
    void go(){
        incrementtable.increment();
    }
}

public class Callbacks {
    public static void main(String[] args) {
        Callee1 callee1 = new Callee1();
        Callee2 callee2 = new Callee2();
        MyIncrement.f(callee2);
        Caller c1 = new Caller(callee2.getCallbackReference());
        Caller c2 = new Caller(callee1);
        c1.go();
        c1.go();
        c2.go();
        c2.go();

    }
}
