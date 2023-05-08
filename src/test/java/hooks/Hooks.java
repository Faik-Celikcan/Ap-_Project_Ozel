package hooks;

import io.cucumber.java.Before;

import static base_urls.ManagementOnSchoolBaseUrlForDean.setUp;


public class Hooks {

    /*
    Hooks : Her bir Scenario ya da Scenario Outline dan ONCE ya da SONRA calismasini istedigim methodlar konur
    @Before ve @After methodlarini icerir
    Burada onemli olan raporlama isleminin ekran goruntusuyle birlikte Hooks yardimiyla yapilmasidir.
     */

    @Before
    public void setUpScenarios(){
        setUp();
    }

//
}

