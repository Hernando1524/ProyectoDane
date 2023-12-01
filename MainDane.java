import java.util.ArrayList;
import java.util.Scanner;

public class MainDane {

    public static void main(String[] args) {
        ArrayList<Departamento> departamentos = capturarDatosDepartamentos();
        analizarYMostrarResultados(departamentos);
    }

    private static ArrayList<Departamento> capturarDatosDepartamentos() {
        ArrayList<Departamento> departamentos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de departamentos: ");
        int numDepartamentos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        for (int i = 0; i < numDepartamentos; i++) {
            System.out.println("Departamento " + (i + 1));

            System.out.print("Número de municipios: ");
            int numMunicipios = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            System.out.print("Extensión (en mt2): ");
            double extension = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer

            System.out.print("Número de habitantes: ");
            int numeroHabitantes = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            System.out.print("Temperatura promedio (en grados Celsius): ");
            double temperatura = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer

            System.out.print("Indicativo telefónico: ");
            String indicativoTelefonico = scanner.nextLine();

            departamentos.add(new Departamento(numMunicipios, extension, numeroHabitantes, temperatura, indicativoTelefonico));
        }

        // Cerrar el Scanner
        scanner.close();

        return departamentos;
    }

    private static void analizarYMostrarResultados(ArrayList<Departamento> departamentos) {
        Departamento departamentoMayorExtension = departamentos.get(0);
        Departamento departamentoMenorTemperatura = departamentos.get(0);
        Departamento departamentoMayorHabitantes = departamentos.get(0);
        Departamento departamentoMenorExtension = departamentos.get(0);

        for (int i = 1; i < departamentos.size(); i++) {
            Departamento departamento = departamentos.get(i);

            // Analizar mayor extensión
            if (departamento.getExtension() > departamentoMayorExtension.getExtension()) {
                departamentoMayorExtension = departamento;
            }

            // Analizar menor temperatura
            if (departamento.getTemperatura() < departamentoMenorTemperatura.getTemperatura()) {
                departamentoMenorTemperatura = departamento;
            }

            // Analizar mayor número de habitantes
            if (departamento.getNumeroHabitantes() > departamentoMayorHabitantes.getNumeroHabitantes()) {
                departamentoMayorHabitantes = departamento;
            }

            // Analizar menor extensión
            if (departamento.getExtension() < departamentoMenorExtension.getExtension()) {
                departamentoMenorExtension = departamento;
            }
        }

        // Mostrar resultados
        System.out.println("Departamento con mayor extensión: " + departamentoMayorExtension);
        System.out.println("Departamento con menor temperatura: " + departamentoMenorTemperatura);
        System.out.println("Departamento con mayor número de habitantes: " + departamentoMayorHabitantes);
        System.out.println("Departamento con menor extensión: " + departamentoMenorExtension);
    }
}

class Departamento {
    private int numMunicipios;
    private double extension;
    private int numeroHabitantes;
    private double temperatura;
    private String indicativoTelefonico;

    public Departamento(int numMunicipios, double extension, int numeroHabitantes, double temperatura, String indicativoTelefonico) {
        this.numMunicipios = numMunicipios;
        this.extension = extension;
        this.numeroHabitantes = numeroHabitantes;
        this.temperatura = temperatura;
        this.indicativoTelefonico = indicativoTelefonico;
    }

    public int getNumMunicipios() {
        return numMunicipios;
    }

    public double getExtension() {
        return extension;
    }

    public int getNumeroHabitantes() {
        return numeroHabitantes;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public String getIndicativoTelefonico() {
        return indicativoTelefonico;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "numMunicipios=" + numMunicipios +
                ", extension=" + extension +
                ", numeroHabitantes=" + numeroHabitantes +
                ", temperatura=" + temperatura +
                ", indicativoTelefonico='" + indicativoTelefonico + '\'' +
                '}';
    }
}

