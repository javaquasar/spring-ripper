package quoters;

import javax.annotation.PostConstruct;

@Profiling
@DeprecatedClass(newImpl = T1000.class)
public class TerminatorQuoter implements Quoter {

  @InjectRandomInt(min = 2, max = 7)
  private int repeat;

  private String message;

  public TerminatorQuoter() {
    System.out.println("PHASE 1");
    System.out.println("repeat = " + repeat);
  }

  @PostConstruct
  public void init() {
    System.out.println("PHASE 2");
    System.out.println("repeat = " + repeat);
  }

  @Override
  //@PostConstruct // не профилирует, т.к. еще не навешаны прокси
  @PostProxy
  public void sayQuote() {
    System.out.println("PHASE 3");
    for (int i = 0; i < repeat; i++) {
      System.out.println("message = " + message);
    }

  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setRepeat(int repeat) {
    this.repeat = repeat;
  }
}
