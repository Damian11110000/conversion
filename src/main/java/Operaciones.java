import javax.swing.*;

public class Operaciones {

    private Double dollar;
    private Double euros;

    public Operaciones(){
        dollar=17.09;
        euros=18.79;
    }

    public void init(){

        while (true){
            MenusUtils menu = new MenusUtils(new String[]{"Conversion de monedas","Conversion de temperatura"},
                    "Menu","Seleccione una opcion de conversion",null);
            String mensaje = menu.obtenerMensaje(menu.inputMenu());

           switch (mensaje){
               case "Conversion de monedas":
                   String cantidad = operacion(menu,null,"Input","Ingresa la cantidad de dinero que deseas convertir",null);
                   conversionMoneda(cantidad);
                   break;
               case "Conversion de temperatura":
                   String temp = operacion(menu,null,"Input","Ingresa la cantidad temperatura",null);
                   conversionTemp(temp);
                   break;
               default:
                   System.out.println("Opcion invalida");
           }

           if(confirm(menu,"Continuar","¿Desea continuar con la ejecucion del programa?")){
               show(menu,"Fin","fin del programa");
               break;
           }

        }
    }

    private String operacion(MenusUtils menu,String[] opciones, String titulo, String descripcion, Icon icon){
        menu.setOpciones(opciones);
        menu.setTitulo(titulo);
        menu.setDescription(descripcion);
        return menu.obtenerMensaje(menu.inputMenu());
    }

    private void show(MenusUtils menu,String titulo,String descripcion){
        menu.setTitulo(titulo);
        menu.setDescription(descripcion);
        menu.showMenu();
    }

    private boolean confirm(MenusUtils menu,String titulo,String descripcion){
        menu.setTitulo(titulo);
        menu.setDescription(descripcion);
        return menu.confirmMenu()!=0 ? true: false;
    }

    private void conversionMoneda(String cantidad){
        MenusUtils menu = new MenusUtils();
        Double monedas = 0.0;

        if(cantidad.equals("NoOpcion")){
            //Lanzar un error de opcion
        }
        try {
            monedas = Double.parseDouble(cantidad);
        }catch (NumberFormatException e){
            show(menu,"Error","El numero especificado es incorrecto");
            return;
        }

        String accion = operacion( menu,new String[]{"Pesos a Dollar","Pesos a Euros","Dollar a Pesos","Euros a Pesos"},
                "Input",
                "Elije la moneda que deseas convertir a tu moneda",
                null);

        switch (accion){
            case "Pesos a Dollar":
                show(menu,"Conversion","El cambio a dolares es: "+monedas/dollar);
                break;
            case "Pesos a Euros":
                show(menu,"Conversion","El cambio a euros es: "+monedas/euros);
                break;
            case "Dollar a Pesos":
                show(menu,"Conversion","El cambio a euros es: "+monedas*dollar);
                break;
            case "Euros a Pesos":
                show(menu,"Conversion","El cambio a euros es: "+monedas*euros);
                break;
            default:
                show(menu,"Error","Opcion no valida");
        }

    }

    private void conversionTemp(String cantidad){
        MenusUtils menu = new MenusUtils();
        Double temp = 0.0;

        if(cantidad.equals("NoOpcion")){
            //Lanzar un error de opcion
        }
        try {
            temp = Double.parseDouble(cantidad);
        }catch (NumberFormatException e){
            show(menu,"Error","La temperatiura especificada es incorrecta");
            return;
        }

        String accion = operacion( menu,new String[]{"Celcius a Farenheit","Celcius a Kelvin","Kelvin a Celcius","Farenheit a Celcius"},
                "Input",
                "Elije la conversion",
                null);

        switch (accion){
            case "Celcius a Farenheit":
                show(menu,"Conversion","El cambio de celcius a Farenheit: "+(temp*1.8+32));
                break;
            case "Celcius a Kelvin":
                show(menu,"Conversion","El cambio de celcius a Farenheit: "+(temp+273.15));
                break;
            case "Kelvin a Celcius":
                show(menu,"Conversion","El cambio de Kelvin a Celcius: "+(temp-273.15));
                break;
            case "Farenheit a Celcius":
                show(menu,"Conversion","El cambio de Farenheit a Celcius: "+((temp-32)/1.8));
                break;
            default:
                show(menu,"Error","Opcion no valida");
        }

    }


}
