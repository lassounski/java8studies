package utils;

import java.util.List;
import java.util.function.Predicate;

public class AssetAdderFunctional {

    public static int getAddedAssets(final List<Asset> assets, final Predicate<Asset> whichAssets){
        return assets.stream()
                .filter(whichAssets)
                .mapToInt(Asset::getValue)
                .sum();
    }
}
