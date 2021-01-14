package priv.lyb.study.genericity.thinkingjavafour.exercise.fruit;

/**
 * @author LiuYingBo 2021/01/14 23:09
 */
public class GenericHolder<T> {
    private T obj;

    public GenericHolder(){}

    public GenericHolder(T obj){
        this.obj =  obj;
    }

    public T getObj(){
        return obj;
    }

    public void setObj(T obj){
        this.obj = obj;
    }
}
