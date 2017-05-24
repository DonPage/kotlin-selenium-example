package demo

import org.openqa.selenium.By
import org.openqa.selenium.firefox.FirefoxDriver

open class BasePage(val driver: FirefoxDriver = FirefoxDriver()) {
    fun el(selector: String) = driver.findElement(By.cssSelector(selector))

    fun click(selector: String) = el(selector).click()

    fun url(url: String) = driver.get(url)

    fun type(input: String, selector: String) = el(selector).sendKeys(input)

    fun quit() = driver.quit()
}

class DuckDuckPage: BasePage() {
    val url = "https://duckduckgo.com/"

    object DOM {
        val logo = "#logo_homepage_link"
        val search_input = "#search_form_input_homepage"
        val search_submit = "#search_button_homepage"
    }

    fun load(): Unit {
        url(url)
        return
    }

    fun search(query: String): Unit {
        type(query, DOM.search_input)
        click(DOM.search_submit)
        return
    }
}


fun main(args: Array<String>) {
    System.setProperty("webdriver.gecko.driver", "/Users/donald/WebstormProjects/geckodriver")
    val page = DuckDuckPage()
    page.load()
    page.search("Purple, Rock, Scissors")
    Thread.sleep(9000)
    page.quit()
}
