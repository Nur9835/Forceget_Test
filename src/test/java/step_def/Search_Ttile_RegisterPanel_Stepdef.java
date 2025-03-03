package step_def;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.RegisterPage;
import utils.Driver;
import utils.SeleniumHelper;

import java.util.List;
import java.util.stream.Collectors;

import static utils.SeleniumHelper.wait_second;

public class Search_Ttile_RegisterPanel_Stepdef {

    RegisterPage registerPage=new RegisterPage(Driver.getDriver());

    List<String> titles ;
    List<String> expectedFiltertTitles;
    Integer expectedFilterTtitlesCount;


    List<String> actualFiltertTitles;
    Integer actualFilterTtitlesCount;



    @When("uyelik sayfasındaki tüm titlelar listede tutulur ve  {string} kelimesine göre beklenen filtreli liste oluşturulur")
    public void uyelikSayfasındakiTümTitlelarListedeTutulurVeKelimesineGöreBeklenenFiltreliListeOluşturulur(String arg0) {
        wait_second(3);
        registerPage.getTitleDownButton().click();
        SeleniumHelper.screenshot();
        wait_second(3);

        SeleniumHelper.scrollToBottom(Driver.getDriver(),registerPage.getScrollCountry());
        wait_second(3);
        SeleniumHelper.screenshot();
        titles=registerPage.getAllOptionTitles();
        expectedFiltertTitles= titles.stream().filter(title -> title.contains(arg0))
                .collect(Collectors.toList());
        //System.out.printf("Tüm title",titles);
        //System.out.printf("Beklenen Filtreli title",filtertTitles);

        //Beklenen filtreli Ttile sayısı değişkende tutulur
        expectedFilterTtitlesCount=expectedFiltertTitles.size();
        System.out.println("Beklenen Filtreli title sayısı " + expectedFilterTtitlesCount);

    }

    @When("uyelik sayfasinda title bolumune {string} kelimesi girilir")
    public void uyelikSayfasindaTitleBolumuneKelimesiGirilir(String arg0) {
        wait_second(3);
        //Kullanıcı aramak istediği title'a göre search işlemi yapar
        registerPage.getJobTitleDropdownText().sendKeys(arg0);
        SeleniumHelper.screenshot();
        wait_second(3);
        //Kullanıcının girmiş olduğu texte göre çıkan tüm titlelar ve sayısı
        actualFiltertTitles=registerPage.getAllOptionTitles();
        System.out.printf("Kullanıcıya gösterilen  Filtreli title",actualFiltertTitles);
        wait_second(3);
        actualFilterTtitlesCount=actualFiltertTitles.size();
        System.out.println("Kullanıcıya gösterilen Filtreli title sayısı " + actualFilterTtitlesCount);

    }


    @Then("Kullanıcının girmiş olduğu text'e uygun Title seçenekleri gösterilmeli")
    public void kullanıcınınGirmişOlduğuTextEUygunTitleSeçenekleriGösterilmeli() {
        //Beklenen ve gerçek filtreli title liste eleman sayıları aynı olmalı
        SeleniumHelper.screenshot();
        Assert.assertEquals(expectedFilterTtitlesCount,actualFilterTtitlesCount);

    }



}
