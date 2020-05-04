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
// nếu muốn 1 xpath cho cả 2 locator link menu trên ta dùng (String all_menu = " xpath1 | xpath2 ")
    public static final String DYNAMIC_LINK_ALL_MENU = "//nav[@class='sidebar sidebar-offcanvas']//a[text()='%s']] | //nav[@class='sidebar sidebar-offcanvas']/span //a[text()='%s']]";
    // dynamic cho Element (1 locator có thể dùng cho nhiều loại)
    public static final String DYNAMIC_TEXTBOX_BUTTON_TEXTAREA_CHECKBOX = "(//textarea)|(//input)[@name='%s']";
    public static final String DYNAMIC_DROPDOWN_LIST = "//select[@name='%s']";
    public static final String DYNAMIC_ERROR_MESSAGE = "//td[contains(text(), %s)]/following-sibling::td/lable]";
}

