package mod.acgaming.universaltweaks.tweaks.mixin;

import net.minecraft.entity.player.EntityPlayer;

import mod.acgaming.universaltweaks.UniversalTweaks;
import mod.acgaming.universaltweaks.config.UTConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityPlayer.class)
public class UTLinearXPMixin
{
    @Inject(method = "xpBarCap", at = @At("HEAD"), cancellable = true)
    public void utLinearXP(CallbackInfoReturnable<Integer> cir)
    {
        if (UTConfig.tweaks.utLinearXP < 1) return;
        if (UTConfig.debug.utDebugToggle) UniversalTweaks.LOGGER.debug("UTLinearXP ::: XP bar cap");
        cir.setReturnValue(UTConfig.tweaks.utLinearXP);
    }
}