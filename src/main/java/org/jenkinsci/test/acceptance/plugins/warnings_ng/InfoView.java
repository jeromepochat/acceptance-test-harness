package org.jenkinsci.test.acceptance.plugins.warnings_ng;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.jenkinsci.test.acceptance.po.Build;
import org.jenkinsci.test.acceptance.po.Control;
import org.jenkinsci.test.acceptance.po.PageObject;

/**
 * Page object for the error and info messages view.
 *
 * @author Alexander Praegla
 * @author Arne Schöntag
 * @author Nikolai Wohlgemuth
 */
public class InfoView extends PageObject {
    private final Control errors = control(By.id("errors"));
    private final Control info = control(By.id("info"));

    /**
     * Creates a new info and error view.
     *
     * @param build
     *         the build that contains the static analysis results
     * @param id
     *         the id of the analysis tool
     */
    public InfoView(final Build build, final String id) {
        super(build, build.url(id + "/info/"));
    }

    /**
     * Returns the error messages.
     *
     * @return all error messages
     */
    public List<String> getErrorMessages() {
        if (errors.exists()) {
            return getElementsFromContainingDivs(errors);
        }
        else {
            return Collections.emptyList();
        }
    }

    /**
     * Returns the info messages.
     *
     * @return all info messages
     */
    public List<String> getInfoMessages() {
        return getElementsFromContainingDivs(info);
    }

    private List<String> getElementsFromContainingDivs(final Control control) {
        return control.resolve()
                .findElements(by.xpath("div"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
