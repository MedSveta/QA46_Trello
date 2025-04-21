package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyBoardPage;

import java.lang.reflect.Method;

import static utils.RandomUtils.*;

public class BoardsTests extends AppManager {
    @BeforeMethod(alwaysRun = true)
    public void login(Method method){
        User user = User.builder()
                .email("sveta1978medved@gmail.com")
                .password("Medqwerty12345!")
                .build();
        logger.info("start method --> "+method.getName()+" with data "+user);
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
    }
    @Test(groups = {"smoke"})
    public void createNewBoardPositiveTest(){
        Board board = Board.builder()
                .boardTitle(generateString(7))
                .build();
        new BoardsPage(getDriver()).createNewBoard(board);
        Assert.assertTrue(new MyBoardPage(getDriver()).validateBoardName(board
                .getBoardTitle(), 5));
    }
    @Test
    public void createNewBoardNegativeTest(){
        Board board = Board.builder()
                .boardTitle("")
                .build();
        new BoardsPage(getDriver()).createNewBoardNegative(board);
        Assert.assertTrue(new BoardsPage(getDriver()).buttonCreateIsNotClickable());
    }
}
