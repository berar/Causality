package causality;

import io.berar.causality.Causation;

/**
 * Created by aleks_000 on 26/5/2017.
 */
public class Main {

    public static void main(String[] args) {
        double povrsina = Double.parseDouble(args[0]);
        double brojSoba = Double.parseDouble(args[1]);
        double brojSpratova = Double.parseDouble(args[2]);

        Causation<String> causation = Causation.create(Main.class.getResourceAsStream("/c1.json"), String.class);
        causation.put("povrsina", povrsina);
        causation.put("brojSoba", brojSoba);
        causation.put("brojSpratova", brojSpratova);

        Plac p1 = Plac.create(causation.getEffect());

        if (p1 instanceof Kuca) {
            Causation<String> causation2 = Causation.create(Main.class.getResourceAsStream("/c2.json"), String.class);
            causation2.put("povrsina", povrsina);
            causation2.put("brojSoba", brojSoba);
            causation2.put("brojSpratova", brojSpratova);

            Plac p2 = Plac.create(causation2.getEffect());
        }

        if (p1 instanceof Zgrada) {
            Causation<String> causation2 = Causation.create(Main.class.getResourceAsStream("/c3.json"), String.class);
            causation2.put("povrsina", povrsina);
            causation2.put("brojSoba", brojSoba);
            causation2.put("brojSpratova", brojSpratova);

            Plac p2 = Plac.create(causation2.getEffect());
        }
    }
}
