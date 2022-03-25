Feature: Login into Application

Scenario Outline: Positive test validation login
Given Initiate the browser with chrome
And Navigate to "https://qaclickacademy.com" Site
And Click on Login link in home page to land on Secure Sign page
When User enter <username> and <password> and logs in
Then Verify that user is successfully logged in

Examples:
|username					|password	|
|test99@gmail.com	|123456		|	
|test00@gmail.com	|123456		|