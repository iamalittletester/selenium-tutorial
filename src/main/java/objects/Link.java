package objects;

import org.openqa.selenium.WebElement;

import java.util.Objects;

public class Link {
    private String url;
    private String label;

    public Link(String url, String label) {
        this.url = url;
        this.label = label;
    }

    public Link(WebElement element) {
        this.url = element.getAttribute("href");
        this.label = element.getText();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return Objects.equals(url, link.url) &&
                Objects.equals(label, link.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, label);
    }

    @Override
    public String toString() {
        return "Link{" +
                "url='" + url + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
