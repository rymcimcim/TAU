Scenario: Login Success 

Given a SignInForm
When set login and password to demo and demo
Then should get home title

Scenario: Go to subpages

Given a SidePanel
When click on subpages link
Then should get subpages title

When click on selectAdd link
Then should get gallery title

Scenario: After Logout

When click on logout button
Then should get logout title

Scenario: Go back to SignIn

When click on relog button
Then should get signin title