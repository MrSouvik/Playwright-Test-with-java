package TestPkg;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FirstCode {
	public static void main(String[] args) {
		//Starting playwright server
		Playwright playwright = Playwright.create();
		
		//open browser - This will open browser in headless mode
		//Browser browser = playwright.chromium().launch();
		
		//Below code will help browser to open in headed mode
		LaunchOptions lOprions = new BrowserType.LaunchOptions().setHeadless(false);
		Browser browser = playwright.chromium().launch(lOprions);
		
		//Creating  a page
		Page page = browser.newPage();
		
		//launching url
		page.navigate("https://www.amazon.com/");
		
		//Capturing page title & printing
		String title = page.title();
		System.out.println("Page title : "+title);
		
		//Capturing page url & printing
		String url = page.url();
		System.out.println("Page URL : "+url);
		
		page.close();
		browser.close();
		
		//Below command will help to perform record & play -
		//mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen <url>"
	}
}
