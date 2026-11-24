import java.util.Comparator;

/**
 * Árvore binária de busca balanceada AVL. Herda da ABB a pesquisa, o percurso e
 * a medição;
 * a inserção e a remoção reaproveitam os métodos da ABB e rebalanceiam cada
 * subárvore
 * no retorno da recursão.
 */
public class AVL<K, V> extends ABB<K, V> {

	/**
	 * Construtor da classe.
	 * Cria uma árvore AVL vazia que organiza os elementos pela ordem natural das
	 * chaves.
	 */
	public AVL() {
		super();
	}

	/**
	 * Construtor da classe.
	 * Cria uma árvore AVL vazia.
	 * 
	 * @param comparador o comparador a ser utilizado para organizar os elementos da
	 *                   árvore.
	 */
	public AVL(Comparator<K> comparador) {
		super(comparador);
	}

	/**
	 * TODO
	 * Método recursivo responsável por adicionar um item à árvore.
	 * 
	 * @param raizArvore raiz da árvore ou subárvore em que o item será adicionado.
	 * @param chave      chave do item que deverá ser adicionado à árvore.
	 * @param item       item que deverá ser adicionado à árvore.
	 * @return a raiz atualizada da árvore ou subárvore balanceada AVL em que o item
	 *         foi adicionado.
	 */
	@Override
	protected No<K, V> inserir(No<K, V> raizArvore, K chave, V item) {
		return null;
	}

	/**
	 * TODO
	 * Método recursivo responsável por localizar na árvore ou subárvore o
	 * antecessor do nó que deverá ser retirado.
	 * 
	 * @param itemRetirar referência ao nó que armazena o item que deverá ser
	 *                    retirado da árvore.
	 * @param raizArvore  raiz da árvore ou subárvore em que o antecessor do nó que
	 *                    deverá ser retirado deverá ser localizado.
	 * @return a raiz atualizada da árvore ou subárvore balanceada AVL após a
	 *         remoção do antecessor do nó que foi retirado da árvore.
	 */
	@Override
	protected No<K, V> removerNoAntecessor(No<K, V> itemRetirar, No<K, V> raizArvore) {
		return null;
	}

	/**
	 * TODO
	 * Método recursivo responsável por localizar um item na árvore e retirá-lo da
	 * árvore.
	 * 
	 * @param raizArvore   raiz da árvore ou subárvore da qual o item será retirado.
	 * @param chaveRemover chave do item que deverá ser localizado e removido da
	 *                     árvore.
	 * @return a raiz atualizada da árvore ou subárvore balanceada AVL da qual o
	 *         item foi retirado.
	 */
	@Override
	protected No<K, V> remover(No<K, V> raizArvore, K chaveRemover) {
		
		return null;
	}

	/**
	 * TODO
	 * Retorna uma lista com os itens cujas chaves estão no intervalo [deOnde,
	 * ateOnde],
	 * em ordem crescente de chave. Subárvores inteiramente fora do intervalo não
	 * são visitadas.
	 * 
	 * @param deOnde  início do intervalo (inclusive).
	 * @param ateOnde fim do intervalo (inclusive).
	 * @return lista com os itens do intervalo, em ordem crescente de chave (vazia,
	 *         se não houver itens).
	 * @throws IllegalArgumentException caso deOnde seja maior do que ateOnde.
	 */
	public Lista<V> recortar(K deOnde, K ateOnde) {
		return null;
	}

	/**
	 * TODO
	 * Retorna o item de menor chave maior ou igual à chave informada (função teto),
	 * percorrendo um único caminho a partir da raiz.
	 * 
	 * @param chave chave de referência.
	 * @return o item de menor chave maior ou igual a chave.
	 * @throws java.util.NoSuchElementException caso todas as chaves da árvore sejam
	 *                                          menores do que chave.
	 */
	public V teto(K chave) {
		return null;
	}

	/**
	 * TODO
	 * Verifica o fator de balanceamento da raiz da subárvore e, se for 2 ou -2,
	 * aplica a rotação simples ou dupla adequada. Caso contrário, apenas atualiza a
	 * altura da raiz.
	 * 
	 * @param raizArvore raiz da subárvore a ser balanceada.
	 * @return a raiz da subárvore balanceada.
	 */
	private No<K, V> balancear(No<K, V> raizArvore) {
		if (raizArvore == null) {
			return null;
		}

		int fb = fatorBalanceamento(raizArvore);

		if (fb == 2) {
			if (fatorBalanceamento(raizArvore.getEsquerda()) == -1) {
				raizArvore.setEsquerda(rotacionarEsquerda(raizArvore.getEsquerda()));
			}
			return rotacionarDireita(raizArvore);
		}

		if (fb == -2) {
			if (fatorBalanceamento(raizArvore.getDireita()) == 1) {
				raizArvore.setDireita(rotacionarDireita(raizArvore.getDireita()));
			}
			return rotacionarEsquerda(raizArvore);
		}

		raizArvore.setAltura();
		return raizArvore;
	}

	private int fatorBalanceamento(No<K, V> no) {
		if (no == null) {
			return 0;
		}
		return altura(no.getEsquerda()) - altura(no.getDireita());
	}

	private int altura(No<K, V> no) {
		return (no == null) ? -1 : no.getAltura();
	}

	/**
	 * TODO
	 * Rotação simples à direita em torno do nó p.
	 * 
	 * @param p raiz da subárvore desbalanceada à esquerda.
	 * @return a nova raiz da subárvore (o antigo filho à esquerda de p).
	 */
	private No<K, V> rotacionarDireita(No<K, V> p) {
		No<K, V> novaRaiz = p.getEsquerda();
		No<K, V> temp = novaRaiz.getDireita();

		novaRaiz.setDireita(p);
		p.setEsquerda(temp);

		p.setAltura();
		novaRaiz.setAltura();

		return novaRaiz;
	}

	/**
	 * TODO
	 * Rotação simples à esquerda em torno do nó p.
	 * 
	 * @param p raiz da subárvore desbalanceada à direita.
	 * @return a nova raiz da subárvore (o antigo filho à direita de p).
	 */
	private No<K, V> rotacionarEsquerda(No<K, V> p) {
		No<K, V> novaRaiz = p.getDireita();
		No<K, V> temp = novaRaiz.getEsquerda();

		novaRaiz.setEsquerda(p);
		p.setDireita(temp);

		p.setAltura();
		novaRaiz.setAltura();

		return novaRaiz;
	}
}
