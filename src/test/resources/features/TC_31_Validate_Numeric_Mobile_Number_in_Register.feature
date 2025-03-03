
Feature:Register Panel
  Scenario Outline: Kayıt işleminde mobilenumber alanına sayısal değer dışında herhangi bir kaydın yapılması engellenmeli
    Given Kayıt ol sayfasına gidilir

    And uyelik sayfasinda mobileNumber bolumune "<mobileNumber>" girilir
    Then "<mobileNumber>" alanında sadece sayısal değerin olduğu kanıtlanır


    Examples:
      | mobileNumber |
      | Nur66        |


