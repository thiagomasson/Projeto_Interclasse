package interclasse;
import java.util.*;
public enum Salas {
    PRIMEIROS(1,"A","B"), SEGUNDOS(2,"C","D"), TERCEIROS(3,"E","F");

    private int numSala;
    private String grupoLetra1;
    private String grupoLetra2;
    private List<String> salasParticipantes;
    private List<String> grupo1;
    private List<String> grupo2;

    Salas(int numSala, String grupoLetra1, String grupoLetra2) {
        this.numSala = numSala;
        this.grupoLetra1 = grupoLetra1;
        this.grupoLetra2 = grupoLetra2;
    }

    public List<String> getGrupo1() {
        return this.grupo1;
    }
    public void setGrupo1(List<String> grupo1) {
        this.grupo1 = grupo1;
    }
    public List<String> getGrupo2() {
        return this.grupo2;
    }
    public void setGrupo2(List<String> grupo2) {
        this.grupo2 = grupo2;
    }
    public List<String> getSalasParticipantes() {
        return this.salasParticipantes;
    }
    public void setSalasParticipantes(List<String> salasParticipantes) {
        this.salasParticipantes = salasParticipantes;
    }

    public List<String> gerarSalas() {
        List<String> salas = Arrays.asList("A","B","C","ETIM","ETEL","ETIQ");

        for(int x = 0; x < salas.size(); x++)
            salas.set(x, this.numSala + salas.get(x));

        return salas;
    }

    private void gerarParticipantes(List<String> participantes){
        setSalasParticipantes(participantes);
    }

    private void montadorGrupos() {
        setGrupo1(getSalasParticipantes().size() == 4 ? Arrays.asList("","","","") : Arrays.asList("","",""));
        setGrupo2(new ArrayList<>(3));

        List<String> salas = new ArrayList<>();
        salas.addAll(getSalasParticipantes());

        Collections.shuffle(salas);

        for(int x = 0; x < getGrupo1().size(); x++)
            getGrupo1().set(x, salas.get(x));

        salas.removeAll(getGrupo1());
        getGrupo2().addAll(salas);
    }

    public void printGrupos() {
        montadorGrupos();

        System.out.println("Grupo " + this.grupoLetra1 + getGrupo1());
        if(!getGrupo2().isEmpty())
            System.out.println("Grupo " + this.grupoLetra2 + getGrupo2());
    }

    public void montarGruposParticipantes(){
        List<String> participantes = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int numSalas;
        int sala;

        System.out.print("Quantas salas irão participar?");
        numSalas = sc.nextInt();

        System.out.print("Quais salas? \n1-A 2-B 3-C 4-ETIM 5-ETEL 6-ETIQ");
        for(int x = 0; x < numSalas; x++) {
            sala = sc.nextInt();
            participantes.add(gerarSalas().get(sala-1));
        }
        gerarParticipantes(participantes);
        printGrupos();
    }

}

