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

import java.io.File;

public class ArquivoNaoEncontradoException extends Exception  {
    
    /**
     * Construtor da classe de exceção ArquivoNaoEncontradoException que 
     * herda de Exception. Instancia um objeto desta classe com uma 
     * frase amigável para exibir quando capturar esta exceção. 
     * Inicializa o atributo File da classe.
     * Esta exceção é lançada quando o arquivo de importação com as TAG's das
     * músicas não é encontrado. 
     * @see Exception
     * @see File
     */
    public ArquivoNaoEncontradoException()
    {   super("Um Anel para a todos arquivos encontrar! Mas esse arquivo não foi encontrado :/");   }    
}