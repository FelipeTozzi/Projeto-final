import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebElement;
import java.util.List;

public class TesteFinal {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/producao");
    }

    //@Test
    public void clicar(){
        WebElement clicar = driver.findElement(By.className("button-link"));
        clicar.click();
    }

    //@Test
    public void preencher(){
        WebElement nome = driver.findElement(By.xpath("//*[@id=\"nome\"]"));
        WebElement tipo = driver.findElement(By.xpath("//*[@id=\"tipo\"]"));
        WebElement quantidade = driver.findElement(By.xpath("//*[@id=\"quantidade\"]"));

        nome.sendKeys("Poligono");
        tipo.sendKeys("forma geométrica");
        quantidade.sendKeys("65656");

        WebElement clicar = driver.findElement(By.xpath("/html/body/form/button"));
        clicar.click();
    }

    //@Test
    public void deletar() {
        List<WebElement> linhas = driver.findElements(By.xpath("//table//tr[td]"));

        for (WebElement linha : linhas) {
            if (linha.getText().contains("Poligono")) {
                WebElement clicar = linha.findElement(By.xpath(".//button[contains(text(), 'Excluir')]"));
                clicar.click();
                break;
            }
        }
    }

    @Test
    public void editar(){
        List<WebElement> linhas = driver.findElements(By.xpath("//table//tr[td]"));

        for (WebElement linha : linhas){
            if (linha.getText().contains("kdasllkIvan")){
                WebElement clicar = linha.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[5]/a"));
                clicar.click();

                WebElement nome = driver.findElement(By.xpath("//*[@id=\"nome\"]"));
                WebElement tipo = driver.findElement(By.xpath("//*[@id=\"tipo\"]"));
                WebElement quantidade = driver.findElement(By.xpath("//*[@id=\"quantidade\"]"));

                nome.clear();
                tipo.clear();
                quantidade.clear();

                nome.sendKeys("Pingu");
                tipo.sendKeys("desebgi");
                quantidade.sendKeys("217839");

                WebElement clicar2 = driver.findElement(By.xpath("/html/body/form/button"));
                clicar2.click();
                break;
            }
        }

    }


}
