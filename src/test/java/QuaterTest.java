import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import quoters.PropertyFileApplicationContext;
import quoters.Quoter;

public class QuaterTest {

  @Test
  public void simple() {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    context.getBean(Quoter.class).sayQuote();
  }

  @Test
  public void with_profiling() throws InterruptedException {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

    while (true) {
      Thread.sleep(300);
      context.getBean(Quoter.class).sayQuote();
    }

  }

  @Test
  public void propirties_context() {
    PropertyFileApplicationContext context = new PropertyFileApplicationContext("context.properties");

    context.getBean(Quoter.class).sayQuote();
  }
}
