package anya.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class SeleniumHelpers<T> {

    public static <V> V assertThat(ExpectedCondition<V> condition, WebDriver driver){
        return new WebDriverWait(driver, Configuration.timeout).until(condition);
    }

    public static <V> V assertThat(ExpectedCondition<V> condition, WebDriver driver, int timeout){
        return new WebDriverWait(driver, timeout).until(condition);
    }

    public static WebElement $(WebElement element, WebDriver driver){
        return assertThat(visibilityOf(element), driver);
    }

    public static WebElement $(By locator, WebDriver driver){
        return assertThat(visibilityOfElementLocated(locator), driver);
    }

    public static WebElement $(String cssSelector, WebDriver driver){
        return assertThat(visibilityOfElementLocated(byCss(cssSelector)), driver);
    }

    public static By byCss(String cssSelector){
        return By.cssSelector(cssSelector);
    }

    public static By byText(String text) {
        return (By.xpath("//div[contains(text(), '" + text + "')]"));
    }

}
