package Fluid;

import java.util.function.Consumer;

public class StringEditor {

    private String text;
    
    public StringEditor(String text) {
        this.text = text;
    }
    
    public StringEditor toUpper() {
        this.text = this.text.toUpperCase();
        return this;
    }
    
    public StringEditor toLower() {
        this.text = this.text.toLowerCase();
        return this;
    }

    public StringEditor toCapital() {
        this.text = this.text.substring(0, 1).toUpperCase() + this.text.substring(1);
        return this;
    }
    
    public StringEditor reverse() {
        this.text = (new StringBuilder(this.text)).reverse().toString();
        return this;
    }

    public StringEditor replace(String patron, String cambio) {
        this.text = this.text.replaceAll(patron, cambio);
        return this;
    }

    public StringEditor filter(String filter) {
        this.text = this.text.replaceAll(filter, "");
        return this;
    }

    public int length() {
        return this.text.length();
    }

    public String toString() {
        return this.text;
    }
    
    public void apply(Consumer<String> consumer) {
        consumer.accept(this.text);
    }
    
}
