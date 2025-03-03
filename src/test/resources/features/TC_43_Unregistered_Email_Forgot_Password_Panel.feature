
Feature:Forgot Password
  Scenario Outline: Şifremi unuttum sayfasında kayıtlı olmayan e-mail olması durumunda "E-posta adresinize bir şifre sıfırlama bağlantısı gönderildi" mesajı gösterilmemeli ve
  kullancıya kayıtlı olmayan e-mail için şifre değiştirme olmayacağının mesajı verilmeli
    Given Kayıt ol sayfasına gidilir
    When  Sign In linkine tıklanır
    And Forgot password link butonuna tıklanır
    Then Şifremi unuttum sayfasına yönlendirildiği doğrulanır
    When şifremi unuttum sayfasinda email bolumune "<email>" girilir
    And Send password reset link butonuna tıklanır
    Then A password reset link has been sent to your email address. uyarısının olmadığı doğrulanır

    Examples:
      | email|
      | tdenemeeeeee99@gmail.com|
