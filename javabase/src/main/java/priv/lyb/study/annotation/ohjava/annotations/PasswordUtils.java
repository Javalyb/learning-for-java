package priv.lyb.study.annotation.ohjava.annotations;

import java.util.List;

/**
 * @author LiuYingBo 2021/01/15 13:34
 */
public class PasswordUtils {

    @UseCase(id = 47, description = "Passwords must contain at least one numeric")
    public boolean validatePasword(String password) {
        return password.matches("");
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49, description = "New password can't equal previously used ones")
    public boolean checkForNewPassword(List<String> prevPasswords, String passwd) {
        return !prevPasswords.contains(passwd);
    }
}
