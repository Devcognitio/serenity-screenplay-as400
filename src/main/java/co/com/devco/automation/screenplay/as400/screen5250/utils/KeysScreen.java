package co.com.devco.automation.screenplay.as400.screen5250.utils;

import java.awt.event.KeyEvent;

public enum KeysScreen {
    F1(KeyEvent.VK_F1),
    F2(KeyEvent.VK_F2),
    F3(KeyEvent.VK_F3),
    F4(KeyEvent.VK_F4),
    F5(KeyEvent.VK_F5),
    F6(KeyEvent.VK_F6),
    F7(KeyEvent.VK_F7),
    F8(KeyEvent.VK_F8),
    F9(KeyEvent.VK_F9),
    F10(KeyEvent.VK_F10),
    F11(KeyEvent.VK_F11),
    F12(KeyEvent.VK_F12),
    F13(KeyEvent.VK_F13),
    F14(KeyEvent.VK_F14),
    F15(KeyEvent.VK_F15),
    F16(KeyEvent.VK_F16),
    F17(KeyEvent.VK_F17),
    F18(KeyEvent.VK_F18),
    F19(KeyEvent.VK_F19),
    F20(KeyEvent.VK_F20),
    F21(KeyEvent.VK_F21),
    F22(KeyEvent.VK_F22),
    F23(KeyEvent.VK_F23),
    F24(KeyEvent.VK_F24),
    ENTER(KeyEvent.VK_ENTER),
    FIELD_EXIT(KeyEvent.VK_PLUS),
    ROLL_UP(KeyEvent.VK_PAGE_UP),
    ROLL_DOWN(KeyEvent.VK_PAGE_DOWN),
    TAB(KeyEvent.VK_TAB),
    ERASE(0xF9);

    private int key;

    KeysScreen(int numberKey) {
        this.key = numberKey;
    }

    public int getNameKey() {
        return key;
    }
}