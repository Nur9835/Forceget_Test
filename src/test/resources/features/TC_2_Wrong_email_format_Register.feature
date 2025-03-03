@register
Feature:Register Panel
  Scenario Outline: Kayıt işleminde tüm alanların doğru bir şekilde olması ve e-mail adresi alanında e-mail yazım formatına aykırı olması durumunda Agree&Sign-Up butonu disabled olmalı
    Given Kayıt ol sayfasına gidilir
    And uyelik sayfasinda firstName bolumune "<firstName>" girilir
    And uyelik sayfasinda lastName bolumune "<lastName>" girilir
    And uyelik sayfasında country bolumune "<country>" checkbox secilir
    And uyelik sayfasinda mobileNumber bolumune "<mobileNumber>" girilir
    And uyelik sayfasinda company bolumune "<company>" girilir
    And uyelik sayfasinda email bolumune "<email>" girilir
    And uyelik sayfasinda title bolumune "<title>" checkbox secilir
    And uyelik sayfasinda password bolumune "<password>" girilir
    And uyelik sayfasinda confirmPassword bolumune "<confirmPassword>" girilir
    And KVKK onaylanmalı
    Then uyelik sayfasinda E-mail input border colour kırmızı olmalı ve kayıt işlemi gerçekleşmemeli

    Examples:
    Examples:
      | firstName | lastName | country | mobileNumber | company       | email           |  title                   |  password  | confirmPassword |
      | Nur       | Test     | +90     | 5555555555   | Test Company  | wrong_email55.  |  Logistic Manager        |   Pass123! | Pass123!        |
