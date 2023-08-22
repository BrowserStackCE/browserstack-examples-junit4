![Logo](https://www.browserstack.com/images/static/header-logo.jpg)

# BrowserStack Examples JUnit4 <a href="https://junit.org/junit4/"><img src="https://junit.org/junit5/assets/img/junit5-logo.png" alt="JUnit5" height="22" /></a>

## Introduction

JUnit is a unit testing framework for the Java programming language. JUnit has been important in the development of test-driven development, and is one of a family of unit testing frameworks which is collectively known as xUnit that originated with SUnit.

This BrowserStack Example repository demonstrates a Selenium test framework written using Junit 4 with parallel testing capabilities. The Selenium test scripts are written for the open source [BrowserStack Demo web application](https://bstackdemo.com) ([Github](https://github.com/browserstack/browserstack-demo-app)). This BrowserStack Demo App is an e-commerce web application which showcases multiple real-world user scenarios. The app is bundled with offers data, orders data and products data that contains everything you need to start using the app and run tests out-of-the-box.

The Selenium tests could be ran on different platforms like on-prem, docker and BrowserStack using various run configurations and test capabilities.

---

## Repository setup

- Clone the repository

- For this infrastructure configuration (i.e on-premise), create the `drivers` folder at `/src/test/resources` and ensure that the ChromeDriver executable is placed in the `/src/test/resources/drivers` folder.

- Ensure you have the following dependencies installed on the machine
  - Java >= 8
  - Maven >= 3.1+
  - Gradle >= 5.0+

  Maven:
    ```sh
    mvn install
    ```

  Gradle:
    ```sh
    gradle build
    ```

## About the tests in this repository

This repository contains the following Selenium tests:

| Module   | Test name                          | Description |
  | ---   | ---                                   | --- |
| E2E      | Regression                | This test scenario verifies successful product purchase lifecycle end-to-end. It demonstrates the [Page Object Model design pattern](https://www.browserstack.com/guide/page-object-model-in-selenium) and is also the default test executed in all the single test run profiles. |
| LocalTest    | BStackLocalTest          | This test verifies the workflow of locally hosted webistes, by navigating to http://localhost:45454/ url |
| Login    | NavigateToLoginPage          | This test verifies the workflow of navigating to Login Page |
| Login    | LockedUserTest              | This test verifies the login workflow error for a locked user. |
| Offers   | CheckOffers     | This test mocks the GPS location for Mumbai and verifies that the product offers applicable for the Mumbai location are shown.   |
| Product  | ApplyingSamsungAndAppleFilter          | This test verifies that Apple and Samsung products are only shown by applying Samsung and Apple vendor filter. |
| Product  | SortLowestToHighest   | This test verifies that the product prices are in ascending order when the product sort "Lowest to Highest" is applied. |
| User     | ImageNotLoading | This test verifies that the product images load for user: "image_not_loading_user" on the e-commerce application. Since the images do not load, the test case assertion fails.|
| User     | CheckExistingOrders |  This test verifies that existing orders are shown for user: "existing_orders_user"  |
| User     | CheckFavourites |  This test verifies that Favourites items are shown for user:  "fav_user"|
  
---



## Test infrastructure environments

- [On-premise/self-hosted](#on-premise-self-hosted)
- [BrowserStack](#browserstack)


## Configuring the maximum parallel test threads for this repository

For all the parallel run configuration profiles, you can configure the maximum parallel test threads by changing the settings below.


- BrowserStack

    [browserstack.yml](browserstack.yml)

    parallelsPerPlatform = 5

## Test Reporting

- [Allure reports](#generating-allure-reports)
---

# On Premise / Self Hosted

This infrastructure points to running the tests on your own machine using a browser (e.g. Chrome) using the browser's driver executables (e.g. ChromeDriver for Chrome). Selenium enables this functionality using WebDriver for many popular browsers.

## Prerequisites

- For this infrastructure configuration (i.e on-premise), create the `drivers` folder at `/src/test/resources` and ensure that the ChromeDriver executable is placed in the `/src/test/resources/drivers` folder.

Note: The ChromeDriver version must match the Chrome browser version on your machine.

## Running Your Tests

### Run a specific test on your own machine

- How to run the test?

  To run the default test scenario (e.g. End to End Scenario) on your own machine, use the following command:

  Maven:
    ```sh
  mvn test -P on-prem
  ```

  Gradle:
    ```sh 
  gradle on_prem
  ```

  To run a specific test scenario, use the following command with the additional 'test-name' argument:

  Maven:
  ```sh
  mvn test -P on-prem -Dtest-name="<Test scenario name>"
  ```

  Gradle:
  ```sh
  gradle on_prem -Dtest-name="<Test scenario name>"
  ```

  where,  the argument 'test-name' can be any test name configured in this repository.

  E.g. "EndToEndTest", "LockedUserTest", "ImageNotLoading" or any of the other test scenario names, as outlined in [About the tests in this repository](#About-the-tests-in-this-repository) section.

- Output

  This run profile executes a specific test scenario on a single browser instance on your own machine.


# BrowserStack

[BrowserStack](https://browserstack.com) provides instant access to 3,000+ real mobile devices and browsers on a highly reliable cloud infrastructure that effortlessly scales as testing needs grow.

## Prerequisites

- Create a new [BrowserStack account](https://www.browserstack.com/users/sign_up) or use an existing one.
- Identify your BrowserStack username and access key from the [BrowserStack Automate Dashboard](https://automate.browserstack.com/) and export them as environment variables using the below commands.

  - For \*nix based and Mac machines:

  ```sh
  export BROWSERSTACK_USERNAME=<browserstack-username> &&
  export BROWSERSTACK_ACCESS_KEY=<browserstack-access-key>
  ```

  - For Windows:

  ```shell
  set BROWSERSTACK_USERNAME=<browserstack-username>
  set BROWSERSTACK_ACCESS_KEY=<browserstack-access-key>
  ```

  Alternatively, you can also hardcode username and access_key objects in the capabilities-bstack-single.yml files of profiles.

Note:
- We have configured a list of test capabilities in the [capabilities-bstack-single.yml](resources/conf/caps/caps.json) file. You can certainly update them based on your device / browser test requirements.
- The exact test capability values can be easily identified using the [Browserstack Capability Generator](https://browserstack.com/automate/capabilities)


## Running Your Tests

### Run a specific test on BrowserStack

In this section, we will run a single test on Chrome browser on Browserstack. To change test capabilities for this configuration, please refer to the [capabilities-bstack-single.yml](resources/conf/caps/caps.json)

- How to run the test?

  - To run the default test scenario (e.g. End to End Scenario) on your own machine, use the following command:

  Maven:
  ```sh
  mvn test -P bstack-single
  ```

  Gradle:
    ```sh
  gradle bstack_single
  ```

  To run a specific test scenario, use the following command with the additional 'test-name' argument:
  Maven:
  ```sh
  mvn test -P bstack-single -Dtest-name="<Test scenario name>"
  ```

  Gradle:
  ```sh
  gradle bstack_single -Dtest-name="<Test scenario name>"
  ```

  where,  the argument 'test-name' can be any test scenario name configured in this repository.

  E.g. "EndToEndTest", "LockedUserTest", "ImageNotLoading" or any of the other test scenario names, as outlined in [About the tests in this repository](#About-the-tests-in-this-repository) section.


- Output

  This run profile executes a single test on a single browser on BrowserStack. Please refer to your [BrowserStack dashboard](https://automate.browserstack.com/) for test results.


### Run the entire test suite in parallel on a single BrowserStack browser

In this section, we will run the tests in parallel on a single browser on Browserstack. Refer to please refer to the [capabilities-bstack-parallel.yml](resources/conf/caps/caps.json) to change test capabilities for this configuration.

- How to run the test?

  To run the entire test suite in parallel on a single BrowserStack browser, use the following command:

  Maven:
  ```sh
  mvn test -P bstack-parallel
  ```
  Gradle:
    ```sh
  gradle bstack_parallel
  ```


- Output

  This run profile executes the entire test suite in parallel on a single BrowserStack browser. Please refer to your [BrowserStack dashboard](https://automate.browserstack.com/) for test results.

  - Note: By default, this execution would run maximum 5 test threads in parallel on BrowserStack. Refer to the section ["Configuring the maximum parallel test threads for this repository"](#Configuring-the-maximum-parallel-test-threads-for-this-repository) for updating the parallel thread count based on your requirements.


### Run the entire test suite in parallel on multiple BrowserStack browsers

In this section, we will run the tests in parallel on multiple browsers on Browserstack. Refer to the `capabilities-bstack-parallel-browsers.yml` file to change test capabilities for this configuration.

- How to run the test?

  To run the entire test suite in parallel on multiple BrowserStack browsers, use the following command:

  Maven:
  ```sh
  mvn test -P bstack-parallel-browsers
  ```

  Gradle:
  ```sh
  gradle bstack_parallel_browsers
  ```

### [Web application hosted on internal environment] Running your tests on BrowserStack using BrowserStackLocal

#### Prerequisites

- Clone the [BrowserStack demo application](https://github.com/browserstack/browserstack-demo-app) repository.
  ```sh
  git clone https://github.com/browserstack/browserstack-demo-app
  ``` 
- Please follow the README.md on the BrowserStack demo application repository to install and start the dev server on localhost.
- In this section, we will run a single test case to test the BrowserStack Demo app hosted on your local machine i.e. localhost. Refer to the `capabilities-bstack-local.yml` file in `src/test/resources` to change test capabilities for this configuration.
- Note: You may need to provide additional BrowserStackLocal arguments to successfully connect your localhost environment with BrowserStack infrastructure. (e.g if you are behind firewalls, proxy or VPN).
- Further details for successfully creating a BrowserStackLocal connection can be found here:

  - [Local Testing with Automate](https://www.browserstack.com/local-testing/automate)
  - [BrowserStackLocal Java GitHub](https://github.com/browserstack/browserstack-local-java)


### [Web application hosted on internal environment] Run a specific test on BrowserStack using BrowserStackLocal

- How to run the test?

  - To run the default test scenario (e.g. End to End Scenario) on a single BrowserStack browser using BrowserStackLocal, use the following command:

  Maven:
  ```sh
  mvn test -P bstack-local
  ```

  Gradle:
    ```sh
  gradle bstack_local
  ```

  To run a specific test scenario, use the following command with the additional test-name argument:
  Maven:
  ```sh
  mvn test -P bstack-local -Dtest-name="<Test scenario name>"
  ```

  Gradle:
  ```sh
  gradle bstack_local -Dtest-name="<Test scenario name>"
  ```

  where,  the argument 'test-name' can be any test scenario name configured in this repository.

  E.g. "Login as username", "Login as Locked User", "Offers for mumbai geo-location" or any of the other test scenario names, as outlined in [About the tests in this repository](#About-the-tests-in-this-repository) section.


- Output

  This run profile executes a single test on an internally hosted web application on a single browser on BrowserStack. Please refer to your BrowserStack dashboard(https://automate.browserstack.com/) for test results.


### [Web application hosted on internal environment] Run the entire test suite in parallel on a single BrowserStack browser using BrowserStackLocal

In this section, we will run the test cases to test the internally hosted website in parallel on a single browser on Browserstack. Refer to the `capabilities-bstack-local.yml` file in `src/test/resources/` to change test capabilities for this configuration.

- How to run the test?

  To run the entire test suite in parallel on a single BrowserStack browser using BrowserStackLocal, use the following command:
  Maven:
  ```sh
  mvn test -P bstack-local-parallel
  ```

  Gradle:
  ```sh
  gradle bstack_local_parallel
  ```

- Output

  This run profile executes the entire test suite on an internally hosted web application on a single browser on BrowserStack. Please refer to your [BrowserStack dashboard](https://automate.browserstack.com/) for test results.

- Note: By default, this execution would run maximum 5 test threads in parallel on BrowserStack. Refer to the section ["Configuring the maximum parallel test threads for this repository"](#Configuring-the-maximum-parallel-test-threads-for-this-repository) for updating the parallel thread count based on your requirements.

### [Web application hosted on internal environment] Run the entire test suite in parallel on multiple BrowserStack browser using BrowserStackLocal

In this section, we will run the test cases to test the internally hosted website in parallel on multiple browsers on Browserstack. Refer to the `capabilities-bstack-local-parallel.yml` file in `src/test/resources` to change test capabilities for this configuration.

- How to run the test?

  To run the entire test suite in parallel on a single BrowserStack browser using BrowserStackLocal, use the following command:

  Maven:
  ```sh
  mvn test -P bstack-local-parallel-browsers
  ```

- Output

  This run profile executes the entire test suite on an internally hosted web application on multiple browsers on BrowserStack. Please refer to your [BrowserStack dashboard](https://automate.browserstack.com/) for test results.

- Note: By default, this execution would run maximum 5 test threads in parallel on BrowserStack. Refer to the section ["Configuring the maximum parallel test threads for this repository"](#Configuring-the-maximum-parallel-test-threads-for-this-repository) for updating the parallel thread count based on your requirements.

## Generating Allure Reports

  In this section, we will generate and serve allure reports for maven test runs.

- Generate Report using the following command: `mvn allure:report`
- Serve the Allure report on a server: `mvn allure:serve`

## Additional Resources

- View your test results on the [BrowserStack Automate dashboard](https://www.browserstack.com/automate)
- Documentation for writing [Automate test scripts in Java](https://www.browserstack.com/automate/java)
- Customizing your tests capabilities on BrowserStack using our [test capability generator](https://www.browserstack.com/automate/capabilities)
- [List of Browsers & mobile devices](https://www.browserstack.com/list-of-browsers-and-platforms?product=automate) for automation testing on BrowserStack
- [Using Automate REST API](https://www.browserstack.com/automate/rest-api) to access information about your tests via the command-line interface
- Understand how many parallel sessions you need by using our [Parallel Test Calculator](https://www.browserstack.com/automate/parallel-calculator?ref=github)
- For testing public web applications behind IP restriction, [Inbound IP Whitelisting](https://www.browserstack.com/local-testing/inbound-ip-whitelisting) can be enabled with the [BrowserStack Enterprise](https://www.browserstack.com/enterprise) offering


[comment]: <> (## Open Issues)

[comment]: <> (<Placeholder section for any known open issues &#40;some test known to not work or is flaky&#41;. If none, please remove the section>)
