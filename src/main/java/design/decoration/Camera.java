package design.decoration;

import static org.assertj.core.api.Assertions.assertThat;

import java.awt.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class Camera {

    private Function<Color, Color> filter;

    public Camera() {
        setFilters();
    }

    /**
     * This method receives a color and applies the filter to this color
     *
     * @return the color after the filter application
     */
    public Color capture(final Color inputColor) {
        final Color processedColor = filter.apply(inputColor);

        return processedColor;
    }

    /**
     * Sets the filter as a chaining of multiple filters
     */
    public void setFilters(final Function<Color, Color>... filters) {
        filter = Stream.of(filters)
                .reduce((color, nextColor) -> color.compose(nextColor))
                //if an empty array of filters is passed then
                //the identity function (color in = color out) will be used
                .orElseGet(Function::identity);
    }
}
