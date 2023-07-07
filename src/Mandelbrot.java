import static java.lang.Math.abs;

public class Mandelbrot extends Fractal {

    public Mandelbrot(int iteration) {
        Fractal.iteration = iteration;
    }
    @Override
    public int count(Complex point) {
        Complex z = new Complex(0, 0);
        for (int i = 0; i < iteration; i++) {
            z = z.square().add(point);
            //System.out.println(z.magnitude());
            //System.out.println(z);
            if (z.abs() > 2) {
                return i;
            }
        }
        return iteration - 1;
    }
}
