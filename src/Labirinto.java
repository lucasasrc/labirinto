import java.util.Stack;

public class Labirinto {
    
    public static void main(String[] args){
        new Labirinto().start();
    }
    
    private Stack<int[]> pilha = new Stack<int[]>();
        
    public void start() {
        int localX = 1;
        int localY = 1;
        int fimX = 1;
        int fimY = 3;
        
        String[][] mapa = {
            {"#","#","#","#","#","#","#","#","#","#","#"},
            {"#"," ","#"," "," "," ","#"," ","#"," ","#"},
            {"#"," ","#","#","#"," ","#"," ","#"," ","#"},
            {"#"," "," ","#"," "," ","#"," "," "," ","#"},
            {"#"," ","#","#","#"," ","#","#","#"," ","#"},
            {"#"," ","#"," "," "," "," "," ","#"," ","#"},
            {"#"," ","#"," ","#","#","#","#","#"," ","#"},
            {"#"," ","#"," "," "," "," "," "," "," ","#"},
            {"#"," ","#","#","#","#","#","#","#"," ","#"},
            {"#"," "," "," "," "," "," "," "," "," ","#"},
            {"#","#","#","#","#","#","#","#","#","#","#"}
        };
        
        boolean corX = localX != fimX; //Verifica as coordenadas
        boolean corY = localY != fimY; //...se for diferente inicia o loop
        
        while(!(corX && corY)){
            
            mapa[localX][localY] = "-"; //Marca como Visitado
            
//            //IMPRIME PILHA ANTES DO MOVIMENTO
//            int size = pilha.size();
//            for(int x=0;x<size;x++){
//                System.out.print(pilha.get(x)[1]+",");
//                System.out.print(pilha.get(x)[0]+" - ");
//                System.out.print(pilha.get(x)[2]+"\n");
//            }
//            System.out.print("\n");
            
            //Movimento Subir
            int subir = localX-1;
            boolean podeSubir = mapa[subir][localY].equals(" "); //Define as condições do Movimento
            if(podeSubir){ //Verifica se pode fazer o movimento
                int[] elem = {localX , localY , 0}; //Cria o Elemento
                pilha.add(elem); //Adiciona o elemento na pilha
                localX = subir; //Anda para nova casa
                continue; //Segue o loop
            }
            
            //Movimento Direita
            int direita = localY+1;
            boolean podeDireita = mapa[localX][direita].equals(" ");
            if(podeDireita){
                int[] elem = {localX , localY , 1};
                pilha.add(elem);
                localY = direita;
                continue;
            }
            
            //Movimento Descer
            int descer = localX+1;
            boolean podeDescer = mapa[descer][localY].equals(" ");
            if(podeDescer){
                int[] elem = {localX , localY , 2};
                pilha.add(elem);
                localX = descer;
                continue;
            }
            
            //Movimento Esquerda
            int esquerda = localY-1;
            boolean podeEsquerda = mapa[localX][esquerda].equals(" ");
            if(podeEsquerda){
                int[] elem = {localX , localY , 3};
                pilha.add(elem);
                localY = esquerda;
                continue;
            }
            
            if((localX == fimX) && (localY == fimY)){ //Verifica se chegou ao destino
                break; //...se chegou ao destino, para o loop
            }
            
            //Volta Passo;
            int last = pilha.size()-1; //Seleciona o elemento da pilha
            localX = pilha.get(last)[0]; //Define o elemento como a posição atual
            localY = pilha.get(last)[1];
            pilha.remove(last); //remove o elemento da pilha
            
            if(pilha.size() == 0){ //Verifica se a pilha esta vazia
                System.out.println("PILHA VAZIA");
                break; //..se tiver, finaliza o loop.
            }
        }
        
        //Imprime pilha
        int size = pilha.size();
        for(int x=0;x<size;x++){
            System.out.print("("+pilha.get(x)[1]+",");
            System.out.print(pilha.get(x)[0]+") - ");
            System.out.print(pilha.get(x)[2]+"\n");
        }
        System.out.print("("+fimY+","+fimX+") - null");//Imprime o destino
        
        //Desempilhar e marcar no labrinto
//        int size = pilha.size();
        for(int x=0;x<size;x++){
            mapa[pilha.get(x)[0]][pilha.get(x)[1]] = "*";
        }
        pilha.clear();
        
        //IMPRIME LABIRINTO
        for(int x=0;x<=10;x++){
            for(int y=0;y<=10;y++){
                System.out.print(mapa[x][y]);
            }
            System.out.print("\n");
        }
    }
    
}