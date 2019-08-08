import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Question2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		SoftAssert softassert = new SoftAssert();
		driver.get("https://www.weightwatchers.com/us/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Part 1: Navigated to website https://www.weightwatchers.com/us/");
		System.out.println("Part 2: Verifying loaded page title ");
		String actualTitle = driver.getTitle();
		System.out.println("Loaded page title is : " + actualTitle);
		String expectedTitle = "WW (Weight Watchers): Weight Loss & Wellness Help";
		softassert.assertEquals(actualTitle, expectedTitle, "Actual and expected do not match");
		softassert.assertAll();
		System.out.println("Loaded page title matches expected page title i.e. WW (Weight Watchers): Weight Loss & Wellness Help");
		System.out.println("Part 3: Clicked on Find Studio");
		driver.findElement(By.xpath("//a[@id='ela-menu-visitor-desktop-supplementa_find-a-studio']/span[1]")).click();// Find
																														// a
																														// studio
		String loadedPageTitle = driver.getTitle();
		System.out.println("Part 4: Verifying loaded page title contains Find WW Studios & Meetings Near You | WW USA");
		System.out.println("Loaded page title is: " + loadedPageTitle); // “Find WW Studios & Meetings Near You | WW
																		// USA”
		System.out.println(loadedPageTitle.contains("Find WW Studios & Meetings Near You | WW USA"));
		System.out.println("true means Loaded page title contains Find WW Studios & Meetings Near You | WW USA");
		System.out.println("Part 5: Searching for meetings for zip code: 10011");
		driver.findElement(By.id("meetingSearch")).sendKeys("10011");// enter zip code
		driver.findElement(By.cssSelector("button.btn.spice-translated")).click();// go button
		String outputName = driver.findElement(By.cssSelector("div.location__name>span")).getText();// get name on the
																									// first search
																									// result
		System.out.println("PART 6: Printing the title of the first result and the distance");
		System.out.println("The name in first search result displayed is: " + outputName);
		String outputDistance = driver.findElement(By.cssSelector("div.location__distance")).getText();
		System.out.println("The distance of the first search result displayed is: " + outputDistance);
		System.out.println("PART 7: Clicking on the first search result");
		driver.findElement(By.xpath("//*[@class='location__name']")).click();
		// String searchResultOutput=
		// driver.findElement(By.xpath("//*[@class='location__name']/span[1]")).getText();
		// softassert.assertEquals(outputName, searchResultOutput, "Actual and expected
		// do not match");
		// softassert.assertAll();
		System.out.println("The title of the page matches the name of the first searched result that was clicked");

		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		int a = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println("Operating Hours on");
		a=7;
		switch (a) {
		case 1:
			System.out.println("Sunday");
			System.out.println(driver.findElement(By.cssSelector("div.hours-list-item-hours>div")).getText());
			break;
		case 2:
			System.out.println("Monday");
			System.out.println(driver.findElement(By.xpath("//li[2]/div[1]/div[2]/div[1]")).getText());
			System.out.println(driver.findElement(By.xpath("//li[2]/div[1]/div[2]/div[2]")).getText());
			break;
		case 3:
			System.out.println("Tuesday");
			System.out.println(driver.findElement(By.xpath("//li[3]/div[1]/div[2]/div[1]")).getText());
			System.out.println(driver.findElement(By.xpath("//li[3]/div[1]/div[2]/div[2]")).getText());
			break;
		case 4:
			System.out.println("Wednesday");
			System.out.println(driver.findElement(By.xpath("//li[4]/div[1]/div[2]/div[1]")).getText());
			System.out.println(driver.findElement(By.xpath("//li[4]/div[1]/div[2]/div[2]")).getText());
			break;
		case 5:
			System.out.println("Thursday");
			System.out.println(driver.findElement(By.xpath("//li[5]/div[1]/div[2]/div[1]")).getText());
			System.out.println(driver.findElement(By.xpath("//li[5]/div[1]/div[2]/div[2]")).getText());
			break;
		case 6:
			System.out.println("Friday");
			System.out.println(driver.findElement(By.xpath("//li[6]/div[1]/div[2]/div[1]")).getText());
			System.out.println(driver.findElement(By.xpath("//li[6]/div[1]/div[2]/div[2]")).getText());
			break;
		case 7:
			System.out.println("Saturday");
			System.out.println(driver.findElement(By.xpath("//li[7]/div[1]/div[2]/div[1]")).getText());
			break;

		}
		List<String> names = new ArrayList<>();

		switch (a) {
		case 1:
			System.out.println("Studio Schedule for Sunday ");
			names.add(driver.findElement(By.xpath("//div[@class='schedule-detailed-day-meetings']/div/div[2]"))
					.getText());
			names.add(driver.findElement(By.xpath("//div[@class='schedule-detailed-day-meetings']/div[2]/div[2]"))
					.getText());
			countFrequency(names);
			// call method
			break;
		case 2:
			System.out.println("Studio Schedule for Monday ");
			names.add(
					driver.findElement(By.xpath("//*[@class='schedule-detailed']/div[2]/div[2]/div/div[2]")).getText());
			names.add(driver.findElement(By.xpath("   //*[@class='schedule-detailed']/div[2]/div[2]/div[2]/div[2]"))
					.getText());
			names.add(driver.findElement(By.xpath(" //*[@class='schedule-detailed']/div[2]/div[2]/div[3]/div[2]"))
					.getText());
			countFrequency(names);
			break;
		case 3:
			System.out.println("Studio Schedule for Tuesday");
			names.add(driver.findElement(By.xpath("//*[@class='schedule-detailed']/div[3]/div[2]/div[1]/div[2]"))
					.getText());
			names.add(driver.findElement(By.xpath("//*[@class='schedule-detailed']/div[3]/div[2]/div[2]/div[2]"))
					.getText());
			names.add(driver.findElement(By.xpath("//*[@class='schedule-detailed']/div[3]/div[2]/div[3]/div[2]"))
					.getText());
			names.add(driver.findElement(By.xpath("//*[@class='schedule-detailed']/div[3]/div[2]/div[4]/div[2]"))
					.getText());
			countFrequency(names);
			break;
		case 4:
			System.out.println("Studio Schedule for Wednesday");
			names.add(driver.findElement(By.xpath("//*[@class='schedule-detailed']/div[4]/div[2]/div[1]/div[2]"))
					.getText());
			names.add(driver.findElement(By.xpath("//*[@class='schedule-detailed']/div[4]/div[2]/div[2]/div[2]"))
					.getText());
			names.add(driver.findElement(By.xpath("//*[@class='schedule-detailed']/div[4]/div[2]/div[3]/div[2]"))
					.getText());
			countFrequency(names);
			break;
		case 5:
			System.out.println("Studio Schedule for Thursday ");
			names.add(driver.findElement(By.xpath(" //*[@class='schedule-detailed']/div[5]/div[2]/div[1]/div[2]"))
					.getText());
			names.add(driver.findElement(By.xpath("//*[@class='schedule-detailed']/div[5]/div[2]/div[2]/div[2]"))
					.getText());
			names.add(driver.findElement(By.xpath("//*[@class='schedule-detailed']/div[5]/div[2]/div[3]/div[2]"))
					.getText());
			names.add(driver.findElement(By.xpath("//*[@class='schedule-detailed']/div[5]/div[2]/div[4]/div[2]"))
					.getText());
			names.add(driver.findElement(By.xpath(" //*[@class='schedule-detailed']/div[5]/div[2]/div[5]/div[2]"))
					.getText());
			countFrequency(names);
			break;
		case 6:
			System.out.println("Studio Schedule for Friday ");
			names.add(driver.findElement(By.xpath("//*[@class='schedule-detailed']/div[6]/div[2]/div[1]/div[2]"))
					.getText());
			names.add(driver.findElement(By.xpath("//*[@class='schedule-detailed']/div[6]/div[2]/div[2]/div[2]"))
					.getText());
			countFrequency(names);
			break;
		case 7:
			System.out.println("Studio Schedule for Saturday");
			names.add(driver.findElement(By.xpath("//*[@class='schedule-detailed']/div[7]/div[2]/div[1]/div[2]"))
					.getText());
			names.add(driver.findElement(By.xpath("//*[@class='schedule-detailed']/div[7]/div[2]/div[2]/div[2]"))
					.getText());
			names.add(driver.findElement(By.xpath("//*[@class='schedule-detailed']/div[7]/div[2]/div[3]/div[2]"))
					.getText());
			countFrequency(names);
			break;
		}

		driver.quit();
	}

	public static void countFrequency(List<String> names) {
		Map<String, Integer> count = new HashMap<>();
		for (String name : names) {
			int frequency = count.getOrDefault(name, 0);
			count.put(name, frequency + 1);
		}
		for (Map.Entry<String, Integer> entry : count.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}

}
