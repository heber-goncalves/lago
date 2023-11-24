public class Animal{
    
    //Atributos da classe
    private char sexo;
    private int velocidade;
    
    //Construtor completo
    public Animal(char sexo, int velocidade){
        this.sexo = sexo;
        this.velocidade = velocidade;
    }
    
    //Getters & setters
    public char getSexo(){
        return this.sexo;
    }
    public void setSexo(char sexo){
        this.sexo = sexo;
    }
    
    public int getVelocidade(){
        return this.velocidade;
    }
    public void setVelocidade(int velocidade){
        this.velocidade = velocidade;
    }
    
    //Sobrescrita do método toString()
    @Override
    public String toString(){
        return "Sexo: " + this.getSexo() + "\nVelocidade: " + this.getVelocidade();
    }
}