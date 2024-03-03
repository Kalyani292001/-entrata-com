# Entrata.com Selenium Automation Project

## Overview
This Selenium Java project is designed for automating tests on the Entrata.com website.
It leverages the Selenium WebDriver framework to interact with the web pages and perform various testing scenarios.

## Prerequisites
- Java Development Kit (JDK)
- Maven
- WebDriver (e.g., ChromeDriver)
- TestNg

## Project Structure
-The project follows a standard Maven project structure.
-src/main/java: Contains the main source code.
-src/test/java: Contains test code.
-src/test/resources: Configuration files, test data, etc.
-pom.xml:All maven dependency here(download TestNG JAR files)

# Sample Configuration
-webdriver.driver=chrome
-webdriver.chrome.driver=/path/to/chromedriver.exe
-base.url=https://www.entrata.com

## Running Tests
-you can usually right-click on your TestNG XML file and select "Run" or "Run As TestNG Suite."
-If you want to run TestNG from the command line, you can use the following Maven command:
mvn clean test -DsuiteXmlFile=testng.xml


