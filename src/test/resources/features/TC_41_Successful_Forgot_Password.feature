
Feature:Forgot Password
  Scenario Outline: Sisteme kayıtlı kullanıcının Forgot Password sayfasında şifresini yenileyebilmeli
    Given Kayıt ol sayfasına gidilir
    When  Sign In linkine tıklanır
    And Forgot password link butonuna tıklanır
    Then Şifremi unuttum sayfasına yönlendirildiği doğrulanır
    When şifremi unuttum sayfasinda email bolumune "<email>" girilir
    And Send password reset link butonuna tıklanır
    Then A password reset link has been sent to your email address. uyarısının olduğu doğrulanır
    And Kullanıcı Google hesabına giriş yapar
    And Gelen e-postada "Forceget Password Reset" başlığı içeren e-posta bulunur
    And E-posta içeriğindeki "Reset password" butonuna tıklanır
    When şifre değiştirme sayfasinda password bolumune kurallara uygun "<password>" girilir
    And  şifre değiştirme sayfasinda confirm password bolumune kurallara uygun "<confirmPassword>" girilir
    And Reset password butonu tıklanır


    Examples:
      | email             |  password    | confirmPassword    |
      |testnur9@gmail.com |  NewPass123! | NewPass123!        |

