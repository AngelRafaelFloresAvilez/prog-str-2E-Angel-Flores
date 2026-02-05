public class ShippingCalculator {
    public double subtotal;
    public double iva;
    public double total;

    public int INICIALIZADOR = 0;
    public int PESO_KG = 12;
    public double IVA = 0.16;
    public double EXTRA_SUBTOTAL = 0.10;
    public int PRIMERA_CUOTA_DISTANCIA = 50;
    public int SEGUNDA_CUOTA_DISTANCIA = 200;
    public int PRIMER_PRECIO_DISTANCIA = 20;
    public int SEGUNDO_PRECIO_DISTANCIA = 60;
    public int TERCER_PRECIO_DISTANCIA = 120;

    /**
     * Constructor basico de la clase
     */
    public ShippingCalculator(){
    }
    /**
     * Metodo que procesa todos los metodos que calculan los precios en conjunto
     * @param pesoKg -> El peso en kilogramos ingresado por usuario y validado por InputValidator
     * @param distanciaKm -> La distancia en kilometros ingresado por usuario y validado por InputValidator
     * @param tipoServicio -> El tipo de servicio ingresado por usuario y validado por InputValidator
     * @param esZonaRemota -> La validacion de la zona remota ingresado por usuario y validado por InputValidator
     */
    public void procesar(double pesoKg, int distanciaKm, int tipoServicio, boolean esZonaRemota){
        calcularSubtotal(pesoKg, distanciaKm, tipoServicio, esZonaRemota);
        calcularIVA(this.subtotal);
        calcularTotal(this.subtotal, this.iva);
    }
    /**
     * Metodo que calcula el subtotal en base al precio, la distancia, el tipo de servicio y si es zona remota
     * @param pesoKg -> El peso en kilogramos proveniente del metodo "procesar"
     * @param distanciaKm -> La distancia en kilometros proveniente del metodo "procesar"
     * @param tipoServicio -> El tipo de servicio proveniente del metodo "procesar"
     * @param zonaRemota -> La validacion de la zona remota proveniente del metodo "procesar"
     */
    private void calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean zonaRemota){
        int precioDistancia;
        int precioServicio;
        double precioZonaRemota = INICIALIZADOR;

        double precioPeso = pesoKg * PESO_KG;

        if (distanciaKm <= PRIMERA_CUOTA_DISTANCIA) {
            precioDistancia = PRIMER_PRECIO_DISTANCIA;
        }else if(distanciaKm <= SEGUNDA_CUOTA_DISTANCIA) { // Originalmente esta linea era
            // distanciaKm > PRIMERA_CUOTA_DISTANCIA && distanciaKm <= SEGUNDA_CUOTA_DISTANCIA, pero la cambie por que la primera parte
            // era siempre true.
            precioDistancia = SEGUNDO_PRECIO_DISTANCIA;
        }else { // Lo mismo de arriba paso con esta linea que antes era un else if etc.
            precioDistancia = TERCER_PRECIO_DISTANCIA;
        }

        if(tipoServicio == 1){
            precioServicio = 50;
        }else{
            precioServicio = 90;
        }

        if(zonaRemota){
            precioZonaRemota = EXTRA_SUBTOTAL;
        }

        this.subtotal = (precioPeso + precioDistancia + precioServicio) + ((precioPeso + precioDistancia + precioServicio) * precioZonaRemota);
    }
    /**
     * Metodo que obtiene el subtotal calculado anteriormente para calcular el IVA
     * @param subtotal -> El subtotal calculado por calcularSubtotal
     */
    private void calcularIVA(double subtotal){
        this.iva = subtotal * IVA;
    }
    /**
     * Metodo que calcuulara el precio total usando el subtotal y el iva procesados anteriormente
     * @param subtotal -> El subtotal calculado por calcularSubtotal
     * @param iva -> El IVA calculado por calcularIVA
     */
    private void calcularTotal (double subtotal, double iva){
        this.total = subtotal + iva;
    }
    /**
     * Metodo que procesa el ticket final que mostrara la pantalla cuando el proceso haya finalizado
     * @param pesoKg -> El peso en kilogramos ingresado por usuario y validado por InputValidator, proveniente de App.java
     * @param distanciaKm -> La distancia en kilometros ingresado por usuario y validado por InputValidator, proveniente de App.java
     * @param tipoServicio -> El tipo de servicio ingresado por usuario y validado por InputValidator, proveniente de App.java
     * @param esZonaRemota -> La comprobacion de servicio ingresado por usuario y validado por InputValidator, proveniente de App.java
     */
    public void imprimirTicket(double pesoKg, int distanciaKm, int tipoServicio, boolean esZonaRemota){
        System.out.println(" ----- Ticket ----- ");
        System.out.println("El tipo de servicio fue " + tipoServicio + ".");
        System.out.println("El peso en kilogramos fue de " + pesoKg + " kilogramos.");
        System.out.println("La distancia fue de " + distanciaKm + " kilometros.");
        System.out.println("La zona remota esta establecida en " + esZonaRemota);
        System.out.println("Subtotal: " + this.subtotal);
        System.out.println("IVA: "+this.iva);
        System.out.println("Total: "+this.total);
        System.out.println(" ----- Ticket ----- ");
    }
}
