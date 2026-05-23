package cn.elytra.gtnh.cutcorners.mixinloader;

import cpw.mods.fml.common.Loader;
import me.fallenbreath.conditionalmixin.api.mixin.RestrictiveMixinConfigPlugin;

import java.util.List;
import java.util.Set;

public class SparkOptionalMixinPlugin extends RestrictiveMixinConfigPlugin {

    private static final String[] SPARK_CLASS_CANDIDATES = {
        "me.lucko.spark.common.command.SparkCommand",
        "me.lucko.spark.command.SparkCommand",
        "me.lucko.spark.SparkCommand",
        "me.lucko.spark.common.command.CommandSpark"
    };

    private Boolean sparkLoaded;

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return isSparkPresent();
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
    }

    @Override
    public List<String> getMixins() {
        return null;
    }


    private boolean isSparkPresent() {
        if (sparkLoaded != null) {
            return sparkLoaded;
        }

        boolean loaded = false;
        try {
            loaded = Loader.isModLoaded("spark");
        } catch (Throwable ignored) {
        }

        if (!loaded) {
            for (String className : SPARK_CLASS_CANDIDATES) {
                try {
                    Class.forName(className, false, SparkOptionalMixinPlugin.class.getClassLoader());
                    loaded = true;
                    break;
                } catch (Throwable ignored) {
                }
            }
        }

        sparkLoaded = loaded;
        return loaded;
    }
}

