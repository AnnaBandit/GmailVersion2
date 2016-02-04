package anya.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

public class CustomConditions{

    public static ExpectedCondition<WebElement> listNthElementHasText(final List<WebElement> elements, final int index, final String expectedText) {
        return new ExpectedCondition<WebElement>() {
            private WebElement element;
            private String actualText;

            public WebElement apply(WebDriver driver) {
                try {
                    element = elements.get(index);
                    actualText = element.getText();

                    return element.getText().contains(expectedText) ? element : null;
                } catch (IndexOutOfBoundsException ex){
                    return null;
                }
            }

            public String toString() {
                return String.format("Actual text on %s element is %s, \nExpected text is %s", index, actualText, expectedText);
            }
        };
    }

    public static ExpectedCondition<List<WebElement>> sizeOf(final List<WebElement> elements, final int expectedSize) {
        return new ExpectedCondition<List<WebElement>>() {
            private int listSize;

            public List<WebElement> apply(WebDriver driver) {
                listSize = elements.size();
                return elements.size() == expectedSize ? elements : null;
            }

            public String toString(){
                return String.format("Actual size of the list is %s,\nexpected size is %s", listSize, expectedSize);
            }
        };
    }

    public static ExpectedCondition<List<WebElement>> textsOf(final List<WebElement> elements, final String... texts) {
        return new ExpectedCondition<List<WebElement>>() {
            private List<WebElement> elements;
            private int listSize;
            private String[] actualTexts;

            public List<WebElement> apply(WebDriver driver) {
                listSize = elements.size();
                actualTexts = new String[elements.size()];

                for (int i = 0; i < elements.size(); i++) {
                    actualTexts[i]=(elements.get(i).getText());
                }

                if (listSize!=texts.length){
                    return null;
                }
                else {
                    for (int i = 0; i < elements.size(); i++) {
                        String actualText = actualTexts[i];
                        if (!actualText.contains(texts[i])) {
                            return null;
                        }
                    }
                    return elements;
                }

            }

            public String toString(){
                return String.format("Expected texts: %s,\nActual texts: %s", Arrays.toString(texts), Arrays.toString(actualTexts));
            }
        };
    }

    public static ExpectedCondition <WebElement> visible(final WebElement element) {
        return ExpectedConditions.visibilityOf(element);
    }

}