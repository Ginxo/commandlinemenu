package mingorance.enrique.commandlinemenu;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MenuOption {

    private Integer selection;
    private String text;
    private Boolean isExit;

    protected MenuOption(final Integer selection, final String text, final Boolean isExit) {
        this.selection = selection;
        this.text = text;
        this.isExit = isExit;
    }

    public void print() {
        System.out.println(String.format("%d. %s", this.getSelection(), this.getText()));
    }
}
