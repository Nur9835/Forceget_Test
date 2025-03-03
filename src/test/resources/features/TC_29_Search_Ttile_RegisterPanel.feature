
Feature:Register Panel
  Scenario Outline: Kayıt işleminde Title alanına girilen kelimeye göre uygun Title seçenekleri doğru gösterilmeli
    Given Kayıt ol sayfasına gidilir
    When uyelik sayfasındaki tüm titlelar listede tutulur ve  "<titleText>" kelimesine göre beklenen filtreli liste oluşturulur
    And uyelik sayfasinda title bolumune "<titleText>" kelimesi girilir
    Then Kullanıcının girmiş olduğu text'e uygun Title seçenekleri gösterilmeli

    Examples:
      | titleText    |
      | Owner        |

