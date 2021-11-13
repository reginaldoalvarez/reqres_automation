Feature: As a user i want and api to get all users registered in the platform

  @login
  Scenario: check that the maximum results per page is 6
    Given that Pedro connects to the api
    When he tries to log with credentials
      | email              | password   |
      | eve.holt@reqres.in | cityslicka |


  @login
  Scenario: check that the maximum results per page is 6
    Given that Pedro connects to the api
    When he tries to log with credentials
      | email              | password   |
      | eve.holt@reqres.in | cityslicka |
  Then he should see the status code 200
    #And he tries to log with credentials
    #  | email              | password   | first_name | last_name |
     # | eve.holt@reqres.in | cityslicka | pedro      | velez     |
    #And he tries to log with credentials
    #  | email              | first_name | last_name |
    #  | eve.holt@reqres.in | pedro      | velez     |
    #And he tries to log with credentials
    #  | email              | first_name | avatar |
    #  | eve.holt@reqres.in | pedro      | cosa   |


