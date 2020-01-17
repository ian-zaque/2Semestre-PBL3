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

import Programa.Model.Musica;
import Programa.Util.Excecoes.NenhumElementoEncontradoException;

public class MyTree {
    private AvlLink raiz;
    
        /**
         * Classe Aninhada da classe MyTree. Esta classe aninhada serve para 
         * conectar os nós da árvore AVL.
         */
        public class AvlLink{
           private AvlLink right, left;
           private Object obj;
           private int height;
        
           /**
            * Construtor da classe AvlLink. Instancia um objeto desta classe aninhada,
            * inicializa a altura como 0, o nó filho direita e esquerda como null.
            * O contéudo recebido por parâmetro será o elemento deste nó. 
            * @param obj 
            */
            public AvlLink(Object obj)
            {   this.obj = obj;
                height = 0;
                right = null; left = null;           
            }

            /**
             * Método que retorna o nó filho da direita.
             * @return - retorna o nó filho da direita.
             */
            public AvlLink getRightChild() { return right;  }

            /**
             * Método que retorna o nó filho da esquerda.
             * @return - retorna o nó filho da esquerda.
             */
            public AvlLink getLeftChild() { return left; }

            /**
             * Método que retorna o objeto de um determinado nó.
             * @return - retorna o objeto de um determinado nó.
             */
            public Comparable getObj() { return (Comparable) obj; }

            /**
             * Método que retorna a altura de determinado nó.
             * @return - retorna a altura de um determinado nó.
             */
            public int getHeight() { return height; }       

            /**
             * Método que atualiza o nó filho da direita.
             * @param right - o novo nó filho da direita.
             */
            public void setRightChild(AvlLink right) { this.right = right;  }

            /**
             * Método que atualiza o conteúdo do nó filho da esquerda.
             * @param left - o novo conteúdo do nó filho da esquerda.
             */
            public void setLeftChild(AvlLink left) { this.left = left;  }

            /**
             * Método que atualiza a altura do nó.
             * @param height - a nova altura do nó.
             */
            public void setHeight(int height) { this.height = height; }           
        }
    
    /**
    * Construtor da classe MyTree. Instancia um objeto desta classe.
    * Inicializa o nó raíz desta árvore AVL como null.
    * @see AvlLink
    */
    public MyTree()
    { raiz = null;  }

    /**
     * Método que retorna o nó raíz da árvore.
     * @return - retorna o nó raíz da árvore.
     */
    public AvlLink getRaiz() { return raiz; }   
    
    /**
     * Método que checa se a árvore está vazia.
     * @return - retorna 'true' se estiver vazia e 'false' em caso contrário. 
     */
    public boolean isEmpty()   { return raiz == null;  }
            
    /**
     * Método público que chama o método privado que retorna a quantidade de 3
     * itens da árvore em questão.
     * @return - retorna a quantidade de itens (nós) da árvore em questão.
     */
    public int contarNos() { return contarNos(raiz); }   
    
    /**
     * Método público que chama o método privado que retorna o nó que possui o 
     * elemento com o atributo igual a string passada no parâmetro.
     * @param nome - String que deseja-se achar o nó. 
     * @return - Nó que possui o elemento com o atributo igual a string passada no parâmetro.
     * @throws NenhumElementoEncontradoException 
     */
    public AvlLink procurar(String nome) throws NenhumElementoEncontradoException { return procurar(raiz,nome); }
    
    /**
     * Método público que chama o método de adicionar um novo nó à árvore.
     * O nó raiz da árvore AVL é reorganizado para ficar equilibrado através das rotações. 
     * @param mus - Música a ser adicionada na árvore.
     * @see Musica
     */
    public void add(Musica mus) { raiz = add(raiz,mus);  }
    
    /**
     * Método que limpa e exclui todos os elementos da árvore.
     * O nó raíz da árvore passa a ser 'null'.
     */
    public void esvaziar() { raiz = null; }
    
    /**
     * Método que retorna a altura do nó passado como parâmetro.
     * @param no - nó que deseja-se saber a altura.
     * @return - retorna a altura do nó passado como parâmetro.
     */
    public int altura(AvlLink no)
    {   if(no == null) { return -1;  }
        else { return no.getHeight();  }            
    }
    
    /**
     * Método que checa qual dos parâmetros é maior. Retorna o maior.
     * @param num1 - número passado por parâmetro.
     * @param num2 - número passado por parâmetro.
     * @return - retorna o maior número dos parâmetros. 
     */
    public int qualMaior(int num1, int num2)
    {   if(num1 > num2) { return num1;  }
        else if(num1 < num2) { return num2; }
      return num1;  
    }
    
    /**
     * Método privado que adiciona um novo elemento ao nó do parâmetro.
     * Checa o nome da música do parâmetro e adiciona onde for menor que 
     * o nó pai. Rotaciona os nós da árvore para ficar balanceada corretamente.
     * Se já existir um elemento com o mesmo nome, este não é adicionado.
     * @param raiz - nó que deseja-se adicionar um novo elemento.
     * @param mus - elemento a ser adicionado.
     * @return - retorna o nó raiz reorganizado e balanceado.
     */
    private AvlLink add(AvlLink raiz, Musica mus)
    {   if(raiz == null) { raiz = new AvlLink((Object) mus);   }        
        
        else if( mus.compare(mus, raiz.getObj())  < 0)
        {   raiz.setLeftChild( add(raiz.getLeftChild(),mus) );
                
                if(altura(raiz.getLeftChild()) - altura(raiz.getRightChild()) == 2)
                {   
                    if( mus.compare(mus, raiz.getObj())  < 0)
                    { raiz = rotacaoSimplesFilhoEsquerda(raiz); }
                
                    else { raiz = rotacaoDuplaFilhoEsquerda(raiz);  }                 
                }                
        }    
        else if( mus.compare(mus, raiz.getObj()) > 0)
        {   raiz.setRightChild( add(raiz.getRightChild(),mus) );
            
               if(altura(raiz.getRightChild()) - altura(raiz.getLeftChild()) == 2)
                { 
                    if( mus.compare(mus, raiz.getObj()) > 0)
                    { raiz = rotacaoSimplesFilhoDireita(raiz); }
                    
                    else { raiz = rotacaoDuplaFilhoDireita(raiz);  }
                }
        }        
        else
        { raiz.setHeight(qualMaior(altura(raiz.getRightChild()),altura(raiz.getLeftChild())) + 1);  }    
     return raiz;
    }
    
    /**
     * Método que checa os nós e retorna aquele que possui o elemento com o nome 
     * da música igual á string passada por parâmetro. Compara os nomes até 
     * achar o nó que possui o mesmo nome. 
     * @param no - nó que deseja-se começar a busca.
     * @param nome - string que deseja-se encontrar.
     * @return - retorna o nó que possui o elemento com o nome da música 
     * igual á string passada por parâmetro.
     * @throws NenhumElementoEncontradoException 
     */
    private AvlLink procurar(AvlLink no, String nome) throws NenhumElementoEncontradoException
    {  try
          { AvlLink aux = no; 
            while (aux != null)
            {  if (nome.compareTo(((Musica)aux.getObj()).getNomeMusica()) < 0)     { aux = aux.getLeftChild(); }
            
                else
                {   if (nome.compareTo(((Musica)aux.getObj()).getNomeMusica()) > 0) { aux = aux.getRightChild();  }                
                    else { return aux; }   // Achou                
                }
            }            
            throw new NenhumElementoEncontradoException();   // Não achou                  
          }
         catch(NenhumElementoEncontradoException exc)
         { throw new NenhumElementoEncontradoException(); }
    } 
    
    /**
     * Método que retorna a quantidade de elementos a a partir do nó passado por
     * parâmetro.
     * @param no - nó que deseja-se começar a busca.
     * @return - retorna a quantidade de elementos a a partir do nó passado por
     * parâmetro.
     */
    private int contarNos(AvlLink no)
    {   if(no == null) { return 0;  }        
        else
        {   AvlLink aux = no;
            int quant = 1; 
            quant += contarNos(aux.getRightChild());
            quant += contarNos(aux.getLeftChild());
          return quant;  
        }
    }
    
    /**
     * Método usado para fazer rotação simples para a direita na árvore 
     * a fim de balanceá-la a partir do nó passado por parâmetro.  
     * @param no1 - nó que deseja-se balancear.
     * @return - retorna o nó passado por parâmetro balanceado. 
     */
    private AvlLink rotacaoSimplesFilhoDireita(AvlLink no1)
    {   AvlLink no2 = no1.getRightChild();
        no1.setRightChild(no2.getLeftChild());
        no2.setLeftChild(no1);
        no1.setHeight(qualMaior(altura(no1.getLeftChild()), altura(no1.getRightChild())) + 1);
        no2.setHeight(qualMaior(altura(no2.getRightChild()), no1.getHeight()) + 1);
      return no2;        
    }
    
    /**
     * Método usado para fazer rotação simples para a esquerda na árvore 
     * a fim de balanceá-la a partir do nó passado por parâmetro.  
     * @param no2 - nó que deseja-se balancear.
     * @return - retorna o nó passado por parâmetro balanceado. 
     */
    private AvlLink rotacaoSimplesFilhoEsquerda(AvlLink no2)
    {   AvlLink no1 = no2.getLeftChild();
        no2.setLeftChild(no1.getRightChild());
        no1.setRightChild(no2);
        no2.setHeight(qualMaior(altura(no2.getLeftChild()), altura(no2.getRightChild())) + 1);
        no1.setHeight(qualMaior(altura(no1.getLeftChild()), no2.getHeight()) + 1);
      return no1;       
    }
    
    /**
     * Método usado para fazer rotação dupla para a direita na árvore 
     * a fim de balanceá-la a partir do nó passado por parâmetro.
     * Rotaciona simples para a esquerda e depois simples para a direita.
     * @param no1 - nó que deseja-se balancear.
     * @return - retorna o nó passado por parâmetro balanceado. 
     */
    private AvlLink rotacaoDuplaFilhoDireita(AvlLink no1)
    {   no1.setRightChild(rotacaoSimplesFilhoEsquerda(no1.getRightChild()));
        return rotacaoSimplesFilhoDireita(no1);        
    }
    
    /**
     * Método usado para fazer rotação dupla para a esquerda na árvore 
     * a fim de balanceá-la a partir do nó passado por parâmetro. 
     * Rotaciona simples para a direita e depois simples para a esquerda.
     * @param no2 - nó que deseja-se balancear.
     * @return - retorna o nó passado por parâmetro balanceado. 
     */
    private AvlLink rotacaoDuplaFilhoEsquerda(AvlLink no2)
    {   no2.setLeftChild(rotacaoSimplesFilhoDireita(no2.getLeftChild())); 
        return rotacaoSimplesFilhoEsquerda(no2);        
    }    
}