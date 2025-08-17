package test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class setup {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.firefox().launch(
				new LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
		page.navigate("https://www.google.com");
		assertThat(page).hasTitle("Google");
		Locator searchbarPage = page.locator("[name = 'q']");
		searchbarPage.fill("Selenium");
		searchbarPage.press("Enter");
		assertThat(page).hasTitle("Selenium - Google Search");
		
		page.close();
		browser.close();
		playwright.close();
	}
}
