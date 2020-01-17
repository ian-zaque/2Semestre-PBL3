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
package TesteUtil;

import Programa.Model.Musica;
import Programa.Util.MyLinkedList;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;


public class MyLinkedListTest {
    private MyLinkedList listaTeste;
    private Musica nome1,nome2,nome3,nome4,nome5,nome6,nome7,nome8,nome20;
    
    /**
     * Este método é executado antes de cada teste. Inicializa os produtos 
     * que serão usados para serem armazenados na lista.
     */
    @Before
    public void setUp(){
        listaTeste = new MyLinkedList();
        nome1 = new Musica("musica1","banda1","album1","1");nome2 = new Musica("musica2","banda2","album2","2");nome3 = new Musica("musica3","banda3","album3","3");
        nome4 = new Musica("musica4","banda4","album4","4");nome5 = new Musica("musica5","banda5","album5","5");nome6 = new Musica("musica6","banda6","album6","6");
        nome7 = new Musica("musica7","banda7","album7","7");nome8 = new Musica("musica8","banda8","album8","8");nome20 = new Musica("musica20","banda20","album20","20");
    }    
    
    /**
     * Teste que checa se o método de inserção da classe MyLinkedList está funcionando. 
     */
    @Test
    public void testeInsere(){
        listaTeste.add(nome1);listaTeste.add(nome5);
        listaTeste.add(nome2);listaTeste.add(nome6);
        listaTeste.add(nome3);listaTeste.add(nome7);
        listaTeste.add(nome4);listaTeste.add(nome8);
        
        assertEquals(nome1, listaTeste.get(0).getObj());
        assertEquals(nome5, listaTeste.get(1).getObj());
        assertEquals(nome2, listaTeste.get(2).getObj());
        assertEquals(nome6, listaTeste.get(3).getObj());
        assertEquals(nome3, listaTeste.get(4).getObj());
        assertEquals(nome7, listaTeste.get(5).getObj());
        assertEquals(nome4, listaTeste.get(6).getObj());
        assertEquals(nome8, listaTeste.get(7).getObj()); 
    }
    
    /**
     * Teste que checa se o método de remoção da classe MyLinkedList está funcionando. 
     */
    @Test
    public void testeRemove(){
        listaTeste.remove();
        listaTeste.remove();
        listaTeste.remove();
        listaTeste.remove();
        
        assertEquals(null, listaTeste.get(0));
        assertEquals(null, listaTeste.get(1));
        assertEquals(null, listaTeste.get(2));
        assertEquals(null, listaTeste.get(3));
    }
    
    /**
     *  Teste que checa se o método de inserção e remoção consecutivos 
     * da classe MyLinkedList estão funcionando. 
     */
    @Test
    public void testeInsereRemove(){
        listaTeste.add(nome1);
        assertEquals(nome1, listaTeste.remove());
        
        listaTeste.add(nome20);
        assertEquals(nome20, listaTeste.remove());
        
        listaTeste.add(nome5);
        assertEquals(nome5, listaTeste.remove());       
    } 
    /**
     * Teste que checa se o método de retornar célula da lista 
     * da classe MyLinkedList está funcionando. 
     */
    @Test
    public void testeGet(){
        listaTeste.add(nome1);listaTeste.add(nome5);
        listaTeste.add(nome2);listaTeste.add(nome6);
        listaTeste.add(nome3);listaTeste.add(nome7);
        listaTeste.add(nome4);listaTeste.add(nome8);
        
        assertEquals(nome1, listaTeste.get(0).getObj());
        assertEquals(nome5, listaTeste.get(1).getObj());
        assertEquals(nome2, listaTeste.get(2).getObj());
        assertEquals(nome6, listaTeste.get(3).getObj());
        assertEquals(nome3, listaTeste.get(4).getObj());
        assertEquals(nome7, listaTeste.get(5).getObj());
        assertEquals(nome4, listaTeste.get(6).getObj());
        assertEquals(nome8, listaTeste.get(7).getObj());      
    }
    
    /**
     * Teste que checa se o método de ver se a lista está vazia
     * da classe MyLinkedList está funcionando. 
     */
    @Test
    public void testeVazia(){
        listaTeste.add(nome1);listaTeste.add(nome5);
        listaTeste.add(nome2);listaTeste.add(nome6);
        listaTeste.add(nome3);listaTeste.add(nome7);
        listaTeste.add(nome4);listaTeste.add(nome8);
        assertFalse(listaTeste.isEmpty());
        
        listaTeste.remove();
        listaTeste.remove();
        listaTeste.remove();
        listaTeste.remove();
        listaTeste.remove();
        listaTeste.remove();
        listaTeste.remove();
        listaTeste.remove();
        assertTrue(listaTeste.isEmpty());
    }    
}