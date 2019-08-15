import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page {

    private WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    private By inputMonth = By.name("monat");
    private By inputDay = By.name("tag");
    private By inputYear = By.name("jahr");
    private By button = By.xpath("/html/body/main/div[2]/form/input[4]");



    public void setInputMonth(String dataMonth) {
        driver.findElement(inputMonth).sendKeys(dataMonth);

    }

    public void setInputDay(String dataDay) {
        driver.findElement(inputDay).sendKeys(dataDay);
    }

    public void setInputYear(String dataYear) {
        driver.findElement(inputYear).sendKeys(dataYear);
    }

    public void clickButton() {
        driver.findElement(button).click();
    }

    public String getResult() {
        String resultTmp = driver.findElement(By.xpath("/html/body/main/h4")).getText();
        return resultTmp.replaceAll("[\\d\\.\\/]", "").trim();

    }
    public String getResultFromOverflowingMonth(){
        String result = driver.findElement(By.xpath("/html/body/main/h3/div")).getText();
        return result.trim();
    }

    public String getTypeOfMonth() {
        return driver.findElement(By.xpath("/html/body/main/div[2]/form/input[1]")).getAttribute("type");

    }

    public String getTypeOfDay() {
        return driver.findElement(By.xpath("/html/body/main/div[2]/form/input[2]")).getAttribute("type");

    }

    public String getTypeOfYear() {
        return driver.findElement(By.xpath("/html/body/main/div[2]/form/input[3]")).getAttribute("type");

    }

    public int getMinOfMonth(){
        return Integer.parseInt(driver.findElement(By.xpath("/html/body/main/div[2]/form/input[1]")).getAttribute("min"));
    }
    public int getMinOfDay(){
        return Integer.parseInt(driver.findElement(By.xpath("/html/body/main/div[2]/form/input[2]")).getAttribute("min"));
    }
    public int getMinOfYear(){
        return Integer.parseInt(driver.findElement(By.xpath("/html/body/main/div[2]/form/input[3]")).getAttribute("min"));
    }


    public int getMaxOfMonth(){
        return Integer.parseInt(driver.findElement(By.xpath("/html/body/main/div[2]/form/input[1]")).getAttribute("max"));
    }
    public int getMaxOfDay(){
        return Integer.parseInt(driver.findElement(By.xpath("/html/body/main/div[2]/form/input[2]")).getAttribute("max"));
    }
    public int getMaxOfYear(){
        return Integer.parseInt(driver.findElement(By.xpath("/html/body/main/div[2]/form/input[3]")).getAttribute("max"));
    }

}

