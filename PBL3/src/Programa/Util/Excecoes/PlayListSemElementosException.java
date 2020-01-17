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
package Programa.Util.Excecoes;

import Programa.Util.MyLinkedList;

public class PlayListSemElementosException extends Exception {
        
    /**
     * Construtor da classe de exceçãoPlayListSemElementosException que herda
     * da classe Exception. Instancia um objeto desta classe com uma 
     * frase amigável para exibir quando capturar esta exceção. 
     * Inicializa o atributo MyLinkedList da classe.
     * Esta exceção é lançada quando a playlist não possui elemento algum, logo
     * quando está vazia.
     * @see Exception
     * @see MyLinkedList
     */
    public PlayListSemElementosException()
    {   super("Não há músicas nesta playlist :/");  }
}