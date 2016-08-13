package exhibitmanagement.factory;

import exhibitmanagement.domain.Chemistry;

/**
 * Created by Bonga on 8/13/2016.
 */
public class ChemistryFactory {


    public static Chemistry CreateChemistry(String mass, String amount, String type, String effect) {
        Chemistry chemistry = new Chemistry.Builder()
                .mass(amount)
                .amount(amount)
                .type(type)
                .type(type)
                .build();
        return chemistry;
    }
}
