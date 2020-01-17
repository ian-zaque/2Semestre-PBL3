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
package TesteControlador;

import Programa.Controlador.Sistema;
import Programa.Model.BancoDeMusicas;
import Programa.Model.Musica;
import Programa.Model.Playlist;
import Programa.Util.Excecoes.ArquivoNaoEncontradoException;
import Programa.Util.Excecoes.FalhaGeracaoInformacoesException;
import Programa.Util.Excecoes.NenhumElementoEncontradoException;
import Programa.Util.Excecoes.PlayListSemElementosException;
import Programa.Util.MyLinkedList;
import Programa.Util.MyTree;
import java.io.FileNotFoundException;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class TesteSistema {
    private Sistema sistema;
    private BancoDeMusicas banco;
    
    /**
     * Este método é executado antes de cada teste. Inicializa um objeto
     * da classe BancoDeMusicas e um da classe Sistema. 
     */
    @Before
    public void setUp()
    {   banco = new BancoDeMusicas("./Musicas");
        sistema = new Sistema();        
    }
    
    /**
     * Teste que checa se a busca de músicas pelo começo do 
     * nome está funcionando.
     * @throws NenhumElementoEncontradoException
     * @throws IOException
     * @throws FileNotFoundException
     * @throws FalhaGeracaoInformacoesException
     * @throws ArquivoNaoEncontradoException 
     * @see MyTree
     * @see BancoDeMusicas
     * @see Sistema
     */
    @Test
    public void TesteBuscarMusica() throws NenhumElementoEncontradoException, IOException, FileNotFoundException, FalhaGeracaoInformacoesException, ArquivoNaoEncontradoException
    {   try
        {   banco.carregarMusicasEmTxt();
            MyTree arvore = banco.carregaMusicaEmArvore();    
            MyTree tree = new MyTree();
            tree.add(sistema.buscarMusica("Bra"));
            tree.add(sistema.buscarMusica("Cho"));
            tree.add(sistema.buscarMusica("Wing"));
            tree.add(sistema.buscarMusica("Radiant"));
            tree.add(sistema.buscarMusica("Dea"));
            tree.add(sistema.buscarMusica("De"));
            tree.add(sistema.buscarMusica("B.Y"));
            tree.add(sistema.buscarMusica("Meus"));
            tree.add(sistema.buscarMusica("Meus p"));
            tree.add(sistema.buscarMusica("Meus pr"));
            tree.add(sistema.buscarMusica("Sym"));
        
            assertEquals(10,tree.contarNos());
            assertTrue(!tree.isEmpty());
            assertEquals("Brasil",((Musica)tree.procurar("Brasil").getObj()).getNomeMusica());
            assertEquals("Oficina G3",((Musica)tree.procurar("Brasil").getObj()).getBanda());      
            assertEquals("Chop Suey!",((Musica)tree.procurar("Chop Suey!").getObj()).getNomeMusica());
            assertEquals("System Of A Down",((Musica)tree.procurar("Chop Suey!").getObj()).getBanda());
            assertEquals("Winged Hussars",((Musica)tree.procurar("Winged Hussars").getObj()).getNomeMusica());
            assertEquals("Sabaton",((Musica)tree.procurar("Winged Hussars").getObj()).getBanda());
            assertEquals("Radiant Eclipse",((Musica)tree.procurar("Radiant Eclipse").getObj()).getNomeMusica());
            assertEquals("Avenged Sevenfold",((Musica)tree.procurar("Radiant Eclipse").getObj()).getBanda());
            assertEquals("Dead Memories",((Musica)tree.procurar("Dead Memories").getObj()).getNomeMusica());
            assertEquals("Slipknot",((Musica)tree.procurar("Dead Memories").getObj()).getBanda());
            assertEquals("De joelhos",((Musica)tree.procurar("De joelhos").getObj()).getNomeMusica());
            assertEquals("Oficina G3",((Musica)tree.procurar("De joelhos").getObj()).getBanda());
            assertEquals("B.Y.O.B",((Musica)tree.procurar("B.Y.O.B").getObj()).getNomeMusica());
            assertEquals("System Of A Down",((Musica)tree.procurar("B.Y.O.B").getObj()).getBanda());
            assertEquals("Meus passos",((Musica)tree.procurar("Meus passos").getObj()).getNomeMusica());
            assertEquals("Oficina G3",((Musica)tree.procurar("Meus passos").getObj()).getBanda());
            assertEquals("Meus próprios meios",((Musica)tree.procurar("Meus próprios meios").getObj()).getNomeMusica());
            assertEquals("Oficina G3",((Musica)tree.procurar("Meus próprios meios").getObj()).getBanda());
            assertEquals("Symphony of Destruction",((Musica)tree.procurar("Symphony of Destruction").getObj()).getNomeMusica());
            assertEquals("Megadeth",((Musica)tree.procurar("Symphony of Destruction").getObj()).getBanda());
        } 
        catch(IOException | FalhaGeracaoInformacoesException exc1)
        { throw new FalhaGeracaoInformacoesException(); }
        catch(NenhumElementoEncontradoException exc3)
        { throw new NenhumElementoEncontradoException(); }    
    }
    
    /**
     * Teste que checa se a busca de músicas pelo começo do 
     * nome consegue capturar a exceção quando não retorna-se nenhuma música.
     * @throws FileNotFoundException
     * @throws ArquivoNaoEncontradoException
     * @throws FalhaGeracaoInformacoesException
     * @throws NenhumElementoEncontradoException 
     * @see MyTree
     * @see BancoDeMusicas
     * @see Sistema
     */
    @Test (expected = NenhumElementoEncontradoException.class)
    public void testeBuscarMusicaExcecao() throws FileNotFoundException, ArquivoNaoEncontradoException, FalhaGeracaoInformacoesException, NenhumElementoEncontradoException
    {   try
        {   banco.carregarMusicasEmTxt();
            MyTree arvore = banco.carregaMusicaEmArvore();
            MyTree tree = new MyTree();
            tree.add(sistema.buscarMusica("a7x >"));
            tree.add(sistema.buscarMusica("TXYWUI"));
            tree.add(sistema.buscarMusica("qwerty"));
            tree.add(sistema.buscarMusica("hino nacional do Brasil"));
            tree.add(sistema.buscarMusica("musica boa"));
            tree.add(sistema.buscarMusica("musica excelente"));               
        }
        catch(IOException | FalhaGeracaoInformacoesException exc1)
        { throw new FalhaGeracaoInformacoesException(); }
        catch(NenhumElementoEncontradoException exc3)
        { throw new NenhumElementoEncontradoException(); }    
    }
    
    /**
     * Teste que checa se a geração de playlist está funcionando.
     * @throws IOException
     * @throws FileNotFoundException
     * @throws FalhaGeracaoInformacoesException
     * @throws ArquivoNaoEncontradoException
     * @throws NenhumElementoEncontradoException
     * @throws PlayListSemElementosException 
     * @see MyTree
     * @see MyLinkedList
     * @see BancoDeMusicas
     * @see Sistema
     */
    @Test
    public void TesteGerarPlaylist() throws IOException, FileNotFoundException, FalhaGeracaoInformacoesException, ArquivoNaoEncontradoException, NenhumElementoEncontradoException, PlayListSemElementosException
    {   try
        {   banco.carregarMusicasEmTxt();
            MyTree arvore = banco.carregaMusicaEmArvore();
            MyLinkedList lista = new MyLinkedList();
            
            lista.add(sistema.buscarMusica("A"));lista.add(sistema.buscarMusica("B"));
            lista.add(sistema.buscarMusica("C"));lista.add(sistema.buscarMusica("Meus p"));
            lista.add(sistema.buscarMusica("Cho"));lista.add(sistema.buscarMusica("D"));
            lista.add(sistema.buscarMusica("E"));lista.add(sistema.buscarMusica("F"));
            lista.add(sistema.buscarMusica("Wi"));lista.add(sistema.buscarMusica("Dys"));
            lista.add(sistema.buscarMusica("Radi"));lista.add(sistema.buscarMusica("Pan"));
            lista.add(sistema.buscarMusica("Dea"));lista.add(sistema.buscarMusica("Mas"));
            lista.add(sistema.buscarMusica("The"));lista.add(sistema.buscarMusica("Mag"));
            lista.add(sistema.buscarMusica("M"));lista.add(sistema.buscarMusica("De"));
            lista.add(sistema.buscarMusica("H"));lista.add(sistema.buscarMusica("Min"));
            lista.add(sistema.buscarMusica("B.Y"));lista.add(sistema.buscarMusica("I"));
            lista.add(sistema.buscarMusica("Meus"));lista.add(sistema.buscarMusica("Bra"));
            lista.add(sistema.buscarMusica("Meus pr"));lista.add(sistema.buscarMusica("J"));
            lista.add(sistema.buscarMusica("Fad"));lista.add(sistema.buscarMusica("Sym"));
            lista.add(sistema.buscarMusica("K"));lista.add(sistema.buscarMusica("Aft"));
            lista.add(sistema.buscarMusica("L"));lista.add(sistema.buscarMusica("Bef"));
            lista.add(sistema.buscarMusica("Ete"));lista.add(sistema.buscarMusica("Sp"));
        
            assertEquals(100,arvore.contarNos());
            assertTrue(!arvore.isEmpty());
            assertEquals(34,lista.size());
            assertTrue(!lista.isEmpty());
            
            Playlist playlist = sistema.gerarPlayList(lista, "#Random Musics For Radio");
            assertEquals(34,playlist.size()); 
            assertTrue(!playlist.getLista().isEmpty());
        }
        catch(IOException exc1)
        { throw new FalhaGeracaoInformacoesException(); }
        catch(NenhumElementoEncontradoException exc2)
        { throw new NenhumElementoEncontradoException(); }
        catch(PlayListSemElementosException exc3)
        { throw new PlayListSemElementosException(); }
    }
    
    /**
     * Teste que checa se a geração de playlist está capturando a exceção 
     * lançada quando a playlist está vazia.
     * @throws IOException
     * @throws FileNotFoundException
     * @throws FalhaGeracaoInformacoesException
     * @throws ArquivoNaoEncontradoException
     * @throws NenhumElementoEncontradoException
     * @throws PlayListSemElementosException 
     * @see MyTree
     * @see MyLinkedList
     * @see BancoDeMusicas
     * @see Sistema
     */
    @Test (expected = PlayListSemElementosException.class)
    public void testeGerarPlaylistExcecao() throws IOException, FileNotFoundException, FalhaGeracaoInformacoesException, ArquivoNaoEncontradoException, NenhumElementoEncontradoException, PlayListSemElementosException
    {   try
        {   banco.carregarMusicasEmTxt();
            MyTree arvore = banco.carregaMusicaEmArvore();
            MyLinkedList lista = new MyLinkedList();
            lista.add(sistema.buscarMusica("baixo do And justice for all"));
            lista.add(sistema.buscarMusica("null"));
            lista.add(sistema.buscarMusica("123456789"));
            lista.add(sistema.buscarMusica("musica boa do justin bieber"));
            
            assertEquals(0,lista.size());
            assertTrue(lista.isEmpty());
            
            Playlist play = sistema.gerarPlayList(lista, "coisas inexistentes");
            assertEquals(0,play.size()); 
            assertTrue(play.getLista().isEmpty());            
        }
        catch(IOException exc1)
        { throw new FalhaGeracaoInformacoesException(); }
        catch(NenhumElementoEncontradoException | PlayListSemElementosException exc2)
        { throw new PlayListSemElementosException(); }
    }    
}