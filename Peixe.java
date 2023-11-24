//Subclasse da classe Animal
public class Peixe extends Animal{
    //Cria atributo específico da classe
    private boolean jaProcriou;
    
    //Construtor completo
    public Peixe (char sexo, int velocidade, boolean jaProcriou){
        super(sexo, velocidade);
        this.jaProcriou = false;
    }
    
    //Getter & setters
    public boolean getJaProcriou(){return this.jaProcriou;}
    public void setJaProcriou(boolean jaProcriou){
        this.jaProcriou = jaProcriou;
    }

    //Retorna true se foi possível procriar com o peixe passado como parâmetro
    public boolean procriar(Peixe vizinho) {
        boolean retorno = false;
        if (this.getJaProcriou() == false && vizinho.getJaProcriou() == false && this.getSexo() != vizinho.getSexo()) {
            this.jaProcriou = true;
            vizinho.setJaProcriou(true);
            retorno = true;
        }
        return retorno;
    }
    
    //Sobrescrita do toString
    @Override
    public String toString(){
        return "Peixe: \n" + super.toString();
    }
}