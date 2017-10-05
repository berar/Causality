package causality;

/**
 *
 * povrsina, brojSoba, brojSpratova
 *
 * Created by aleks_000 on 26/5/2017.
 */
public class Plac {
    public String tip = "Plac";

    public static Plac create(String in) {
        in = in.toLowerCase();
        if (in.equals("plac")) {
            return new Plac();
        } else if (in.equals("kuca")) {
            return new Kuca();
        } else if (in.equals("spratnakuca")) {
            return new SpratnaKuca();
        } else if (in.equals("dvospratnakuca")) {
            return new DvospratnaKuca();
        } else if (in.equals("zgrada")) {
            return new Zgrada();
        } else if (in.equals("soliter")) {
            return new Soliter();
        } else if (in.equals("fabrika")) {
            return new Fabrika();
        } else if (in.equals("njiva")) {
            return new Njiva();
        }
        return new Plac();
    }
}

class Njiva extends Plac {
    public Njiva() {
        super.tip = "Njiva";
    }
}

class Kuca extends Plac {
    public Kuca() {
        super.tip = "Kuca";
    }
}

class SpratnaKuca extends Kuca {
    public SpratnaKuca() {
        super.tip = "Spratna Kuca";
    }
}

class DvospratnaKuca extends Kuca {
    public DvospratnaKuca() {
        super.tip = "Dvospratna Kuca";
    }
}

class Zgrada extends Plac {
    public Zgrada() {
        super.tip = "Zgrada";
    }
}

class Soliter extends Zgrada {
    public Soliter() {
        super.tip = "Soliter";
    }
}

class Fabrika extends Zgrada {
    public Fabrika() {
        super.tip = "Fabrika";
    }
}


