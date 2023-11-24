//Subclasse da classe Animal
public class Pescador extends Animal{
    
    //Construtor completo
    public Pescador(char sexo, int velocidade){
        super(sexo, velocidade);
    }
    
    //Getters & setters
    public char getSexo(){
        return super.getSexo();
    }
    public void setSexo(char sexo){
        super.setSexo(sexo);
    }
    
    public int getVelocidade(){
        return super.getVelocidade();
    }
    public void setVelocidade(int velocidade){
        super.setVelocidade(velocidade);
    }
    
    //Retorna true caso o objeto da classe tenha velocidade maior do que o urso passado como parâmetro e false caso contrário
    public boolean atirarNoUrso(Urso urso){
        boolean retorno = false;
        if(this.getVelocidade() > urso.getVelocidade()){
            retorno = true;
        }
        return retorno;
    }
    
    //Retorna true caso o objeto da classe tenha velocidade maior do que o peixe passado como parâmetro e false caso contrário
    public boolean pescarPeixe(Peixe peixe){
        boolean retorno = false;
        if(this.getVelocidade() > peixe.getVelocidade()){
            retorno = true;
        }
        return retorno;
    }
    
    //Sobrescrita do toString()
    @Override
    public String toString(){
        return "Pescador: \n" + super.toString();
    }
}