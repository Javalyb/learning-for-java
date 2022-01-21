package priv.lyb.study.base.enumkey.enums;

/**
 * @author LiuYingBo 2021/01/16 00:51
 */
public enum SecurityCategory {
    STOCK(Security.Stock.class),
    BOND(Security.Bond.class);

    private Security [] securities;
    SecurityCategory(Class<? extends Security> t){
        securities = t.getEnumConstants();
    }

    interface Security{
        enum Stock implements Security{
            SHORT, LONG, MARGIN
        }
        enum Bond implements Security{
            MUNICIPAL, JUNK
        }
    }

    public static void main(String[] args) {
        for (Security security : SecurityCategory.STOCK.securities) {
            System.out.println(security);
        }
    }
}
