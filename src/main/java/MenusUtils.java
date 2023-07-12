import javax.swing.*;

public class MenusUtils {

    private String[] opciones;
    private String titulo;
    private String description;

    private Icon icon;

    public MenusUtils() {
    }

    public MenusUtils(String[] opciones, String titulo, String description, Icon icon) {
        this.opciones = opciones;
        this.titulo = titulo;
        this.description = description;
        this.icon = icon;
    }

    public Object inputMenu(){
        if(titulo ==null || description ==null ) {
            return null;
        }
        if(opciones==null){
            return  JOptionPane.showInputDialog(null, description
                    , titulo, JOptionPane.PLAIN_MESSAGE,
                    icon,null,null);
        }
        return  JOptionPane.showInputDialog(null, description
                , titulo, JOptionPane.PLAIN_MESSAGE,
                icon, opciones, opciones[0]);
    }

    public void showMenu(){
        JOptionPane.showMessageDialog(null,description,titulo,JOptionPane.PLAIN_MESSAGE,icon);
    }

    public int confirmMenu(){
        return JOptionPane.showConfirmDialog(null,description,titulo,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,icon);
    }

    public String obtenerMensaje(Object mensaje){
        return (mensaje==null) ? "NoOpcion" : mensaje.toString();
    }

    public String[] getOpciones() {
        return opciones;
    }

    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}
