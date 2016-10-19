package utils;

import java.util.List;

public class AssetAdderInefficient {
    public static int getTotalAssets(final List<Asset> assets) {
        return assets.stream()
                .mapToInt(Asset::getValue)
                .sum();
    }

    public static int getTotalBondAssets(final List<Asset> assets) {
        return assets.stream()
                .filter(asset -> asset.getAssetType() == Asset.AssetType.BOND)
                .mapToInt(Asset::getValue)
                .sum();
    }

    public static int getTotalStockAssets(final List<Asset> assets) {
        return assets.stream()
                .filter(asset -> asset.getAssetType() == Asset.AssetType.STOCK)
                .mapToInt(Asset::getValue)
                .sum();
    }
}
