
Feature:Register Panel
  Scenario Outline: Kayıt işleminde önceden kayıt olunmuş e-mail ile tekrar kayıt olunmaya çalışılması durumunda engelenmeli
    Given Kayıt ol sayfasına gidilir
    When uyelik sayfasinda firstName bolumune "<firstName>" girilir
    And uyelik sayfasinda lastName bolumune "<lastName>" girilir
    And uyelik sayfasında country bolumune "<country>" checkbox secilir
    And uyelik sayfasinda mobileNumber bolumune "<mobileNumber>" girilir
    And uyelik sayfasinda company bolumune "<company>" girilir
    And uyelik sayfasinda email bolumune "<email>" girilir
    And uyelik sayfasinda title bolumune "<title>" checkbox secilir
    And uyelik sayfasinda password bolumune "<password>" girilir
    And uyelik sayfasinda confirmPassword bolumune "<confirmPassword>" girilir
    And KVKK onaylanmalı
    Then Agree&Sign-Up butonu tıkla


    Examples:
      | firstName | lastName | country | mobileNumber | company       | email               |  title                   |   password         |  confirmPassword |
      | Nur       | Test     | +90     | 5555555555   | Test Company  | hnk9833@gmail.com  |  Logistic Manager        |   Pass123!         |  Pass123!        |


