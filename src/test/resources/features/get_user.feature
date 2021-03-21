			@Regression2
			Feature: as a user i want an Api(s) to retrieve the user´s information 
			
			@GetUSersIdCheckData
			Scenario: get specific user data
				Given someone  needs to consume the api
				When he searches the user with id 3
				Then he should get the status code 200
				And he should get the same user info
				|email							|first_name|last_name|avatar																 |
				|emma.wong@reqres.in|Emma			 |Wong		 |https://reqres.in/img/faces/3-image.jpg|

			@GetUSersIdCheck404
			Scenario: get specific user data with no existet id
				Given someone  needs to consume the api
				When he searches the user with id 2001
				Then he should get the status code 404
				
			@GetUSersCheckTotal
			Scenario: get all user data and check total users retrieved
				Given someone  needs to consume the api
				When he searches all users
				Then he should get the status code 200
				Then he should get the same as user quantity as the field TOTAL
				
			@GetUSersCheckUsersPerPage
			Scenario: get all user data and check total users retrieved
				Given someone  needs to consume the api
				When he searches all users
				Then he should get the status code 200
				Then he should get the same as user quantity as the field PER_PAGE
				
			@GetUSersCheckUsersTotalPages
			Scenario: get all user data and check total users retrieved
				Given someone  needs to consume the api
				When he searches all users
				Then he should get the status code 200
				Then he should get the same as user quantity as the field TOTAL_PAGES
