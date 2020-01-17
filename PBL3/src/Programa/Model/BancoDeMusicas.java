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

package Programa.Model;

import Programa.Util.Excecoes.ArquivoNaoEncontradoException;
import Programa.Util.Excecoes.FalhaGeracaoInformacoesException;
import Programa.Util.MyTree;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BancoDeMusicas {    
    private MyTree arvoreMusicas;
    private File diretorio; 
    
    /**
     * Construtor da classe BancoDeMusicas. Instancia um objeto desta classe.
     * Inicializa os atributos árvore AVL e File desta classe.
     * @param caminhoStr  - string que será o diretório do atributo File.
     */
    public BancoDeMusicas(String caminhoStr) 
    {   this.arvoreMusicas = new MyTree(); 
        this.diretorio = new File(caminhoStr);      
    }

    /**
     * Método que retorna o atributo File desta classe.
     * @return - retorna o atributo File desta classe.
     * @see File
     */
    public File getDiretorio() {  return diretorio;  }

    /**
     * Método que atualiza o atributo File desta classe. 
     * @param diretorio - novo File para o atributo File. 
     * @see File
     */
    public void setDiretorio(File diretorio) { this.diretorio = diretorio;  }
       
    /**
     * Método que retorna o atributo MyTree desta classe.
     * @return - retorna o atributo MyTree desta classe.
     * @see MyTree
     */
    public MyTree getArvore() { return arvoreMusicas;   }
 
    /**
     * Método que atualiza o atributo MyTree desta classe. 
     * @param arvore - nova árvre para o atributo MyTree. 
     * @see MyTree
     */
    public void setArvore(MyTree arvore)  { this.arvoreMusicas = arvore; }            
    
    /**
     * Método que lê todos os arquivos do diretório do atributo File, os "converte" 
     * em uma string, guardando num array de string, e, para cada idem deste array,
     * é lida as informações dos últimos 128 bytes. Ao fazer isto, escreve em um arquivo
     * .txt estas informações em uma linha para cada musica.
     * @throws FileNotFoundException
     * @throws IOException
     * @throws FalhaGeracaoInformacoesException
     * @throws ArquivoNaoEncontradoException 
     * @see File
     * @see FileInputStream
     * @see Musica
     */
    public void carregarMusicasEmTxt() throws FileNotFoundException, IOException, FalhaGeracaoInformacoesException, ArquivoNaoEncontradoException
    {   try
        { File fileAux;        
          String[] nomeMusicas = diretorio.list();
        
           for(String str : nomeMusicas)
           {    fileAux = new File(diretorio + "/" + str);
                
                FileInputStream fileIn = new FileInputStream(fileAux);  
                fileIn.skip(fileIn.available() - 128);
                byte[] vetorByte = new byte[128];
                fileIn.read(vetorByte);
                
                String mp3TagTotal = new String(vetorByte);
                String nomeMusica = tagToString(mp3TagTotal,3,32);
                String nomeBanda = tagToString(mp3TagTotal,33,62);
                String nomeAlbum = tagToString(mp3TagTotal,63,92);
                String numAno = tagToString(mp3TagTotal,93,97);
                                                
                BufferedWriter escreveTxt = new BufferedWriter( new FileWriter("TagMusicas.txt",true));
                escreveTxt.write(nomeMusica);
                escreveTxt.write(nomeBanda);                
                escreveTxt.write(nomeAlbum);
                escreveTxt.write(numAno);
                escreveTxt.write(str);
                
                escreveTxt.newLine();
                escreveTxt.flush();
                escreveTxt.close();
           }                
        }           
            catch(FileNotFoundException exc1)
            {  throw new ArquivoNaoEncontradoException(); }    
            catch(IOException | NullPointerException exc2)
            {  throw new FalhaGeracaoInformacoesException(); }           
        }
    
    /**
     * Método que lê cada linha do arquivo selecionado no método 'carregarMusicasEmTxt()'
     * e cada espaço definido dos bytes cria um atributo para um objeto da classe Musica
     * que é adicionado numa árvore AVL se o arquivo possuir no final '.mp3', retornando
     * esta árvore.
     * @return - retorna a árvore AVL.
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ArquivoNaoEncontradoException 
     * @see MyTree
     * @see BufferedReader
     * @see FileReader
     * @see Musica
     */
    public MyTree carregaMusicaEmArvore() throws FileNotFoundException, IOException, ArquivoNaoEncontradoException
    {      try
        {   BufferedReader leitorArquivo = new BufferedReader(new FileReader("TagMusicas.txt"));
            String tag;
            
            while( (tag = leitorArquivo.readLine()) != null)
            {   
                if(tag.endsWith(".mp3"))
                {   String[] arrayTag = tag.split(";");
                    Musica musica = new Musica(arrayTag[0],arrayTag[1],arrayTag[2],arrayTag[3]);
                    musica.setNomeArquivo(arrayTag[4]);
                    arvoreMusicas.add(musica);                   
                }                            
            }
          leitorArquivo.close();     
        }
        catch(FileNotFoundException exc1)
        {  throw new ArquivoNaoEncontradoException(); }
     return arvoreMusicas;
    }
    
    /**
     * Método que formata e retorna uma string passada por parâmetro e 
     * concatena com ';'a fim de torná-la na forma necessária para ser 
     * lida no arquivo .txt.
     * @param str - string passada por parâmetro que será formatada.
     * @param ini - número que constará como início da substring. 
     * @param fim - número que constará como fim da substring
     * @return - retorna a string na forma necessária para ser lida no 
     * arquivo .txt.
     */
    private String tagToString(String str, int ini, int fim)
    {   String tagTxt = str;
        tagTxt = tagTxt.substring(ini, fim);
        tagTxt = tagTxt.trim();
        tagTxt = tagTxt.concat(";");
      return tagTxt;  
    }
}