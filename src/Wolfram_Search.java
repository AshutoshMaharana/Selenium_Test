import java.util.concurrent.TimeUnit;
//
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wolfram_Search {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub #678E9C
		
		String url = "http://wolframalpha.com";
		By srchBoxPath = By.xpath("//input[@class = '_3mX7MD-u']");
		By equalClkPath = By.xpath("//button[@class = '_2HkkNXzH _1caL4O8E _3nvo6gir']");
		By plainTextPathDiv = By.xpath("//*[@class ='_3Pdb5d8U _3h1vjsSe']//self::div[1]");
		By plainTextPathButton = By.xpath("//*[@class ='_3Pdb5d8U _3h1vjsSe']//descendant::button[4]");
		By frstPodPath = By.xpath("//*[@class = '-ux9E2hV' and text() ='Input:']");
		By validatePodPath = By.xpath("//*[@class = 'pa ch cc1' and text() = 'Input:']");
		By compNoteBkPath = By.xpath("//*[@class = '_2HkkNXzH _25mWAnMO _3mC8nV6K']");
		By playButtonpath = By.xpath("//*[@class='ButtonBoxContainer _2Ruv5efOhTpkxbU_U8Gd6K nb-control pa ButtonBoxContainer _2Ruv5efOhTpkxbU_U8Gd6K nb-control']//self::div[1]");
		
		
		System.setProperty("webdriver.chrome.driver", "H:\\Desktop\\Selenium_Test\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		WebDriver driver = new ChromeDriver(options);
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);

		
		WebElement searchBox = driver.findElement(srchBoxPath);
		WebElement equalClk = driver.findElement(equalClkPath);
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(srchBoxPath));

		searchBox.sendKeys("2+2");
		wait.until(ExpectedConditions.visibilityOfElementLocated(equalClkPath));
		
		equalClk.click();
	
		WebElement frstPod = driver.findElement(frstPodPath);
	
		WebElement plainTextDiv = driver.findElement(plainTextPathDiv);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(frstPodPath));
		if(frstPod.getText().equalsIgnoreCase("Input:")){
			System.out.println("Validation successful");
			
			System.out.println(frstPod.getCssValue("color"));// now validate color
			action.moveToElement(plainTextDiv).build().perform();
			wait.until(ExpectedConditions.presenceOfElementLocated(plainTextPathButton));
			WebElement plainText = driver.findElement(plainTextPathButton);
			plainText.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(compNoteBkPath));
			WebElement compNoteBk = driver.findElement(compNoteBkPath);
			compNoteBk.click();
			
		}
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebElement playButton = driver.findElement(playButtonpath);
		playButton.click();
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
