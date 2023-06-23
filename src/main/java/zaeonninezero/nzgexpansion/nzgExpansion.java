package zaeonninezero.nzgexpansion;

import zaeonninezero.nzgexpansion.init.*;
import zaeonninezero.nzgexpansion.client.ClientHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("nzgexpansion")
public class nzgExpansion {
	public static final String MOD_ID = "nzgexpansion";
	
	public nzgExpansion() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::setup);
		
		MinecraftForge.EVENT_BUS.register(this);
		
		//Registers all of the Deferred Registers from the init classes.
		initItems.ITEMS.register(bus);
		initSounds.SOUNDS.register(bus);
		
		bus.addListener(this::onClientSetup);
	}
	
	//Common setup
	private void setup(final FMLCommonSetupEvent event) {
		System.out.println("NineZero's Gun Expansion pre-initialized.");
	}
	
	//Client setup
	private void onClientSetup(FMLClientSetupEvent event) {
		ClientHandler.setup();
	}
}