package priv.lyb.study.annotation.ohjava.annotations.database;

/**
 * @author LiuYingBo 2021/01/15 15:58
 */
@DBTable(name = "MEMBER")
public class Member {
    @SQLString(id = 30)
    String firstName;

    @SQLString(id = 50)
    String lastName;

    @SQLInteger()
    Integer age;

    @SQLString(id = 30,constraints = @Constraints(unique = true))
    String reference;

    static int memberCount;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getReference() {
        return reference;
    }

    @Override
    public String toString() {
        return reference;
    }

}
