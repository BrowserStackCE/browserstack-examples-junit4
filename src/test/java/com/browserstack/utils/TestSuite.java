package com.browserstack.utils;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.browserstack.suites.e2e.EndToEndTest;
import com.browserstack.suites.login.FavouritesEnforcesLoginTest;
import com.browserstack.suites.login.LockedUserTest;
import com.browserstack.suites.offers.CheckOffers;
import com.browserstack.suites.product.ApplyingFilters;
import com.browserstack.suites.product.LowestToHighest;
import com.browserstack.suites.user.CheckExistingOrders;
import com.browserstack.suites.user.CheckFavouriteItems;
import com.browserstack.suites.user.ImageNotLoading;



@RunWith(Suite.class)

@Suite.SuiteClasses({ EndToEndTest.class, FavouritesEnforcesLoginTest.class, LockedUserTest.class, CheckOffers.class,
		LowestToHighest.class, ApplyingFilters.class, ImageNotLoading.class, CheckExistingOrders.class, CheckFavouriteItems.class })

public class TestSuite {

}
