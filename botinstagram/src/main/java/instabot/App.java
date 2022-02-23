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
                    .setLocale("pt-BR")
                    .setGeolocation(-23.558934, -46.627823)
                    .setHttpCredentials("torquatopaulomessias", "jdh2WbvqC2W5Pqd"));

            // Open new page
            Page page = context.newPage();
            // Go to https://www.wikipedia.org/
            page.navigate("https://www.instagram.com");

            page.pause();

            // Click text=Entrar
            page.click("text=Entrar");
           
           //fazer login
            // Click [aria-label="Telefone, nome de usuário ou email"]
            page.click("[aria-label=\"Telefone, nome de usuário ou email\"]");
            // Fill [aria-label="Telefone, nome de usuário ou email"]
            page.fill("[aria-label=\"Telefone, nome de usuário ou email\"]", "torquatopaulomessias");
            // Click [aria-label="Senha"]
            page.click("[aria-label=\"Senha\"]");
            // Fill [aria-label="Senha"]
            page.fill("[aria-label=\"Senha\"]", "jdh2WbvqC2W5Pqd");
            // Click button:has-text("Entrar")
            // page.waitForNavigation(new
            // Page.WaitForNavigationOptions().setUrl("https://www.instagram.com/accounts/onetap/?next=%2F"),
            // () ->
            page.waitForNavigation(() -> {
                page.click("button:has-text(\"Entrar\")");
            });
            // Click text=Agora não
            page.click("text=Agora não");
            
            // assistir stores
            page.click("div[role=\"button\"]", new Page.ClickOptions()
                    .setPosition(2, 6));

            //avançar stores
            // Click div[role="button"] >> :nth-match(button, 4)
            page.click("div[role=\"button\"] >> :nth-match(button, 4)");
            // assert
            // page.url().equals("https://www.instagram.com/stories/virginia/2779259641213025589/");
            // Click header button
            page.click("header button");
            // assert page.url().equals("https://www.instagram.com/");
            // Click [data-testid="mobile-nav-logged-in"] [data-testid="user-avatar"]
            page.click("[data-testid=\"mobile-nav-logged-in\"] [data-testid=\"user-avatar\"]");
            // assert page.url().equals("https://www.instagram.com/torquatopaulomessias/");
            // Click [aria-label="Atividade"]
            page.click("[aria-label=\"Atividade\"]");
            // assert page.url().equals("https://www.instagram.com/accounts/activity/");
            // Click text=rodrigueslorenabarreto começou a seguir você.2 dSeguir >> button
            page.click("text=rodrigueslorenabarreto começou a seguir você.2 dSeguir >> button");
            // Click button:has-text("Seguir")
            page.click("button:has-text(\"Seguir\")");
            // Click [data-testid="mobile-nav-logged-in"] [data-testid="user-avatar"]
            page.click("[data-testid=\"mobile-nav-logged-in\"] [data-testid=\"user-avatar\"]");
            // assert page.url().equals("https://www.instagram.com/torquatopaulomessias/");
            // Click [data-testid="user-avatar"]
            page.click("[data-testid=\"user-avatar\"]");
            // assert page.url().equals("https://www.instagram.com/torquatopaulomessias/");
            // Click [data-testid="user-avatar"]
            page.click("[data-testid=\"user-avatar\"]");
            // assert page.url().equals("https://www.instagram.com/torquatopaulomessias/");
            // Click [data-testid="mobile-nav-logged-in"] a >> :nth-match(div, 2)
           
            
            //pesquisar
            page.click("[placeholder=\"Pesquisar\"]");
            // assert page.url().equals("https://www.instagram.com/explore/search/");
            // Fill [placeholder="Pesquisar"]
            page.fill("[placeholder=\"Pesquisar\"]", "biana");
            // Click text=bianapolitano
           
           
          
            
            // Click [aria-label="Página inicial"]
            page.click("[aria-label=\"Página inicial\"]");
            // assert page.url().equals("https://www.instagram.com/");

        }
    }
}
