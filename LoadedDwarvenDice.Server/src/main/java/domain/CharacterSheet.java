package domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
    Integer id;

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

    public CharacterSheet(int id)
    {
        this.id = id;
    }
    
    public CharacterSheet()
    {
    } 
}