package mingorance.enrique.commandlinemenu;

public class MenuManager {

    private Menu menu;

    public static void main(final String... args) {
        Menu subMenu1 = MenuBuilder.createSubMenu("Menu Secundario 1", 1)
                .addSimpleOption(1, "OpciónS1 1")
                .addSimpleOption(2, "OpciónS1 2")
                .addSimpleOption(3, "OpciónS1 3")
                .addSimpleOption(4, "OpciónS1 4")
                .addExitOption(0, "SalirS1")
                .build();

        Menu subMenu2 = MenuBuilder.createSubMenu("Menu Secundario 2", 2)
                .addSimpleOption(1, "OpciónS2 1")
                .addSimpleOption(2, "OpciónS2 2")
                .addSimpleOption(3, "OpciónS2 3")
                .addSimpleOption(4, "OpciónS2 4")
                .addExitOption(0, "SalirS2")
                .build();


        Menu mainMenu = MenuBuilder.createMainMenu("Menu Principal")
                .addSubMenuOption("Submenú 1", subMenu1)
                .addSubMenuOption("Submenú 2", subMenu2)
                .addExitOption(0, "Salir")
                .build();

        System.out.println(mainMenu.play());

    }

}
