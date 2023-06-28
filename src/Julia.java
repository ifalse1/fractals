import static java.lang.Math.abs;

public class Julia extends Fractal{
    private int iteration;
    private Complex c;
    public Julia(int iteration) {
        this.iteration = iteration;
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
