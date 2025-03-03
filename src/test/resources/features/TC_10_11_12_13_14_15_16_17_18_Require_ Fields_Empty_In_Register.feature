
Feature:Register Panel
  Scenario Outline: Kayıt işleminde zorunlu alanların her birinin boş bırakılması sonucunda Agree&Sign-Up butonu disabled olmalı
    Given Kayıt ol sayfasına gidilir
    When uyelik sayfasinda firstName bolumune "<firstName>" girilir
    And uyelik sayfasinda lastName bolumune "<lastName>" girilir
    And uyelik sayfasında country bolumune "<country>" checkbox secilir
    And uyelik sayfasinda mobileNumber bolumune "<mobileNumber>" girilir
    And uyelik sayfasinda company bolumune "<company>" girilir
    And uyelik sayfasinda email bolumune "<email>" girilir
    And uyelik sayfasinda title bolumune "<title>" checkbox secilir
    And KVKK onaylanmalı
    And uyelik sayfasinda password bolumune "<password>" girilir
    And uyelik sayfasinda confirmPassword bolumune "<confirmPassword>" girilir



    Examples:
      | firstName | lastName | country | mobileNumber | company       | email              |  title                   |   password         |  confirmPassword |
      |           | Test     | +90     | 5555555555   | Test Company  | hnk9833@gmail.com  |  Logistic Manager        |   Pass123!         |  Pass123!        |
      | Nur       |          | +90     | 5555555555   | Test Company  | hnk9833@gmail.com  |  Logistic Manager        |   Pass123!         |  Pass123!        |
      | Nur       | Test     |         | 5555555555   | Test Company  | hnk9833@gmail.com  |  Logistic Manager        |   Pass123!         |  Pass123!        |
      | Nur       | Test     | +90     |              | Test Company  | hnk9833@gmail.com  |  Logistic Manager        |   Pass123!         |  Pass123!        |
      | Nur       | Test     | +90     | 5555555555   |               | hnk9833@gmail.com  |  Logistic Manager        |   Pass123!         |  Pass123!        |
      | Nur       | Test     | +90     | 5555555555   | Test Company  |                    |  Logistic Manager        |   Pass123!         |  Pass123!        |
      | Nur       | Test     | +90     | 5555555555   | Test Company  | hnk9833@gmail.com  |                          |   Pass123!         |  Pass123!        |
      | Nur       | Test     | +90     | 5555555555   | Test Company  | hnk9833@gmail.com  |  Logistic Manager        |                    |  Pass123!        |
      | Nur       | Test     | +90     | 5555555555   | Test Company  | hnk9833@gmail.com  |  Logistic Manager        |   Pass123!         |                  |
