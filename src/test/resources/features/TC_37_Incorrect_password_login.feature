
Feature:Login Panel
  Scenario Outline: Giriş Yap sayfasında kayıtlı e-mail ve yanlış passwordle giriş yapılmaya çalışması sonucunda  uyarı verilmeli
    Given Kayıt ol sayfasına gidilir
    When  Sign In linkine tıklanır
    Then Giriş yap sayfasına yönlendirildiği kanıtlanır
    When giriş yap sayfasinda email bolumune "<email>" girilir
    And giriş yap sayfasinda password bolumune "<password>" girilir
    And Sign In butonu tıklanır
    Then Parola doğrulama başarısız oldu uyarısı alınmalı


    Examples:

      | email               | password       |
      | hnk-98@hotmail.com  | PassXO123!     |


