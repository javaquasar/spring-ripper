import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import screensaver.ColorFrame;
import screensaver.Config;

public class ScreenSaverTest {

  @Test
  public void name_test() throws InterruptedException {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

    while (true) {
      context.getBean(ColorFrame.class).showOnRandomPlace();
      Thread.sleep(100);
    }

  }
}
