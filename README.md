# Flipkart Order Test [Selenium]
### Brief
# Use Case
a. Open https://www.flipkart.com/ in an un-signed state<br>
b. Go to Electronics/Mobile section, choose OPPO<br>
c. Select item with name OPPO Reno<br>
d. Click on ‘Add to Cart’<br>
e. Click on Flipkart main icon to go back to home screen<br>
f. Click on Cart and verify if the item exists in the page.<br>
g. Click on Place Order<br>
h. Login using your account. Make one if you don't have one already.<br>
i. Add order confirmation email and press continue<br>
j. On payments options, select net banking, select Corporation Bank<br>
k. Take a screenshot of the Bank screen.<br>

# Test Run Instructions<br/>
1. Open project in IntelliJ
2. Add configurations in configuration.properties file under resources directory
2. Run the test cases using Maven

# Assumptions
1. Delivery address is already added in users account
2. Confirmation email id is already added
3. Item to be added should be deliverable at mentioned delivery address(since OPPO A3s is not deliverable at multiple locations, used OPPO Reno3)