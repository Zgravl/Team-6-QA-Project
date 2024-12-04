# KSU SWE 3643 Software Testing and Quality Assurance Semester Project: Web-Based Calculator
This repository contains an overview of our team's web-based calculator project. This includes the logic for the calculator and the unit tests.
This project was completed as of 11:40PM 12/3/2024
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
    - It is implemented in Java, separate from the web server or user interface.
    - Responsibility: Accept inputs, perform calculations, and return results.
- Unit Test Module
    The Unit tests ensure that the calculator's logic works as expected, independently of the web server or user interface.
    - This module is crucial for identifying and fixing bugs early in development.
    - Responsibility: Validate each method's correctness under normal, edge, and error conditions.
- Relationships
    - Unit tests provide inputs to the methods and verify that the outputs match expected values.
    - Unit tests simulate edge cases (e.g., dividing by zero) to ensure the logic handles these correctly.
    - Unit tests also act as a regression preventer, making sure that new changes don't break existing functionality.
<image src="README.assets/Architecture Diagram.png">
  
### Modules: 
- **Calculator logic**
  - SampleStandardDeviation: Takes a list of one or more numeric values (one per line) and computes the sample standard deviation.
  - PopulationStandardDeviation: Takes a list of two or more numeric values (one per line) and computes the population standard deviation.
  - Mean: Takes a list of one or more numeric values (one per line) and computes the mean
  - ZScore: Takes a list of three numeric values (three values separated by commas on one line) and computes the ZScore
  - LinearRegression: Takes a list of two or more x,y number pairs (only one pair per line) and computes the Single Linear Regression
  - RegressionPrediction: Takes a list of three numeric values (three values separated by commas on one line) and predicts Y from the linear regression formula
- **Unit Tests**
  - each logic module has a corresponding test module which tests all lines of logic and error handling
  - each unit test has 100% coverage for its corresponding logic module


## Environment
This application has only been tested in Windows 10 and Windows 11 but should work in Mac and Linux environments<br>
[To prepare your environment to execute this application]:<br>
__Set up Java and Oracle JDK__
1. [Install the latest Java runtime for your system.](https://www.java.com/en/download/manual.jsp)
2. [Install the latest version of Oracle JDK (x64 Installer).](https://www.oracle.com/java/technologies/downloads/?er=221886#jdk23-windows)
3. After installing the JDK, search for Environment Variables in the start menu.
4. Under system Variables click New and set the variable name to ```JAVA_HOME``` and set the variable value to the path you installed the JDK (ex: C:\Program Files\Java\jdk-XX) and hit OK.
5. Find the ```path``` variable under System Variable and double-click it.
6. Press new and add ```%JAVA_HOME%\bin``` to the list and hit OK.

__Set up Maven__
1. First ensure that java and JDK are installed you can do this by executing ```java -version``` and ```javac -version``` in the command line.
2. [Install the latest version of Apache Maven.](https://maven.apache.org/)
3. [Steps on how to install](https://www.geeksforgeeks.org/how-to-install-apache-maven-on-windows/)
4. After installing, search for Environment Variables in the start menu.
5. Under System Variables click New and set the variable name to ```MAVEN_HOME``` and set the variable value to the path you installed the JDK (ex: C:\Program Files\apache-maven-XX) and hit OK.
6. Find the ```path``` variable under System Variable and double-click it.
7. Press new and add ```%MAVEN_HOME%\bin``` to the list and hit OK.
8. verify the installation by executing the command ```mvn -v``` in a command prompt and it should display the version of Maven and Java you have installed.

## Executing Unit Tests
1. Make sure that you have maven, java, as well as a JDK installed installed
2. Open the project file on your computer and copy the address of the first src file (This should look something like C:\Users\user\Documents\Team-6-QA-Project-main\Team-6-QA-Project-main\src)
3. open your terminal/command prompt and give the command cd + the address for your root file (Should look something like cd C:\Users\user\Documents\Team-6-QA-Project-main\Team-6-QA-Project-main\src)
4. To run the test execute the command ```mvn test```
5. If Maven, java, and your JDK are properly installed it should return something like this:

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
The tests for each class achieve a 100% coverage on all statements and paths
<image src="README.assets/Coverage Test.PNG">

## Final Video Presentation
**[Please watch our project presentation on YouTube](https://youtu.be/-kdr4BC3WzE).**
