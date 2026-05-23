package cn.elytra.gtnh.cutcorners.mixins.spark;

import net.minecraft.network.rcon.RConConsoleSource;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;

@Restriction(require = @Condition(value = "spark"))
@Mixin(targets = "me.lucko.spark.forge.plugin.Forge1710SparkPlugin", remap = false)
public class CommandHandlerSparkRconEchoMixin {

    @Inject(method = "func_71515_b", at = @At("RETURN"))
    private void gtnhcc$notifyRconCommandCompletion(ICommandSender sender, String[] args, CallbackInfo ci) {
        if (!(sender instanceof RConConsoleSource)) {
            return;
        }
        sender.addChatMessage(new ChatComponentText("[spark] command processed"));
    }
}

