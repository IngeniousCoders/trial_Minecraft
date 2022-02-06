package com.ingeniousmc.tutrialmod.events;


import com.ingeniousmc.tutrialmod.commands.ReturnHomeCommand;
import com.ingeniousmc.tutrialmod.commands.SetHomeCommand;
import com.ingeniousmc.tutrialmod.tutorialMod;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = tutorialMod.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        new SetHomeCommand(event.getDispatcher());
        new ReturnHomeCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onPlayerCloneEvent(PlayerEvent.Clone event) {
        if(!event.getOriginal().getEntityWorld().isRemote()) {
            event.getPlayer().getPersistentData().putIntArray(tutorialMod.MOD_ID + "homepos",
                    event.getOriginal().getPersistentData().getIntArray(tutorialMod.MOD_ID + "homepos"));
        }
    }
}