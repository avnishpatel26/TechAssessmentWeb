@APIAutomation
Feature: API Automation

Scenario: UnSuccessful User Registration
When user set Rest API url
And user set Header param request  with "Content-Type" as "application/json"
And send a POST HTTP Request to register with email : "eve.holt@reqres.in"
Then user receive HTTP response code 400

Scenario: Successful User Registration
When user set Rest API url
And user set Header param request  with "Content-Type" as "application/json"
And send a POST HTTP Request to register with email : "eve.holt@reqres.in" and password: "pistol"
Then user receive HTTP response code 200

Scenario: Successful user registration and deletion
When user set Rest API url
And user set Header param request  with "Content-Type" as "application/json"
And send a POST HTTP Request to create a user with name : "Jazz" and job: "leader"
Then user receive HTTP response code 201
And user set Header param request  with "Content-Type" as "application/json"
And user sends a DELETE HTTP Request to delete last created user
Then user receive HTTP response code 204

Scenario: Get list of users from Page
When user set Rest API url
And send a GET HTTP Request to fetch list of users from page "2"
Then user receive HTTP response code 200
And response should contains list of users from page 2