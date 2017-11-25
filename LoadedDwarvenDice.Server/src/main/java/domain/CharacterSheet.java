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
import javax.xml.bind.annotation.XmlTransient;
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
    int id;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    CharacterSheetList characterSheetList;

    //---General Information---
    String characterName;
    String player;
    String cClass;
    String classLevel;
    String HitPoints;
    String AC;
    String speed;
    String experience;

    //---Character Description---
    String race;
    String alignemnt;
    String religion;
    String cSize;
    String age;
    String gender;
    String height;
    String weight;
    String eye;
    String hair;
    String skin;

    //---Abilities---
    String Strength;
    String Dexterity;
    String Constitution;
    String Intelligence;
    String Wisdom;
    String Charisma;
    String baseAttackBonus;
    String spellResistance;
    String grapple;

    //---Saving Throws---
    String fortitudeBase;
    String reflexBase;
    String willBase;

    //---Skills---
    String Appraise;
    String Balance;
    String Bluff;
    String Climb;
    String Concentration;
    String Craft;
    String DecipherScript;
    String Diplomacy;
    String DisableDevice;
    String Disguise;
    String EscapeArtist;
    String Forgery;
    String GatherInformation;
    String HandleAnimal;
    String Heal;
    String Hide;
    String Intimidate;
    String Jump;
    String KnowledgeArcana;
    String KnowledgeArchitecture;
    String KnowledgeDungeoneering;
    String KnowledgeGeography;
    String KnowledgeHistory;
    String KnowledgeLocal;
    String KnowledgeNature;
    String KnowledgeNobility;
    String KnowledgeReligion;
    String KnowledgeThePlanes;
    String Listen;
    String MoveSilently;
    String OpenLock;
    String Perform;
    String Profession;
    String Ride;
    String sSearch;
    String SenseMotive;
    String SleightOfHand;
    String Spellcraft;
    String Spot;
    String Survival;
    String Swim;
    String Tumble;
    String UseMagicDevice;
    String UseRope;

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
    HashMap<String, List<String>> inventory;
    //Input order: Valuta, Amount
    HashMap<String, String> money;

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

    String spellSave;
    String arcaneSpellFailure;

    //Input order: Level, SpellsKnown, SpellSaveDC, SpellsPerDay, BonusSpells 
    HashMap<String, List<String>> spellsKnown;
    

    /**
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
     * @param Appraise
     * @param Balance
     * @param Bluff
     * @param Climb
     * @param Concentration
     * @param Craft
     * @param DecipherScript
     * @param Diplomacy
     * @param DisableDevice
     * @param Disguise
     * @param EscapeArtist
     * @param Forgery
     * @param GatherInformation
     * @param HandleAnimal
     * @param Heal
     * @param Hide
     * @param Intimidate
     * @param Jump
     * @param KnowledgeArcana
     * @param KnowledgeArchitecture
     * @param KnowledgeDungeoneering
     * @param KnowledgeGeography
     * @param KnowledgeHistory
     * @param KnowledgeLocal
     * @param KnowledgeNature
     * @param KnowledgeNobility
     * @param KnowledgeReligion
     * @param KnowledgeThePlanes
     * @param Listen
     * @param MoveSilently
     * @param OpenLock
     * @param Perform
     * @param Profession
     * @param Ride
     * @param sSearch
     * @param SenseMotive
     * @param SleightOfHand
     * @param Spellcraft
     * @param Spot
     * @param Survival
     * @param Swim
     * @param Tumble
     * @param UseMagicDevice
     * @param UseRope
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
            String level,
            String hitPoints,
            String armorClass,
            String speed,
            String experience,
            String race,
            String alignemnt,
            String deity,
            String size,
            String age,
            String gender,
            String height,
            String weight,
            String eyes,
            String hair,
            String skin,
            String str,
            String dex,
            String con,
            String intelligence,
            String wis,
            String cha,
            String baseAttackBonus,
            String spellResistance,
            String grapple,
            String fortitudeBase,
            String reflexBase,
            String willBase,
            String Appraise,
            String Balance,
            String Bluff,
            String Climb,
            String Concentration,
            String Craft,
            String DecipherScript,
            String Diplomacy,
            String DisableDevice,
            String Disguise,
            String EscapeArtist,
            String Forgery,
            String GatherInformation,
            String HandleAnimal,
            String Heal,
            String Hide,
            String Intimidate,
            String Jump,
            String KnowledgeArcana,
            String KnowledgeArchitecture,
            String KnowledgeDungeoneering,
            String KnowledgeGeography,
            String KnowledgeHistory,
            String KnowledgeLocal,
            String KnowledgeNature,
            String KnowledgeNobility,
            String KnowledgeReligion,
            String KnowledgeThePlanes,
            String Listen,
            String MoveSilently,
            String OpenLock,
            String Perform,
            String Profession,
            String Ride,
            String sSearch,
            String SenseMotive,
            String SleightOfHand,
            String Spellcraft,
            String Spot,
            String Survival,
            String Swim,
            String Tumble,
            String UseMagicDevice,
            String UseRope,
            HashMap<String, List<String>> attack,
            HashMap<String, List<String>> armourProtectiveItem,
            HashMap<String, List<String>> shieldProtectiveItem,
            HashMap<String, List<String>> protectiveItem1,
            HashMap<String, List<String>> protectiveItem2,
            HashMap<String, List<String>> inventory,
            HashMap<String, String> money,
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
            String spellSave,
            String arcaneSpellFailure,
            HashMap<String, List<String>> spellsKnown)
    {
        this.characterName = cName;
        this.player = player;
        this.cClass = cClass;
        this.classLevel = level;
        this.HitPoints = hitPoints;
        this.AC = armorClass;
        this.speed = speed;
        this.experience = experience;
        this.race = race;
        this.alignemnt = alignemnt;
        this.religion = deity;
        this.cSize = size;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.eye = eyes;
        this.hair = hair;
        this.skin = skin;
        this.Strength = str;
        this.Dexterity = dex;
        this.Constitution = con;
        this.Intelligence = intelligence;
        this.Wisdom = wis;
        this.Charisma = cha;
        this.baseAttackBonus = baseAttackBonus;
        this.spellResistance = spellResistance;
        this.grapple = grapple;
        this.fortitudeBase = fortitudeBase;
        this.reflexBase = reflexBase;
        this.willBase = willBase;

        this.Appraise = Appraise;
        this.Balance = Balance;
        this.Bluff = Bluff;
        this.Climb = Climb;
        this.Concentration = Concentration;
        this.Craft = Craft;
        this.DecipherScript = DecipherScript;
        this.Diplomacy = Diplomacy;
        this.DisableDevice = DisableDevice;
        this.Disguise = Disguise;
        this.EscapeArtist = EscapeArtist;
        this.Forgery = Forgery;
        this.GatherInformation = GatherInformation;
        this.HandleAnimal = HandleAnimal;
        this.Heal = Heal;
        this.Hide = Hide;
        this.Intimidate = Intimidate;
        this.Jump = Jump;
        this.KnowledgeArcana = KnowledgeArcana;
        this.KnowledgeArchitecture = KnowledgeArchitecture;
        this.KnowledgeDungeoneering = KnowledgeDungeoneering;
        this.KnowledgeGeography = KnowledgeGeography;
        this.KnowledgeHistory = KnowledgeHistory;
        this.KnowledgeLocal = KnowledgeLocal;
        this.KnowledgeNature = KnowledgeNature;
        this.KnowledgeNobility = KnowledgeNobility;
        this.KnowledgeReligion = KnowledgeReligion;
        this.KnowledgeThePlanes = KnowledgeThePlanes;
        this.Listen = Listen;
        this.MoveSilently = MoveSilently;
        this.OpenLock = OpenLock;
        this.Perform = Perform;
        this.Profession = Profession;
        this.Ride = Ride;
        this.sSearch = sSearch;
        this.SenseMotive = SenseMotive;
        this.SleightOfHand = SleightOfHand;
        this.Spellcraft = Spellcraft;
        this.Spot = Spot;
        this.Survival = Survival;
        this.Swim = Swim;
        this.Tumble = Tumble;
        this.UseMagicDevice = UseMagicDevice;
        this.UseRope = UseRope;

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

        this.money = money;

    }
}
