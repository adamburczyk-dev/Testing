Feature: New Order
  Scenario Outline: Create and delete New Address

    Given An open browser with https://prod-kurs.coderslab.pl
    And Logged in user

    When Search a product
    And Check Discount
    And Choose Size <Size> and count <Count>
    And Add to Cart
    And Go to checkout
    And Set Delivery Conditions
    And Take a screenshot

    Then Order has status Awaiting check Payment and values are valid
    And tearDown


    Examples:

    |Size|Count|
    |L   |5    |

