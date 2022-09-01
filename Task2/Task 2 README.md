# **TASK - 2** 

## Mobile App Test Automation

### **Application Name - Monefy Android App**

## **End-to-End user flows covered**

1. Install the application from playstore & launch this app.
2. Add new expense of any category.
3. Add new income of any category.
4. Add new account of any type.

## **Tech Stack used for Mobile Test Automation Framework**

1. Java - Java is a programming language and a platform
2. Appium - Appium is an open source test automation framework for use with native, hybrid and mobile web apps. It drives iOS, Android, and Windows apps using the WebDriver protocol.
3. TestNG - TestNG is an automation testing framework which makes automated tests more structured, readable, maintainable and user-friendly. It provides powerful features and reporting.
4. ExtentReports - ExtentReports is an open-source reporting library useful for test automation. It can be easily integrated with major testing frameworks like JUnit, NUnit, TestNG, etc. These reports are HTML documents that depict results as pie charts.
5. Maven - Maven is a popular open-source build tool to build, publish, and deploy several projects at once for better project management. It is used to take care of the dependencies to build the project.
6. Android SDK - Android SDK build tools are used for building actual binaries of Android App. The main functions of Android SDK Build tools are built, debug, run and test Android applications.

## **Test Class**

**MonefyTest** - 4 Test methods which cover the following test cases:

1. Install App from Play Store and Launch it.
2. Add a new account
3. Add a new income record
4. Add a new expense record

## **Base class** 
 
 **CreateReport** - This class is used to create HTML Reports. Contains methods to configure the location, name, look & feel of the HTML report. Used in the MonefyTest class.


### **POM.XML**

Available in the root directory and having all needed dependencies and plugins to be used by suite.

https://github.com/nitinkaushik3390/nitin-kaushik-QA/blob/master/Task2/pom.xml

### **TestNG.XML**

TestNG Automation Suite XML File which is having configuration for all test classes to be executed.

https://github.com/nitinkaushik3390/nitin-kaushik-QA/blob/master/Task2/testng.xml

## Execution Steps

### **Setup Instructions**:

1. Setup java on your system.
2. Download & Setup the latest version of Android SDK.
3. Setup Android Studio and using it, create an Android AVD emulator having android version 8.0.
4. Configure Google account in the above emulator to use the playstore.
5. Download and install the latest version of Eclipse IDE for Java.
6. Clone this repo - https://github.com/nitinkaushik3390/nitin-kaushik-QA.git 
7. Import cloned repo in step 6 as Maven project in Eclipse:
    File->Import->Go to Maven -> Existing Maven Projects. Click on Next
    Choose Task3 folder. And Click on Finish.
8. In the imported project, right click on pom.xml & run as -> Maven build so that  all the dependencies will be uploaded.
9. Now to run automation project ,right click on pom.xml & Run as -> Maven   Test .All test suites will be executed.
10. Automation Execution report can be seen from under -> test-output-> MonefyTestReport.html

## **Execution Report**

Test Suite is having 4 testcases and after execution, the HTML report will be generated under "test-output-> MonefyTestReport.html".
