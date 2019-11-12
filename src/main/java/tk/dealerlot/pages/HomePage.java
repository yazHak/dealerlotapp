package tk.dealerlot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tk.dealerlot.common.Driver;
import tk.dealerlot.common.PageBase;

import java.util.List;

public class HomePage extends PageBase {

    private By stockLocator = By.id("stockNumber");

    public int getNumberOfCarsOnPage() {
        List<WebElement> stockElementList = seleniumUtil.findElements(stockLocator);
        int count = stockElementList.size();
        return count;
    }

    public void goToPage() {
        Driver.getDriver().get("http://dealerlot.tk/");
    }

    public void deleteCar(int stockNumber) {
        By deleteButton = By.cssSelector("a[href='/delete/"+stockNumber+"']");
        Driver.getDriver().findElement(deleteButton).click();
    }
}
