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
    @FindBy(xpath = "//input[@data-testid='create-board-title-input']")
    WebElement inputBoardTitle;
    @FindBy(xpath = "//button[@data-testid='create-board-submit-button']")
    WebElement buttonCreateBoardSubmit;
    @FindBy(xpath = "//div[@class='board-tile-details is-badged']")
    WebElement firstBoard;
    @FindBy(xpath = "//span[@class='QMKgZFIlTLiEJN']")
    WebElement popUpMessageBoardDelete;
    @FindBy(xpath = "//div[@class='B1uWdim9Jd0dJ9']")
    WebElement btnAccount;
    @FindBy(xpath = "//a[@class='gJDsPins_eYkBM']//span")
    WebElement btnManageAccount;

    public void openMyAccount(){
        clickWait(btnAccount, 5);
        clickWait(btnManageAccount, 5);
    }

    public void openFirstBoard() {
        clickWait(firstBoard, 3);
    }

    public boolean validateUrl() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("boards"));
    }

    public void createNewBoard(Board board) {
        clickWait(btnCreateNewBoard, 3);
        inputBoardTitle.sendKeys(board.getBoardTitle());
        clickWait(buttonCreateBoardSubmit, 3);
    }

    public void createNewBoardNegative(Board board) {
        clickWait(btnCreateNewBoard, 3);
        inputBoardTitle.sendKeys(board.getBoardTitle());
    }

    public boolean buttonCreateIsNotClickable() {
        return new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.not(ExpectedConditions
                        .elementToBeClickable(buttonCreateBoardSubmit)));
    }
    public boolean validatePopUpMessage(String text){
        return validateTextInElementWait(popUpMessageBoardDelete, text, 5);
    }
}
