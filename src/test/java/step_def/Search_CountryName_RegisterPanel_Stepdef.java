package step_def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.RegisterPage;
import utils.Driver;
import utils.SeleniumHelper;

import java.util.List;
import java.util.stream.Collectors;

import static utils.SeleniumHelper.*;

public class Search_CountryName_RegisterPanel_Stepdef {

    RegisterPage registerPage = new RegisterPage(Driver.getDriver());

    List<String> countries;
    List<String> expectedFiltertCountries;
    Integer expectedFilterCountriesCount;

    List<String> actualFilterCountries;
    Integer actualFilterCountriesCount;


    @When("uyelik sayfasındaki tüm country listede tutulur ve  {string} kelimesine göre beklenen filtreli liste oluşturulur")
    public void uyelikSayfasındakiTümCountryListedeTutulurVeKelimesineGöreBeklenenFiltreliListeOluşturulur(String arg0) {
        wait_second(3);
        registerPage.getCountryDownButton().click();
        wait_second(3);
        SeleniumHelper.screenshot();
        //scroll kaydırıldıkça sadece 16 şar ülke html tarafında göründüğünden yani dinamik olarak değiştiği için tüm scroll'u 100 px olacak şekilde kaydırdım ve
        // kaydırdıkça html tarafında görünen tüm ülkelerden (çakışma olacağını bildiğim için) oluşturduğum listeyi benzersiz olacak şekilde ayarlayarak yeni bir liste oluşturdum
        // ve en son oluşturduğum listede artık dropdown menüdeki tüm ülkeler mevcut oldu

        List<String> allScrollItems  = scrollAndCollectItems(Driver.getDriver(), registerPage.getScrollCountry());
        //System.out.println("Toplam : " + allScrollItems.size());

        //benzersiz listem(tüm countryler)
         countries = removeDuplicatesAndKeepOrder(allScrollItems);

        System.out.println("Toplam ülke sayısı : " + countries.size());

        expectedFiltertCountries= countries.stream().filter(title -> title.contains(arg0))
                .collect(Collectors.toList());
        //Beklenen filtreli Countrt sayısı değişkende tutulur
        expectedFilterCountriesCount=expectedFiltertCountries.size();
        System.out.println("Beklenen Filtreli Counry sayısı " + expectedFilterCountriesCount);

    }


    @And("uyelik sayfasinda country bolumune {string} kelimesi girilir")
    public void uyelikSayfasindaCountryBolumuneKelimesiGirilir(String arg0) {

        //Kullanıcı aramak istediği title'a göre search işlemi yapar
        registerPage.getCountryDropdownText().sendKeys(arg0);
        wait_second(3);

       //Kullanıcının girmiş olduğu texte göre çıkan tüm titlelar ve sayısı
        actualFilterCountries=registerPage.getAllOptionTitles();
        System.out.printf("Kullanıcıya gösterilen  Filtreli country",actualFilterCountries);
        wait_second(3);
        actualFilterCountriesCount=actualFilterCountries.size();
        System.out.println("Kullanıcıya gösterilen Filtreli title sayısı " + actualFilterCountriesCount);



    }

    @Then("Kullanıcının girmiş olduğu country'e uygun Country seçenekleri gösterilmeli")
    public void kullanıcınınGirmişOlduğuCountryEUygunCountrySeçenekleriGösterilmeli() {

        //Beklenen ve gerçek filtreli country liste eleman sayıları aynı olmalı
        Assert.assertEquals(expectedFilterCountriesCount,actualFilterCountriesCount);
    }
}
