/**
 *
 * @author Ricardo García
 */
public class cifradoCesar {
    private StringBuilder cadenaCifrada;
    private StringBuilder cadenaDescifrada;

    public void cifrar(String texto, int clave) {
        cadenaCifrada = new StringBuilder();
        clave = clave % 256;
        for (int i = 0; i < texto.length(); i++) {
            cadenaCifrada.append((char) (texto.charAt(i) + clave));
        }
        setCadenaCifrada(cadenaCifrada);
    }

    public void descifrar(String texto, int clave) {
        cadenaDescifrada = new StringBuilder();
        clave = clave % 256;
        for (int i = 0; i < texto.length(); i++) {
            cadenaDescifrada.append((char) (texto.charAt(i) - clave));
        }
        setCadenaDescifrada(cadenaDescifrada);
    }

    public void setCadenaCifrada(StringBuilder cadenaCifrada){
        this.cadenaCifrada = cadenaCifrada;
    }
    
    public String getCadenaCifrada(){
        return this.cadenaCifrada.toString();
    }

    public void setCadenaDescifrada(StringBuilder cadenaDescifrada){
        this.cadenaDescifrada = cadenaDescifrada;
    }

    public String getCadenaDescifrada(){
        return this.cadenaDescifrada.toString();
    }
}
