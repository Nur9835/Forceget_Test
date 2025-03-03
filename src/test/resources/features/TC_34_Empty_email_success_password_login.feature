
Feature:Login Panel
  Scenario Outline: Giriş Yap sayfasında e-mail alanı boş bırakılıp giriş yapılmaya çalışması sonucunda  uyarı verilmeli
    Given Kayıt ol sayfasına gidilir
    When  Sign In linkine tıklanır
    Then Giriş yap sayfasına yönlendirildiği kanıtlanır
    When giriş yap sayfasinda email bolumune "<email>" girilir
    And giriş yap sayfasinda password bolumune "<password>" girilir
    And Sign In butonu tıklanır
    Then Lütfen gerekli alanları doldurun! uyarısı verilmeli

    Examples:
      | email    | password     |
      |          | Pass123!     |

