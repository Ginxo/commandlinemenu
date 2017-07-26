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

    public MenuBuilder addMenuOption(final Integer selection, final String text, final Boolean isExit) {
        this.menu.addMenuOption(new MenuOption(selection, text, isExit));
        return this;
    }

    public MenuBuilder addSubMenu(final Menu subMenu) {
        this.menu.addSubMenu(subMenu);
        return this;
    }

    public Menu build() {
        return this.menu;
    }
}
