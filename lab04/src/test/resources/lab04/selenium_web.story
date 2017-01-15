Scenario: Failed login 1

Given a SignInForm
When set login and password to demo and demo1
Then browser should give an authentication error

Scenario: Failed login 2

Given a SignInForm
When set login and password to demo1 and demo
Then browser should give an authentication error

Scenario: Failed login 3

Given a SignInForm
When set login and password to demo1 and demo1
Then browser should give an authentication error

Scenario: Login Success 

Given a SignInForm
When set login and password to demo and demo
Then should get home title

Scenario: After Logout

When click on logout button
Then should get logout title

Scenario: Go back to SignIn

When click on relog button
Then should get signin title