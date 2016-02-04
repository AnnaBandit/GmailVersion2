package anya.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class ConsiseAPI<T> {

    public <V> V assertThat(ExpectedCondition<V> condition){
        return new WebDriverWait(getDriver(), Configuration.timeout).until(condition);
    }

    public <V> V assertThat(ExpectedCondition<V> condition, int timeout){
        return new WebDriverWait(getDriver(), timeout).until(condition);
    }

    public WebElement $(WebElement element){
        return assertThat(visibilityOf(element));
    }

    public WebElement $(By locator){
        return assertThat(visibilityOfElementLocated(locator));
    }

    public WebElement $(String cssSelector){
        return assertThat(visibilityOfElementLocated(byCss(cssSelector)));
    }

    public static By byCss(String cssSelector){
        return By.cssSelector(cssSelector);
    }

    public static By byText(String text) {
        return (By.xpath("//div[contains(text(), '" + text + "')]"));
    }

    public abstract WebDriver getDriver();

}
