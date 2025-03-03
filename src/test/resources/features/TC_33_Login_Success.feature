
Feature:Login Panel
  Scenario Outline: Giriş Yap sayfasında önceden kayıtlı kullanıcı bilgilerini eksiksiz ve doğru girmesi sonucunda başarılı bir şekilde giriş yapmalı
    Given Kayıt ol sayfasına gidilir
    When  Sign In linkine tıklanır
    Then Giriş yap sayfasına yönlendirildiği kanıtlanır
    When giriş yap sayfasinda email bolumune "<email>" girilir
    And giriş yap sayfasinda password bolumune "<password>" girilir
    And Sign In butonu tıklanır
    Then Başarılı bir şekilde giriş yapıldığı doğrulanır


    Examples:
      | email               | password     |
      | hnk-98@hotmail.com  | Pass123!     |


