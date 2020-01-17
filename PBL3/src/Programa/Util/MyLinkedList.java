/**
 * Componente Curricular: Módulo Integrado de Programação II
 * Autor: <Ian Zaque Pereira de Jesus dos Santos>
 * Data:  <03/12/2018>
 *
 * Declaro que este código foi elaborado por mim de forma individual e
 * não contém nenhum trecho de código de outro colega ou de outro autor, 
 * tais como provindos de livros e apostilas, e páginas ou documentos 
 * eletrônicos da Internet. Qualquer trecho de código de outra autoria que
 * uma citação para o  não a minha está destacado com  autor e a fonte do
 * código, e estou ciente que estes trechos não serão considerados para fins
 * de avaliação. Alguns trechos do código podem coincidir com de outros
 * colegas pois estes foram discutidos em sessões tutorias.
 */
package Programa.Util;

import java.util.Iterator;

public class MyLinkedList implements IList{
    private Link first;
    private Link last;
    private int tamanho;

    /**
     * Método que retorna a referência pro primeiro nó.
     * @return last 
     */
    public Link getFirst() { return first; }

    /**
     * Método que altera a referência pro primeiro nó para o @param passado.
     * @param first 
     */
    public void setFirst(Link first) {this.first = first; }

    /**
     * Método que retorna a referência pro último nó.
     * @return last 
     */
    public Link getLast() { return last;  }

    /**
     * Método que altera a referência pro último nó para o @param passado.
     * @param last 
     */
    public void setLast(Link last) { this.last = last;  }
            
    /**
    * Construtor da lista.
    * Inicializa a primeira e a última referência da lista como null.
    * Inicializa o tamanho da lista como 0.
    */
    public MyLinkedList()
    {   first = null;
        last = null;
        tamanho = 0;
    }

    /**
    * 
    * Método que consegue-se achar qualquer célula da lista através da posição.
    * @param pos é o número da posição da célula que se deseja pegar.   
    * @return retorna referência 'aux' da célula desejada. 
    */    
    private Link getCelula(int pos){
        
        if(this.tamanho > 0)
        {    Link aux = first;
            int cont = 0;                
            
            if(pos == 0 && cont == 0)
                {return first.getNext();}
            else
            { for(cont = 0; cont < pos; cont++)
                { aux = aux.getNext(); }                   
                return aux;        
            }
        }
        else
            return null;
    }           
        
    /**
    * 
    * Método que adiciona no início da lista um objeto
    * @param obj é o objeto a ser inserino no início da lista.       
    */
    public void addInicio(Object obj){
      Link novo = new Link (obj);
      novo.setNext(first);
      first = novo;
      
      if(this.tamanho == 0)
      { last = first; }
           
      this.tamanho++;
    }
    
    /**
    * Método que adiciona na posição escolhida da lista um objeto. 
    * Adiciona no fim caso a posição seja igual ao tamanho da lista. 
    * Adiciona no início caso a posição seja igual a 0
    * @param obj é o objeto a ser inserino no início da lista.   
    * @param pos é a posição que se deseja inserir na lista 
    */
    public void addMeio(int pos, Object obj){
        if(pos == 0)
          { addInicio(obj); }       //No inicio
        
        else if(pos == this.tamanho)     //No final
        {   addFim(obj); }
            
        else                        //No meio
        {   Link aux = getCelula(pos -1);
            Link novo = new Link (obj);
            aux.setNext(novo);
            this.tamanho++;
        }        
    }
    
    /**
    * Método que adiciona no fim da lista. 
    * Adiciona no início caso a posição seja igual a 0
    * @param obj é o objeto a ser inserino no início da lista.     
    */
    public void addFim(Object obj){
        if(this.tamanho == 0)
            { addInicio(obj); }
            
       else
        {   Link novo = new Link(obj);
            last.setNext(novo);
            last = novo;
            this.tamanho++;
        }        
    }
    
    /**
    * Método que remove 1ª célula da lista.
    * @return objeto removido.
    */
    public Object removeInicio(){
        Link aux = first;
        first = first.getNext();
        this.tamanho--;
        
        if(tamanho == 0)            //Se lista ficar vazia
        {   last = null;
            first = null;
        } 
      return aux.getObj();
    }
    
    /**
    * Método que remove célula da lista da posição escolhida.
    * @param pos posição da célula a ser removida.
    * @return objeto removido.
    */
    public Comparable removeMeio(int pos){      //Remove no meio
        Link ant = getCelula(pos - 1);
        Link aux1 = ant.getNext();
        Link prox = aux1.getNext();
        Link aux2 = getCelula(pos);
        
        ant.setNext(prox);
        prox.setAnter(ant);
        this.tamanho--;
        
        return (Comparable) aux2.getObj();
    }
    
    /**
    * Método que remove última célula da lista.
    * Remove 1ª célula se o tamanho for igual a 1.
    * @return objeto removido.
    */
    public Object removeFim(){
                   
        if (this.tamanho > 1)
        {  if(tamanho == 1)
                {return removeInicio();}        
        
            else
            {   Link penult = getCelula(tamanho - 1);
                penult.setNext(getCelula(tamanho));
                this.last = penult;
                this.tamanho--;
            
                return penult.getObj();
            }
        }
        return null;
    }                    
    
    /**
    * Método que retorna quantidade de células da lista.
    * @return tamanho
    */
    @Override
    public int size() {
        return this.tamanho;
    }     
        
    /**
    * Método que checa no @return se a lista está vazia.
    * @return 'true' se as referências para o início e fim da lista estiverem
    * nulos, 'false' caso contrário.
    */
    @Override
    public boolean isEmpty() {
        return(first == null && last == null);
    }   
    
    /**
    * Método que chama o método que adiciona no fim da lista
    * @param obj objeto a ser adicionado no fim da lista
    */
    @Override
    public void add(Object obj) {           //Adiciona no final.
        addFim( obj);
    } 
    
    /**
    * Método que adiciona na posição desejada da lista.
    * @param pos posição escolhida.
    * @param obj objeto a ser adicionado. 
    * @return true para caso adicione, 'false' caso contrário.
    */    
    @Override
    public boolean add(int pos, Object obj) {
        if(this.tamanho >= 0)
        {   if(pos == this.tamanho)              //Add no final
                {   addFim((Comparable) obj);
                    return true;
                }
            else if(pos == 0 && this.tamanho == 0)       //Add no inicio
                {   addInicio((Comparable) obj);
                    return true;
                }
            else if(pos < 0 || pos > tamanho)
                {   return false; }
            
            else
                {   addMeio(pos, obj);
                    return true;  
                }
        }
        else
         { return false; }
    }

    /**
    * Método que remove célula do final da lista.
    * @return null caso a lista esteja vazia, chama o método removeFim() ou removeInicio()
    * e retorna o objeto removido.  
    */
    @Override
    public Object remove() {            //Remove do fim.
        
        if(this.tamanho > 1)
            { return removeFim(); }
        
        else if(this.tamanho == 1)
            { return removeInicio(); }           
               
        
      return null;          //Caso lista vazia, retorna null.
    }

    /**
    * Método que remove na posição desejada da lista.
    * @param pos posição escolhida. 
    * @return null caso a lista esteja vazia ou pos seja maior que tamanho da lista
    * ou caso seja menor que 0. Chama o método correspondente a posição escolhida 
    * e retorna o objeto da posição, se não for nenhum outro caso.
    */
    @Override
    public Object remove(int pos) {
      if( tamanho > 0 )
        {  if(pos == tamanho)
               { return removeFim(); }                 // Remove no fim
        
            else if(pos < 0 || pos > tamanho)
                { return null; }                    //Caso a posição não exista na lista
         
            else if(pos == 1)
                { return removeMeio(1); }          //Caso a posição seja a 1 na lista
            
            else if(pos == 0)
                { return removeInicio(); }          //Caso a posição seja a 0 na lista
            
            else
                { return removeMeio(pos);  }        //Caso a posição estiver no meio da lista
        }
      else
          return null;
    }    
    
    /**
    * 
    * Método que consegue-se achar qualquer célula da lista através da posição.
    * @param index é o número da posição da célula que se deseja pegar.   
    * @return retorna referência da célula desejada. 
    */
    @Override
    public Link get(int index) {
        if(index == 0)
            {   if(first == null)
                    { return null;}
                else    
                    { return first; }
            }
                    
        else if(index < 0 || index > tamanho)    
            { return null;}
            
        else if(index == this.tamanho)
            { return last; }
                
        else
            { return getCelula(index); }            
    }     

    @Override
    public Iterator iterator()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}