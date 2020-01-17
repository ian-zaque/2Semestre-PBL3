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

public class Link {
    private Link next;
    private Link anter;
    private Object obj;
            
    /**
     * Construtor da classe Link. Inicializa o atributo 'obj' como o recebido pelo parâmetro. 
     * @param obj - objeto que será o conteúdo do nó 
     */ 
    public Link(Object obj)
    {   this.obj = obj;
        next = null;
    }   
   
    /**
     * Método que retorna o nó próximo ao nó escolhido.
     * @return next - próximo nó da lista. 
     */ 
    public Link getNext(){ return next; }

    /**
     * Método que retorna o objeto do nó escolhido.
     * @return obj - o objeto do nó escolhido.
     */ 
    public Object getObj() {  return obj;  }

    /**
     * Método que retorna o nó anterior ao nó escolhido.
     * @return anter - o nó anterior da lista.
     */    
    public Link getAnter() { return anter;  }
    
    /**
     * Método que modifica a referência para o nó próximo.
     * @param next - objeto que será o novo objeto.
     */
    public void setNext(Link next) { this.next = next;   }

    /**
     * Método que modifica o objeto escolhido.
     * @param obj - objeto que será o novo objeto.
     */
    public void setObj(Object obj) { this.obj = obj;  }

    /**
     * Método que modifica a referência para o nó anterior.
     * @param anter. Refência para nó anterior
     */
    public void setAnter(Link anter){  this.anter = anter;  }
}