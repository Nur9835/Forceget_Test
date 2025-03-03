
Feature:Login Panel
  Scenario Outline: Giriş Yap sayfasında kayıtlı olmayan e-mail ve password  ile giriş yapılmaya çalışması sonucunda  uyarı verilmeli
    Given Kayıt ol sayfasına gidilir
    When  Sign In linkine tıklanır
    Then Giriş yap sayfasına yönlendirildiği kanıtlanır
    When giriş yap sayfasinda email bolumune "<email>" girilir
    And giriş yap sayfasinda password bolumune "<password>" girilir
    And Sign In butonu tıklanır
    Then Yanlış e-mail veya passsword uyarısı alınmalı


    Examples:
      | email                 | password     |
      | hnk983300@gmail.com   | Pass123!     |


