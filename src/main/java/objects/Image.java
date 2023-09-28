package objects;

import org.openqa.selenium.WebElement;

import java.util.Objects;

public class Image {
    private String src;
    private String height;
    private String width;

    public Image(String src, String height, String width) {
        this.src = src;
        this.height = height;
        this.width = width;
    }

    public Image(WebElement element) {
        this.src = element.getAttribute("src");
        this.height = element.getAttribute("height");
        this.width = element.getAttribute("width");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(src, image.src) &&
                Objects.equals(height, image.height) &&
                Objects.equals(width, image.width);
    }

    @Override
    public int hashCode() {
        return Objects.hash(src, height, width);
    }

    @Override
    public String toString() {
        return "Image{" +
                "src='" + src + '\'' +
                ", height='" + height + '\'' +
                ", width='" + width + '\'' +
                '}';
    }
}
