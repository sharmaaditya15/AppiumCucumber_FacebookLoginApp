#Author: Aditya Sharma
Feature: Login to Facebook and like Fetch Rewards' page

  Scenario Outline: Like the Fetch Rewards page
    Given user opens the Facebook
    When enter username <username> and password <password>
    And click on Login button
    And search for Fetch Rewards and hit enter
    Then click on Like button

    Examples: 
      | username               | password      |
      | mytestuser15@gmail.com | Test@Password |

      #This is a auto-deleting user and will be delete in 8 days (by 11/06 ) , please update the username and passowrd for FB login 