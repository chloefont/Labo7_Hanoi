package hanoi;

import hanoi.gui.JHanoiDisplay;

public class HanoiDisplayer extends JHanoiDisplay {

    @Override
    public void display(Hanoi h){
        System.out.println(h.display());
    }

}
