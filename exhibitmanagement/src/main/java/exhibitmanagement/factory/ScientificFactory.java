package exhibitmanagement.factory;

import exhibitmanagement.domain.Scientific;

/**
 * Created by Bonga on 8/15/2016.
 */
public class ScientificFactory  {

    public static Scientific getScientific(String name, String mass) {
        Scientific myScientific = new Scientific.Builder()
                .name(name)
                .mass(mass)
                .build();
        return myScientific;


    }
}
