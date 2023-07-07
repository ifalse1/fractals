import java.util.Dictionary;

import static java.lang.Math.abs;

public class Julia extends Fractal{
    private Complex c;
    public Julia(Dictionary fracInfo) {
        Fractal.iteration = (int) fracInfo.get("iteration");
        c = new Complex((Double) fracInfo.get("creal"), (Double) fracInfo.get("cimag"));
    }
    @Override
    int count(Complex z) {
        for (int i = 0; i < iteration; i++) {
            z = z.square().add(c);
            if (abs(z.magnitude()) > 2) {
                return i;
            }
        }
        return iteration - 1;
    }
}
