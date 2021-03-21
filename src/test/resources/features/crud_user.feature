			@Regression
			Feature: as a user i want an Api(s) to create, delete and update user´s information 
			
			@CRUDCreateUserCheckCode
			Scenario Outline: Create user check status codes
			Given someone  needs to consume the api
			When he creates a user
			|name |job       |
			|<name>|<job>|
			Then he should get the status code <status_code>
			Examples:
			|name|job|status_code|
			|Pedro|Automation|201|
			||Automation|400|
			|Pedro||400|
			|||400|
			
			
			@CRUDCreateUser
			Scenario: Create user check data
			Given someone  needs to consume the api
			When he creates a user
			|name |job       |
			|Sergio|engineer|
			Then he should get the status code 201
			And he should get the response with the data requested
			
			@CRUDDeleteUser
			Scenario: Delete a user
			Given someone  needs to consume the api
			When he creates a user
			|name |job       |
			|Sergio|engineer|
			Then he should get the status code 201
			And he should get the response with the data requested
			When he deletes the user created
			Then he should get the status code 204
			
			
			@CRUDDeleteUserNoExistent
			Scenario: Delete a user an existent user
			Given someone  needs to consume the api
			When he creates a user
			|name |job       |
			|Sergio|engineer|
			Then he should get the status code 201
			And he should get the response with the data requested
			When he deletes the user created
			Then he should get the status code 204
			When he deletes the user created
			Then he should get the status code 404
			
			@CRUDUpdateUser
			Scenario: Updats user´s name and job
			Given someone  needs to consume the api
			When he creates a user
			|name |job       |
			|Sergio|engineer|
			Then he should get the status code 201
			And he should get the response with the data requested
			When he update the user last created user
			|name |job       |
			|pedro|Barman|
			Then he should get the status code 200
			Then he should get the update response with the data requested
			Examples:
			|name|job|
			|Pedro|Barman|
			
			@CRUDUpdateUserCheckStatusCode
			Scenario Outline: Update user check status codes
			Given someone  needs to consume the api
			When he creates a user
			|name |job       |
			|Sergio|engineer|
			Then he should get the status code 201
			And he should get the response with the data requested
			When he update the user last created user
			|name |job       |
			|<name>|<job>|
			Then he should get the status code <status_code>
			Then he should get the update response with the data requested
			Examples:
			|name|job|status_code|
			|Pedro|Barman|200|
			|||200|
			||Comedian|200|
			|Laura||200|
			
			@CRUDE2E
			Scenario: create a user, update and delete it
			Given someone  needs to consume the api
			When he creates a user
			|name |job       |
			|Sergio|engineer|
			Then he should get the status code 201
			And he should get the response with the data requested
			When he update the user last created user
			|name |job       |
			|pedro|Barman|
			Then he should get the status code 200
			Then he should get the update response with the data requested
			When he deletes the user created
			Then he should get the status code 204
