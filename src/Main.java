import hanoi.Hanoi;
import hanoi.gui.JHanoi;

// TODO commenter les constructeurs !

public class Main {
    public static void main(String[] args) {
        int arg = Integer.parseInt(args[0]);

        if (arg == 0) {
            try {
                Hanoi hanoi = new Hanoi(Integer.parseInt(args[1]));
                hanoi.solve();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            new JHanoi();
        }
    }
}