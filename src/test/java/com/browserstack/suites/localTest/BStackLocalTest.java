package com.browserstack.suites.localTest;

import com.browserstack.utils.BaseTest;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class BStackLocalTest extends BaseTest {
    @Test
    public void test() {
        webDriver.get("http://localhost:45454/");
        assertTrue("Local content not validated!", webDriver.getTitle().contains("BrowserStack Local"));
    }
}

