package flipk.det;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.objectrepository.validation;
import com.reusabalemethods.CommonActions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class demo {
	CommonActions ca =new CommonActions();
	validation v=new validation();
	@Given("user Browser Launch")
	public void user_Browser_Launch() {
	    driver.get("https://www.flipkart.com/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   
	}

	@When("user click on close button")
	public void user_click_on_close_button() {
	    ca.click(v.getButton());
	}
	@And("user Search the oneplus tv{string}")
	public void user_Search_the_oneplus_tv(String string) {
	   ca.sendKeys(v.getSearch(), string);
	   ca.click(v.getSearchClick());
	}

	@And("user Click on the Oneplus tv")
	public void user_Click_on_the_Oneplus_tv() {
		ca.javaScript();
		ca.click(v.getOneplusTvclick());
		Set<String> winh = driver.getWindowHandles();
		List<String> gh = new ArrayList<String>(winh);
		driver.switchTo().window(gh.get(1));
	}

	@Then("user Buynow the oneplus tv")
	public void user_Buynow_the_oneplus_tv() {
		ca.click(v.getAddTocart());
	}

	@Then("user payment page")
	public void user_payment_page() throws IOException {
	   ca.click(v.getBuyNow());
	   ca.takeScreenshot();
	}

}

}
