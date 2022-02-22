package instabot;

import com.microsoft.playwright.*;

//mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="codegen wikipedia.org"
public class App {
    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false).setSlowMo(500));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setUserAgent(
                            "Mozilla/5.0 (iPhone; CPU iPhone OS 12_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0 Mobile/15E148 Safari/604.1")
                    .setIsMobile(true)
                    .setViewportSize(375, 812)
                    .setHasTouch(true)
                    .setLocale("sp-BR"));
            // Open new page
            Page page = context.newPage();
            // Go to https://www.wikipedia.org/
            page.navigate("https://www.google.com");
         
           // page.pause();
          
            // Click form[role="search"] div div div >> :nth-match(div, 3)
            page.click("form[role=\"search\"] div div div >> :nth-match(div, 3)");
            // assert page.url().equals("https://www.google.com/#sbfbu=1&pi=");
            // Fill [aria-label="Pesquisar"]
            page.fill("[aria-label=\"Pesquisar\"]", "teste");
            // Press Enter
            // page.waitForNavigation(new
            // Page.WaitForNavigationOptions().setUrl("https://www.google.com/search?q=teste&source=hp&ei=g1EVYpGNIZPY5OUPprKMsAg&oq=teste&gs_lcp=ChFtb2JpbGUtZ3dzLXdpei1ocBADMggIABCABBCxAzIICAAQgAQQsQMyCAgAEIAEELEDMggIABCABBCxAzIICAAQgAQQsQMyBQgAEIAEMgUIABCABDIICAAQgAQQsQM6CwgAEIAEELEDEIMBOhEILhCABBCxAxCDARDHARDRAzoOCC4QgAQQsQMQxwEQowJQnhZYjRtghSJoAHAAeACAAV2IAcADkgEBNZgBAKABAbABAA&sclient=mobile-gws-wiz-hp"),
            // () ->
            page.waitForNavigation(() -> {
                page.press("[aria-label=\"Pesquisar\"]", "Enter");
            });
            // assert
            // page.url().equals("https://www.google.com/search?q=teste&source=hp&ei=g1EVYpGNIZPY5OUPprKMsAg&oq=teste&gs_lcp=ChFtb2JpbGUtZ3dzLXdpei1ocBADMggIABCABBCxAzIICAAQgAQQsQMyCAgAEIAEELEDMggIABCABBCxAzIICAAQgAQQsQMyBQgAEIAEMgUIABCABDIICAAQgAQQsQM6CwgAEIAEELEDEIMBOhEILhCABBCxAxCDARDHARDRAzoOCC4QgAQQsQMQxwEQowJQnhZYjRtghSJoAHAAeACAAV2IAcADkgEBNZgBAKABAbABAA&sclient=mobile-gws-wiz-hp");
            // Click text=Speedtest by Ookla - Teste de Velocidade de Conexão da Internet
            page.click("text=Speedtest by Ookla - Teste de Velocidade de Conexão da Internet");
            // assert page.url().equals("https://www.speedtest.net/pt");
            // Click [aria-label="start speed test - connection type multi"]
            page.click("[aria-label=\"start speed test - connection type multi\"]");
            page.waitForTimeout(20000);
            page.close();
        }
    }
}
