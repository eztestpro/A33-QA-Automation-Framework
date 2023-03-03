import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework18 extends BaseTest {
    @BeforeMethod
    @Override
    public void setUpBrowser() {
        super.setUpBrowser();
    }

    @Test(enabled = true, description = "This is a test to check if the song is playing")
    public void playSongTest()  {
        openLoginUrl();
        provideEmail("test@test.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        playSong();
        Assert.assertTrue(isSongPlaying());

    }
    public void playSong() {
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));

        playNextButton.click();
        playButton.click();

    }
    public boolean isSongPlaying() {
        WebElement soundBarPlay = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        Assert.assertTrue(soundBarPlay.isDisplayed());
        return soundBarPlay.isDisplayed();
    }
}