//Subclasse da classe Animal
public class Urso extends Animal{
    
    //Construtor completo
    public Urso(char sexo, int velocidade){
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
    
    //Retorna true caso o peixe atacado (passado como parâmetro) tenha velocidade menor do que o urso da classe
    public boolean atacarPeixe(Peixe peixe){
        boolean retorno = false;
        if(this.getVelocidade() > peixe.getVelocidade()){
            retorno = true;
        }
        return retorno;
    }
    
    //Sobrescrita do toString()
    @Override
    public String toString(){
        return "Urso: \n" + super.toString();
    }
}