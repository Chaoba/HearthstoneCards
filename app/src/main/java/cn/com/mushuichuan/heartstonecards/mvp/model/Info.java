package cn.com.mushuichuan.heartstonecards.mvp.model;

import java.util.ArrayList;

/**
 * Created by Liyanshun on 2016/2/18.
 * {
 "patch": "4.1.0.10956",
 "classes": [
 "Druid",
 "Hunter",
 "Mage",
 "Paladin",
 "Priest",
 "Rogue",
 "Shaman",
 "Warlock",
 "Warrior",
 "Dream"
 ],
 "sets": [
 "Basic",
 "Classic",
 "Credits",
 "Naxxramas",
 "Slush",
 "Goblins vs Gnomes",
 "Missions",
 "Promo",
 "Reward",
 "System",
 "Blackrock Mountain",
 "Hero Skins",
 "Tavern Brawl",
 "The Grand Tournament",
 "The League of Explorers"
 ],
 "types": [
 "Hero",
 "Minion",
 "Spell",
 "Enchantment",
 "Weapon",
 "Hero Power"
 ],
 "factions": [
 "Horde",
 "Alliance",
 "Neutral"
 ],
 "qualities": [
 "Free",
 "Common",
 "Rare",
 "Epic",
 "Legendary"
 ],
 "races": [
 "Demon",
 "Dragon",
 "Mech",
 "Murloc",
 "Beast",
 "Pirate",
 "Totem"
 ],
 "locales": [
 "deDE",
 "enGB",
 "enUS",
 "esES",
 "esMX",
 "frFR",
 "itIT",
 "koKR",
 "plPL",
 "ptBR",
 "ruRU",
 "zhCN",
 "zhTW",
 "jaJP"
 ]
 }
 */
public class Info {
    public String patch;
    public ArrayList<String> classes;
    public ArrayList<String> sets;
    public ArrayList<String> types;
    public ArrayList<String> factions;
    public ArrayList<String> qualities;
    public ArrayList<String> races;
    public ArrayList<String> locales;
}
