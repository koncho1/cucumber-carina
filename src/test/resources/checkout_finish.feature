Feature: Is checkout feature working correctly?

  Scenario: Standard user checks out
    Given user "standard_user" logs in with valid credentials
    And adds products to cart
    And finishes checkout
    Then checkout is succesful