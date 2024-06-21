import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Day2_ArabamCom {
    AndroidDriver<AndroidElement> androidDriver;


    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
      //  capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\ahmet\\IdeaProjects\\T_135_Appium\\Apps\\arabam.com_5.1.6_Apkpure (1).apk");
        capabilities.setCapability("appPackage","com.dogan.arabam");
        // AppPackage caliscak oldugunuz uygulaminin bilgisini girdikten sonra (T.C) O uygulamayi baslatir.
        // fakat!!!!! uygulamayi basta yuklemeniz gerekmektedir!!! yuklu degilse uygulamayi BASLATMAZ !!!!!!!
        capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");
        // UYGULAMNIN HANGI SAYFASINDAN BASLAMANIZI ISTIYORSANIZ ILGILI SAYFANIN ACTIVITY DEGERINI GIRER
        // O SAYFADAN UYGULAMAYI BASLATABILIRSINIZ.

        androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        androidDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void arabam1(){
        // uygulamanin basarili bir sekilde yuklendigi dogrulanir
        Assert.assertTrue(androidDriver.isAppInstalled("com.dogan.arabam"));
        // uygulaminin basarili bir sekilde acildigi dogrulanir
Assert.assertTrue(androidDriver.findElementByXPath("//*[@text='Alırken, satarken kullanırken']").isDisplayed());
        // alt menuden ilan ara butonuna tiklanir
        androidDriver.findElementByXPath("//*[@text='İlan Ara']").click();
        // kategori olarak otomobil secilir

        // arac olarak Volkswagen secilir
        // arac markasi olarak passat secilir
        // 1.4 TSI BlueMotion secilir
        // Paket secimi yapilir
        // Ucuzdan pahaliya siralama yaparak filtreleme yapilir
        // Gelen en ucuz aracin 500.000 tl den buyuk oldugu dogrulanir
    }

    @Test
    public void login(){

    }

    @Test
    public void arabam2(){

    }
}
