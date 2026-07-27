# Selenium Login Automation Tests

An automation testing project built with **Selenium WebDriver**, **Java**, and **TestNG** to test login and logout workflows on a web application.


## Project Overview

This project demonstrates end-to-end automated testing of authentication scenarios using the **Page Object Model (POM)** design pattern. It covers valid login, invalid credentials, edge cases, and logout functionality.

**Test Site:** [The Internet - Herokuapp](https://the-internet.herokuapp.com/login)

## Tech Stack

| Tool & Purpose |
| Java 17 | Programming language |
| Selenium WebDriver 4 | Browser automation |
| TestNG 7.9.0 | Test execution and reporting |
| WebDriverManager | Auto-manages ChromeDriver |
| Maven | Build and dependency management |


## Test Cases

| Test ID | Test Name | Description | Expected Result |
| TC01 | Valid Login | Login with correct username and password | Redirects to `/secure` page |
| TC02 | Invalid Password | Login with correct username but wrong password | Error message displayed |
| TC03 | Invalid Username | Login with wrong username | Error message displayed |
| TC04 | Blank Fields | Submit login form with empty fields | Validation error shown |
| TC05 | Logout | Logout after successful login | Redirects back to `/login` page |


## Prerequisites

Make sure the following are installed on your machine:

- [Java JDK 17](https://adoptium.net) or higher
- [Apache Maven 3.9+](https://maven.apache.org/download.cgi)
- [Google Chrome](https://www.google.com/chrome/) (latest version)
- [VS Code](https://code.visualstudio.com/) with Extension Pack for Java

## How to Run

**1. Clone the repository**
git clone https://github.com/your-username/selenium-login-tests.git
cd selenium-login-tests

**2. Run all tests**
mvn test

**3. View the test report**
After running, open this file in your browser:
target/surefire-reports/index.html

## Test Results
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS

All 5 test cases pass successfully. Chrome opens automatically for each test — no manual setup required.

## Design Pattern

This project uses the **Page Object Model (POM)** pattern:

- `LoginPage.java` contains all the web element locators and actions (click, type, navigate)
- `LoginTest.java` and `LogoutTest.java` contain only the test logic and assertions
- This separation means if the webpage changes, only the Page Object needs to be updated — not every test
