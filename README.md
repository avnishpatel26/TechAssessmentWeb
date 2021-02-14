# TechAssessmentWeb
Technical assessment for Website

Setup the the Solution: Using the IDE import the maven Project into the work space. Build the solution from within the IDE and maven will automatically download the required java dependencies.

Running the Test cases: Corresponding Tag has been provided to the feature file in order to run it. 
The test here can be executed using the tag @APIAutomation to run test from APIAutomation.feature and @WebAutomation to run WebApplication.feature
Runner classes are maintained under '/src/test/java/com/cucumbertest/stepdefs/WebTestRunner.java' & other one is 'APITestRunner.java'. 
Provide the tag name under tags field and run the AcceptanceTest Class as junit.

Analyzing the Test Results with help of Extent Reports: 
An extent Report will be generated at '/target/cucumber-reports/report.html' inside the project folder after the test run is completed. 
Open the report into a web browser (Chrome is highly recomended for better results). 
A sample report is already present in the root folder of the current solution.
