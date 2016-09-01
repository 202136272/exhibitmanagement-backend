package exhibitmanagement.factory;

import exhibitmanagement.domain.Ballistic;

/**
 * Created by Bonga on 8/13/2016.
 */
public class BallisticFactory {

    public static Ballistic getBallistic(String name, String reference, String type)
    {
        Ballistic myBallistic = new Ballistic.Builder()
                .reference(reference)
                .name(name)
                .type(type)
                .build();
        return myBallistic;

    }


}
