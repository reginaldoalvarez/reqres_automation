Feature: Como usuario de reqrest yo quiero cargar la Api para traer todos los usuarios registrados

  @listUserMaximum
  Scenario: check that the maxinum results per page is 6
    Given that Pedro connets to the api
    When he get the list of user in thr page 1
    Then he should get a maximum 6 user per page