# KSU SWE 3643 Software Testing and Quality Assurance Semester Project: Web-Based Calculator
This repository contains an overview of our team's web-based calculator project. This includes the logic for the calculator, the unit as well as en-to-end tests, and the web application and all documentation.
## Table of Contents
- [Architecture](#architecture)
- [Environment](#environment)
- [Executing Unit Tests](#executing-unit-tests)
- [Reviewing Unit Test Coverage](#reviewing-unit-test-coverage)
- [Final Video Presentation](#final-video-presentation)
### Members: Zakkary Byrd, Jonah Gardin



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
This application has only been tested in Windows 10 an Windows 11 but should work in Mac and linux environments
To prepare your environment to execute this application:
1. [Install the latest Java runtime for your system.](https://www.java.com/en/download/manual.jsp)
2. [Install the latest version of Oracle JDK.](https://www.oracle.com/java/technologies/downloads/?er=221886#jdk23-windows)
3. [Install the latest version of Apache Maven.](https://www.geeksforgeeks.org/how-to-install-apache-maven-on-windows/)
4. [Install the latest version of playwrite.](https://playwright.dev/java/docs/intro)


## Executing Unit Tests


## Reviewing Unit Test Coverage

<image src="README.assets/image_13251241.PNG">


## Final Video Presentation
