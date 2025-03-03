
Feature:Register Panel
  Scenario Outline: Kayıt işleminde password ile confirm password alanlarındaki eye ikonları şifre görünürlüğünü doğru göstermeli
    Given Kayıt ol sayfasına gidilir
    When uyelik sayfasinda password bolumune "<password>" girilir
    And uyelik sayfasinda confirmPassword bolumune "<confirmPassword>" girilir
    Then uyelik sayfasında password alanında buulunan eye icon tıklandığında kullanıcının girdiği passwordu görünür şekilde göstermeli
    Then uyelik sayfasında confirmpassword alanında bulunan eye icon tıklandığında kullanıcının girdiği passwordu görünür şekilde göstermeli
    Then uyelik sayfasında password alanında buulunan eye icon 2.kez tıklandığında kullanıcının girdiği passwordu maskeli şekilde göstermeli
    Then uyelik sayfasında confirmpassword alanında bulunan eye icon 2.kez tıklandığında kullanıcının girdiği passwordu maskeli şekilde göstermeli


    Examples:
      |   password         |  confirmPassword |
      |   NurTest66.       |  NurTest66.      |