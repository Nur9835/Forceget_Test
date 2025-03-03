
Feature:Register Panel
  Scenario Outline: Kayıt işleminde Country alanına girilen kelimeye göre uygun Country seçenekleri doğru gösterilmeli
    Given Kayıt ol sayfasına gidilir
    When uyelik sayfasındaki tüm country listede tutulur ve  "<countryText>" kelimesine göre beklenen filtreli liste oluşturulur
    And uyelik sayfasinda country bolumune "<countryText>" kelimesi girilir
    Then Kullanıcının girmiş olduğu country'e uygun Country seçenekleri gösterilmeli

    Examples:
      | countryText  |
      | Tur          |

