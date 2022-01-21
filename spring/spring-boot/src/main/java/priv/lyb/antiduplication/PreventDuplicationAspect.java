package priv.lyb.antiduplication;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Author: lyb
 * @Description:
 * @Date: 19:47 2022/01/04
 */
@Aspect
@Component
public class PreventDuplicationAspect {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 定义切点
     */
    @Pointcut("@annotation(priv.lyb.antiduplication.PreventDuplication)")
    public void preventDuplication(){

    }

    @Around("preventDuplication()")
    public Object before(ProceedingJoinPoint joinPoint) throws Exception{
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //获取执行方法
        Method method = ((MethodSignature)(joinPoint.getSignature())).getMethod();
        //获取防重复提交注解
        PreventDuplication annotation = method.getAnnotation(PreventDuplication.class);

        String token = request.getHeader(IdempotentConstant.TOKEN);
        String redisKey = IdempotentConstant.PREVENT_DUPLICATION_PREFIX
                .concat(token)
                .concat(getMethodSign(method, joinPoint.getArgs()));
        String redisValue = redisKey.concat(annotation.value()).concat("submit duplication");
        if(!redisTemplate.hasKey(redisKey)){
            redisTemplate.opsForValue()
                    .set(redisKey,redisValue,annotation.expriceSeconds(), TimeUnit.SECONDS);
            try {
                //正常执行方法并返回
                //ProceedingJoinPoint类型参数可以决定是否执行目标方法，且环绕通知必须要有返回值，返回值即为目标方法的返回值
                return joinPoint.proceed();
            }catch (Throwable throwable){
                redisTemplate.delete(redisKey);
                throw new RuntimeException(throwable);
            }
        }else{
            throw new RuntimeException("请勿重复提交");
        }

    }

    private String getMethodSign(Method method, Object... args){
        StringBuilder sb = new StringBuilder(method.getName().toString());
        for (Object arg : args) {
            sb.append(arg.toString());
        }
        //return DigestUtils.sha1Hex(sb.toString());
        return sb.toString();
    }

    private String toString(Object arg){
        if(Objects.isNull(arg)){
            return "null";
        }
        if(arg instanceof Number){
            return arg.toString();
        }
        return JSONObject.toJSONString(arg);
    }
}
