package trial;

import org.junit.Test;

import e2e.EndToEndTest;
import login.FavouritesEnforcesLoginTest;
import login.LockedUserTest;
import pages.Login;
import utils.DriverFactory;


public class trial extends DriverFactory {

	
	public void TestSuite() throws Exception {
		
		EndToEndTest e2e = new EndToEndTest();
		
		e2e.EndToEnd();
		
		FavouritesEnforcesLoginTest f = new FavouritesEnforcesLoginTest();
		
		f.FavouriteEnforcesLoginTest();
		
		LockedUserTest l = new LockedUserTest();
		
		l.lockedUserTest();
		
		
	}
	
	
	
}
