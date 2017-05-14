package screensaver;

import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = "screensaver")
public class Config {

  @Bean
  @Scope(value = "periodical")
  public Color color() {
    Random random = new Random();
    return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
  }

  @Bean
  public ColorFrame frame() {
    return new ColorFrame() {
      @Override
      protected Color getColor() {
        return color(); // это не вызов метода! это обращение к бину
      }
    };
  }

}
