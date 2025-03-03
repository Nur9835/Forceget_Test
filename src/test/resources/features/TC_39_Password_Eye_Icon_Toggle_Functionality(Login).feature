
Feature:Login Panel
  Scenario Outline: Giriş Yap sayfasında  password eye ikonu şifre görünürlüğünü doğru göstermeli
    Given Kayıt ol sayfasına gidilir
    When  Sign In linkine tıklanır
    Then Giriş yap sayfasına yönlendirildiği kanıtlanır
    When giriş yap sayfasinda password bolumune "<password>" girilir
    Then giriş yap sayfasında password alanında buulunan eye icon tıklandığında kullanıcının girdiği passwordu görünür şekilde göstermeli
    Then giriş yap sayfasında password alanında buulunan eye icon 2.kez tıklandığında kullanıcının girdiği passwordu maskeli şekilde göstermeli

    Examples:
      |   password         |
      |   NurTest66.       |