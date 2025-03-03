
Feature:Login Panel
  Scenario : Giriş Yap sayfasında bulunan Sign-up link button'un Kayıt sayfasına yönlendirmeli
    Given Kayıt ol sayfasına gidilir
    When Sign In linkine tıklanır
    Then Giriş yap sayfasına yönlendirildiği kanıtlanır
    Then Sign-up linkine tıklanır ve Kayıt ol sayfasına yönlendirildiği kanıtlanır
