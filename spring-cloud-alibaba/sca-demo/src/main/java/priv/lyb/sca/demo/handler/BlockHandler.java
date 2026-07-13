package priv.lyb.sca.demo.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class BlockHandler {

    public static String handleBlock(BlockException ex) {
        return "Sentinel blocked! " + ex.getClass().getSimpleName();
    }

    public static String handleFallback(Throwable t) {
        return "Fallback! " + t.getClass().getSimpleName();
    }
}
