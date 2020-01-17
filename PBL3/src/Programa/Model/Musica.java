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

import java.util.Comparator;

public class Musica implements Comparator,Comparable{
    private String nomeMusica, banda, album, nomeArquivo, anoLanca;
    
    /**
     * Construtor da classe Musica que implementa as interfaces Comparator 
     * e Comparable. Instancia um objeto desta classe. Recebe o nome da 
     * música, o nome do artista, nome do álbum e ano de lançamento dela.
     * @param nomeMusica - nome da música.
     * @param banda - nome do artista.
     * @param album - nome do álbum.
     * @param anoLanca - ano de lançamento da música.
     */
    public Musica(String nomeMusica, String banda, String album, String anoLanca)
    {   this.anoLanca = anoLanca; this.banda = banda;
        this.album = album;this.nomeMusica = nomeMusica;        
    }   
            
    /**
     * Método que retorna o nome da música. 
     * @return - retorna o nome da música. 
     */
    public String getNomeMusica() { return nomeMusica;  }

    /**
     * Método que retorna o nome do artista. 
     * @return - retorna o nome do artista. 
     */
    public String getBanda()  { return banda;  }

    /**
     * Método que retorna o nome do albúm. 
     * @return - retorna o nome do albúm. 
     */
    public String getAlbum()  { return album;  }  

    /**
     * Método que retorna o nome do arquivo. 
     * @return - retorna o nome do arquivo. 
     */
    public String getNomeArquivo()   { return nomeArquivo;  }

    /**
     * Método que atualiza o nome do arquivo desta música.
     * @param nomeArquivo - novo nome do arquivo desta música.
     */
    public void setNomeArquivo(String nomeArquivo)  {  this.nomeArquivo = nomeArquivo;  }

    /**
     * Método que retorna o ano de lançamento da música.
     * @return - retorna o ano de lançamento da música. 
     */
    public String getAnoLanca()   { return anoLanca;  }    

    /**
     * Método que concatena e retorna o nome do arquivo e a indicação deste.
     * Usado para gerar as informações da playlist.
     * @return - retorna o nome do arquivo e a indicação deste.
     * @see Playlist
     */
    public String tagDaMusica()
    { return ("Música: " + nomeArquivo); }
    
    /**
     * Método sobreescrito que compara os objetos dos parâmetros pelo nome.
     * Retorna -1 se o primeiro objeto tiver nome menor que o segundo, 1 se tiver
     * nome maior e 0 se forem iguais.
     * @param o1 - objeto a ser comparado.
     * @param o2 - objeto a ser comparado.
     * @return - Retorna -1 se o primeiro objeto tiver nome menor que o segundo, 
     * 1 se tiver nome maior e 0 se forem iguais.
     */
    @Override
    public int compare(Object o1, Object o2)
    {   if(((Musica)o1).getNomeMusica().compareTo( ((Musica)o2).getNomeMusica()) < 0)
           {return -1;}                    
        else if(((Musica)o1).getNomeMusica().compareTo( ((Musica)o2).getNomeMusica()) > 0)    
            { return 1;}
      return 0;       
    }

    /**
     * Método sobreescrito que chama o método 'compare' desta classe e compara
     * a música que chamou o método e o objeto passado por parâmetro. 
     * @param obj - objeto a ser comparado.
     * @return - Retorna -1 se o primeiro objeto tiver nome menor que o segundo, 
     * 1 se tiver nome maior e 0 se forem iguais.
     */
    @Override
    public int compareTo(Object obj)
    {  return compare(this,obj); }
}