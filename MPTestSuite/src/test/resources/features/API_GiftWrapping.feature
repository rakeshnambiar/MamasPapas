Feature: To verify the various functionalities in the Gift Wrapping REST API

  @TC01_APIGiftWrappingTest
  Scenario: To check minimum '1' item is available or not
    When Gift Wrapper REST Service is available
    When I hit to service with proper credential to get the available Gift Wrappers
    Then Service should return the successful response code '200'
    And Minimum one item should available under the 'Item' array node


  @TC02_APIGiftWrappingTest
  Scenario: To check 'base_currency' in the response
    When I have a successful response from Gift Wrapping REST API
    When I check the 'base_currency' tag in the response
    Then I should see the tag without null value


  @TC03_APIGiftWrappingTest
  Scenario: To check 'base_price' in the response
    When I have a successful response from Gift Wrapping REST API
    When I check the 'base_price' tag in the response
    Then I should see the tag without null value