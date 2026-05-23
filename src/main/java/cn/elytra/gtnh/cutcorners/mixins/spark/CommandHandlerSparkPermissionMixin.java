package cn.elytra.gtnh.cutcorners.mixins.spark;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.command.ICommandSender;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;

@Restriction(require = @Condition(value = "spark"))
@Mixin(targets = "me.lucko.spark.forge.plugin.Forge1710ServerSparkPlugin", remap = false)
public class CommandHandlerSparkPermissionMixin {

	@Inject(method = "hasPermission", at = @At("HEAD"), cancellable = true)
	private void gtnhcc$allowAllPlayersSparkPermission(ICommandSender sender, String permission, CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(true);
	}
}

