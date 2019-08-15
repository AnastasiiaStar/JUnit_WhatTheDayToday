import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class PageTest {

    private WebDriver driver;
    private Page page;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Asya\\Downloads\\mvc-security-master\\TestSeleniumProject\\drivers\\geckodriver.exe");
        this.driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.topster.su/calendar/wochentag.php");
        this.page = new Page(driver);
    }

    //проверка корректного отображения всех дней в неделе
    @Test
    public void checkMonday() {
        page.setInputMonth("08");
        page.setInputDay("12");
        page.setInputYear("2019");
        page.clickButton();
        Assert.assertEquals("был понедельник", page.getResult());

    }

    @Test
    public void checkTuesday() {
        page.setInputMonth("08");
        page.setInputDay("13");
        page.setInputYear("2019");
        page.clickButton();
        Assert.assertEquals("был Вторник", page.getResult());
    }

    @Test
    public void checkWednesday() {
        page.setInputMonth("08");
        page.setInputDay("14");
        page.setInputYear("2019");
        page.clickButton();
        Assert.assertEquals("среду", page.getResult());
    }


    @Test
    public void checkThursday() {
        page.setInputMonth("08");
        page.setInputDay("15");
        page.setInputYear("2019");
        page.clickButton();
        Assert.assertEquals("Четверг", page.getResult());
    }

    @Test
    public void checkFriday() {
        page.setInputMonth("08");
        page.setInputDay("16");
        page.setInputYear("2019");
        page.clickButton();
        Assert.assertEquals("Пятница", page.getResult());
    }

    @Test
    public void checkSaturday() {
        page.setInputMonth("08");
        page.setInputDay("17");
        page.setInputYear("2019");
        page.clickButton();
        Assert.assertEquals("Суббота", page.getResult());
    }

    @Test
    public void checkSunday() {
        page.setInputMonth("08");
        page.setInputDay("18");
        page.setInputYear("2019");
        page.clickButton();
        Assert.assertEquals("это воскресенье", page.getResult());
    }

    @Test
    public void checkInputTextInMonth() {
        page.setInputMonth("Восьмое");
        page.setInputDay("15");
        page.setInputYear("2019");
        page.clickButton();
        Assert.assertNotEquals(page.getTypeOfMonth(), "text");

    }

    //ввод текста в поля
    @Test
    public void checkInputTextInDay() {
        page.setInputMonth("8");
        page.setInputDay("Пятнадцатое");
        page.setInputYear("2019");
        page.clickButton();
        Assert.assertNotEquals(page.getTypeOfDay(), "text");

    }

    @Test
    public void checkInputTextInYear() {
        page.setInputMonth("8");
        page.setInputDay("15");
        page.setInputYear("Две тысячи девятнадцатый");
        page.clickButton();
        Assert.assertNotEquals(page.getTypeOfYear(), "text");
    }

    //воод отрицательных чисел
    @Test
    public void checkInputNegativeNumberToMonth() {
        page.setInputMonth("-13");
        page.setInputDay("15");
        page.setInputYear("2019");
        page.clickButton();
        Assert.assertNotEquals(page.getMinOfMonth(), "1");
    }


    @Test
    public void checkInputNegativeNumberToDay() {
        page.setInputMonth("08");
        page.setInputDay("-11115");
        page.setInputYear("2019");
        page.clickButton();
        Assert.assertNotEquals(page.getMinOfDay(), "1");
    }

    @Test
    public void checkInputNegativeNumberToYear() {
        page.setInputMonth("08");
        page.setInputDay("15");
        page.setInputYear("-2019");
        page.clickButton();
        Assert.assertNotEquals(page.getMinOfDay(), "1900");
    }


    //ввод больших чисел
    @Test
    public void checkInputBigNumberToMonth() {
        page.setInputMonth("9999999913");
        page.setInputDay("15");
        page.setInputYear("2019");
        page.clickButton();
        Assert.assertNotEquals(page.getMaxOfMonth(), "12");
    }

    @Test
    public void checkInputBigNumberToDay() {
        page.setInputMonth("08");
        page.setInputDay("1513131313");
        page.setInputYear("2019");
        page.clickButton();
        Assert.assertNotEquals(page.getMaxOfDay(), "31");
    }
    @Test
    public void checkInputBigNumberToYear() {
        page.setInputMonth("08");
        page.setInputDay("15");
        page.setInputYear("201920192019");
        page.clickButton();
        Assert.assertNotEquals(page.getMaxOfYear(), "2050");
    }

    //ввод несуществующего числа в месяце

    @Test
    public void checkOverflowingMonth() {
        page.setInputMonth("06");
        page.setInputDay("31");
        page.setInputYear("2019");
        page.clickButton();
        Assert.assertEquals("Ошибка: Дата не так!", page.getResultFromOverflowingMonth());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
