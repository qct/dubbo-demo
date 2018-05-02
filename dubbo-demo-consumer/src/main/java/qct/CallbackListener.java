package qct;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * default description.
 *
 * @author Damon.Q
 * @date 2018/1/29
 * @since 1.0
 */
@Service
public class CallbackListener {

    public void onInvoke() {
        System.out.println("I'm onInvoke");
    }

    public void onResult(Object res, Object... args) {
        System.out.println("I'm onResult");
    }
}
