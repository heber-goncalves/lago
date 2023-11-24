//Importa a classe Random para gerar números aleatórios na classe
import java.util.Random;

public class Principal{
    
    //Método main
    public static void main(String[] args){
        
        //Imprime o cabeçalho do programa (trocadilho com "lago Ness")
        System.out.println("     000");
        System.out.println("   0000000 ");
        System.out.println(" 0000000000       __                                              .^. ______..");
        System.out.println(" 000000000    O  /  \\                                            < ~ \\       |_");
        System.out.println("   000000     |~/    \\           ð                                ´´--\\______| ");
        System.out.println("     ||       /\\      \\    ð                                 ð       / |    \\\\ ");
        System.out.println(" ###############~~~~~~~~~~~~~~ð~~~~~ LAGO MESS ~~ð~~~~~~~~~~~~~ð~~~###############");
        
        //Imprime a dinâmica do lago
        System.out.println("\n # Como funciona: ");
        System.out.println(" - Se um urso se encontra ao lado de um peixe, ele ataca o peixe, mas só consegue mata-lo se a sua velocidade for maior do que a do peixe;");
        System.out.println(" - Se um pescador se encontra ao lado de um peixe, ele tenta pescar o peixe, mas só consegue pesca-lo se a sua velocidade for maior do que a do peixe;");
        System.out.println(" - Caso um pescador esteja ao lado de um urso, ele atira no urso. O que tiver a menor velocidade morre;");
        System.out.println(" - Quando um pescador fica entre dois ursos, ele atira no urso que está na posição acima e, caso consiga matá-lo, este pescador acaba sendo morto mesmo\n   assim pelo urso da posição inferior;");
        System.out.println(" - Se um peixe se encontra ao lado de outro peixe e ambos são do mesmo sexo e nenhum dos dois ainda se reproduziu, um novo peixe é criado, mas este só é\n   adicionado ao lago se ainda tiver espaço nele.");
        
        //Cria o lago
        Lago lago1 = new Lago();
        
        //Apresenta os dados inciais do lago
        System.out.println("\n ! Vamos lá !");
        System.out.println("\n ## Tamanho do lago: " + lago1.getTamanhoArrays());
        System.out.println(" ## Quantidades iniciais: ");
        System.out.println("    ~ Peixes: " + lago1.getMaxPeixes());
        System.out.println("    ~ Ursos: " + lago1.getMaxUrsos());
        System.out.println("    ~ Pescadores: " + lago1.getMaxPescadores());
        lago1.randomizaArray();
        System.out.println("----------------------   Estado inicial do lago + (Iteração 1)  ------------------");
        System.out.println(lago1.toString());
        
        /**
         * O for abaixo itera 5 vezes e a cada iteração:
         *  - 0. Imprime a organização do lago onde ocorrerão os eventos dos passos seguintes;
            - 1. Percorre o array_margem1 do índice 0 ao índice N (onde N é o tamanho do array) até
            encontrar um Urso ou Pescador. Caso encontre um Urso, verifique se é possível invocar
            seu método atacarPeixe(). Se for um Pescador, verifique se é possível invocar seu
            método atirarNoUrso() e, subsequentemente, pescarPeixe(), nesta ordem;
            - 2. Percorre o array array_agua1, executando o método procriar() de todos
                os peixes elegíveis, ou seja, aqueles que se encontram no mesmo índice que um Peixe do
                sexo oposto no array_agua2;
            - 3. Percorre o array_margem2 do índice 0 ao índice N (onde N é o tamanho do array)
                até encontrar um Urso ou Pescador. Caso encontre um Urso, verifique se é possível
                invocar seu método atacarPeixe(). Se for um Pescador, verifique se é possível invocar
                seu método atirarNoUrso() e, subsequentemente, pescarPeixe(), nesta ordem.
            - 4. Randomiza o array para ser impresso na próxima iteração.
         */
        for(int i = 0; i < 5; i++){
            
            /**
             * Passo 0
             */
            if(i > 0){
                System.out.println("\n----------------------------------   Iteração " + (i + 1) + "  ---------------------------------");
                System.out.println(" # Nova organização do lago: ");
                System.out.println(lago1.toString());
            }
            
            /**
             * Passo 1
            */
            for(int i1 = 0; i1 < lago1.getTamanhoArrays(); i1++){
                //Verifica se tem um urso na margem
                if(lago1.getArrayMargem1()[i1] instanceof Urso && lago1.getArrayMargem1()[i1 ]!= null){
                    //Verifica se tem um peixe ao lado do urso
                    if(lago1.getArrayAgua1()[i1] instanceof Peixe && lago1.getArrayAgua1()[i1] != null){
                        //Situação 1: urso ataca o peixe e tem velocidade maior do que ele. Peixe morre e a informação é impressa na tela.
                        if(((Urso)lago1.getArrayMargem1()[i1]).atacarPeixe(((Peixe)lago1.getArrayAgua1()[i1])) == true){
                            lago1.getArrayAgua1()[i1] = null;
                            System.out.println(" - O urso na posição " + i1 + " da margem 1 atacou e matou o peixe na mesma posição da água 1");
                        //Situação 2: urso ataca o peixe e tem velocidade menor do que ele. Peixe não morre e a informação é impressa na tela.
                        } else if(((Urso)lago1.getArrayMargem1()[i1]).atacarPeixe(((Peixe)lago1.getArrayAgua1()[i1])) == false){
                            System.out.println(" - O urso na posição " + i1 + " da margem 1 atacou mas não conseguiu matar o peixe na mesma posição da água 1");
                        }
                    }
                //Verifica se há um pescador que não esteja nem no primeiro, nem no último índice do array da margem
                } else if(i1 != 0 && i1 != (lago1.getTamanhoArrays() - 1) && lago1.getArrayMargem1()[i1] instanceof Pescador && lago1.getArrayMargem1()[i1] != null){
                    //Verifica se tem apenas um urso ao lado do pescador e se este está acima dele
                    if(lago1.getArrayMargem1()[i1 - 1] instanceof Urso && lago1.getArrayMargem1()[i1 - 1] != null && lago1.getArrayMargem1()[i1 + 1] == null){
                        //Pescador atira no urso
                        if(((Pescador)lago1.getArrayMargem1()[i1]).atirarNoUrso(((Urso)lago1.getArrayMargem1()[i1 - 1])) == true){
                            //Se o pescador tem velocidade maior do que a do urso, o urso morre e a informação é impressa na tela
                            lago1.getArrayMargem1()[i1 - 1] = null;
                            System.out.println(" - O pescador na posição " + i1 + " da margem 1 atirou e matou o urso posição " + (i1 - 1) + " da mesma margem");
                        } else if(((Pescador)lago1.getArrayMargem1()[i1]).atirarNoUrso(((Urso)lago1.getArrayMargem1()[i1 - 1])) == false){
                            //Se o pescador tem velocidade menor do que a do urso, o pescador morre e a informação é impressa na tela
                            lago1.getArrayMargem1()[i1] = null;
                            System.out.println(" - O urso na posição " + (i1 - 1) + " da margem 1 matou o pescador posição " + i1 + " da mesma margem");
                        }
                    //Verifica se tem apenas um urso ao lado do pescador e se este está abaixo dele
                    } else if(lago1.getArrayMargem1()[i1 + 1] instanceof Urso && lago1.getArrayMargem1()[i1 + 1] != null && lago1.getArrayMargem1()[i1 - 1] == null){
                        //Pescador atira no urso
                        if(((Pescador)lago1.getArrayMargem1()[i1]).atirarNoUrso(((Urso)lago1.getArrayMargem1()[i1 + 1])) == true){
                            //Se o pescador tem velocidade maior do que a do urso, o urso morre e a informação é impressa na tela
                            lago1.getArrayMargem1()[i1 + 1] = null;
                            System.out.println(" - O pescador na posição " + i1 + " da margem 1 atirou e matou o urso posição " + (i1 + 1) + " da mesma margem");
                        } else if(((Pescador)lago1.getArrayMargem1()[i1]).atirarNoUrso(((Urso)lago1.getArrayMargem1()[i1 + 1])) == false){
                            //Se o pescador tem velocidade menor do que a do urso, o pescador morre e a informação é impressa na tela
                            lago1.getArrayMargem1()[i1] = null;
                            System.out.println(" - O urso na posição " + (i1 + 1) + " da margem 1 matou o pescador posição " + i1 + " da mesma margem");
                        }
                    //Verifica se o pescador está entre dois ursos
                    } else if(lago1.getArrayMargem1()[i1 - 1] instanceof Urso && lago1.getArrayMargem1()[i1 - 1] != null && lago1.getArrayMargem1()[i1 + 1] instanceof Urso && lago1.getArrayMargem1()[i1 + 1] != null){
                        //Pescador atira no urso que está acima dele
                        if(((Pescador)lago1.getArrayMargem1()[i1]).atirarNoUrso(((Urso)lago1.getArrayMargem1()[i1 - 1])) == true){
                            //Se o pescador tem velocidade maior do que o urso que está acima dele, o urso morre e a informação é impressa na tela
                            lago1.getArrayMargem1()[i1 - 1] = null;
                            System.out.println(" - O pescador na posição " + i1 + " da margem 1 atirou e matou o urso posição " + (i1 - 1) + " da mesma margem");
                            //O pescador também morre por ter sido atacado pelo urso que está abaixo dele e a informação é impressa na tela
                            lago1.getArrayMargem1()[i1] = null;
                            System.out.println(" - Logo após, o urso na posição " + (i1 + 1) + " da margem 1 matou o pescador posição " + i1 + " da mesma margem");
                        } else if(((Pescador)lago1.getArrayMargem1()[i1]).atirarNoUrso(((Urso)lago1.getArrayMargem1()[i1 - 1])) == false){
                            //Se o pescador tem velocidade menor do que o urso que está acima dele, o pescador morre e a informação é impressa na tela
                            lago1.getArrayMargem1()[i1] = null;
                            System.out.println(" - O urso na posição " + (i1 - 1) + " da margem 1 matou o pescador posição " + i1 + " da mesma margem");
                        }
                    }
                //Verifica se o pescador está na primeira posição do array margem
                } else if(i1 == 0 && lago1.getArrayMargem1()[i1] instanceof Pescador && lago1.getArrayMargem1()[i1] != null){
                    //Verifica se tem um urso logo abaixo dele
                    if(lago1.getArrayMargem1()[i1 + 1] instanceof Urso && lago1.getArrayMargem1()[i1 + 1] != null){
                        //Pescador atira no urso que está abaixo dele
                        if(((Pescador)lago1.getArrayMargem1()[i1]).atirarNoUrso(((Urso)lago1.getArrayMargem1()[i1 + 1])) == true){
                            //Se o pescador tem velocidade maior, o urso morre e a informação é impressa na tela
                            lago1.getArrayMargem1()[i1 + 1] = null;
                            System.out.println(" - O pescador na posição " + i1 + " da margem 1 atirou e matou o urso posição " + (i1 + 1) + " da mesma margem");
                        } else if(((Pescador)lago1.getArrayMargem1()[i1]).atirarNoUrso(((Urso)lago1.getArrayMargem1()[i1 + 1])) == false){
                            //Se o pescador tem velocidade menor, o pescador morre e a informação é impressa na tela
                            lago1.getArrayMargem1()[i1] = null;
                            System.out.println(" - O urso na posição " + (i1 + 1) + " da margem 1 matou o pescador posição " + i1 + " da mesma margem");
                        }
                    }
                //Verifica se o pescador está na última posição do array margem
                } else if(i1 == (lago1.getTamanhoArrays() - 1) && lago1.getArrayMargem1()[i1] instanceof Pescador && lago1.getArrayMargem1()[i1] != null){
                    //Verifica se tem um urso logo acima dele
                    if(lago1.getArrayMargem1()[i1 - 1] instanceof Urso && lago1.getArrayMargem1()[i1 - 1] != null){
                        //Pescador atira no urso que está acima dele
                        if(((Pescador)lago1.getArrayMargem1()[i1]).atirarNoUrso(((Urso)lago1.getArrayMargem1()[i1 - 1])) == true){
                            //Se o pescador tem velocidade maior, o urso morre e a informação é impressa na tela
                            lago1.getArrayMargem1()[i1 - 1] = null;
                            System.out.println(" - O pescador na posição " + i1 + " da margem 1 atirou e matou o urso posição " + (i1 - 1) + " da mesma margem");
                        } else if(((Pescador)lago1.getArrayMargem1()[i1]).atirarNoUrso(((Urso)lago1.getArrayMargem1()[i1 - 1])) == false){
                            //Se o pescador tem velocidade menor, o pescador morre e a informação é impressa na tela
                            lago1.getArrayMargem1()[i1] = null;
                            System.out.println(" - O urso na posição " + (i1 - 1) + " da margem 1 matou o pescador posição " + i1 + " da mesma margem");
                        }
                    }
                }
                //Verifica se tem um pescador ao lado de um peixe
                if(lago1.getArrayMargem1()[i1] instanceof Pescador && lago1.getArrayMargem1()[i1] != null && lago1.getArrayAgua1()[i1] instanceof Peixe && lago1.getArrayAgua1()[i1] != null){
                    //Pescador tenta pescar o peixe
                    if(((Pescador)lago1.getArrayMargem1()[i1]).pescarPeixe(((Peixe)lago1.getArrayAgua1()[i1])) == true){
                        //Se a velocidade do pescador é maior do que a do peixe, o peixe é removido do lago e a informação é impressa na tela
                        lago1.getArrayAgua1()[i1] = null;
                        System.out.println(" - O pescador na posição " + i1 + " da margem 1 pescou o peixe na mesma posição da água 1");
                    } else if(((Pescador)lago1.getArrayMargem1()[i1]).pescarPeixe(((Peixe)lago1.getArrayAgua1()[i1])) == false){
                        //Se a velocidade do pescador é menor do que a do peixe, o peixe não é removido do lago e a informação é impressa na tela
                        System.out.println(" - O pescador na posição " + i1 + " da margem 1 tentou mas não conseguiu pescar o peixe na mesma posição da água 1");
                    }
                }
            }
            
            /**
             * Passo 2
             */
            for(int i2 = 0; i2 < lago1.getTamanhoArrays(); i2++){
                //Verifica se tem um peixe ao lado do outro
                if(lago1.getArrayAgua1()[i2] instanceof Peixe && lago1.getArrayAgua1()[i2]!= null && lago1.getArrayAgua2()[i2] instanceof Peixe && lago1.getArrayAgua2()[i2]!= null){
                    //Verifica se ambos os peixes nunca procriaram e se têm sexo diferente um do outro
                    if(((Peixe)lago1.getArrayAgua1()[i2]).getJaProcriou() == false && ((Peixe)lago1.getArrayAgua2()[i2]).getJaProcriou() == false && (((Peixe)lago1.getArrayAgua1()[i2]).getSexo() != ((Peixe)lago1.getArrayAgua2()[i2]).getSexo())){
                        boolean peixeInserido1 = false;
                        boolean peixeInserido2 = false;
                        ((Peixe)lago1.getArrayAgua1()[i2]).procriar(((Peixe)lago1.getArrayAgua2()[i2]));
                        //Tenta inserir um peixe novo no array_agua1
                        for(int i21 = 0; i21 < lago1.getTamanhoArrays(); i21++){
                            if(lago1.getArrayAgua1()[i21] == null){
                                lago1.getArrayAgua1()[i21] = lago1.criaPeixe();
                                System.out.println(" - O peixe na posição " + i2 + " da água 1 procriou com o peixe da mesma posição da água 2. Novo peixe foi inserido no lago.");
                                peixeInserido1 = true;
                                break;
                            }
                        }
                        //Caso não tenha conseguido inserir no array_agua1, tenta inserir um peixe novo no array_agua2
                        for(int i22 = 0; i22 < lago1.getTamanhoArrays(); i22++){
                            if(lago1.getArrayAgua2()[i22] == null && peixeInserido1 == false){
                                lago1.getArrayAgua2()[i22] = lago1.criaPeixe();
                                System.out.println(" - O peixe na posição " + i2 + " da água 1 procriou com o peixe da mesma posição da água 2.  Novo peixe foi inserido no lago.");
                                peixeInserido2 = true;
                                break;
                            }
                        }
                        //Caso não tenha conseguido inserir o peixe novo em nenhum array água, informa que o lago está cheio
                        if(peixeInserido1 == false && peixeInserido2 == false){
                            System.out.println(" - O peixe na posição " + i2 + " da água 1 procriou com o peixe da mesma posição da água 2, mas o novo peixe NÃO foi inserido no\n   lago por falta de espaço");
                        }
                    }
                }
            }
            
            /**
             * Passo 3
             */
            //Os comentários deste passo são os mesmos do passo 1, visto que a lógica implementada é a mesma, só que para o array_margem2
            for(int i3 = 0; i3 < lago1.getTamanhoArrays(); i3++){
                if(lago1.getArrayMargem2()[i3] instanceof Urso && lago1.getArrayMargem2()[i3]!= null){
                    if(lago1.getArrayAgua2()[i3] instanceof Peixe && lago1.getArrayAgua2()[i3] != null){
                        if(((Urso)lago1.getArrayMargem2()[i3]).atacarPeixe(((Peixe)lago1.getArrayAgua2()[i3])) == true){
                            lago1.getArrayAgua2()[i3] = null;
                            System.out.println(" - O urso na posição " + i3 + " da margem 2 atacou e matou o peixe na mesma posição da água 2");
                        } else if(((Urso)lago1.getArrayMargem2()[i3]).atacarPeixe(((Peixe)lago1.getArrayAgua2()[i3])) == false){
                            System.out.println(" - O urso na posição " + i3 + " da margem 2 atacou mas não conseguiu matar o peixe na mesma posição da água 2");
                        }
                    }
                } else if(i3 != 0 && i3 != (lago1.getTamanhoArrays() - 1) && lago1.getArrayMargem2()[i3] instanceof Pescador && lago1.getArrayMargem2()[i3] != null){
                    if(lago1.getArrayMargem2()[i3 - 1] instanceof Urso && lago1.getArrayMargem2()[i3 - 1] != null && lago1.getArrayMargem2()[i3 + 1] == null){
                        if(((Pescador)lago1.getArrayMargem2()[i3]).atirarNoUrso(((Urso)lago1.getArrayMargem2()[i3 - 1])) == true){
                            lago1.getArrayMargem2()[i3 - 1] = null;
                            System.out.println(" - O pescador na posição " + i3 + " da margem 2 atirou e matou o urso posição " + (i3 - 1) + " da mesma margem");
                        } else if(((Pescador)lago1.getArrayMargem2()[i3]).atirarNoUrso(((Urso)lago1.getArrayMargem2()[i3 - 1])) == false){
                            lago1.getArrayMargem2()[i3] = null;
                            System.out.println(" - O urso na posição " + (i3 - 1) + " da margem 2 matou o pescador posição " + i3 + " da mesma margem");
                        }
                    } else if(lago1.getArrayMargem2()[i3 + 1] instanceof Urso && lago1.getArrayMargem2()[i3 + 1] != null && lago1.getArrayMargem2()[i3 - 1] == null){
                        if(((Pescador)lago1.getArrayMargem2()[i3]).atirarNoUrso(((Urso)lago1.getArrayMargem2()[i3 + 1])) == true){
                            lago1.getArrayMargem2()[i3 + 1] = null;
                            System.out.println(" - O pescador na posição " + i3 + " da margem 2 atirou e matou o urso posição " + (i3 + 1) + " da mesma margem");
                        } else if(((Pescador)lago1.getArrayMargem2()[i3]).atirarNoUrso(((Urso)lago1.getArrayMargem2()[i3 + 1])) == false){
                            lago1.getArrayMargem2()[i3] = null;
                            System.out.println(" - O urso na posição " + (i3 + 1) + " da margem 2 matou o pescador posição " + i3 + " da mesma margem");
                        }
                    } else if(lago1.getArrayMargem2()[i3 - 1] instanceof Urso && lago1.getArrayMargem2()[i3 - 1] != null && lago1.getArrayMargem2()[i3 + 1] instanceof Urso && lago1.getArrayMargem2()[i3 + 1] != null){
                        if(((Pescador)lago1.getArrayMargem2()[i3]).atirarNoUrso(((Urso)lago1.getArrayMargem2()[i3 - 1])) == true){
                            lago1.getArrayMargem2()[i3 - 1] = null;
                            System.out.println(" - O pescador na posição " + i3 + " da margem 2 atirou e matou o urso posição " + (i3 - 1) + " da mesma margem");
                            lago1.getArrayMargem2()[i3] = null;
                            System.out.println(" - Logo após, o urso na posição " + (i3 + 1) + " da margem 2 matou o pescador posição " + i3 + " da mesma margem");
                        } else if(((Pescador)lago1.getArrayMargem2()[i3]).atirarNoUrso(((Urso)lago1.getArrayMargem2()[i3 - 1])) == false){
                            lago1.getArrayMargem2()[i3] = null;
                            System.out.println(" - O urso na posição " + (i3 - 1) + " da margem 2 matou o pescador posição " + i3 + " da mesma margem");
                        }
                    }
                } else if(i3 == 0 && lago1.getArrayMargem2()[i3] instanceof Pescador && lago1.getArrayMargem2()[i3] != null){
                    if(lago1.getArrayMargem2()[i3 + 1] instanceof Urso && lago1.getArrayMargem2()[i3 + 1] != null){
                        if(((Pescador)lago1.getArrayMargem2()[i3]).atirarNoUrso(((Urso)lago1.getArrayMargem2()[i3 + 1])) == true){
                            lago1.getArrayMargem2()[i3 + 1] = null;
                            System.out.println(" - O pescador na posição " + i3 + " da margem 2 atirou e matou o urso posição " + (i3 + 1) + " da mesma margem");
                        } else if(((Pescador)lago1.getArrayMargem2()[i3]).atirarNoUrso(((Urso)lago1.getArrayMargem2()[i3 + 1])) == false){
                            lago1.getArrayMargem2()[i3] = null;
                            System.out.println(" - O urso na posição " + (i3 + 1) + " da margem 2 matou o pescador posição " + i3 + " da mesma margem");
                        }
                    }
                } else if(i3 == (lago1.getTamanhoArrays() - 1) && lago1.getArrayMargem2()[i3] instanceof Pescador && lago1.getArrayMargem2()[i3] != null){
                    if(lago1.getArrayMargem2()[i3 - 1] instanceof Urso && lago1.getArrayMargem2()[i3 - 1] != null){
                        if(((Pescador)lago1.getArrayMargem2()[i3]).atirarNoUrso(((Urso)lago1.getArrayMargem2()[i3 - 1])) == true){
                            lago1.getArrayMargem2()[i3 - 1] = null;
                            System.out.println(" - O pescador na posição " + i3 + " da margem 2 atirou e matou o urso posição " + (i3 - 1) + " da mesma margem");
                        } else if(((Pescador)lago1.getArrayMargem2()[i3]).atirarNoUrso(((Urso)lago1.getArrayMargem2()[i3 - 1])) == false){
                            lago1.getArrayMargem2()[i3] = null;
                            System.out.println(" - O urso na posição " + (i3 - 1) + " da margem 2 matou o pescador posição " + i3 + " da mesma margem");
                        }
                    }
                }
                if(lago1.getArrayMargem2()[i3] instanceof Pescador && lago1.getArrayMargem2()[i3] != null && lago1.getArrayAgua2()[i3] instanceof Peixe && lago1.getArrayAgua2()[i3] != null){
                    if(((Pescador)lago1.getArrayMargem2()[i3]).pescarPeixe(((Peixe)lago1.getArrayAgua2()[i3])) == true){
                        lago1.getArrayAgua2()[i3] = null;
                        System.out.println(" - O pescador na posição " + i3 + " da margem 2 pescou o peixe na mesma posição da água 2");
                    } else if(((Pescador)lago1.getArrayMargem2()[i3]).pescarPeixe(((Peixe)lago1.getArrayAgua2()[i3])) == false){
                        System.out.println(" - O pescador na posição " + i3 + " da margem 2 tentou mas não conseguiu pescar o peixe na mesma posição da água 2");
                    }
                }
            }
            System.out.println("\n----------------------------------------------------------------------------------");
            
            /**
             * Passo 4
             */
            lago1.randomizaArray();
        }
        
        //Imprime o arranjo final do lago após a última iteração
        System.out.println("Arranjo final do lago: ");
        System.out.println(lago1.toString());
    }
}