/**
 * Ciencias de la Computacion II
 * Nombre: Werner Garcia
 * Carnet: 031-43059
 * Fecha: 25/08/13 12:21 AM
 * Proyecto #1 - Bmp Image Handler
 */

package lib.CliManager;

/***
 * Clase para manejar las opciones individuales.
 * Utiliza el patron Builder
 */
public class Option {

    private String longOpt;
    private String description;
    private String opt;
    private String argName;
    private boolean hasArg = false;

    private Option(final Builder _builder){
        this.argName = _builder.argName;
        this.longOpt = _builder.longOpt;
        this.description = _builder.description;
        this.opt = _builder.opt;
        this.hasArg = _builder.hasArg;
    }

    public String getLongOpt() {
        return this.longOpt;
    }

    public String getDescription() {
        return this.description;
    }

    public String getOpt() {
        return this.opt;
    }

    public String getArgName() {
        return this.argName;
    }

    public boolean getHasArg() {
        return this.hasArg;
    }

    public void setArgName(String argName) {
        this.argName = argName;
    }

    public void setHasArg() {
        this.hasArg = true;
    }

    public static Builder builder()
    {
        return builder(null);
    }

    public static Builder builder(final String opt)
    {
        return new Builder(opt);
    }

    public static class Builder {
        private String longOpt;
        private String description;
        private String opt;
        private String argName;
        private boolean hasArg = false;

        private Builder(final String opt) {
            this.opt = opt;
        }

        public Builder longOpt(String s) {
            this.longOpt = s;
            return this;
        }

        public Builder desc(String s) {
            this.description = s;
            return this;
        }

        public Builder hasArg() {
            this.hasArg = true;
            return this;
        }

        public Builder argName(String s) {
            this.argName = s;
            return this;
        }

        public Option build() {
            return new Option(this);
        }

    }

}
