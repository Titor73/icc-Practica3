public class EditorTexto {
    private StringBuilder contenido;
    private StringBuilder anterior;

    public EditorTexto() {
        this.contenido = new StringBuilder();
        this.anterior = null;
    }

    private void guardar() {
        this.anterior = new StringBuilder(this.contenido.toString());
    }

    private boolean rango(int inicio, int fin) {
        return inicio>=0 && fin>=inicio && fin<=contenido.length();
    }

    private boolean indice(int posicion) {
        return posicion>=0 && posicion<=contenido.length();
    }

    public void escribir(String texto) {
        if (texto == null || texto.isEmpty()) return;
        guardar();
        contenido.append(texto);
    }

    public void insertar(int posicion, String texto) {
        if (texto == null || texto.isEmpty()) return;
        if (!indice(posicion)) return;
        guardar();
        contenido.insert(posicion, texto);
    }

    public void eliminar(int inicio, int fin) {
        if (!rango(inicio, fin)) return;
        guardar();
        contenido.delete(inicio, fin);
    }

    public void reemplazar(int inicio, int fin, String texto) {
        if (!rango(inicio, fin) || texto==null) return;
        guardar();
        contenido.replace(inicio, fin, texto);
    }

    public void deshacer() {
        if (this.anterior == null) return;
        this.contenido = new StringBuilder(this.anterior.toString());
        this.anterior = null;
    }

    public String obtenerTexto() {
        return contenido.toString();
    }

}