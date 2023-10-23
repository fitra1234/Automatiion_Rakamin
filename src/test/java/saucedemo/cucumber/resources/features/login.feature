Feature: Login, Add to chart, And Remove chart aplikasi soucedemo
@Regression @Positive
Scenario: Success Login
Given halaman login saucedemo
  When Input Username
  And  Input Password
  And  Click login button
  Then User in on dashboard page

  @Regression @Negative
  Scenario: Failed Login
    Given halaman login saucedemo
    When Input Lockout Username
    And  Input Password
    And  Click login button
    Then User Get Error Message

  @Regression @Positive
  Scenario: Add to Chart Bike Light
    Given halaman login saucedemo
    When Input Username
    And  Input Password
    And  Click login button
    And User in on dashboard page
    Then Click Add to Chart Bike Light

  @Regression @Positive
  Scenario: Delete Bike Light from Chart
    Given halaman login saucedemo
    When Input Username
    And  Input Password
    And  Click login button
    And User in on dashboard page
    And Click Add to Chart Bike Light
    Then Click Remove Chart

