package techproed.tests.practice;

import org.testng.annotations.Test;
import techproed.pages.DhtmlPage;
import techproed.utilities.ActionsUtils;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class P03 {




    @Test
    public void test01() {

        DhtmlPage page = new DhtmlPage();

        //http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html adresine gidiniz

        Driver.getDriver().get(ConfigReader.getProperties("dhtmlUrl"));

        //Tüm ülkeleri yazdırınız

        page.countries.forEach(t-> System.out.println(t.getText()));

        //Ülkeler ile şehirleri eşleştiriniz

        ActionsUtils.dragAndDrop(page.oslo,page.norway);
        ActionsUtils.dragAndDrop(page.stockholm,page.sweden);
        ActionsUtils.dragAndDrop(page.washington,page.unitedStates);
        ActionsUtils.dragAndDrop(page.copenhagen,page.denmark);
        ActionsUtils.dragAndDrop(page.seoul,page.southKorea);
        ActionsUtils.dragAndDrop(page.rome,page.italy);
        ActionsUtils.dragAndDrop(page.madrid,page.spain);


    }
}
