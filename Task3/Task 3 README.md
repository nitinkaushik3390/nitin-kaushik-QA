# **TASK - 3**

## Restful API Test Automation

### API documentation & PetStore APIs URL - https://petstore3.swagger.io/

### **Endpoints Covered**

1) POST_NewPet
2) GET_FindByStatus
3) PUT_UpdateExistingPet
4) DELETE_Pet

### **Test Scenarios**

* POST Method - 6 test cases covered in the test file **PostNewPet**.

  POST request to create new pet in the pet store and verify response payload.

  Expected Result - New Pet should be created with the posted parameter values.

* GET Method - 5 test cases covered in the test file **GetPetByStatus**.

  GET request for pet query By status and verify response payload with expected v/s actual attributes.

  Expected Result - Existing pets should be fetched on the basis of respective statuses.

* PUT Method - 7 test cases covered in the test file **PutUpdateExistingPet**.

  PUT request to update an existing pet in the pet store.

  Expected Result - Existing pet should be updated with the posted parameter values.

* DELETE Method - 2 test cases covered in the test file **DeletePet**.

  DELETE request with specified pet Id to delete the existing record.

  Expected Result- Existing pet with the given Pet ID should be deleted.

### **Rest API Automation Suite Information** 

Below mentioned libraries have been used to automate the REST services:

1. REST Assured - REST Assured is used to verify the REST APIs with the help of the Java library. Java library acts like a headless client to act upon the Rest web services. The libraries based on the Rest Assured library are also capable of validating the HTTP responses from the server. This library uses Gherkin language which makes it easier to understand the tests.
2. TestNG - TestNG is an automation testing framework which makes automated tests more structured, readable, maintainable and user-friendly. It provides powerful features and reporting
3. Maven - Maven is a popular open-source build tool to build, publish, and deploy several projects at once for better project management. It is used to take care of the dependencies to build the project.
4. Extent Reports - ExtentReports is an open-source reporting library useful for test automation. It can be easily integrated with major testing frameworks like JUnit, NUnit, TestNG, etc. These reports are HTML documents that depict results as pie charts

## **Test Classes**

* **PostNewPet** - 6 Test methods which cover the following test cases:

 1. Add New Pet with a valid request payload. Response payload is validated thereafter.

    Test Validations: Content type header value, Show all headers, Verify Status code, Verification of posted values (name, status), Response time < 2000 ms, Show Response body.

 2. Add new pet without status in the request payload. Response payload is validated thereafter.

    Test Validations: Content type header value, Show all headers, Verify Status code, Verification of posted values (name, blank status value), Show Response time, Show Response body.
   
 3. Add new pet without name in the request payload. Response payload is validated thereafter.

    Test Validations: Content type header value, Show all headers, Verify Status code, Verification of posted values (blank name, status), Show Response time, Show Response body.
   
 4. Add new pet without category in the request payload. Response payload is validated thereafter.

    Test Validations: Content type header value, Show all headers, Verify Status code, Verification of posted values (name, status), Show Response time, Show Response body.
   
 5. Add new pet with blank/no values in the request payload. Response payload is validated thereafter.

    Test Validations: Content type header value, Show all headers, Verify Status code, Verification of error message, Show Response time, Show Response body.
   
 6. Add new pet with new invalid parameters in the request payload. Response payload is validated thereafter.

    Test Validations: Content type header value, Show all headers, Verify Status code, Verification of error message, Show Response time, Show Response body.

* **GetPetByStatus** - 5 Test methods which cover the following test cases:

 1. Get all the pets having 'available' status in the request payload. Response payload is validated thereafter.

    Test Validations: Content type header value, Show all headers, Verify Status code, Response time < 2000 ms, Show Response body.

 2. Get all the pets having 'pending' status in the request payload. Response payload is validated thereafter.

    Test Validations: Content type header value, Show all headers, Verify Status code, Show response time, Show Response body.
   
 3. Get all the pets having 'sold' status in the request payload. Response payload is validated thereafter.

    Test Validations: Content type header value, Show all headers, Verify Status code, Show response time, Show Response body.
   
 4. Get pets with an invalid status value passed in the request payload. Response payload is validated thereafter.

    Test Validations: Content type header value, Show all headers, Verify Status code, Show response time, Show Response body.
   
 5. Get pets if no status value is posted in the request payload. Response payload is validated thereafter.

    Test Validations: Content type header value, Show all headers, Verify Status code, Show response time, Show Response body.

* **PutUpdateExistingPet** - 7 Test methods which cover the following test cases:

 1. Update an existing pet with a valid request payload. Response payload is validated thereafter.

    Test Validations: Content type header value, Show all headers, Verify Status code, Verification of posted values (updated name, updated id, updated status), Response time < 2000 ms, Show Response body.

 2. Update an existing pet without a status value in the request payload. Response payload is validated thereafter.

    Test Validations: Content type header value, Show all headers, Verify Status code, Verification of posted values (updated name, updated id, blank status), Show Response time, Show Response body.
   
 3. Update an existing pet without a name value in the request payload. Response payload is validated thereafter.

    Test Validations: Content type header value, Show all headers, Verify Status code, Verification of posted values (blank name, updated id, updated status), Show Response time, Show Response body.
   
 4. Update an existing pet without a category value in the request payload. Response payload is validated thereafter.

    Test Validations: Content type header value, Show all headers, Verify Status code, Verification of posted values (updated name, updated id, status), Show Response time, Show Response body.
   
 5. Update an existing pet with an incorrect pet ID in the request payload. Response payload is validated thereafter.

    Test Validations: Content type header value, Show all headers, Verify Status code, Verification of pet not found message, Show Response time, Show Response body.
   
 6. Update an existing pet with invalid parameters in the request payload. Response payload is validated thereafter.

    Test Validations: Content type header value, Show all headers, Verify Status code, Verification of error message, Show Response time, Show Response body.
   
 7. Update an existing pet without any updates request payload. Response payload is validated thereafter.

    Test Validations: Content type header value, Show all headers, Verify Status code, Verification of values (name, id, status), Show Response time, Show Response body.

* **DeletePet** - 2 Test methods which cover the following test cases:

 1. Delete an existing pet with a valid pet id in the request payload. Response payload is validated thereafter.

    Test Validations: Status code, Verification of pet deleted message.

 2. Delete a pet by passing an invalid pet ID in the request payload. Response payload is validated thereafter.

    Test Validations: Status code, Verification of pet deleted message.

* **GetFindByStatus** - 2 Test methods to validate the status code & response body verification.

## **Base classes**

* **BaseClass** - This class contains methods to setup Request Builder, Response Builder & Base URL which is used in the Get class.
* **ExtentReport** - This class is used to create HTML Reports. Contains methods to configure the location, name, look & feel of the HTML report. Used in the Delete class.


### **POM.XML**
Available in the root directory and having all needed dependencies and plugins to be used by suite.

https://github.com/nitinkaushik3390/nitin-kaushik-QA/blob/master/Task3/pom.xml

### **TestNG.XML**
TestNG Automation Suite XML File which is having configuration for all test classes to be executed.

https://github.com/nitinkaushik3390/nitin-kaushik-QA/blob/master/Task3/testng.xml

## **Execution Steps**

### **Setup Instructions**:

1. Download and install Eclipse IDE for Java Developers.

2. Verify that the Pets API Endpoints are running by executing any end-point on this swagger link - https://petstore3.swagger.io/

3. Clone this repo : 
   
   https://github.com/nitinkaushik3390/nitin-kaushik-QA.git

4. Import cloned repo in step 3 as Maven project in Eclipse. Open the Task3 folder in the 'Task3' branch:

   File-> Import-> Go to Maven -> Existing Maven Projects. Click on Next
   Choose Task3 folder. And Click on Finish.

5. In import project, right click on pom.xml & run as -> Maven build so that all the dependencies will be uploaded.
 
6. Now to run automation project ,right click on pom.xml & Run as -> Maven Test .All test suites will be executed.

7. Execution reports can be seen under the directory test-output -> DeleteAPItestreport.html / GetAPItestreport.html / PostAPItestreport.html / PutAPItestreport.html files.

## **Execution Report**

 Test Suite is having 20 testcases and after execution, respective reports will be generated under /test-ouput/DeleteAPItestreport.html / GetAPItestreport.html / PostAPItestreport.html / PutAPItestreport.html files.
