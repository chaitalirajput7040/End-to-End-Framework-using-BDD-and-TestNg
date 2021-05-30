
@Regression
Feature: Testing Onlin Fruit and Veggies App


  @Login
  Scenario: Login to Online fruits and Veggies App
  Given User launches the app
  |http://192.168.1.100:1080|
    When User gives the username as "Online_User"
    Given User gives the password as "T25saW5lX1VzZXI="
    And some other precondition
   Then User clicks on Login button
   
    
    @Add_to_Cart
    Scenario: Add items into the cart
    Given USer lands on the Add to Cart page 
    And user selects the items and add them to cart 
     |items|quantity|
     |Banana|2|
     |Apple|2|
     |Orange|2|
     |Brinjal|2|
     |Potatoes|2|
     Then Verify the quantity 
     And verify the total items is accurate
     And verify the total cost is accurate
     And User click on the checkout button 
     
     @Checkout
     Scenario: User checksout
     Given: User lands on the checkout page 
    # And Verify the items and Quantity are accurate
     Then User fills the billing address details 
     And User clicks on the checkout button
     
     @OrderPlaced
     Scenario: Order placed 
     Given User lands on the order placed page 
     And User verify the message
     And Verify the details are accurate 
     Then User clicks on logout button 
     
     
     
     
    

