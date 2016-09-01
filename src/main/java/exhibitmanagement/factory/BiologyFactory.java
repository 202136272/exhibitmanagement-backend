package exhibitmanagement.factory;

import exhibitmanagement.domain.Biology;

/**
 * Created by Bonga on 8/13/2016.
 */
public class BiologyFactory {


    public static Biology getBiology(String name, String reference, String type)
    {
        Biology myBiology = new Biology.Builder()
                .name(name)
                .reference(reference)
                .type(type)
                .build();
        return myBiology;

    }
}
