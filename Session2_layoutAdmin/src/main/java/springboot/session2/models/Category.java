package springboot.session2.models;

public class Category {
    private int idc;
    private String name_c;
    private int active;

    public static String IDC = "idc";
    public static String NAME_C = "name_c";
    public static String ACTIVE = "active";

    public Category(int idc, String name_c, int active) {
        super(); // super để làm gì
        this.idc = idc;
        this.name_c = name_c;
        this.active = active;
    }

    public Category() {
        super(); // super để làm khỉ gì
        this.idc = 0;
        name_c =""; // đâu cần ghi this làm gì, làm màu hả.
        active = 0;
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public String getName_c() {
        return name_c;
    }

    public void setName_c(String name_c) {
        this.name_c = name_c;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public static String getIDC() {
        return IDC;
    }

    public static void setIDC(String IDC) {
        Category.IDC = IDC;
    }

    public static String getNameC() {
        return NAME_C;
    }

    public static void setNameC(String nameC) {
        NAME_C = nameC;
    }

    public static String getACTIVE() {
        return ACTIVE;
    }

    public static void setACTIVE(String ACTIVE) {
        Category.ACTIVE = ACTIVE;
    }
}
