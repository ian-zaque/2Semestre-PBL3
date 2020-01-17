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
package Programa.Controlador;

import Programa.Model.Playlist;
import Programa.Model.BancoDeMusicas;
import Programa.Model.Musica;
import Programa.Util.Excecoes.ArquivoNaoEncontradoException;
import Programa.Util.Excecoes.NenhumElementoEncontradoException;
import Programa.Util.Excecoes.PlayListSemElementosException;
import Programa.Util.MyLinkedList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Sistema {
    private BancoDeMusicas banco;
    
    /**
     * Construtor da classe Sistema. Instancia um objeto desta classe.
     * Inicializa o atributo BancoDeMusicas com o diretório sendo a pasta 
     * onde estão os arquivos .mp3.
     * @see BancoDeMusicas
     */
    public Sistema()
    { banco = new BancoDeMusicas("./Musicas"); }

    /**
     * Método que retorna o atributo BancoDeMusicas desta classe.
     * @return - retorna o atributo BancoDeMusicas desta classe.
     */
    public BancoDeMusicas getBanco() { return banco; }

    /**
     * Método que atualiza o atributo BancoDeMusicas desta classe.
     * @param banco - novo atributo BancoDeMusicas desta classe.
     */
    public void setBanco(BancoDeMusicas banco) { this.banco = banco; }
    
    /**
     * Método que retorna um objeto Musica a partir da procura pelo começo do
     * nome dela. Lê-se o arquivo .txt que possui as informações das músicas
     * e, se começar com a palavra passada por parâmetro e terminar com '.mp3',
     * retorna-se uma música com os atributos lidos do arquivo.
     * @param palavra
     * @return - retorna uma música com os atributos lidos do arquivo, caso
     * sejam os necessários.
     * @throws NenhumElementoEncontradoException
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ArquivoNaoEncontradoException 
     * @see Musica
     * @see BufferedReader
     * @see FileReader
     */
    public Musica buscarMusica(String palavra) throws NenhumElementoEncontradoException, IOException, FileNotFoundException, ArquivoNaoEncontradoException 
    {  try
        {   BufferedReader leitorArquivo = new BufferedReader(new FileReader("TagMusicas.txt"));
            String tag;
            Musica musica = null;
            
            while( (tag = leitorArquivo.readLine()) != null)
            {   
                if(tag.startsWith(palavra)  && tag.endsWith(".mp3"))
                {   String[] arrayTag = tag.split(";");
                    musica = new Musica(arrayTag[0],arrayTag[1],arrayTag[2],arrayTag[3]);
                    musica.setNomeArquivo(arrayTag[4]);
                    return musica;                                 
                }                             
            }
          leitorArquivo.close(); 
                if(tag == null) { throw new NenhumElementoEncontradoException();  }
                else if(musica == null) { throw new NenhumElementoEncontradoException();  }
        }    
        catch(NenhumElementoEncontradoException exc)
        { throw new NenhumElementoEncontradoException(); }       
      return null;       
    }
    
    /**
     * Método que recebe uma lista encadeada com músicas e o nome de uma playlist.
     * O método instancia uma playlist com os elementos do objeto MyLinkedList 
     * passados por parâmetro, gera e retorna  as informações (gravadas num .txt)
     * desta playlist. 
     * @param lista - lista encadeada que possui as músicas desta playlist.
     * @param nomePlay - string nome da playlist.
     * @return - retorna a playlist com as músicas.
     * @throws NenhumElementoEncontradoException
     * @throws PlayListSemElementosException
     * @throws IOException 
     * @see Playlist
     * @see MyLinkedList
     */
    public Playlist gerarPlayList(MyLinkedList lista, String nomePlay) throws NenhumElementoEncontradoException, PlayListSemElementosException, IOException
    {  try 
        {   Playlist playlist = new Playlist();
            playlist.setLista(lista);
            gerarInfoPlaylist(playlist,nomePlay);
                
              if(lista.isEmpty())
              { throw new PlayListSemElementosException(); }            
          return playlist;  
        }
        catch(NenhumElementoEncontradoException | PlayListSemElementosException exc1)
        {   throw new PlayListSemElementosException();   }
    }
      
    /**
     * Método que gera as informações de determinada playlist passada por parâmetro 
     * escrevendo estas em um arquivo .txt com a hora e data da criação da playlist
     * e o diretório de onde estão as músicas.
     * @param playlist - playlist cujas informações serão geradas.
     * @param nomePlay - nome da playlist gerada. 
     * @throws NenhumElementoEncontradoException
     * @throws PlayListSemElementosException
     * @throws IOException 
     * @see Playlist
     * @see BufferedWriter
     * @see FileWriter
     */
    private void gerarInfoPlaylist(Playlist playlist, String nomePlay) throws NenhumElementoEncontradoException, PlayListSemElementosException, IOException
    {   try
        {   if(playlist.getLista().isEmpty())
               { throw new NenhumElementoEncontradoException(); }
        
          BufferedWriter escreveTxt = new BufferedWriter(new FileWriter("PlaylistInfo.txt",true));     
          escreveTxt.write(playlist.gerarCabecalho(banco.getDiretorio().getCanonicalPath(),nomePlay)); 
          escreveTxt.newLine();
          escreveTxt.newLine();
          
            for(int cont = 0; cont < playlist.getLista().size(); cont++)
            { escreveTxt.write( ((Musica)playlist.getLista().get(cont).getObj()).tagDaMusica() );
              escreveTxt.newLine();
              escreveTxt.flush();              
            }
          escreveTxt.newLine();
          escreveTxt.close();          
        }
        catch(NenhumElementoEncontradoException exc)
        {   throw new PlayListSemElementosException();   }
    }    
}