package com.backtobedrock.LiteDeathBan.runnables.CombatTag;

import com.backtobedrock.LiteDeathBan.domain.Killer;
import com.backtobedrock.LiteDeathBan.domain.data.PlayerData;
import com.backtobedrock.LiteDeathBan.domain.notifications.ActionBarNotification;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class ActionBarTag extends AbstractCombatTag {
    private final ActionBarNotification actionBarNotification;

    public ActionBarTag(Player player, PlayerData playerData, Killer tagger, ActionBarNotification actionBarNotification) {
        super(player, playerData, tagger);
        this.actionBarNotification = actionBarNotification;
    }

    @Override
    public void start() {
        super.start();
        this.player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(this.actionBarNotification.getTextStart()));
    }

    @Override
    public void stop() {
        super.stop();
        this.player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(this.actionBarNotification.getTextEnd()));
    }
}

