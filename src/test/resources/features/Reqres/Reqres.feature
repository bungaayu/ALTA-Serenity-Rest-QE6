Feature: Test API in Reqres

  @latihan
  #Scenario 1
  Scenario Outline: Get list user with valid page xyz
    Given get list user with parameter page <page>
    When send request get list user
    Then should return 200 ok
    And response body page should be <page>
    And get list user json schema validator
    Examples:
    |page|
    |1   |
    |2   |

  @tugas
  #Scenario 1.2
  Scenario Outline: Get list user with invalid string parameter
    Given get list user with invalid string parameter "<page>"
    When send request get list user
    Then should return 404 not found
    Examples:
    |page|
    |abc |
    |xxx |

  @tugas
  #Scenario 1.3
  Scenario Outline: Get list user with invalid special char parameter
    Given get list user with invalid special char parameter "<page>"
    When send request get list user
    Then should return 404 not found
    Examples:
      |page|
      |@@@ |
      |?%$ |

  @tugas
  #Scenario 1.4
  Scenario: Get list user without parameter
    Given get list user without parameter
    When send request get list user without parameter
    Then should return 200 ok
    And response body page should be 1

  @latihan
  #Scenario 2.1
  Scenario: Post create new user with valid json
    Given post create new user
    When send request post create new user
    Then should return 201 created
    And response body should contain name "Bunga Ayu" and job "QA Engineer"
    And post create new user json schema validator

  @tugas
  #Scenario 2.2
  Scenario: Post create new user with incomplete json
    Given post create new user with incomplete json
    When send request post create new user
    Then should return 400 bad request

  @tugas
  #Scenario 3.1
  Scenario Outline: Get single user with valid id
    Given get single user with id <id>
    When send request get single user
    Then should return 200 ok
    And response body id should be <id>
    Examples:
    |id|
    |1 |
    |2 |

  @tugas
  #Scenario 3.2
  Scenario Outline: Get single user not found
    Given get single user with id <id>
    When send request get single user
    Then should return 404 not found
    Examples:
    |id|
    |13|
    |50|

  @tugas
  #Scenario 3.3
  Scenario Outline: Get single user with invalid string id
    Given get single user with invalid string id "<id>"
    When send request get single user
    Then should return 404 not found
    Examples:
      |id|
      |xxx |
      |abc |

  @tugas
  #Scenario 3.4
  Scenario Outline: Get single user with invalid special char id
    Given get single user with invalid special char id "<id>"
    When send request get single user
    Then should return 404 not found
    Examples:
      |id|
      |??? |
      |$#% |

  @tugas
  #Scenario 3.5
  Scenario: Get single user without parameter
    Given get single user without parameter
    When send request get single user without parameter
    Then should return 200 ok
    And response body page should be 1

  @latihan
  #Scenario 4.1
  Scenario Outline: Put update user with valid json
    Given put update user with id <id>
    When send request put update user
    Then should return 200 ok
    And response body should contain name "Bunga Edit" and job "QA Edit"
    And put update user json schema validator
    Examples:
    |id|
    |1 |
    |2 |

  @tugas
  #Scenario 4.2
  Scenario Outline: Put update user with incomplete json
    Given put update user incomplete json with id <id>
    When send request put update user
    Then should return 400 bad request
    Examples:
      |id|
      |1 |
      |2 |

  @tugas
  #Scenario 5.1
  Scenario Outline: Patch update user with incomplete json
    Given patch update user with id <id>
    When send request patch update user
    Then should return 200 ok
    And response body should contain name "Bunga Edit Incomplete JSON for Patch"
    Examples:
      |id|
      |1 |
      |2 |

  @tugas
  #Scenario 5.2
  Scenario Outline: Patch update user with complete json
    Given patch update complete user with id <id>
    When send request patch update user
    Then should return 400 bad request
    Examples:
      |id|
      |1 |
      |2 |

  @latihan
  #Scenario 6.1
  Scenario Outline: Delete user with valid id
      Given delete user with valid id <id>
      When send request delete user
      Then should return 204 no content
      Examples:
      |id|
      |1 |
      |2 |

  @tugas
  #Scenario 6.2
  Scenario Outline: Delete user with invalid string id
    Given delete user with invalid string id "<id>"
    When send request delete user
    Then should return 404 not found
    Examples:
      |id|
      |abc |
      |xxx |

  @tugas
  #Scenario 6.3
  Scenario Outline: Delete user with invalid special char id
    Given delete user with invalid special char id "<id>"
    When send request delete user
    Then should return 404 not found
    Examples:
      |id|
      |%%% |
      |@*& |

  @tugas
  #Scenario 6.4
  Scenario: Delete user without parameter id
    Given delete user without parameter id
    When send request delete user without parameter id
    Then should return 404 not found

  @tugas
  #Scenario 7.1
  Scenario: Get list resource without path
    Given get list resource without path
    When send request get list resource without path
    Then should return 200 ok
    And response body page should be 1

  @tugas
  #Scenario 7.2
  Scenario Outline: Get list resource with valid parameter
    Given get list resource with parameter page <page>
    When send request get list resource
    Then should return 200 ok
    And response body page should be <page>
    Examples:
    |page|
    |1   |
    |2   |

  @tugas
  #Scenario 7.3
  Scenario Outline: Get list resource with invalid string parameter
    Given get list resource with invalid parameter page "<page>"
    When send request get list resource
    Then should return 404 not found
    Examples:
      |page|
      |abc |
      |xxx |

  @tugas
  #Scenario 7.4
  Scenario Outline: Get list resource with not listed parameter page
    Given get list resource with parameter page <page>
    When send request get list resource
    Then should return 200 ok
    And response body page should be <page>
    Examples:
      |page|
      |3   |
      |12  |

  @tugas
  #Scenario 7.5
  Scenario Outline: Get list resource with invalid special char parameter
    Given get list resource with invalid parameter page "<page>"
    When send request get list resource
    Then should return 404 not found
    Examples:
      |page|
      |abc |
      |xxx |

  @tugas
  #Scenario 8.1
  Scenario Outline: Get single resource with valid id
    Given get single resource with id <id>
    When send request get single resource
    Then should return 200 ok
    And response body id should be <id>
    Examples:
      |id|
      |1 |
      |2 |

  @tugas
  #Scenario 8.2
  Scenario Outline: Get single resource not found
    Given get single resource with id <id>
    When send request get single resource
    Then should return 404 not found
    Examples:
      |id|
      |13 |
      |50 |

  @tugas
  #Scenario 8.3
  Scenario Outline: Get single resource with invalid string id
    Given get single resource with invalid id "<id>"
    When send request get single resource
    Then should return 404 not found
    Examples:
      |id|
      |bunga |
      |dairy |

  @tugas
  #Scenario 8.4
  Scenario Outline: Get single resource with invalid special char id
    Given get single resource with invalid id "<id>"
    When send request get single resource
    Then should return 404 not found
    Examples:
      |id|
      |*** |
      |;):$|

  @tugas
  #Scenario 9.1
  Scenario: Post register with valid json
    Given post register new user
    When send request post register new user
    Then should return 200 ok

  @tugas
  #Scenario 9.2
  Scenario: Post register with invalid json
    Given post register new user invalid json
    When send request post register new user
    Then should return 400 bad request

  @tugas
  #Scenario 10.1
  Scenario: Post login with valid json
    Given post login with valid json
    When send request post login
    Then should return 200 ok

  @tugas
  #Scenario 10.2
  Scenario: Post login with unregistered user
    Given post login with unregistered user
    When send request post login
    Then should return 400 bad request

  @tugas
  #Scenario 10.3
  Scenario: Post login with incomplete data
    Given post login with incomplete json
    When send request post login
    Then should return 400 bad request
