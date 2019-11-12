package tk.dealerlot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import tk.dealerlot.common.Driver;
import tk.dealerlot.common.PageBase;

public class AddCarPage extends PageBase {

    private By yearInput = By.id("year");
    private By makeSelect = By.id("make");
    private By modelInput = By.id("model");
    private By colorInput = By.id("color");
    private By stockInput = By.id("stock");
    private By imageInput = By.id("image");
    private By addCarButton = By.tagName("button");

    public void goToPage() {
        Driver.getDriver().get("http://dealerlot.tk/add");
    }

    public void enterYear(int year) {
        seleniumUtil.sendKeys(yearInput,year+"");
    }
    public void enterModel(String model) {
        seleniumUtil.sendKeys(modelInput,model);
    }

    public void enterColor(String color) {
        seleniumUtil.sendKeys(colorInput,color);
    }

    public void enterStock(int Stock) {
        seleniumUtil.sendKeys(stockInput,Stock+"");
    }

    public void enterImage(String image) {
        seleniumUtil.sendKeys(imageInput,image);
    }

    public void selectMake(String make) {
        WebElement selectEl = Driver.getDriver().findElement(makeSelect);
        Select makeSelect = new Select(selectEl);
        switch (make.toLowerCase()) {
            case "audi": makeSelect.selectByVisibleText("Audi"); break;
            case "BMW" : makeSelect.selectByVisibleText("BMW"); break;
            case "toyota" : makeSelect.selectByVisibleText("Toyota"); break;
            default:throw new IllegalArgumentException("Make you requested is not existing in dropdown");
        }
    }

    public void clickAddCarButton() {

    }
}
