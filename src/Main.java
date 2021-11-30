import hanoi.Hanoi;
import hanoi.gui.JHanoi;

public class Main {
    public static void main(String[] args) {
      try {
          Hanoi hanoi = new Hanoi(3);
          hanoi.solve();
      } catch (Exception e) {
          System.out.println(e.getMessage());
      }

      //JHanoi h = new JHanoi();
    }
}
