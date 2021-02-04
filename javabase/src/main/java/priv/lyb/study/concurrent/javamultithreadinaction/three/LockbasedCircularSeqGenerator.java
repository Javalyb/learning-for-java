package priv.lyb.study.concurrent.javamultithreadinaction.three;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LiuYingBo 2021/02/04 00:08
 */
public class LockbasedCircularSeqGenerator{
    private short sequence =-1;
    private final Lock lock = new ReentrantLock();
    public short nextSequence(){
        lock.lock();
        try {
            if(sequence>=999){
                sequence = 0;
            }else{
                sequence++;
            }
            return  sequence;
        }finally {
            lock.unlock();
        }
    }
}
