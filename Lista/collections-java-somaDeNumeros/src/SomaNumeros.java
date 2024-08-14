import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {

	private List<Integer> inteirosList;

	public SomaNumeros() {
		this.inteirosList = new ArrayList<>();
	}

	public void adicionarNumero(int numero) {
		inteirosList.add(numero);
	}

	public Integer calcularSoma() {
		int soma = 0;
		if (!inteirosList.isEmpty()) {
			for (Integer n : inteirosList) {
				soma += n;
			}
		}
		return soma;
	}

	public Integer encontrarMaiorNumero() {
		int maiorNumero = 0;
		if (!inteirosList.isEmpty()) {
			for (Integer n : inteirosList) {
				if (n >= maiorNumero) {
					maiorNumero = n;
				}
			}
			return maiorNumero;
		}
		else {
		      throw new RuntimeException("A lista está vazia!");
		    }
	}

	public Integer encontrarMenorNumero() {
		int menorNumero = 0;
		if (!inteirosList.isEmpty()) {
			for (Integer n : inteirosList) {
				if (n <= menorNumero) {
					menorNumero = n;
				}
			}
			return menorNumero;
		}else {
		      throw new RuntimeException("A lista está vazia!");
	    }
		
	}

	public void exibirNumeros() {
		if (!inteirosList.isEmpty()) {
			System.out.println(this.inteirosList);
		} else {
			System.out.println("A lista está vazia!");
		}
	}

	public static void main(String[] args) {
		
		SomaNumeros somaNumeros = new SomaNumeros();

		
		somaNumeros.adicionarNumero(5);
		somaNumeros.adicionarNumero(0);
		somaNumeros.adicionarNumero(0);
		somaNumeros.adicionarNumero(-2);
		somaNumeros.adicionarNumero(10);

	
		System.out.print("Números adicionados: ");
		somaNumeros.exibirNumeros();

		System.out.println("Soma dos números = " + somaNumeros.calcularSoma());
		System.out.println("Maior número = " + somaNumeros.encontrarMaiorNumero());
		System.out.println("Menor número = " + somaNumeros.encontrarMenorNumero());
	}
}
