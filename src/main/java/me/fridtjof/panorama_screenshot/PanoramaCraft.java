package me.fridtjof.panorama_screenshot;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class PanoramaCraft implements ModInitializer {
	ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	public static final Logger LOGGER = LoggerFactory.getLogger("panorama_craft");
	private final File GAME_DIR = new File(FabricLoader.getInstance().getGameDir().toString());
	private final File SCREENSHOT_DIR = new File(FabricLoader.getInstance().getGameDir().toString() + "/screenshots/");
	private final String PANORAMA_NAMES = "panorama_0.png – panorama_5.png";
	public static KeyBinding panoramaKeyBinding0 = KeyBindingHelper.registerKeyBinding(new KeyBinding("Take Panorama Screenshot0", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_F4, "Panorama Screenshot"));
	public static KeyBinding panoramaKeyBinding1 = KeyBindingHelper.registerKeyBinding(new KeyBinding("Take Panorama Screenshot1", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_F4, "Panorama Screenshot"));
	public static KeyBinding panoramaKeyBinding2 = KeyBindingHelper.registerKeyBinding(new KeyBinding("Take Panorama Screenshot2", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_F4, "Panorama Screenshot"));
	public static KeyBinding panoramaKeyBinding3 = KeyBindingHelper.registerKeyBinding(new KeyBinding("Take Panorama Screenshot3", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_F4, "Panorama Screenshot"));
	public static KeyBinding panoramaKeyBinding4 = KeyBindingHelper.registerKeyBinding(new KeyBinding("Take Panorama Screenshot4", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_F4, "Panorama Screenshot"));
	public static KeyBinding panoramaKeyBinding5 = KeyBindingHelper.registerKeyBinding(new KeyBinding("Take Panorama Screenshot5", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_F4, "Panorama Screenshot"));
	@Override
	public void onInitialize() {
		System.out.println("Initializing JouTakorama!");
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (panoramaKeyBinding0.wasPressed()) {
				PlayerEntity player = MinecraftClient.getInstance().player;
				assert player != null;
				float[] angle = {-90, 0};
				player.setYaw(angle[0]);
				player.setPitch(angle[1]);
				ScreenshotRecorder.saveScreenshot(GAME_DIR, MinecraftClient.getInstance().getFramebuffer(), message -> {
					player.sendMessage(Text.translatable("screenshot.success", message), false);
				});
			}
			while (panoramaKeyBinding1.wasPressed()) {
				PlayerEntity player = MinecraftClient.getInstance().player;
				assert player != null;
				float[] angle = {0, 0};
				player.setYaw(angle[0]);
				player.setPitch(angle[1]);
				ScreenshotRecorder.saveScreenshot(GAME_DIR, MinecraftClient.getInstance().getFramebuffer(), message -> {
					player.sendMessage(Text.translatable("screenshot.success", message), false);
				});
			}
			while (panoramaKeyBinding2.wasPressed()) {
				PlayerEntity player = MinecraftClient.getInstance().player;
				assert player != null;
				float[] angle = {90, 0};
				player.setYaw(angle[0]);
				player.setPitch(angle[1]);
				ScreenshotRecorder.saveScreenshot(GAME_DIR, MinecraftClient.getInstance().getFramebuffer(), message -> {
					player.sendMessage(Text.translatable("screenshot.success", message), false);
				});
			}
			while (panoramaKeyBinding3.wasPressed()) {
				PlayerEntity player = MinecraftClient.getInstance().player;
				assert player != null;
				float[] angle = {180, 0};
				player.setYaw(angle[0]);
				player.setPitch(angle[1]);
				ScreenshotRecorder.saveScreenshot(GAME_DIR, MinecraftClient.getInstance().getFramebuffer(), message -> {
					player.sendMessage(Text.translatable("screenshot.success", message), false);
				});
			}
			while (panoramaKeyBinding4.wasPressed()) {
				PlayerEntity player = MinecraftClient.getInstance().player;
				assert player != null;
				float[] angle = {-90, -90};
				player.setYaw(angle[0]);
				player.setPitch(angle[1]);
				ScreenshotRecorder.saveScreenshot(GAME_DIR, MinecraftClient.getInstance().getFramebuffer(), message -> {
					player.sendMessage(Text.translatable("screenshot.success", message), false);
				});
			}
			while (panoramaKeyBinding5.wasPressed()) {
				PlayerEntity player = MinecraftClient.getInstance().player;
				assert player != null;
				float[] angle = {-90, 90};
				player.setYaw(angle[0]);
				player.setPitch(angle[1]);
				ScreenshotRecorder.saveScreenshot(GAME_DIR, MinecraftClient.getInstance().getFramebuffer(), message -> {
					player.sendMessage(Text.translatable("screenshot.success", message), false);
				});
			}
			Text panoramaTakenText = Text.literal(PANORAMA_NAMES).formatted(Formatting.UNDERLINE).styled((style) -> {
				return style.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, SCREENSHOT_DIR.getAbsolutePath()));
			});

		});
	}
}