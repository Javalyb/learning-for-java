package priv.lyb;

/**
 * @Author: apollo
 * @Description:
 * @Date: 23:04 2021/03/20
 */
public class Entity {
    private String ladingNo;
    private String caseNo;

    public String getLadingNo() {
        return ladingNo;
    }

    public void setLadingNo(String ladingNo) {
        this.ladingNo = ladingNo;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    private String orderNo;
}
