#Feature: Negative Login Tests
#    We use datatable for testing
#  Scenario:
#    When Admin user enters login credentials
#      | Username           | Password             | ErrorMessage              |
#      |                    | Exelent2022Sdet!     | Username cannot be empty  |
#      | Admin              |                        | Password cannot be empty  |
#      | Admin              | InvalidPass           | Invalid credentials       |
#      | InvalidUsername    | Exelent2022Sdet!      | Invalid credentials       |
#
#    Then login negative tests are successfully