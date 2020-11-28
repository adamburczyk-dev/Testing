Feature: New Address
  Scenario Outline: Create and delete New Address

    Given An open browser with https://prod-kurs.coderslab.pl
    And Logged in user

    When User click in Create New Address button
    And A keyword <Alias> is entered in Alias field
    And A keyword <Address> is entered in Address field
    And A keyword <City> is entered in City field
    And A Zip/Postal Code <Zip/Postal> is entered in Zip/Postal field
    And A Phone number <Phone> is entered in Phone field
    And A new address is saved

    Then Data validation <ExpectedAlias> <ExpectedAddress> <ExpectedCity> <ExpectedZip/Postal> <ExpectedPhone>
    And Deleting the created address
    And Logout and close browser

    Examples:
      |Alias  |ExpectedAlias  |Address    |ExpectedAddress  |City   |ExpectedCity|Zip/Postal  |ExpectedZip/Postal  |Phone        |ExpectedPhone|
      |Quaro  |Quaro          |Bazarowa   |Bazarowa         |Hell   |Hell        |66-666      |66-666              |666-666-666  |666-666-666  |



