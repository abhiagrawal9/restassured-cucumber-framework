Feature: Login Feature

Scenario: Home Page Login default
Given User is on the login page
When User login in to app with valid username and password
Then User should see the home page
And Products are displaying