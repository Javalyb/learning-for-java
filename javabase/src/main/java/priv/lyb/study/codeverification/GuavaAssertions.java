package priv.lyb.study.codeverification;

import com.google.common.base.VerifyException;
import static com.google.common.base.Verify.verify;
import static com.google.common.base.Verify.verifyNotNull;

/**
 * @author LiuYingBo 2021/01/25 02:38
 */
public class GuavaAssertions {
    public static void main(String[] args) {
        verify(2+2==4);
        try {
            verify(2-2==5);
        } catch (VerifyException e) {
            System.out.println(e);
        }

        try {
            verify(1+2==4,"Bad math");
        }catch (VerifyException e){
            System.out.println(e);
        }

        try {
            verify(1+2==4,"Bad math","not 4");
        }catch (VerifyException e){
            System.out.println(e);
        }

        String s = "";
        s = verifyNotNull(s);
        s = null;
        try {
            verifyNotNull(s);
        }catch (VerifyException e){
            System.out.println(e);
        }

        try {
            verifyNotNull(s,"Should't be null: ","arg s");
        }catch (VerifyException e){
            System.out.println(e);
        }
    }
}
