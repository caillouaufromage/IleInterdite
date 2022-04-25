package Models;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Element{

    Coupe,Crane,Cristal,Coffre;


    private static final List<Element> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Element randomElement()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public static String  getName(){
        return Element.getName();
    }
}
