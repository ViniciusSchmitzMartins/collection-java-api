import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LivrariaOnline {

	private Map<String, Livro> livrosMap;

	public LivrariaOnline() {
		this.livrosMap = new HashMap<>();
	}

	public void adicionarLivro1(String link, Livro livro) {
		livrosMap.put(link, livro);
	}

	public void removerLivro(String titulo) {
		List<String> tituloParaRemover = new ArrayList<>();
		if (!livrosMap.isEmpty()) {
			for (Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
				if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
					tituloParaRemover.add(entry.getKey());
				}
			}
			for (String chave : tituloParaRemover) {
				livrosMap.remove(chave);
			}
		}

	}

	public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
		List<Map.Entry<String, Livro>> paraOrdenar = new ArrayList<>(livrosMap.entrySet());

		Collections.sort(paraOrdenar, new ComparatorPorPreco());

		Map<String, Livro> livrosOrdenados = new LinkedHashMap<>();

		for (Map.Entry<String, Livro> entry : paraOrdenar) {
			livrosOrdenados.put(entry.getKey(), entry.getValue());
		}

		return livrosOrdenados;

	}

	public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
		List<Map.Entry<String, Livro>> listaPorAutor = new ArrayList<>(livrosMap.entrySet());

		Collections.sort(listaPorAutor, new ComparatorPorAutor());

		Map<String, Livro> autoresSelecionados = new LinkedHashMap<>();

		for (Map.Entry<String, Livro> entry : listaPorAutor) {
			autoresSelecionados.put(entry.getKey(), entry.getValue());
		}

		return autoresSelecionados;

	}

	public List<Livro> obterLivroMaisCaro() {
		List<Livro> livroCaro = new ArrayList<>();
		double maior = 0;

		if (!livrosMap.isEmpty()) {
			for (Livro livro : livrosMap.values()) {
				if (livro.getPreco() > maior) {
					maior = livro.getPreco();
				}
			}
		} else {
			System.out.println("Não existe Livros!");
		}

		for (Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
			if (entry.getValue().getPreco() == maior) {
				Livro livroComPrecoMaisAlto = livrosMap.get(entry.getKey());
				livroCaro.add(livroComPrecoMaisAlto);
			}
		}
		return livroCaro;
	}

	public List<Livro> obterLivroMaisbarato() {
		List<Livro> livroBarato = new ArrayList<>();
		double menor = Double.MAX_VALUE;

		if (!livrosMap.isEmpty()) {
			for (Livro livro : livrosMap.values()) {
				if (livro.getPreco() < menor) {
					menor = livro.getPreco();
				}
			}
		} else {
			System.out.println("Não existe Livros!");
		}

		for (Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
			if (entry.getValue().getPreco() == menor) {
				Livro livroComPrecoMaisAlto = livrosMap.get(entry.getKey());
				livroBarato.add(livroComPrecoMaisAlto);
			}
		}
		return livroBarato;
	}

	public static void main(String[] args) {
		LivrariaOnline livrariaOnline = new LivrariaOnline();
		// Adiciona os livros à livraria online
		livrariaOnline.adicionarLivro1("https://amzn.to/3EclT8Z", new Livro("1984", "George Orwell", 50d));
		livrariaOnline.adicionarLivro1("https://amzn.to/47Umiun",
				new Livro("A Revolução dos Bichos", "George Orwell", 7.05d));
		livrariaOnline.adicionarLivro1("https://amzn.to/3L1FFI6",
				new Livro("Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d));
		livrariaOnline.adicionarLivro1("https://amzn.to/3OYb9jk", new Livro("Malorie", "Josh Malerman", 5d));
		livrariaOnline.adicionarLivro1("https://amzn.to/45HQE1L",
				new Livro("E Não Sobrou Nenhum", "Agatha Christie", 50d));
		livrariaOnline.adicionarLivro1("https://amzn.to/45u86q4",
				new Livro("Assassinato no Expresso do Oriente", "Agatha Christie", 5d));

		// Exibe todos os livros ordenados por preço
		System.out.println("Livros ordenados por preço: \n" + livrariaOnline.exibirLivrosOrdenadosPorPreco());

		// Exibe todos os livros ordenados por autor
		System.out.println("Livros ordenados por autor: \n" + livrariaOnline.exibirLivrosOrdenadosPorPreco());

		// Pesquisa livros por autor
		String autorPesquisa = "Josh Malerman";
		livrariaOnline.pesquisarLivrosPorAutor(autorPesquisa);

		// Obtém e exibe o livro mais caro
		System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());

		// Obtém e exibe o livro mais barato
		System.out.println("Livro mais barato: " + livrariaOnline.obterLivroMaisbarato());

		// Remover um livro pelo título
		livrariaOnline.removerLivro("1984");
		System.out.println(livrariaOnline.livrosMap);

	}

	private void adicionarLivro(String string, Livro livro) {
		// TODO Auto-generated method stub
		
	}

}
