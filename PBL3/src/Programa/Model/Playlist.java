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

import Programa.Util.MyLinkedList;
import java.time.LocalDate;
import java.time.LocalTime;

public class Playlist {
    private MyLinkedList lista;
    private LocalDate data;   
    private LocalTime hora;

    /**
     * Construtor da classe Playlist. Instancia um objeto desta classe.
     * Instancia um objeto da classe MyLinkedList, inicializa os atrbutos hora e
     * data sendo a hora e a data no momento que foram criados. 
     * @see MyLinkedList
     * @see LocalTime
     * @see LocalDate
     */
    public Playlist()
    {   lista = new MyLinkedList();
        data = LocalDate.now();   
        hora = LocalTime.now();
    }
    
    /**
     * Método que retorna o objeto atributo lista encadeada.
     * @return - retorna o objeto atributo lista encadeada.
     * @see MyLinkedList
     */
    public MyLinkedList getLista()  { return lista; }

    /**
     * Método que atualiza a lista encadeada desta classe.
     * @param lista - nova lista encadeada desta classe.
     */
    public void setLista(MyLinkedList lista) { this.lista = lista; }

    /**
     * Método que retorna a quantidade de elementos presentes no atributo
     * lista encadeada.
     * @return - retorna a quantidade de elementos presentes no atributo
     * lista encadeada.
     * @see MyLinkedList
     */
    public int size() { return getLista().size(); }
    
    /**
     * Método que retorna o atributo data desta classe. 
     * @return - retorna o atributo data desta classe. 
     * @see LocalDate
     */
    public LocalDate getData()  {  return data; }

    /**
     * Método que retorna o atributo hora desta classe. 
     * @return - retorna o atributo hora desta classe. 
     * @see LocalTime
     */
    public LocalTime getHora() {  return hora;  }
           
    /**
     * Método que concatena e retorna o cabeçalho que será exibido no arquivo 
     * .txt com as informações desta playlist. Recebe a string que representa 
     * o diretório onde estão as músicas da playlist e o nome desta playlist.
     * @param diretorio - string que representa o diretório
     * onde estão as músicas da playlist.
     * @param nomePlaylist - o nome desta playlist.
     * @return - retorna o cabeçalho com informações desta playlist.
     */
    public String gerarCabecalho(String diretorio, String nomePlaylist)
    {   String dataCabec = String.valueOf(data.getDayOfMonth()).concat( "/" + data.getMonth().getValue() + "/"+ data.getYear());
        String horaCabec = String.valueOf(hora.getHour()).concat(":" + hora.getMinute());        
      return ("Nome da Playlist: " + nomePlaylist + "." + "  Criada às " + horaCabec + " no dia " + dataCabec + "." + "  Diretório: " + diretorio);  
    }
}