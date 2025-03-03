
Feature:Login Panel
  Scenario : Giriş Yap sayfasında bulunan Forgot password link button'un Şifremi unuttum sayfasına yönlendirmeli
    Given Kayıt ol sayfasına gidilir
    When Sign In linkine tıklanır
    And Giriş yap sayfasına yönlendirildiği kanıtlanır
    And Forgot password link butonuna tıklanır
    Then Şifremi unuttum sayfasına yönlendirildiği doğrulanır
