import static java.lang.Math.abs;

public class Mandelbrot extends Fractal {
    private int iteration;

    public Mandelbrot(int iteration) {
        this.iteration = iteration;
    }
    @Override
    int count(Complex point) {
        Complex z = new Complex(0, 0);
        for (int i = 0; i < iteration; i++) {
            z = z.square().add(point);
            if (abs(z.magnitude()) > 2) {
                return i;
            }
        }
        return iteration - 1;
    }
}
