package priv.lyb.study.base.rtti;

import java.util.Optional;

/**
 * @author LiuYingBo 2021/01/27 04:34
 */
class People {
    public final Optional<String> first;
    public final Optional<String> last;
    public final Optional<String> address;
    public final boolean empty;

    People(String first, String last, String address) {
        this.first = Optional.ofNullable(first);
        this.last = Optional.ofNullable(last);
        this.address = Optional.ofNullable(address);
        empty = !this.first.isPresent()
                && !this.first.isPresent()
                && !this.first.isPresent();
    }

    People(String first, String last) {
        this(first, last, null);
    }

    People(String first) {
        this(first, null, null);
    }

    People() {
        this(null, null, null);
    }

    public static void main(String[] args) {
        System.out.println(new People());

        System.out.println(new People("Smith"));

        System.out.println(new People("Bob","Smith"));
    }

    @Override
    public String toString() {
        if (empty) {
            return "<Empty>";
        }
        return (first.orElse("") + "" + last.orElse("") + address.orElse("")).trim();
    }

}
