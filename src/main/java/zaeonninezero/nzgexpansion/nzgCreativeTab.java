package zaeonninezero.nzgexpansion;

import com.mrcrayfish.guns.item.GunItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import zaeonninezero.nzgexpansion.init.initItems;

public class nzgCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, nzgExpansion.MOD_ID);
    public static final RegistryObject<CreativeModeTab> NZG_TAB = CREATIVE_TABS.register("nzg_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + nzgExpansion.MOD_ID))
            .icon(() -> {
                ItemStack stack = new ItemStack(initItems.REVOLVER.get());
                stack.getOrCreateTag().putBoolean("IgnoreAmmo", true);
                return stack;
            })
            .displayItems((flags, output) ->
            {
                initItems.ITEMS.getEntries().forEach(registryObject ->
                {
                    if(registryObject.get() instanceof GunItem item)
                    {
                        ItemStack stack = new ItemStack(item);
                        stack.getOrCreateTag().putInt("AmmoCount", item.getGun().getGeneral().getMaxAmmo());
                        output.accept(stack);
                        return;
                    }
                    output.accept(registryObject.get());
                });
            })
            .build());
}
