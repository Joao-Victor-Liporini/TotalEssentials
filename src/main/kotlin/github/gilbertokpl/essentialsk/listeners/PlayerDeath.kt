package github.gilbertokpl.essentialsk.listeners

import github.gilbertokpl.essentialsk.configs.GeneralLang
import github.gilbertokpl.essentialsk.configs.MainConfig
import github.gilbertokpl.essentialsk.configs.OtherConfig
import github.gilbertokpl.essentialsk.data.DataManager
import github.gilbertokpl.essentialsk.util.FileLoggerUtil
import github.gilbertokpl.essentialsk.util.PluginUtil
import org.apache.commons.lang3.exception.ExceptionUtils
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.PlayerDeathEvent

class PlayerDeath : Listener {
    @EventHandler
    fun event(e: PlayerDeathEvent) {
        if (MainConfig.getInstance().backActivated) {
            try {
                setBackLocation(e)
            } catch (e: Exception) {
                FileLoggerUtil.getInstance().logError(ExceptionUtils.getStackTrace(e))
            }
        }
        if (MainConfig.getInstance().messagesDeathmessagesMessage) {
            try {
                deathMessage(e)
            } catch (e: Exception) {
                FileLoggerUtil.getInstance().logError(ExceptionUtils.getStackTrace(e))
            }
        }
        if (MainConfig.getInstance().addonsPlayerPreventLoseXp) {
            try {
                loseXP(e)
            } catch (e: Exception) {
                FileLoggerUtil.getInstance().logError(ExceptionUtils.getStackTrace(e))
            }
        }
    }

    private fun loseXP(e: PlayerDeathEvent) {
        e.keepLevel = true
        e.droppedExp = 0
    }

    private fun setBackLocation(e: PlayerDeathEvent) {
        if (!e.entity.hasPermission("essentialsk.commands.back") || MainConfig.getInstance().backDisabledWorlds.contains(
                e.entity.world.name.lowercase()
            ) && !e.entity.hasPermission("essentialsk.bypass.backblockedworlds")
        ) return
        DataManager.getInstance().playerCacheV2[e.entity.name.lowercase()]?.setBack(e.entity.location) ?: return
    }

    private fun deathMessage(e: PlayerDeathEvent) {
        e.deathMessage = null
        val damageCause = e.entity.player!!.lastDamageCause ?: run {
            PluginUtil.getInstance().serverMessage(
                GeneralLang.getInstance().deathmessagesNothingKillPlayer
                    .replace("%player%", e.entity.player!!.name)
            )
            return
        }

        if (damageCause.cause == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
            val ent = damageCause as EntityDamageByEntityEvent
            if (ent.damager is Player) {
                PluginUtil.getInstance().serverMessage(
                    GeneralLang.getInstance().deathmessagesPlayerKillPlayer
                        .replace("%player%", e.entity.player!!.name)
                        .replace("%killer%", ent.damager.name)
                )
                return
            }
            val causeMessage =
                OtherConfig.getInstance().deathmessageListReplacer[ent.damager.toString().lowercase()] ?: run {
                    ent.damager.toString().lowercase()
                }
            PluginUtil.getInstance().serverMessage(
                GeneralLang.getInstance().deathmessagesEntityKillPlayer
                    .replace("%player%", e.entity.player!!.name)
                    .replace("%entity%", causeMessage)
            )
            return
        }

        val causeMessage =
            OtherConfig.getInstance().deathmessageListReplacer[damageCause.cause.name.lowercase()] ?: run {
                PluginUtil.getInstance().consoleMessage(
                    GeneralLang.getInstance().deathmessagesCauseNotExist
                        .replace("%cause%", damageCause.cause.name.lowercase())
                )
                PluginUtil.getInstance().serverMessage(
                    GeneralLang.getInstance().deathmessagesNothingKillPlayer
                        .replace("%player%", e.entity.player!!.name)
                )
                return
            }
        PluginUtil.getInstance().serverMessage(
            causeMessage.replace("%player%", e.entity.player!!.name)
        )
    }
}