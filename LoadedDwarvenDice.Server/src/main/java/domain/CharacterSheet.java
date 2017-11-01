package domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * TODO:Documentation!
 *
 * @author Alexander Eilert Berg
 */
@Entity
@Data
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CharacterSheet implements Serializable
{
    @Id
    @GeneratedValue
    Long id;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    CharacterSheetList characterSheetList;
    
    //---General Information---
    String cName;
    String player;
    String cClass;
    Integer level;
    Integer hitPoints;
    Integer armorClass;
    Integer speed;
    Integer experience;

    //---Character Description---
    String race;
    String alignemnt;
    String deity;
    String size;
    Integer age;
    String gender;
    Integer height;
    Integer weight;
    String eyes;
    String hair;
    String skin;

    //---Abilities---
    Integer str;
    Integer dex;
    Integer con;
    Integer intelligence;
    Integer wis;
    Integer cha;
    Integer baseAttackBonus;
    Integer spellResistance;
    Integer grapple;

    //---Saving Throws---
    Integer fortitudeBase;
    Integer reflexBase;
    Integer willBase;

    //---Skills---
    //Input order: SkillName,KeyAbility,AbilityMod,Ranks,Misc  
    HashMap<List<String>, List<Integer>> skills;

    //---Attack---
    //Input order:
    HashMap<String, List<String>> attack;

    //---Gear---
    //Input order: ItemName, Type, ACBonus, MaxDex, CheckPenalty, SpellFailure, Speed, Weight, SpecialProperties
    HashMap<String, List<String>> armourProtectiveItem;
    //Input order: ItemName, ACBonus, Weight, CheckPenalty, SpellFailure, SpecialProperties
    HashMap<String, List<String>> shieldProtectiveItem;
    //Input order: ItemName, ACBonus, Weight, SpecialProperties
    HashMap<String, List<String>> protectiveItem1;
    //Input order: ItemName, ACBonus, Weight, SpecialProperties
    HashMap<String, List<String>> protectiveItem2;

    //---Other possessions---
    //Input order: ItemName, Amount, Weight
    HashMap<String, List<Integer>> inventory;
    //Input order: Valuta, Amount
    HashMap<String, Integer> money;

    //---Feats---
    List<String> feats;

    //---Special abilities---
    List<String> specialAbilities;

    //---Other---
    List<String> languages;

    //---Spells---
    List<String> domainORSpecialitySchool;

    List<String> level0Spells;
    List<String> level1Spells;
    List<String> level2Spells;
    List<String> level3Spells;
    List<String> level4Spells;
    List<String> level5Spells;
    List<String> level6Spells;
    List<String> level7Spells;
    List<String> level8Spells;
    List<String> level9Spells;

    Integer spellSave;
    Integer arcaneSpellFailure;

    //Input order: Level, SpellsKnown, SpellSaveDC, SpellsPerDay, BonusSpells 
    HashMap<Integer, List<Integer>> spellsKnown;

    /**
     * TODO: Add Documentation
     * 
     * @param cName
     * @param player
     * @param cClass
     * @param level
     * @param hitPoints
     * @param armorClass
     * @param speed
     * @param experience
     * @param race
     * @param alignemnt
     * @param deity
     * @param size
     * @param age
     * @param gender
     * @param height
     * @param weight
     * @param eyes
     * @param hair
     * @param skin
     * @param str
     * @param dex
     * @param con
     * @param intelligence
     * @param wis
     * @param cha
     * @param baseAttackBonus
     * @param spellResistance
     * @param grapple
     * @param fortitudeBase
     * @param reflexBase
     * @param willBase
     * @param skills
     * @param attack
     * @param armourProtectiveItem
     * @param shieldProtectiveItem
     * @param protectiveItem1
     * @param protectiveItem2
     * @param inventory
     * @param money
     * @param feats
     * @param specialAbilities
     * @param languages
     * @param domainORSpecialitySchool
     * @param level0Spells
     * @param level1Spells
     * @param level2Spells
     * @param level3Spells
     * @param level4Spells
     * @param level5Spells
     * @param level6Spells
     * @param level7Spells
     * @param level8Spells
     * @param level9Spells
     * @param spellSave
     * @param arcaneSpellFailure
     * @param spellsKnown 
     */
    public CharacterSheet(
            String cName,
            String player,
            String cClass,
            Integer level,
            Integer hitPoints,
            Integer armorClass,
            Integer speed,
            Integer experience,
            String race,
            String alignemnt,
            String deity,
            String size,
            Integer age,
            String gender,
            Integer height,
            Integer weight,
            String eyes,
            String hair,
            String skin,
            Integer str,
            Integer dex,
            Integer con,
            Integer intelligence,
            Integer wis,
            Integer cha,
            Integer baseAttackBonus,
            Integer spellResistance,
            Integer grapple,
            Integer fortitudeBase,
            Integer reflexBase,
            Integer willBase,
            HashMap<List<String>, List<Integer>> skills,
            HashMap<String, List<String>> attack,
            HashMap<String, List<String>> armourProtectiveItem,
            HashMap<String, List<String>> shieldProtectiveItem,
            HashMap<String, List<String>> protectiveItem1,
            HashMap<String, List<String>> protectiveItem2,
            HashMap<String, List<Integer>> inventory,
            HashMap<String, Integer> money,
            List<String> feats,
            List<String> specialAbilities,
            List<String> languages,
            List<String> domainORSpecialitySchool,
            List<String> level0Spells,
            List<String> level1Spells,
            List<String> level2Spells,
            List<String> level3Spells,
            List<String> level4Spells,
            List<String> level5Spells,
            List<String> level6Spells,
            List<String> level7Spells,
            List<String> level8Spells,
            List<String> level9Spells,
            Integer spellSave,
            Integer arcaneSpellFailure,
            HashMap<Integer, List<Integer>> spellsKnown)
    {
        this.cName = cName;
        this.player = player;
        this.cClass = cClass;
        this.level = level;
        this.hitPoints = hitPoints;
        this.armorClass = armorClass;
        this.speed = speed;
        this.experience = experience;
        this.race = race;
        this.alignemnt = alignemnt;
        this.deity = deity;
        this.size = size;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.eyes = eyes;
        this.hair = hair;
        this.skin = skin;
        this.str = str;
        this.dex = dex;
        this.con = con;
        this.intelligence = intelligence;
        this.wis = wis;
        this.cha = cha;
        this.baseAttackBonus = baseAttackBonus;
        this.spellResistance = spellResistance;
        this.grapple = grapple;
        this.fortitudeBase = fortitudeBase;
        this.reflexBase = reflexBase;
        this.willBase = willBase;

        this.attack = attack;
        this.armourProtectiveItem = armourProtectiveItem;
        this.shieldProtectiveItem = shieldProtectiveItem;
        this.protectiveItem1 = protectiveItem1;
        this.protectiveItem2 = protectiveItem2;
        this.inventory = inventory;

        this.feats = feats;
        this.specialAbilities = specialAbilities;
        this.languages = languages;
        this.domainORSpecialitySchool = domainORSpecialitySchool;
        this.level0Spells = level0Spells;
        this.level1Spells = level1Spells;
        this.level2Spells = level2Spells;
        this.level3Spells = level3Spells;
        this.level4Spells = level4Spells;
        this.level5Spells = level5Spells;
        this.level6Spells = level6Spells;
        this.level7Spells = level7Spells;
        this.level8Spells = level8Spells;
        this.level9Spells = level9Spells;
        this.spellSave = spellSave;
        this.arcaneSpellFailure = arcaneSpellFailure;
        this.spellsKnown = spellsKnown;

        this.skills = skills;
        this.money = money;

    }
}
