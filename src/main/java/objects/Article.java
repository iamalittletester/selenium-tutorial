package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class Article {
    private Image img;
    private String tag;
    private Link link;

    public Article(Image img, String tag, Link link) {
        this.img = img;
        this.tag = tag;
        this.link = link;
    }

    public Article(WebElement element) {
        this.img = new Image(element.findElement(By.cssSelector("img")));
        this.tag = element.findElement(By.cssSelector("span")).getText();
        this.link = new Link(element.findElement(By.cssSelector("a")));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(img, article.img) &&
                Objects.equals(tag, article.tag) &&
                Objects.equals(link, article.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(img, tag, link);
    }

    @Override
    public String toString() {
        return "Article{" +
                "img=" + img +
                ", tag='" + tag + '\'' +
                ", link=" + link +
                '}';
    }
}
