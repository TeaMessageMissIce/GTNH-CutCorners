package cn.elytra.gtnh.cutcorners.mixinloader;

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unused")
@LateMixin
public class SparkOptionalMixinLoader implements ILateMixinLoader {

    @Override
    public String getMixinConfig() {
        return "mixins.spark_optional.json";
    }

    @Override
    public @NotNull List<String> getMixins(Set<String> loadedMods) {
        return Arrays.asList(
            "CommandHandlerSparkPermissionMixin",
            "CommandHandlerSparkRconEchoMixin"
        );
    }
}
