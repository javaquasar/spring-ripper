package screensaver;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public abstract class ColorFrame extends JFrame {

  public ColorFrame() {
    setSize(200, 200);
    setVisible(true);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }

  public void showOnRandomPlace() {
    Random random = new Random();
    setLocation(random.nextInt(1200), random.nextInt(700));
//    setBackground(color); not working for mac
    repaint();
  }

  @Override
  public void paint(Graphics g) {
    // Если при объявление бина Color указать
    // @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    // новый бин будет создаваться при каждом обращении к полю color
    // даже если обращения происходят в одном методе

    getContentPane().setBackground(getColor());
  }

  protected abstract Color getColor();
}
