# KSU SWE 3643 Software Testing and Quality Assurance Semester Project: Web-Based Calculator
This repository contains an overview of our team's web-based calculator project. This includes the logic for the calculator and the unit tests. 
## Table of Contents
- [Team Members](#team-members)
- [Architecture](#architecture)
- [Environment](#environment)
- [Executing Unit Tests](#executing-unit-tests)
- [Reviewing Unit Test Coverage](#reviewing-unit-test-coverage)
- [Final Video Presentation](#final-video-presentation)

### Team Members: Zakkary Byrd, Jonah Gardin

## Architecture

- Core Calculator Logic Module
    - This module contains the core computational functionality.
    - It is implemented in java, separate form the web server or user interface.
    - Responsibility : Accept inputs, perform calculations, and return results.
- Unit Test Module
    - The Unit tests ensure that the logic in the Calculator works as expected, independently of the web server or user interface.
    - This module is crucial for identifying and fixing bugs early in the development process.
    - Responsibility: Validate each method's correctness under normal, edge, and error conditions.
- Relationships
    - Unit tests provide inputs to the methods and verify that the outputs match expected values.
    - Unit tests simulate edge cases to (e.g., dividing by zero) to ensure that the logic handles these correctly.
    - Unit tests also act as a regression preventer, making sure that new changes don't break exisiting functionality.
  
### Modules: 
- **Calculator logic**
  - SampleStandardDeviation: Takes a list of one or more numeric values (one per line) and computes the sample standard deviation.
  - PopulationStandardDeviation: Takes a list of two or more numeric values (one per line) and computes the population standard deviation.
  - Mean: Takes a list of one or more numeric values (one per line) and computes the mean
  - ZScore: Takes a list of three numeric values (three values seperated by commas on one line) and computes the ZScore
  - LinearRegression: Takes a list of two or more x,y number pairs (only one pair per line) and computes the Single Linear Regression
  - RegressionPrediction: Takes a list of three numeric values (three values seperated by commas on one line) and predicts Y from the linear regression formula
- **Unit Tests**
  - each logic module has a corresponding test module which tests all lines of logic and error handling
  - each unit test has 100% coverage for their corresponding logic module


## Environment
This application has only been tested in Windows 10 an Windows 11 but should work in Mac and linux environments<br>
[To prepare your environment to execute this application]:
1. [Install the latest Java runtime for your system].(https://www.java.com/en/download/manual.jsp)
2. 
[Install the latest version of Oracle JDK.](https://www.oracle.com/java/technologies/downloads/?er=221886#jdk23-windows)
1. You will need to 
[Install the latest version of Apache Maven.](https://www.geeksforgeeks.org/how-to-install-apache-maven-on-windows/)

## Executing Unit Tests
1. Make sure that you have maven, java, as well as a jdk installed installed
2. Open the project file on your computer and copy the address of the first src file (This should look something like C:\Users\user\Documents\Team-6-QA-Project-main\Team-6-QA-Project-main\src)
3. open your terminal/command prompt and give the command cd + the addres for your root file (Should look something like cd C:\Users\user\Documents\Team-6-QA-Project-main\Team-6-QA-Project-main\src)
4. To run the test execute the folling command:
```
mvn test
```
5. If maven, java, and your jdk are properly installed it should return something like

```plaintext
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running LinearRegressionTest
[INFO] Tests run: 9, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.047 s -- in LinearRegressionTest
[INFO] Running MeanTest
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.005 s -- in MeanTest
[INFO] Running PopulationStandardDeviationTest
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.006 s -- in PopulationStandardDeviationTest
[INFO] Running RegressionPredictionTest
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.009 s -- in RegressionPredictionTest
[INFO] Running SampleStandardDeviationTest
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.007 s -- in SampleStandardDeviationTest
[INFO] Running ZScoreTest
[INFO] Tests run: 7, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.008 s -- in ZScoreTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 39, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.335 s
[INFO] Finished at: 2024-12-03T13:22:36-08:00
[INFO] ------------------------------------------------------------------------
```

## Reviewing Unit Test Coverage
The tests for each class achieve a 100% covereage on all statements and paths
<image src="README.assets/image_13251241.PNG">

## Final Video Presentation
