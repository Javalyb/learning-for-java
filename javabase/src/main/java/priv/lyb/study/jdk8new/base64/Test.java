package priv.lyb.study.jdk8new.base64;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

/**
 * @author LiuYingBo 2021/01/11 17:49
 */
public class Test {
    @org.junit.Test
    public void fun() throws UnsupportedEncodingException {
        String base64EncoderStr = Base64.getUrlEncoder().encodeToString("https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=Java%20LocalDateTime%20parse&fenlei=256&oq=Java%2520LocalDateTime&rsv_pq=b29db08800029e64&rsv_t=7055rqFVPdV6vP4W%2FwnLou%2F8hnAx5xw4yUPkAyqH8ER3V1ECvzOW45MWtp4&rqlang=cn&rsv_dl=tb&rsv_enter=1&rsv_btype=t&inputT=1694&rsv_sug3=154&rsv_sug1=61&rsv_sug7=100&rsv_sug2=0&rsv_sug4=2532".getBytes(StandardCharsets.UTF_8));
        String base64DecodeStr = new String(Base64.getUrlDecoder().decode(base64EncoderStr),StandardCharsets.UTF_8);
        System.out.println(base64DecodeStr);

        //mime编码：用于非文本文件的二进制文件
        StringBuilder stringBuilder = new StringBuilder();
        for(String a: Arrays.asList("1","2","3")){
            stringBuilder.append(a);
        }
        String base64MimeEncodeStr = Base64.getMimeEncoder().encodeToString(stringBuilder.toString().getBytes(StandardCharsets.UTF_8));
        System.out.println(base64MimeEncodeStr);
    }
}
