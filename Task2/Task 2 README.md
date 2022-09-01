**#TASK - 2** 

##### Mobile App Test Automation

**Application Name - Monefy Android App**

**#End to End user flows covered**

1) Install the application from playstore & launch this app.
2) Add new expense of any category.
3) Add new income of any category.
4) Add new account of any type.

**#Tech Stack for Test Automation Framework**

1) Java
2) Appium server
3) TestNG
4) ExtentReports 
5) Maven
6) Android SDK

**#Rest API Automation Suite Information** 

I have used below listed libraries to automate the Mobile Application.

RestAssured -Its a Java library for testing REST services. It supports XML and JSON formats. Its having Gherkin structured syntax which is a kind of BDD implementation to increase readability of test scenario.
TestNG - Its a TDD implementation and provides very useful annotations to make test execution smooth also it generates report for execution of test suite in html and xml format.
Maven - Its well known build tool for Java to take care of dependencies to build the project.

**#Test Class**

One test class 'MonefyTest' constitutes of 4 Test Cases/User Flows.

* Install & Launch the app from the playstore
* Add new account
* Add new income record
* Add new expense record

**#Base class** 
 
 CreateReport class is used to create HTML Extent Report. 


**#POM.XML** -
Its available at root directory and having all needed dependencies and plugins to be used by suite.
https://github.com/karanit25/Karan-Thakur/blob/master/pom.xml

**#TestNG.XML** -
Its Automation Suite File which is having configuration for all test classes to be executed.
https://github.com/karanit25/Karan-Thakur/blob/master/testng.xml

##### Execution Steps

**#Setup Instructions**:

1) Setup java on your system.
2) Setup the latest version of Android SDK.
3) Create Android AVD emulator having android version 8.0.
4) Configure google account in the above emulator to use the playstore.
5) Download and install the latest version of Eclipse IDE for Java.
6) Clone this repo : 
git clone https://github.com/SMK125/shonam-mulani.git
7) Import cloned repo in step 6 as Maven project in Eclipse:
   File->Import->Go to Maven -> Existing Maven Projects.Click on Next
   Choose shonam-mulani\Task3 folder. And Click on Finish.
8)In import project ,right click on pom.xml & run as -> Maven build so that  all the dependencies will be uploaded.

9) Now to run automation project ,right click on pom.xml & Run as -> Maven   Test .All test suites will be executed.
   Automation Execution report can be seen from under -> test-output-> MonefyTestReport.html

**#Execution Report** - Test Suite is having 4 testcase and after execution report will be generated under "test-output-> MonefyTestReport.html".