package io.github.gilbertodamim.kcore.config.langs

import io.github.gilbertodamim.kcore.config.ConfigMain
import org.bukkit.configuration.file.YamlConfiguration

object KitsLang {
    lateinit var notExist: String
    lateinit var Exist: String
    lateinit var editKitTime: String
    lateinit var createKitUsage: String
    lateinit var delKitUsage: String
    lateinit var createKitSuccess: String
    lateinit var createKitProblem: String
    lateinit var delKitSuccess: String
    lateinit var delKitProblem: String
    lateinit var editKitSuccess: String
    lateinit var editKitProblem: String
    lateinit var editkitInventoryItemsName: String
    lateinit var editkitInventoryItemsLore: List<String>
    lateinit var editkitInventoryTimeName: String
    lateinit var editkitInventoryTimeLore: List<String>
    lateinit var editkitInventoryNameName: String
    lateinit var editkitInventoryNameLore: List<String>
    lateinit var editkitInventoryTimeMessage: String
    lateinit var editkitInventoryNameMessage: String
    lateinit var kitInventoryIconBackName: String
    lateinit var kitInventoryIconNextName: String
    lateinit var kitInventoryItemsName: String
    lateinit var nameLength: String
    lateinit var kitInventoryItemsLore: List<String>
    lateinit var kitPickupMessage: String
    lateinit var kitPickupIcon: String
    lateinit var kitPickupIconNotPickup: String
    lateinit var kitInventoryIconEditkitName: String
    lateinit var notExistKits: String
    lateinit var kitPickupIconLoreNotPerm: List<String>
    lateinit var kitPickupIconLoreTime: List<String>
    lateinit var list: String
    lateinit var pickedSuccess: String
    fun reload(source1: YamlConfiguration) {
        notExist = ConfigMain.getString(source1, "Kits.not-exist", true)
        Exist = ConfigMain.getString(source1, "Kits.exist", true)
        editKitTime = ConfigMain.getString(source1, "Kits.editkit-time", true)
        createKitUsage = ConfigMain.getString(source1, "Kits.createkit-usage", true)
        delKitUsage = ConfigMain.getString(source1, "Kits.delkit-usage", true)
        createKitSuccess = ConfigMain.getString(source1, "Kits.createkit-success", true)
        createKitProblem = ConfigMain.getString(source1, "Kits.createkit-problem", true)
        delKitSuccess = ConfigMain.getString(source1, "Kits.delkit-success", true)
        delKitProblem = ConfigMain.getString(source1, "Kits.delkit-problem", true)
        editKitSuccess = ConfigMain.getString(source1, "Kits.editkit-success", true)
        editKitProblem = ConfigMain.getString(source1, "Kits.editkit-problem", true)
        editkitInventoryItemsName = ConfigMain.getString(source1, "Kits.editkit-inventory-items-name", true)
        editkitInventoryItemsLore = ConfigMain.getStringList(source1, "Kits.editkit-inventory-items-lore", true)
        editkitInventoryTimeName = ConfigMain.getString(source1, "Kits.editkit-inventory-time-name", true)
        editkitInventoryTimeMessage = ConfigMain.getString(source1, "Kits.editkit-inventory-time-message", true)
        editkitInventoryTimeLore = ConfigMain.getStringList(source1, "Kits.editkit-inventory-time-lore", true)
        editkitInventoryNameName = ConfigMain.getString(source1, "Kits.editkit-inventory-name-name", true)
        editkitInventoryNameMessage = ConfigMain.getString(source1, "Kits.editkit-inventory-name-message", true)
        editkitInventoryNameLore = ConfigMain.getStringList(source1, "Kits.editkit-inventory-name-lore", true)
        kitInventoryIconBackName = ConfigMain.getString(source1, "Kits.kit-inventory-icon-back-name", true)
        kitInventoryIconNextName = ConfigMain.getString(source1, "Kits.kit-inventory-icon-next-name", true)
        kitInventoryItemsName = ConfigMain.getString(source1, "Kits.kit-inventory-items-name", true)
        kitInventoryItemsLore = ConfigMain.getStringList(source1, "Kits.kit-inventory-items-lore", true)
        nameLength = ConfigMain.getString(source1, "Kits.name-length", true)
        kitPickupMessage = ConfigMain.getString(source1, "Kits.kit-pickup-message", true)
        kitPickupIcon = ConfigMain.getString(source1, "Kits.kit-pickup-icon", true)
        kitPickupIconNotPickup = ConfigMain.getString(source1, "Kits.kit-pickup-icon-not-pickup", true)
        kitPickupIconLoreNotPerm = ConfigMain.getStringList(source1, "Kits.kit-pickup-icon-lore-not-perm", true)
        kitPickupIconLoreTime = ConfigMain.getStringList(source1, "Kits.kit-pickup-icon-lore-time", true)
        kitInventoryIconEditkitName = ConfigMain.getString(source1, "Kits.kit-inventory-icon-editkit-name", true)
        notExistKits = ConfigMain.getString(source1, "Kits.not-exist-kits", true)
        list = ConfigMain.getString(source1, "Kits.list", true)
        pickedSuccess = ConfigMain.getString(source1, "Kits.picked-success", true)
    }
}