package co.com.devco.automation.screenplay.as400.screen3270.utils;

import com.bytezone.dm3270.commands.AIDCommand;

public enum KeysScreen {
    F1(AIDCommand.AID_PF1,"PF1"),
    F2(AIDCommand.AID_PF2,"PF2"),
    F3(AIDCommand.AID_PF3,"PF3"),
    F4(AIDCommand.AID_PF4,"PF4"),
    F5(AIDCommand.AID_PF5,"PF5"),
    F6(AIDCommand.AID_PF6,"PF6"),
    F7(AIDCommand.AID_PF7,"PF7"),
    F8(AIDCommand.AID_PF8,"PF8"),
    F9(AIDCommand.AID_PF9,"PF9"),
    F10(AIDCommand.AID_PF10,"PF10"),
    F11(AIDCommand.AID_PF11,"PF11"),
    F12(AIDCommand.AID_PF12,"PF12"),
    F13(AIDCommand.AID_PF13,"PF13"),
    F14(AIDCommand.AID_PF14,"PF14"),
    F15(AIDCommand.AID_PF15,"PF15"),
    F16(AIDCommand.AID_PF16,"PF16"),
    F17(AIDCommand.AID_PF17,"PF17"),
    F18(AIDCommand.AID_PF18,"PF18"),
    F19(AIDCommand.AID_PF19,"PF19"),
    F20(AIDCommand.AID_PF20,"PF20"),
    F21(AIDCommand.AID_PF21,"PF21"),
    F22(AIDCommand.AID_PF22,"PF22"),
    F23(AIDCommand.AID_PF23,"PF23"),
    F24(AIDCommand.AID_PF24,"PF24"),
    ENTER(AIDCommand.AID_ENTER,"ENTER"),
    CLEAR(AIDCommand.AID_CLEAR,"CLR");

    private byte key;
    private String nameKey;

    KeysScreen(byte numberKey,String nameKey) {
        this.key = numberKey;
        this.nameKey = nameKey;
    }

    public byte getKey() {
        return key;
    }

    public String getNameKey(){
        return nameKey;
    }

}