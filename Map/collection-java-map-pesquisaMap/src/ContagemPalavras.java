import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {

	private Map<String, Integer> palavrasMap;

	public ContagemPalavras() {
		this.palavrasMap = new HashMap<>();
	}

	public void adicionarPalavras(String palavra, Integer contagem) {
		palavrasMap.put(palavra, contagem);
	}

	public void removerPalavra(String palavra) {
		if (!palavrasMap.isEmpty()) {
			palavrasMap.remove(palavra);
		} else {
			System.out.println("Palavra não existe");
		}

	}

	public int exibirContagemPalavras() {
		int contagemTotal = 0;
		for (int contagem : palavrasMap.values()) {
			contagemTotal += contagem;
		}
		return contagemTotal;
	}

	public String encontrarPalavrasMaisFrequente() {
		String palavraMaisFrequente = null;
		int count = 0;
		for (Map.Entry<String, Integer> entry : palavrasMap.entrySet()) { // Map.entry ele pega o map e transforma em um Set de key e outro de values tendo relação entre eles forma de percorrer um map quando tem 2 tipos
			if (entry.getValue() > count) {
				count = entry.getValue();
				palavraMaisFrequente = entry.getKey();
			}
		}
		return palavraMaisFrequente;

	}
	
	  public static void main(String[] args) {
		    ContagemPalavras contagemLinguagens = new ContagemPalavras();

		    // Adiciona linguagens e suas contagens
		    contagemLinguagens.adicionarPalavras("Java", 2);
		    contagemLinguagens.adicionarPalavras("Python", 8);
		    contagemLinguagens.adicionarPalavras("JavaScript", 1);
		    contagemLinguagens.adicionarPalavras("C#", 6);

		    // Exibe a contagem total de linguagens
		    System.out.println("Existem " + contagemLinguagens.exibirContagemPalavras() + " palavras.");

		    // Encontra e exibe a linguagem mais frequente
		    String linguagemMaisFrequente = contagemLinguagens.encontrarPalavrasMaisFrequente();
		    System.out.println("A linguagem mais frequente é: " + linguagemMaisFrequente);
		  }

}
