# KSU SWE 3643 Software Testing and Quality Assurance Semester Project: Web-Based Calculator
This repository contains an overview of our team's web-based calculator project. This includes the logic for the calculator, the unit as well as en-to-end tests, and the web application and all documentation.
## Table of Contents
- [Architecture](#architecture)
- [Environment](#environment)
- [Executing the Web Application](#executing-the-web-application)
- [Executing Unit Tests](#executing-unit-tests)
- [Reviewing Unit Test Coverage](#reviewing-unit-test-coverage)
- [Executing End-To-End Tests](#executing-end-to-end-tests)
- [Final Video Presentation](#final-video-presentation)
### Members: Zakkary Byrd, Jonah Gardin



## Architecture
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
- **Web Server**
- **End-to-End Tests**

## Environment
