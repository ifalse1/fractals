public class Complex {
    private double real, imaginary;
    public Complex(double r, double i) {
        this.real = r;
        this.imaginary = i;
    }

    public Complex square() {
        return new Complex(this.real * this.real - this.imaginary * this.imaginary, 2 * this.real * this.imaginary);
    }

    public Complex add(Complex constant) {
        return new Complex(this.real + constant.real, this.imaginary + constant.imaginary);
    }

    // How close the number is to infinity
    public double magnitude() {
        return real * real + imaginary * imaginary;
    }

    public double abs() { return Math.sqrt(real * real + imaginary * imaginary); }
}
