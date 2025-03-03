
Feature:Login Panel
  Scenario Outline: Giriş Yap sayfasında password alanı boş bırakılıp giriş yapılmaya çalışması sonucunda  uyarı verilmeli
    Given Kayıt ol sayfasına gidilir
    When  Sign In linkine tıklanır
    Then Giriş yap sayfasına yönlendirildiği kanıtlanır
    When giriş yap sayfasinda email bolumune "<email>" girilir
    And giriş yap sayfasinda password bolumune "<password>" girilir
    And Sign In butonu tıklanır
    Then Lütfen Şifrenizi girin! uyarısı verilmeli

    Examples:
      | email              | password     |
      | hnk9833@gmail.com  |              |

