package design;

import org.junit.Test;
import utils.Asset;
import utils.AssetAdderFunctional;
import utils.AssetAdderInefficient;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SeparationOfConcernsMethodLevel {

    private final List<Asset> assets = Arrays.asList(
            new Asset(Asset.AssetType.BOND,1000),
            new Asset(Asset.AssetType.BOND,2000),
            new Asset(Asset.AssetType.STOCK,3000),
            new Asset(Asset.AssetType.STOCK,4000)
    );

    @Test
    public void shouldCountAllAssets(){
        assertThat(AssetAdderInefficient.getTotalAssets(assets)).isEqualTo(10000);

        assertThat(
                AssetAdderFunctional.getAddedAssets(assets,
                        asset -> true)
        ).isEqualTo(10000);
    }
    
    @Test
    public void shouldCountBondAssets(){
        assertThat(AssetAdderInefficient.getTotalBondAssets(assets)).isEqualTo(3000);

        assertThat(
                AssetAdderFunctional.getAddedAssets(assets,
                        asset -> asset.getAssetType().equals(Asset.AssetType.BOND))
        ).isEqualTo(3000);
    }
    
    @Test
    public void shouldCountStockAssets(){
        assertThat(AssetAdderInefficient.getTotalStockAssets(assets)).isEqualTo(7000);

        assertThat(
                AssetAdderFunctional.getAddedAssets(assets,
                asset -> asset.getAssetType().equals(Asset.AssetType.STOCK))
        ).isEqualTo(7000);
    }
}
