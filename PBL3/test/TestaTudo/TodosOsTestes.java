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
package TestaTudo;

import TesteControlador.TesteSistema;
import TesteModel.TesteBancoDeMusicas;
import TesteUtil.MyLinkedListTest;
import TesteUtil.TesteMyTree;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
  { 
    TesteBancoDeMusicas.class,
    TesteMyTree.class, 
    MyLinkedListTest.class,
    TesteSistema.class,
})

/**
 * Classe de testes que roda todos os testes criados. 
 */
public class TodosOsTestes {    
}