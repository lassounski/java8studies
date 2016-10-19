package design;

import java.util.function.Function;

public class Decoration {

    class Camera{
        private Function<Color, Color> filter;

        public Color capture(final Color inputColor){
            final Color processedColor = filter.apply(inputColor);
            
            return processedColor;
        }
    }
}
