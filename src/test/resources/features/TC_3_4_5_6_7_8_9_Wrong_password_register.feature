
Feature:Register Panel
  Scenario Outline: Kayıt işleminde tüm alanların doğru bir şekilde olması ve  şifre rakam, harf ve en az 8 karakterden oluşmadığı durumda uyarı vermeli
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
    And Agree&Sign-Up butonu tıkla
    Then Password is not strong enough uyarısı vermeli

    Examples:
      | firstName | lastName | country | mobileNumber | company       | email              |  title                   |   password         |  confirmPassword |
      | Nur       | Test     | +90     | 5555555555   | Test Company  | hnk9833@gmail.com  |  Logistic Manager        |   p                |  p               |
      | Nur       | Test     | +90     | 5555555555   | Test Company  | hnk9833@gmail.com  |  Logistic Manager        |   3                |  3               |
      | Nur       | Test     | +90     | 5555555555   | Test Company  | hnk9833@gmail.com  |  Logistic Manager        |   !                |  !               |
      | Nur       | Test     | +90     | 5555555555   | Test Company  | hnk9833@gmail.com  |  Logistic Manager        |   PP3              |  PP3             |
      | Nur       | Test     | +90     | 5555555555   | Test Company  | hnk9833@gmail.com  |  Logistic Manager        |   pp3              |  pp3             |
      | Nur       | Test     | +90     | 5555555555   | Test Company  | hnk9833@gmail.com  |  Logistic Manager        |   Pp3              |  Pp3             |
      | Nur       | Test     | +90     | 5555555555   | Test Company  | hnk9833@gmail.com  |  Logistic Manager        |   Pas1!            |  Pas1!           |
      | Nur       | Test     | +90     | 5555555555   | Test Company  | hnk9833@gmail.com  |  Logistic Manager        |   PASSWORD123!     |  PASSWORD123!    |
      | Nur       | Test     | +90     | 5555555555   | Test Company  | hnk9833@gmail.com  |  Logistic Manager        |   password123!     |  password123!    |
      | Nur       | Test     | +90     | 5555555555   | Test Company  | hnk9833@gmail.com  |  Logistic Manager        |   Password!        |  Password!       |
      | Nur       | Test     | +90     | 5555555555   | Test Company  | hnk9833@gmail.com  |  Logistic Manager        |   Password123      |  Password123     |


