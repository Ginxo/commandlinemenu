package mingorance.enrique.commandlinemenu;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
public class Menu {

    @Getter(AccessLevel.PUBLIC)
    private String header;
    private Integer selection;
    private List<MenuOption> menuOptions;
    private List<Menu> subMenus;


    protected Menu(final String header) {
        this.header = header;
    }

    protected Menu(final String header, final Integer selection) {
        this.header = header;
        this.selection = selection;
    }

    protected void addMenuOption(final MenuOption menuOption) {
        if (this.menuOptions == null) {
            this.menuOptions = new ArrayList<>();
        }
        this.menuOptions.add(menuOption);
    }

    protected void addSubMenu(final Menu subMenu) {
        if (this.subMenus == null) {
            this.subMenus = new ArrayList<>();
        }
        this.subMenus.add(subMenu);
    }

    private void print() {
        System.out.println("*******************************************************");
        System.out.println(String.format("*************************** %s ************************", this.getHeader()));
        System.out.println("*******************************************************");
        System.out.println("");
        this.menuOptions.stream().sorted((a, b) -> Integer.compare(a.getSelection(), a.getSelection())).forEach(MenuOption::print);
    }

    private void play(final Integer selection) {
        this.subMenus.stream().filter(m -> m.getSelection() == selection).findFirst().orElse(null).play();
    }

    public String play() {
        this.print();
        Integer selectedItem;
        final Scanner in = new Scanner(System.in);
        do {
            System.out.print("Introduzca su selección ");
            selectedItem = in.nextInt();
        } while (!this.isValidSelection(selectedItem));
        if (this.isExit(selectedItem)) {
            return null;
        } else {
            Menu selectedSubMenu = this.getSubMenu(selectedItem);
            if (selectedSubMenu == null) {
                return "." + selectedItem;
            } else {
                final String subMenuSelection = selectedSubMenu.play();
                if (subMenuSelection == null) {
                    return this.play();
                }
                return selectedItem + subMenuSelection;
            }
        }
    }

    private Boolean isValidSelection(final Integer selection) {
        return this.subMenus == null || this.isExit(selection) || this.getSubMenu(selection) != null;
    }

    private Boolean isExit(final Integer selection) {
        MenuOption menuOption = this.menuOptions.stream().filter(mO -> mO.getIsExit() && mO.getSelection() == selection).findFirst().orElse(null);
        return menuOption != null;
    }

    private Menu getSubMenu(final Integer selection) {
        return this.subMenus == null ? null : this.subMenus.stream().filter(m -> m.getSelection() == selection).findFirst().orElse(null);
    }


}
