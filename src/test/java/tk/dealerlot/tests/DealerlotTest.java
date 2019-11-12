package tk.dealerlot.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tk.dealerlot.common.TestBase;
import tk.dealerlot.pages.AddCarPage;
import tk.dealerlot.pages.EditCarPage;
import tk.dealerlot.pages.HomePage;
import tk.dealerlot.utils.DbUtil;

public class DealerlotTest extends TestBase {

    @Test
    public void verifyNumberOfCarsOnPageMatchNumberOfCarsInDatabase() {
        HomePage homePage = new HomePage();
        homePage.goToPage();
        int numberOfCarsOnPage = homePage.getNumberOfCarsOnPage();
        System.out.println("There are "+ numberOfCarsOnPage +" cars on HomePage");
        int numberOfCarsInDb = DbUtil.getNumbersOfCarsFromDb();
        System.out.println("There are "+ numberOfCarsInDb + " cars in DataBase");
        Assert.assertEquals(numberOfCarsInDb,numberOfCarsOnPage);
    }

    @Test
    public void verifyAddingCarCreatesRowForNewCarInDatabase() {
        AddCarPage addCarPage = new AddCarPage();
        addCarPage.goToPage();
        addCarPage.enterYear(1976);
        addCarPage.selectMake("Audi");
        addCarPage.enterModel("Beetle");
        addCarPage.enterColor("blue");
        addCarPage.enterImage("image");
        addCarPage.clickAddCarButton();
        boolean result = DbUtil.doesStockExistInDb(777);
        Assert.assertTrue(result);
    }

    @Test
    public void verifyDeletingACarRemovesCarFromDatabase() {
        HomePage homePage = new HomePage();
        homePage.goToPage();
        homePage.deleteCar(777);
        boolean result = DbUtil.doesStockExistInDb(777);
        Assert.assertFalse(result);
    }

    @Test
    public void verifyEditingCar() {
        EditCarPage editCarPage = new EditCarPage();
        editCarPage.goToPage(18);
        String newModelName = "Tundra";
        editCarPage.enterModel(newModelName);
        editCarPage.clickUpdateCarButton();
        String modelNameInDb = DbUtil.getModelNameForCar(18);
        Assert.assertEquals(modelNameInDb, newModelName);
    }
}
