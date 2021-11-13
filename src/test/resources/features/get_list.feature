
  Feature: As a user i want and api to get all users registered in the platform

    @listUSersMaximum
    Scenario: check that the maximum results per page is 6
      Given that Pedro connects to the api
      When he get the list of user in the page 1
      Then he should see a maximum of 6 users per page
