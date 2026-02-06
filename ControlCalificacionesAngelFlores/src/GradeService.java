public class GradeService {
    public double promedio;
    public double califFinal;
    public String estado;
    public int bloqueo = 0;

    public int DIVISION_PROMEDIO = 3;
    public int LIMITE_ASISTENCIAS = 80;
    public int CALIFICACION_APROBATORIA = 70;
    public double PORCENTAJE_PROMEDIO = 0.7;
    public double PORCENTAJE_ASISTENCIA = 0.3;

    /**
     * Constructor basico de la clase
     */
    public GradeService(){
    }
    /**
     * Metodo que procesa todos los metodos que calculan el promedio, el estado y la calificacion final en conjunto
     * @param califUno -> Primera calificacion procesada por InputValidatorClass
     * @param califDos -> Segunda calificacion procesada por InputValidatorClass
     * @param califTres -> Tercera calificacion procesada por InputValidatorClass
     * @param asistencia -> El numero de asistencias procesada por InputValidatorClass
     * @param entregoProyecto -> La comprobacion de proyecto procesada pro InputValidatorClass
     */
    public void procesar(double califUno, double califDos, double califTres, int asistencia, boolean entregoProyecto){
        calcularPromedio(califUno, califDos, califTres);
        determinarEstado(asistencia, entregoProyecto);
        calcularFinal(asistencia);
    }
    /**
     * Metodo que calcula el promedio en base a las tres calificaciones traidas por la clase procesar
     * @param califUno -> Primera calificacion
     * @param califDos -> Segunda calificacion
     * @param califTres -> Tercera calificacion
     */
    private void calcularPromedio(double califUno, double califDos, double califTres){
        this.promedio = (califUno + califDos + califTres) / DIVISION_PROMEDIO;
    }
    /**
     * Metodo que determina el estado en base al numero de asistencias y si entrego o no proyecto
     * @param asistencia -> El numero de asistencias traido de parte de la clase procesar
     * @param entregoProyecto -> La comprobacion de si entrego o no proyecto traida de la clase procesar
     */
    private void determinarEstado (int asistencia, boolean entregoProyecto){
        if (asistencia < LIMITE_ASISTENCIAS) {
            this.estado = "REPROBADO por asistencia";
            this.bloqueo = 1;
        } else if (!entregoProyecto){
            this.estado = "REPROBADO por proyecto";
            this.bloqueo = 1;
        }
    }
    /**
     * Metodo que calcula la calificacion final en base al numero de asistencias y el promedio
     * @param asistencia -> El numero de asistencias
     */
    private void calcularFinal(int asistencia){
        this.califFinal = (this.promedio * PORCENTAJE_PROMEDIO) + (asistencia * PORCENTAJE_ASISTENCIA);
        if(this.bloqueo == 0){
            if (califFinal >= CALIFICACION_APROBATORIA) {
                this.estado = "APROBADO";
            } else {
                this.estado = "REPROBADO por calificación";
            }
        }
    }
    /**
     * Metodo que genera e imprime el reporte final
     * @param nombreAlumno -> El nombre del alumno traida de appCalif
     * @param califUno -> Primera calificacion
     * @param califDos -> Segunda calificacion
     * @param califTres -> Tercera calificacion
     * @param asistencia -> El numero de asistencias
     * @param entregoProyecto -> Si entrego o no proyecto
     */
    public void imprimirReporte(String nombreAlumno, double califUno, double califDos, double califTres, int asistencia, boolean entregoProyecto){
        System.out.println(" ----- Reporte ----- ");
        System.out.println("Nombre : " + nombreAlumno);
        System.out.println("Calificación parcial 1 : " + califUno);
        System.out.println("Calificación parcial 2 : " + califDos);
        System.out.println("Calificación parcial 3 : " + califTres);
        System.out.println("Promedio final : " + this.promedio);
        System.out.println("Asistencias : " + asistencia);
        System.out.println("¿Entrego proyecto? : " + entregoProyecto);
        System.out.println("Calificacion final : " + this.califFinal);
        System.out.println("Estado : " + this.estado);
        System.out.println(" ----- Reporte ----- ");
    }
}