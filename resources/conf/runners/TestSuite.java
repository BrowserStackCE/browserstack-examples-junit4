package runners;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;



@RunWith(Suite.class)

@Suite.SuiteClasses({ e2e.EndToEndTest.class, login.FavouritesEnforcesLoginTest.class, login.LockedUserTest.class, offers.CheckOffers.class,
		product.LowestToHighest.class, product.ApplyingFilters.class, user.ImageNotLoading.class, user.CheckExistingOrders.class, user.CheckFavouriteItems.class })

public class TestSuite {

}
