package design.decoration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import java.awt.*;


public class CameraTest {

    private final Camera camera = new Camera();

    @Test
    public void shouldPrintDefaultColorWhenNoFilterApplied() {
        assertThat(camera.capture(Color.BLACK)).isEqualTo(Color.BLACK);
    }

    @Test
    public void shouldMakeTheColorBrighterUsingOneFilter() {
        camera.setFilters(color -> color.brighter());
        assertThat(camera.capture(Color.BLACK)).isNotEqualTo(Color.BLACK);
    }

    @Test
    public void shouldMakeAnyColorWhite() {
        camera.setFilters(color -> Color.WHITE);
        assertThat(camera.capture(Color.BLACK)).isEqualTo(Color.WHITE);
    }

    @Test
    public void shouldFilterColorUsingMultipleFilters() {
        camera.setFilters(
                color -> new Color(color.getRed() + 2, color.getGreen() + 2, color.getBlue() + 2),
                color -> new Color(color.getRed() + 1, color.getGreen() + 1, color.getBlue() + 1)
        );
                assertThat(camera.capture(Color.BLACK)).isEqualTo(new Color(3,3,3));
    }
}
