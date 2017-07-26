package mingorance.enrique.commandlinemenu;

public class MenuBuilder {

    private Menu menu;

    private MenuBuilder(final Menu menu) {
        this.menu = menu;
    }


    public static MenuBuilder createMainMenu(final String title) {
        return new MenuBuilder(new Menu(title));
    }

    public static MenuBuilder createSubMenu(final String title, final Integer selection) {
        return new MenuBuilder(new Menu(title, selection));
    }

    public MenuBuilder addSimpleOption(final Integer selection, final String text) {
        this.menu.addMenuOption(new MenuOption(selection, text, false));
        return this;
    }

    public MenuBuilder addExitOption(final Integer selection, final String text) {
        this.menu.addMenuOption(new MenuOption(selection, text, true));
        return this;
    }

    public MenuBuilder addSubMenuOption(final String text, final Menu subMenu) {
        this.menu.addMenuOption(new MenuOption(subMenu.getSelection(), text, false));
        this.menu.addSubMenu(subMenu);
        return this;
    }

    public Menu build() {
        return this.menu;
    }
}
