package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class setup {

		static Playwright playwright = Playwright.create();
		static Browser browser = playwright.firefox().launch(
				new LaunchOptions().setHeadless(false));
		static Page page = browser.newPage();
		
		@BeforeTest
		public static void setup_playwright() {
			page.navigate("https://www.google.com");
			assertThat(page).hasTitle("Google");
		}
		
		@AfterTest
		public static void tearDown() {
			page.close();
			browser.close();
			playwright.close();
		}
		
		@Test
		public void homePage() {
			Locator searchbarPage = page.locator("[name = 'q']");
			searchbarPage.fill("Selenium");
			searchbarPage.press("Enter");
			assertThat(page).hasTitle("Selenium - Google Search");
		}
	}

