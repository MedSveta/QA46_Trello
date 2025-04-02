package pages;

import dto.Board;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BoardsPage extends BasePage {
    public BoardsPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory
                (driver, 10), this);
    }

    @FindBy(xpath = "//li[@data-testid='create-board-tile']")
    WebElement btnCreateNewBoard;

    public boolean validateUrl() {
        return new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.urlContains("boards"));
    }

    public void createNewBoard(Board board) {
        clickWait(btnCreateNewBoard, 3);
    }
}
