//Importa a classe Random a fim de gerar números inteiros aleatórios na classe
import java.util.Random;

public class Lago{
    
    //Atributos da classe
    private Animal[] array_margem1, array_agua1, array_agua2, array_margem2;
    private int tamanho_arrays;
    private int max_ursos, max_peixes, max_pescadores;
    
    /**
     * Construtor não recebe parâmetros e define aleatoriamente o tamanho dos arrays que irão compor a estrutura do lago e também as quantidades iniciais de cada tipo de animal
     * Após isso, chama o método populaArrays() para criar a quantidade definida de cada tipo de animal e inserir aleatoriamente nos arrays que compõe o lago
     */
    public Lago(){
        Random rand = new Random();
        
        this.tamanho_arrays = rand.nextInt(11 - 5) + 5;
        this.max_ursos = rand.nextInt(6 - 1) + 1;
        this.max_peixes = rand.nextInt(13 - 5) + 5;
        this.max_pescadores = rand.nextInt(3 - 1) + 1;
        
        array_margem1 = new Animal[tamanho_arrays];
        array_agua1 = new Animal[tamanho_arrays];
        array_agua2 = new Animal[tamanho_arrays];
        array_margem2 = new Animal[tamanho_arrays];
        
        this.populaArrays();
    }
    
    //Getters & setters
    public Animal[] getArrayMargem1(){
        return this.array_margem1;
    }
    public void setArrayMargem1(Animal[] array_margem1){
        this.array_margem1 = array_margem1;
    }
    
    public Animal[] getArrayAgua1(){
        return this.array_agua1;
    }
    public void setArrayAgua1(Animal[] array_agua1){
        this.array_agua1 = array_agua1;
    }
    
    public Animal[] getArrayAgua2(){
        return this.array_agua2;
    }
    public void setArrayAgua2(Animal[] setArrayAgua2){
        this.array_agua2 = array_agua2;
    }
    
    public Animal[] getArrayMargem2(){
        return this.array_margem2;
    }
    public void setArrayMargem2(Animal[] array_margem2){
        this.array_margem2 = array_margem2;
    }
    
    public int getTamanhoArrays(){
        return this.tamanho_arrays;
    }
    public void setTamanhoArrays(int tamanho_arrays){
        this.tamanho_arrays = tamanho_arrays;
    }
    
    public int getMaxUrsos(){
        return this.max_ursos;
    }
    public void setMaxUrsos(int max_ursos){
        this.max_ursos = max_ursos;
    }
    
    public int getMaxPeixes(){
        return this.max_peixes;
    }
    public void setMaxPeixes(int max_peixes){
        this.max_peixes = max_peixes;
    }
    
    public int getMaxPescadores(){
        return this.max_pescadores;
    }
    public void setMaxPescadores(int max_pescadores){
        this.max_pescadores = max_pescadores;
    }
    
    //Método que, quando chamado no construtor, cria e insere os peixes, ursos e pescadores nos arrays que compõe o lago
    public void populaArrays(){
        Random rand = new Random();
        
        //Insere os ursos nos arrays das margens
        int qtdeUrsos = 0;
        int contUrsos1 = 0;
        int contUrsos2 = 0;
        //Laço itera para inserir nos arrays magens a quantidade de ursos sorteada no construtor
        while(qtdeUrsos < this.getMaxUrsos()){
            //Sorteia um número que será utilizado para definir em qual das duas margens será inserido o urso que será criado nessa iteração do laço while acima
            int sorteiaArray = rand.nextInt(10);
            //Se o número sorteado é par, verifica se a posição do array está vazia e cria um urso novo e insere nela
            if(sorteiaArray % 2 == 0){
                if(contUrsos1 < this.getTamanhoArrays()){
                    if(this.array_margem1[contUrsos1] == null){
                        int sorteiaSexo = rand.nextInt(10);
                        char sexo = 'f';
                        if(sorteiaSexo % 2 == 0){
                            sexo = 'm';
                        }
                        int velocidade = rand.nextInt(21 - 1) + 1;
                        this.array_margem1[contUrsos1] = new Urso(sexo, velocidade);
                        qtdeUrsos++;
                    }
                }
                contUrsos1++;
            //Se o número sorteado é ímpar, verifica se a posição do array está vazia e cria um urso novo e insere nela
            } else if(sorteiaArray % 2 == 1){
                if(contUrsos2 < this.getTamanhoArrays()){
                    if(this.array_margem2[contUrsos2] == null){
                        int sorteiaSexo = rand.nextInt(10);
                        char sexo = 'f';
                        if(sorteiaSexo % 2 == 0){
                            sexo = 'm';
                        }
                        int velocidade = rand.nextInt(21 - 1) + 1;
                        this.array_margem2[contUrsos2] = new Urso(sexo, velocidade);
                        qtdeUrsos++;
                    }
                }
                contUrsos2++;
            }
        }
        
        //Insere os pescadores nos arrays das margens
        int qtdePescadores = 0;
        int contPescadores1 = 0;
        int contPescadores2 = 0;
        //Laço itera para inserir nos arrays magens a quantidade de pescadores sorteada no construtor
        while(qtdePescadores < this.getMaxPescadores()){
            //Sorteia um número que será utilizado para definir em qual das duas margens será inserido o pescador que será criado nessa iteração do laço while acima
            int sorteiaArray = rand.nextInt(10);
            //Se o número sorteado é par, verifica se a posição do array está vazia e cria um pescador novo e insere nela
            if(sorteiaArray % 2 == 0){
                if(contPescadores1 < this.getTamanhoArrays()){
                    if(this.array_margem1[contPescadores1] == null){
                        int sorteiaSexo = rand.nextInt(10);
                        char sexo = 'f';
                        if(sorteiaSexo % 2 == 0){
                            sexo = 'm';
                        }
                        int velocidade = rand.nextInt(21 - 1) + 1;
                        this.array_margem1[contPescadores1] = new Pescador(sexo, velocidade);
                        qtdePescadores++;
                    } 
                }
                contPescadores1++;
            //Se o número sorteado é ímpar, verifica se a posição do array está vazia e cria um pescador novo e insere nela
            } else if(sorteiaArray % 2 == 1){
                if(contPescadores2 < this.getTamanhoArrays()){
                    if(this.array_margem2[contPescadores2] == null){
                        int sorteiaSexo = rand.nextInt(10);
                        char sexo = 'f';
                        if(sorteiaSexo % 2 == 0){
                            sexo = 'm';
                        }
                        int velocidade = rand.nextInt(21 - 1) + 1;
                        this.array_margem2[contPescadores2] = new Pescador(sexo, velocidade);
                        qtdePescadores++;
                    }
                }
                contPescadores2++;
            }
        }
        
        ////Insere os peixes nos arrays das águas
        int qtdePeixes = 0;
        int contPeixes1 = 0;
        int contPeixes2 = 0;
        //Laço itera para inserir nos arrays águas a quantidade de peixes sorteada no construtor
        while(qtdePeixes < this.getMaxPeixes()){
            //Sorteia um número que será utilizado para definir em qual das duas águas será inserido o peixe que será criado nessa iteração do laço while acima
            int sorteiaArray = rand.nextInt(10);
            //Se o número sorteado é par, verifica se a posição do array está vazia e cria um peixe novo e insere nela
            if(sorteiaArray % 2 == 0){
                if(contPeixes1 < this.getTamanhoArrays()){
                    if(this.array_agua1[contPeixes1] == null){
                        int sorteiaSexo = rand.nextInt(10);
                        char sexo = 'f';
                        if(sorteiaSexo % 2 == 0){
                            sexo = 'm';
                        }
                        int velocidade = rand.nextInt(21 - 1) + 1;
                        this.array_agua1[contPeixes1] = new Peixe(sexo, velocidade, false);
                        qtdePeixes++;
                    }
                }
                contPeixes1++;
            //Se o número sorteado é par, verifica se a posição do array está vazia e cria um peixe novo e insere nela
            } else if(sorteiaArray % 2 == 1){
                if(contPeixes2 < this.getTamanhoArrays()){
                    if(this.array_agua2[contPeixes2] == null){
                        int sorteiaSexo = rand.nextInt(10);
                        char sexo = 'f';
                        if(sorteiaSexo % 2 == 0){
                            sexo = 'm';
                        }
                        int velocidade = rand.nextInt(21 - 1) + 1;
                        this.array_agua2[contPeixes2] = new Peixe(sexo, velocidade, false);
                        qtdePeixes++;
                    }
                }
                contPeixes2++;
            }
        } 
    }
    
    //Método que randomiza os arrays que compõe o lago
    public void randomizaArray(){
        for (int i = tamanho_arrays - 1; i > 0; i--) {
            Random rand = new Random();
            int indiceTemp = rand.nextInt(i + 1);
            
            Animal temp1 = array_margem1[i];
            array_margem1[i] = array_margem1[indiceTemp];
            array_margem1[indiceTemp] = temp1;
            
            Animal temp2 = array_agua1[i];
            array_agua1[i] = array_agua1[indiceTemp];
            array_agua1[indiceTemp] = temp2;
            
            Animal temp3 = array_agua2[i];
            array_agua2[i] = array_agua2[indiceTemp];
            array_agua2[indiceTemp] = temp3;
            
            Animal temp4 = array_margem2[i];
            array_margem2[i] = array_margem2[indiceTemp];
            array_margem2[indiceTemp] = temp4;
        }
    }
    
    //Método que cria um novo peixe (chamado na classe principal quando dois peixes conseguem procriar)
    public Peixe criaPeixe(){
        Random rand = new Random();
        int sexoPeixeInserido = rand.nextInt(3 - 1) + 1;
        int velocidadePeixeInserido = rand.nextInt(21 - 1) + 1;
        char sexoInserido;
        if(sexoPeixeInserido == 1){
            sexoInserido = 'm';
        }else{
            sexoInserido = 'f';
        }
        return new Peixe(sexoInserido, velocidadePeixeInserido, false);
    }
    
    //Sobrescrita do método toString()
    @Override
    public String toString(){
        String retorno = "";
        //Cria o cabeçalho do lago
        retorno += "\n                array_margem1  array_agua1  array_agua2  array_margem2";
        for(int i = 0; i < this.tamanho_arrays; i++){
            //A cada linha concatena os tipos de objeto que estão na posição de cada array
            if(this.array_margem1[i] == null){
                retorno += "\n            " + i + " -       #      ";
            } else if(this.array_margem1[i] instanceof Urso){
                retorno += "\n            " + i + " -     Urso     ";
            } else if(this.array_margem1[i] instanceof Pescador){
                retorno += "\n            " + i + " -   Pescador   ";
            }
            if(this.array_agua1[i] == null){
                retorno += "      ~      ";
            } else if(this.array_agua1[i] instanceof Peixe){
                retorno += "    Peixe    ";
            }
            if(this.array_agua2[i] == null){
                retorno += "      ~      ";
            } else if(this.array_agua2[i] instanceof Peixe){
                retorno += "    Peixe    ";
            }
            if(this.array_margem2[i] == null){
                retorno += "      #      ";
            } else if(this.array_margem2[i] instanceof Urso){
                retorno += "    Urso     ";
            } else if(this.array_margem2[i] instanceof Pescador){
                retorno += "  Pescador   ";
            }
        }
        retorno += "\n";
        return retorno;
    }
}
    
    