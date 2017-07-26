package mingorance.enrique.commandlinemenu;

public class MenuManager {

    private Menu menu;

    public static void main(final String... args) {
        Menu subMenu1 = MenuBuilder.createSubMenu("Menu Secundario 1", 1)
                .addMenuOption(1, "OpciónS1 1", false)
                .addMenuOption(2, "OpciónS1 2", false)
                .addMenuOption(3, "OpciónS1 3", false)
                .addMenuOption(4, "OpciónS1 4", false)
                .addMenuOption(0, "SalirS1", true)
                .build();

        Menu subMenu2 = MenuBuilder.createSubMenu("Menu Secundario 2", 2)
                .addMenuOption(1, "OpciónS2 1", false)
                .addMenuOption(2, "OpciónS2 2", false)
                .addMenuOption(3, "OpciónS2 3", false)
                .addMenuOption(4, "OpciónS2 4", false)
                .addMenuOption(0, "SalirS2", true)
                .build();


        Menu mainMenu = MenuBuilder.createMainMenu("Menu Principal")
                .addMenuOption(1, "Submenú 1", false)
                .addMenuOption(2, "Submenú 2", false)
                .addMenuOption(0, "Salir", true)
                .addSubMenu(subMenu1)
                .addSubMenu(subMenu2)
                .build();

        System.out.println(mainMenu.play());

    }

}
