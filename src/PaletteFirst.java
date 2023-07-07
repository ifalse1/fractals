import java.util.ArrayList;

public class PaletteFirst extends Palette {
    ArrayList<Double> really_long = new ArrayList<>();
    public PaletteFirst(int iteration) {
        Palette.iteration = iteration;
    }

    @Override
    Double getColor() {
        return null;
    }
}
