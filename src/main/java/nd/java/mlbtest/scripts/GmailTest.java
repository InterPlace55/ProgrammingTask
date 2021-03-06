package nd.java.mlbtest.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import nd.java.mlbtest.pages.gmail.GmailEmailPage;
import nd.java.mlbtest.pages.gmail.GmailLoginPage;

/**
 * Hello world!
 *
 */
public class GmailTest 
{
	/**
     * The test initialize a Firefox browser window that opens Gmail. 
     * Once the Gmail login page loads, the test will log into Gmail with a test account. 
     * Once logged in, the test will verify that the login is successful by verifying the name 
     * and email of test user is correct. 
     */
	public static boolean executeTest()
	{
		String email = "xxxtest825@gmail.com";
		String password = "RodeToSun123";
		String name = "Test Daniels";
		
		WebDriver driver = new FirefoxDriver();
    	GmailLoginPage glp = new GmailLoginPage(driver);
    	GmailEmailPage gep = glp.loginToGmail(email, password);
    	
    	boolean right = gep.verifyLoginIsSuccessful(email, name);
    	
    	if(right)
    		System.out.println("Gmail Test - Login successful and correct: Test Passed");
    	else System.out.println("Gmail Test - Login failed: Test Failed");
    	
    	gep.closeBrowser();
    	
    	return right;
	}
	
    public static void main( String[] args )
    {
    	executeTest();
    }
}
