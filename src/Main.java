import hanoi.Hanoi;
import hanoi.gui.JHanoi;

import util.Element;
import util.Iterator;

// TODO commenter les constructeurs !

public class Main {
    public static void main(String[] args) {
        int arg = Integer.parseInt(args[0]);

        testIter();

        if(arg == 0){
            try {
                Hanoi hanoi = new Hanoi(5);
                hanoi.solve();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }else{
            new JHanoi();
        }
    }

    public static void testIter(){
        Element<String> el1 = new Element<>("el 1");
        Element<String> el2 = new Element<>("el 2");
        el1.setNext(el2);
        Iterator<String> it = new Iterator<>(el1);

        if(it.hasNext()){
            System.out.println("TEST PASSED !");
        }
        String next = it.next();
        if(next.equals("el 1")){
            System.out.println("TEST PASSED !");
        }
        next = it.next();
        if(next.equals("el 2")){
            System.out.println("TEST PASSED !");
        }

        if(!it.hasNext()){
            System.out.println("TEST PASSED !");
        }

        if(it.next() == null){
            System.out.println("TEST PASSED !");
        }

    }
}
