# ProQuestAutomation
This project uses Selenium, Java, and Maven for automated testing.  It searches Google for "ProQuest," saves the search result titles in a file, and takes a screenshot after looking up "QA" on the ProQuest website.
=======
# ProQuestAutomationProj
## Complete instructions to install all automation components

## Overview
This project uses Selenium, Java, and Maven for automated testing. 
It searches Google for "ProQuest," saves the search result titles in a file, and takes a screenshot after looking up "QA" on the ProQuest website.

## Prerequisites
Before you started, ensure you have installed all the necessary automation components
First one is
# Setting Up the Automation Environment

## 1. Java Development Kit(JDK):
**Download and install**:
- Download the latest version from [Download JDK](https://www.oracle.com/java/technologies/downloads/#java11?er=221886) from Oracle website 
- I have downloaded JDK 21.0.3 and ensure that Java version should be 11 or higher.
- Set up the JAVA_HOME environment variable to point to your JDK installation.
- You can verify by running the following command in your terminal/command prompt: Java -version

## 2. Apache Maven
**Download Maven**: 
- We can download maven version from this link [Download Maven](https://maven.apache.org/download.cgi)
- I have downloaded Maven latest version for windows which is Binary zip archive and extracted it and i saved it in Program files by creating Maven folder.
- I have Set up environment variables (add Maven bin folder to PATH) and in System variables, created MAVEN_HOME as variable and provided value as path of the Maven.

## 3. Install IntelliJ IDEA
- I have Downloaded IntelliJ IDEA from [JetBrains](https://www.jetbrains.com/idea/download/?section=windows) and installed it.
- Selected the Community version as a free option.

## 4. GitHub Account
- Create a GitHub account and set up Git locally 
- Instructions for Git setup can be found [here](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git).
- Clone the repository: git clone https://github.com/yourusername/ProQuestAutomationProj.git

# Setting Up the Project
This document provides step-by-step instructions for setting up and executing the automation project 
using Selenium.
## Create a Maven Project in IntelliJ
- Open IntelliJ IDEA. 
- Create a New Project:
- Select New Project.
- choose your JDK version, and hit Next. 
- Name your project, and specify a location.
- Click on "Create" to create the project.

## Adding Dependencies
1. From [Maven Repository](https://mvnrepository.com/) Add Dependencies in pom.xml: 
Open the pom.xml file in your project and add the following dependencies:
Seleniumhq which is the latest version 4.20.0 and add WebDriverManager dependency version is 5.8.0 
and add Apache Common IO in repository version is 2.16.1, to run all the tests in TestNG add testng 7.4.0.
2. Save the pom.xml file. IntelliJ will automatically download the specified dependencies.

## Writing Automation Test Code
### 1. Creating Test Classes
1. Go to Project you have created in IntelliJ, in the src/test/java folder, create package tests.
2. Inside the package, create new class called "GoogleSearchTest".
### 2. Implementing the Test Logic
In Created class, write the selenium code using java to perform automation, 
1. Setup WebDriver and initialize the chromeDriver 
2. Set an implicit wait (global wait) to wait for 5 seconds to load all the elements on the webpage.
3. Maximize the browser and by using driver method it will navigate to google.com
4. In Search field search for "ProQuest" and Enter it (Using WebDriver locators) locate the elements in the DOM.
5. Loop through the `WebElements` to find the titles of all results on the first page and write them to a text file on the operating system.
6. Click on ProQuest, search for "QA", and take a screenshot of the search results using the `TakesScreenshot` interface.
### 3. Explanation
- **Test 1**: Searches for "ProQuest" on Google and writes the titles of search results to a file called GoogleSearchResults.txt.
- **Test 2**: Opens the ProQuest website, searches for "QA" in the navigation bar, and takes a screenshot saved as ProQuestSearchQA.png.

## Create a TestNG XML File (Optional)
To run tests via TestNG, you can create a testng.xml file in your project root:

# Execute the Tests
- We can run the tests using Maven, TestNG or simply right-click on the project and run the tests.
###  Run Tests with Maven
1. Open a terminal and navigate to the project directory: cd ProQuestAutomation
2. Compile and run the tests using Maven: mvn clean test
### To run tests using the TestNG XML file:
- Open a terminal and navigate to the project directory: cd ProQuestAutomation and run mvn clean test -Dsurefire.suiteXmlFiles=testng.xml
### To run the tests in Intellij itself
1. Right-click on the GoogleSearchTest class and select Run GoogleSearchTest.main()
2. We can also run the tests using TestNG by adding TestNG dependency in pom.xml file and run the tests via testng.xml file in Intellij itself.

### Expected Output
Ensure that messages indicating success appear, such as 
1. Titles written to file successfully.
2. Screenshot saved successfully.
- We can also see the results whether testcases are pass or not while running as per execution using TestNG.

## Verify Outputs
1. A text file named search_results.txt will be generated in the project directory containing the titles of the search results.
2. A screenshot of the ProQuest website after searching for "QA" will be saved as ProQuest_QA_search.png.

## Push Code to GitHub
### Initialize Git
1. Open the terminal in the project directory.
2. Initialize Git using git init command 
3. Add files (staging) git add *
4. git commit -m "Initial commit"
5. git remote add origin "github url"
6. git push -u origin main

