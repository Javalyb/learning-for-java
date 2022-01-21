package priv.lyb.study.base.enumkey;

/**
 * @author LiuYingBo 2021/01/15 19:43
 */
public enum OzWitch {
    WEST("west"),
    NORTH("north"),
    EAST("east"),
    SOUTH("south");
    private String description;
    OzWitch(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }

    public static void main(String[] args) {
        System.out.println(OzWitch.WEST.getDescription());
        for (OzWitch value : OzWitch.values()) {
            System.out.println(value + " " + value.getDescription());
        }
    }
}
