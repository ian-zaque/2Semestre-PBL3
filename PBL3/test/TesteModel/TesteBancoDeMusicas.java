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
package TesteModel;

import Programa.Model.BancoDeMusicas;
import Programa.Model.Musica;
import Programa.Util.Excecoes.ArquivoNaoEncontradoException;
import Programa.Util.Excecoes.FalhaGeracaoInformacoesException;
import Programa.Util.Excecoes.NenhumElementoEncontradoException;
import Programa.Util.MyTree;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class TesteBancoDeMusicas {
    private BancoDeMusicas banco;
    
    /**
     * Este método é executado antes de cada teste. Inicializa um objeto
     * da classe BancoDeMusicas. 
     */
    @Before
    public void setUp()
    { banco = new BancoDeMusicas("./Musicas"); }     
    
    /**
     * Teste que checa se as TAG's estão sendo corretamente carregadas 
     * no arquivo .txt. 
     * @throws IOException
     * @throws FileNotFoundException
     * @throws FalhaGeracaoInformacoesException
     * @throws ArquivoNaoEncontradoException 
     * @see File
     */
    @Test
    public void testeCarregarMusicasEmTxt() throws IOException, FileNotFoundException, FalhaGeracaoInformacoesException, ArquivoNaoEncontradoException
    { try  
        {   banco.carregarMusicasEmTxt();
            File arq = new File(banco.getDiretorio().getAbsolutePath().concat("/") );
            assertTrue(arq.exists());     
        }
        catch(IOException | FalhaGeracaoInformacoesException exc1)
        { throw new FalhaGeracaoInformacoesException(); }
    }
    
    /**
     * Teste que checa se a exceção lançada ao falhar na geração das informações
     * foi capturada corretamente.
     * @throws IOException
     * @throws FileNotFoundException
     * @throws FalhaGeracaoInformacoesException
     * @throws ArquivoNaoEncontradoException 
     * @see BancoDeMusicas
     */
    @Test (expected = FalhaGeracaoInformacoesException.class)
    public void testeCarregarMusicasEmTxtExcecao() throws IOException, FileNotFoundException, FalhaGeracaoInformacoesException, ArquivoNaoEncontradoException
    {   try   
        {   banco = new BancoDeMusicas("fgkftk");
            banco.carregarMusicasEmTxt(); 
        }
        catch(IOException | FalhaGeracaoInformacoesException exc1)
        { throw new FalhaGeracaoInformacoesException(); }
    }
    
    /**
     * Teste que checa se as músicas estão sendo corretamente carregadas na árvore AVL.
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ArquivoNaoEncontradoException
     * @throws FalhaGeracaoInformacoesException
     * @throws NenhumElementoEncontradoException 
     * @see MyTree
     * @see BancoDeMusicas
     */
    @Test
    public void testeCarregarMusicasEmArvore() throws IOException, FileNotFoundException, ArquivoNaoEncontradoException, FalhaGeracaoInformacoesException, NenhumElementoEncontradoException
    {  try
        {   banco.carregarMusicasEmTxt();
            MyTree arvore = banco.carregaMusicaEmArvore();
        
            assertTrue(!arvore.isEmpty());
            assertEquals(100,arvore.contarNos());
        
            assertEquals("Afterlife",((Musica)arvore.procurar("Afterlife").getObj()).getNomeMusica());        
            assertEquals("Avenged Sevenfold",((Musica)arvore.procurar("Afterlife").getObj()).getBanda());
            assertEquals("Avenged Sevenfold", ((Musica)arvore.procurar("Afterlife").getObj()).getAlbum());
            assertEquals("2007", ((Musica)arvore.procurar("Afterlife").getObj()).getAnoLanca());
    
            assertEquals("Espelhos Mágicos",((Musica)arvore.procurar("Espelhos Mágicos").getObj()).getNomeMusica());        
            assertEquals("Oficina G3",((Musica)arvore.procurar("Espelhos Mágicos").getObj()).getBanda());
            assertEquals("Indiferença", ((Musica)arvore.procurar("Espelhos Mágicos").getObj()).getAlbum());
            assertEquals("1996", ((Musica)arvore.procurar("Espelhos Mágicos").getObj()).getAnoLanca());
        
            assertEquals("The Enemy Inside",((Musica)arvore.procurar("The Enemy Inside").getObj()).getNomeMusica());        
            assertEquals("Dream Theater",((Musica)arvore.procurar("The Enemy Inside").getObj()).getBanda());
            assertEquals("The Enemy Inside", ((Musica)arvore.procurar("The Enemy Inside").getObj()).getAlbum());
            assertEquals("2013", ((Musica)arvore.procurar("The Enemy Inside").getObj()).getAnoLanca());

            assertEquals("Duality",((Musica)arvore.procurar("Duality").getObj()).getNomeMusica());        
            assertEquals("Slipknot",((Musica)arvore.procurar("Duality").getObj()).getBanda());
            assertEquals("Antennas to Hell", ((Musica)arvore.procurar("Duality").getObj()).getAlbum());
            assertEquals("2012", ((Musica)arvore.procurar("Duality").getObj()).getAnoLanca());
        }
        catch(FileNotFoundException exc1)
        { throw new ArquivoNaoEncontradoException(); }
        catch(IOException exc2)
        { throw new FalhaGeracaoInformacoesException(); }
    }    
}