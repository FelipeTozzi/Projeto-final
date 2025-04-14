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

    @Test
    public void preencher(){
        WebElement clicar = driver.findElement(By.className("button-link")); //Aperta "Nova Produção"
        clicar.click();

        WebElement nome = driver.findElement(By.xpath("//*[@id=\"nome\"]"));
        WebElement tipo = driver.findElement(By.xpath("//*[@id=\"tipo\"]"));
        WebElement quantidade = driver.findElement(By.xpath("//*[@id=\"quantidade\"]"));

        nome.sendKeys("Poligono");
        tipo.sendKeys("forma geométrica");
        quantidade.sendKeys("1");

        WebElement clicar2 = driver.findElement(By.xpath("/html/body/form/button")); //Aperta "Salvar"
        clicar2.click();
    }

    @Test
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
            if (linha.getText().contains("Inglaterra")){
                WebElement clicar = linha.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[5]/a"));
                clicar.click(); //clica em "Editar"

                WebElement nome = driver.findElement(By.xpath("//*[@id=\"nome\"]"));
                WebElement tipo = driver.findElement(By.xpath("//*[@id=\"tipo\"]"));
                WebElement quantidade = driver.findElement(By.xpath("//*[@id=\"quantidade\"]"));

                nome.clear();
                tipo.clear();
                quantidade.clear();

                nome.sendKeys("Rio de Janeiro");
                tipo.sendKeys("Rio");
                quantidade.sendKeys("12345");

                WebElement clicar2 = driver.findElement(By.xpath("/html/body/form/button"));
                clicar2.click();
                break;
            }
        }

    }
}
