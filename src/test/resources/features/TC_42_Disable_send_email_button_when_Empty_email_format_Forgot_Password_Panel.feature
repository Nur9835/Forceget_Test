
Feature:Forgot Password
  Scenario: Şifremi unuttum sayfasında e-mail alanı boş bırakılması durumunda Send password reset link butonu disable olmalı
    Given Kayıt ol sayfasına gidilir
    When  Sign In linkine tıklanır
    And Forgot password link butonuna tıklanır
    Then Şifremi unuttum sayfasına yönlendirildiği doğrulanır
    Then Send password reset link butonunun disable olduğu doğrulanır




