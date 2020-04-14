import org.testng.annotations.Test;

public class SecondTest {
    @Test (groups = "print", description = "test login") //description là diễn giải cho nội dung của testcase
    public void TC01_TestNG() {
        System.out.println("Hanhsuki");

    }
}
