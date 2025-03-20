Feature: Cart Functionality

  Scenario: Add item to cart and proceed to checkout
    Given I am on a product page
    When I add the product to the cart
    And I navigate to the cart
    Then I should be able to proceed to checkout
