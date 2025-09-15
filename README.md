**Playwright - **

It's an open source, cross browser automation library developed by Microsoft.It's a Node.js based library. 
It support Chromium, FireFox and Webkit (safari and IOS browser) with a single API. 
It aupport Java, Javascript/Typescript, Python.

Advantages over Selenium -
1. Any Browser Any platform - One API 
2. Language-JsvaScript, Java, Python, typeScript 
3. Mobile testing 
4. API Testing 
5. cross browser 
6. Headless and headed execution 
7. Multiple Tabs/Context - Native support 
8. No Flaky tests 
9. Auto wait 
10. Web first assertion 
11. Tracing

No limits - 
Multiple everything - Multiple tab, browser, users Trusted events drag & drop, hover & etc 
Frames shadow support 

Powerful tooling - 
Codegen 
Playwright Inspector 
Trace viewer 

Platwright - Entry point manages browser driver 
Browser Represent actual browser instance BrowserContext an Isolated environment (Like an incognito window) 
Page Represent a single tab or Window 
Locator for finding and interacting with element. 

Flow: Playwright -> Browser -> BrowserContext -> Page browser.newPage() open a new page in default 
browser context(Shared session) 
browser.newContext() create a new isolated session (private), then create a page inside it.


**Script- **
Playwright playwright = Playwright.create()
Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); 
Page page = browser.newPage();

page.navigate("https://www.google.com"); 
Locator button = page.locator("#signIn"); button.hover(); 
page.getByText("Sign in").click();

assertThat(page).hasTitle("Sign in Google Accounts"); page.getByPlaceholder("Email or phone").type("abc@gmail.com");

page.getByText("Next").click(); 
page.getByPlaceholder ("Enter your password").type("your_password"); ("Sign in").click(); 

page.locator("#signIn").click(); 
page.close(); 
browser.close(); 

Type vs fill- 

Type - it type char by char, and it append the text to any existing text present in that element. 

Fill - a quick copy paste action, entire value is inserted in target at once. It first clear existing content and then insert.

