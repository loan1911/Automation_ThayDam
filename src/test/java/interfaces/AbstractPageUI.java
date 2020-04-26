package interfaces;

public class AbstractPageUI {
    public static final String TIEN_MAT_NGAN_HANG="//nav[@class='sidebar sidebar-offcanvas']//span[text()='TIỀN MẶT VÀ NGÂN HÀNG']";
    public static final String PHIEU_THU="//li[@class='nav-item ng-star-inserted']//a[text()='Phiếu thu']";
    public static final String PHIEU_CHI="//nav[@class='sidebar sidebar-offcanvas']//a[text()='Phiếu chi']";
    public static final String BAO_NO="//li[@class='nav-item ng-star-inserted']//a[text()='Báo Nợ']";
    public static final String BAO_CO="//nav[@class='sidebar sidebar-offcanvas']//a[text()='Báo có']";
    public static final String KIEM_KE_QUY="//nav[@class='sidebar sidebar-offcanvas']//a[text()='Kiểm kê quỹ']";
// Chỉ cần 1 element đại diện cho tất các các xpath của các menu (đây là kỹ thuật strig format)
// Nếu có nhiều dynamic ta sẽ dùng kỹ thuật Xpath Axes để bắt, ta sẽ truyền nhiều %s
    public static final String DYNAMIC_LINK_SUB = "//nav[@class='sidebar sidebar-offcanvas']//a[text()='%s']";
    public static final String DYNAMIC_LINK = "//nav[@class='sidebar sidebar-offcanvas']//span[text()='%s']";

}

//    public static void main(String[] args) {


//        String DYNAMIC_LINK = "//nav[@class='sidebar sidebar-offcanvas']//a[text()='%s']";
//        clickToLink(DYNAMIC_LINK, "10");

//    }

//    public static void clickToLink (String locator, String value1){
//    locator = String.format(locator, value1);
//    }
//    public static void clickToLink (String locator, String value1, String value2){
//        locator = String.format(locator, value1, value2);
//    }
// Nếu các kiểu dữ liệu value có kiểu dữ liệu giống nhau ta sẽ sử dụng kỹ thuật rest- parameter (tham số cuối cùng)
//    public static void clickToLink (String locator, String... values){
//    locator = String.format(locator, (Object[]) values);
//}
