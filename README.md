# Automated Testing Framework for UI and API
## Overview
This comprehensive testing framework integrates UI and API automation to validate the functionality and behavior of a web application and sample APIs. The project employs Java, Selenium WebDriver, RestAssured, and Cucumber BDD for automated end-to-end testing. The architecture follows Maven for efficient project management, and GitHub for version control. Jenkins is utilized for continuous integration and continuous delivery, while Allure Report generates interactive and detailed test reports..
## Tools Used
- Intellij IDE: Integrated development environment for Java development.
- Maven Project: Project management tool for building and managing Java-based projects.
- Selenium WebDriver: Automation tool for browser-based testing of web applications.
- RestAssured: Java library for API testing.
- Cucumber BDD Framework: Behavior-Driven Development framework for writing test scenarios in a natural language format.
- GitHub: Version control platform for collaborative development.
- Jenkins: Automation server for continuous integration and continuous delivery.
- Allure Report: Reporting tool for generating interactive and visually appealing test reports.

  
## API Directory

	-	common utils: Contains base classes and configuration reader.

	-	endpoints: Maintains endpoint URLs.

	-	globaldatas: Holds reused variables across projects.

	-	payload: Contains methods for creating payloads.
 
	-	pagemanager: Manages singleton objects for payload classes.

	-	pojo: Stores classes for converting JSON to POJO for request variables.

	-	runner: Cucumber JUnit runner class.

	-	stepdefinition: Holds classes for converting feature files to step definition classes.

## UI Directory

	-	common utils: Contains utility classes.

	-	page manager: Manages singleton objects for page classes.

	-	pages: Stores locators using Page Factory pattern.

	-	step definition: Holds classes for converting feature files to step definition classes.

	-	runner: TestNG runner class.

	-	validation: Contains reusable methods for TestNG validation.
 
## Resources Directory

	-	Feature files.

	-	Excel files for test data.

	-	config.properties file.

	-	Directory for failed screenshots.

## Prerequisites
Ensure you have Java, Maven, and Intellij IDE installed on your machine.

# Project Setup Guide
This guide provides step-by-step instructions to set up the project on your local machine.
## Step 1: Git Clone
1. Open a terminal.
2. Navigate to the directory where you want to clone the project.
3. Run: `git clone git clone https://github.com/deepakdebugnkill/DemoFramework.git`
## Step 2: Java Installation
- Ensure Java is installed. Download and install it from [Java's official website](https://www.oracle.com/java/technologies/javase-downloads.html).
## Step 3: Maven Installation
- Download and install Maven from [Maven's official website](https://maven.apache.org/download.cgi).
## Step 4: Selenium Setup
1. Include Selenium dependencies in your project's `pom.xml` file.
  ```xml
<dependencies>
<!-- Selenium -->
<dependency>
<groupId>org.seleniumhq.selenium</groupId>
<artifactId>selenium-java</artifactId>
<version>[selenium_version]</version>
</dependency>
</dependencies>
  ```
  Replace `[selenium_version]` with the desired Selenium version.
## Step 5: Rest Assured Setup
1. Include Rest Assured dependencies in your project's `pom.xml` file.
  ```xml
<dependencies>
<!-- Rest Assured -->
<dependency>
<groupId>io.rest-assured</groupId>
<artifactId>rest-assured</artifactId>
<version>[rest_assured_version]</version>
</dependency>
</dependencies>
  ```
  Replace `[rest_assured_version]` with the desired Rest Assured version.
## Step 6: Allure Installation
- Follow the instructions on the [Allure website](https://docs.qameta.io/allure/) to install Allure for reporting.
## Step 7: GitHub
- Set up Git credentials.
## Step 8: Jenkins
- Install Jenkins on your machine by following the instructions on the [Jenkins website](https://www.jenkins.io/download/).
- Set up Jenkins jobs to build and run project.
## Step 9: Jira
- Ensure you have access to the Jira project.
- Integrated Jira with Jenkins for automated build statuses..
