
package TesteUtil;

import Programa.Model.Musica;
import Programa.Util.Excecoes.NenhumElementoEncontradoException;
import Programa.Util.MyTree;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class TesteMyTree {
    private MyTree arvore;
    private Musica nome1,nome2,nome3,nome4,nome5,nome6,nome7,nome8,nome9,nome10,nome11,nome12,nome13,nome14,nome15,nome16,nome17,nome18,nome19,nome20;
    
    @Before
    public void setUp()
    {   arvore = new MyTree();
        nome1 = new Musica("musica1","banda1","album1","1");nome2 = new Musica("musica2","banda2","album2","2");nome3 = new Musica("musica3","banda3","album3","3");
        nome4 = new Musica("musica4","banda4","album4","4");nome5 = new Musica("musica5","banda5","album5","5");nome6 = new Musica("musica6","banda6","album6","6");
        nome7 = new Musica("musica7","banda7","album7","7");nome8 = new Musica("musica8","banda8","album8","8");nome9 = new Musica("musica9","banda9","album9","9");
        nome10 = new Musica("musica10","banda10","album10","10");nome11 = new Musica("musica11","banda11","album11","11");nome12 = new Musica("musica12","banda12","album12","12");
        nome13 = new Musica("musica13","banda13","album13","13");nome14 = new Musica("musica14","banda14","album14","14");nome15 = new Musica("musica15","banda15","album15","15");
        nome16 = new Musica("musica16","banda16","album16","16");nome17 = new Musica("musica17","banda17","album17","17");nome18 = new Musica("musica18","banda18","album18","18");
        nome19 = new Musica("musica19","banda19","album19","19");nome20 = new Musica("musica20","banda20","album20","20");
    }
 
    @Test
    public void testeAdd() throws NenhumElementoEncontradoException
    {   arvore.add(nome4);arvore.add(nome7);arvore.add(nome13);arvore.add(nome19);
        arvore.add(nome5);arvore.add(nome8);arvore.add(nome14);arvore.add(nome20);
        arvore.add(nome1);arvore.add(nome9);arvore.add(nome15);
        arvore.add(nome6);arvore.add(nome10);arvore.add(nome16);
        arvore.add(nome3);arvore.add(nome11);arvore.add(nome17);
        arvore.add(nome2);arvore.add(nome12);arvore.add(nome18);
               
        assertEquals(20,arvore.contarNos()); 
        assertEquals(nome1, arvore.procurar("musica1").getObj()); assertEquals(nome7, arvore.procurar("musica7").getObj());
        assertEquals(nome2, arvore.procurar("musica2").getObj()); assertEquals(nome8, arvore.procurar("musica8").getObj());
        assertEquals(nome3, arvore.procurar("musica3").getObj()); assertEquals(nome9, arvore.procurar("musica9").getObj());
        assertEquals(nome4, arvore.procurar("musica4").getObj()); assertEquals(nome10, arvore.procurar("musica10").getObj());
        assertEquals(nome5, arvore.procurar("musica5").getObj()); assertEquals(nome11, arvore.procurar("musica11").getObj());
        assertEquals(nome6, arvore.procurar("musica6").getObj()); assertEquals(nome12, arvore.procurar("musica12").getObj());
        assertEquals(nome13, arvore.procurar("musica13").getObj()); assertEquals(nome14, arvore.procurar("musica14").getObj());
        assertEquals(nome15, arvore.procurar("musica15").getObj()); assertEquals(nome16, arvore.procurar("musica16").getObj());
        assertEquals(nome17, arvore.procurar("musica17").getObj()); assertEquals(nome18, arvore.procurar("musica18").getObj());
        assertEquals(nome19, arvore.procurar("musica19").getObj()); assertEquals(nome20, arvore.procurar("musica20").getObj());
    }
    
    @Test    
    public void testeIsEmpty()
    {   assertTrue(arvore.isEmpty());
        
        arvore.add(nome4);arvore.add(nome7);arvore.add(nome13);arvore.add(nome19);
        arvore.add(nome5);arvore.add(nome8);arvore.add(nome14);arvore.add(nome20);
        arvore.add(nome1);arvore.add(nome9);arvore.add(nome15);
        arvore.add(nome6);arvore.add(nome10);arvore.add(nome16);
        arvore.add(nome3);arvore.add(nome11);arvore.add(nome17);
        arvore.add(nome2);arvore.add(nome12);arvore.add(nome18);
    
        assertEquals(20,arvore.contarNos()); 
        assertFalse(arvore.isEmpty());
    }
    
    @Test
    public void testeContarNos()
    {   assertEquals(0,arvore.contarNos());
        
        arvore.add(nome4);
        arvore.add(nome5);
        assertEquals(2,arvore.contarNos());
        
        arvore.add(nome4);
        arvore.add(nome5);
        assertEquals(2,arvore.contarNos());
        
        arvore.add(nome4);arvore.add(nome7);arvore.add(nome13);arvore.add(nome19);
        arvore.add(nome5);arvore.add(nome8);arvore.add(nome14);arvore.add(nome20);
        arvore.add(nome1);arvore.add(nome9);arvore.add(nome15);
        arvore.add(nome6);arvore.add(nome10);arvore.add(nome16);
        arvore.add(nome3);arvore.add(nome11);arvore.add(nome17);
        arvore.add(nome2);arvore.add(nome12);arvore.add(nome18);
        assertEquals(20,arvore.contarNos());
    }
    
    @Test
    public void testeEsvaziar()
    {   arvore.add(nome4);arvore.add(nome7);arvore.add(nome13);arvore.add(nome19);
        arvore.add(nome5);arvore.add(nome8);arvore.add(nome14);arvore.add(nome20);
        arvore.add(nome1);arvore.add(nome9);arvore.add(nome15);
        arvore.add(nome6);arvore.add(nome10);arvore.add(nome16);
        arvore.add(nome3);arvore.add(nome11);arvore.add(nome17);
        arvore.add(nome2);arvore.add(nome12);arvore.add(nome18);
        assertEquals(20,arvore.contarNos());
                        
        arvore.esvaziar();
        assertEquals(0,arvore.contarNos());
        assertTrue(arvore.isEmpty());
    }
    
    @Test
    public void testeInsereRemove() throws NenhumElementoEncontradoException
    {   assertTrue(arvore.isEmpty());
        assertEquals(0,arvore.contarNos());
        
        arvore.add(nome4);arvore.add(nome7);arvore.add(nome13);
        arvore.add(nome19);arvore.add(nome5);arvore.add(nome8);
               
        assertTrue(!arvore.isEmpty());
        assertEquals(6,arvore.contarNos());
        arvore.esvaziar();
        
        assertTrue(arvore.isEmpty());
        assertEquals(0,arvore.contarNos());
        
        arvore.add(nome4);arvore.add(nome7);arvore.add(nome13);
        arvore.add(nome19);arvore.add(nome5);arvore.add(nome8);
        arvore.add(nome4);arvore.add(nome7);arvore.add(nome13);
        arvore.add(nome19);arvore.add(nome5);arvore.add(nome8);
        
        assertTrue(!arvore.isEmpty());
        assertEquals(6,arvore.contarNos());                     //Se tiver elementos iguais, eles n são adicionados na árvore
               
        arvore.add(nome4);arvore.add(nome7);arvore.add(nome13);arvore.add(nome19);
        arvore.add(nome5);arvore.add(nome8);arvore.add(nome14);arvore.add(nome20);
        arvore.add(nome1);arvore.add(nome9);arvore.add(nome15);
        arvore.add(nome6);arvore.add(nome10);arvore.add(nome16);
        arvore.add(nome3);arvore.add(nome11);arvore.add(nome17);
        arvore.add(nome2);arvore.add(nome12);arvore.add(nome18);
        
        assertTrue(!arvore.isEmpty());
        assertEquals(20,arvore.contarNos()); 
    }
}