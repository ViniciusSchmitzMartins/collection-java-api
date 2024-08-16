import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {

	private Set<Tarefa> tarefaList;

	public ListaTarefas() {
		this.tarefaList = new HashSet<>();
	}

	public void adicionarTarefa(String descricao) {
		tarefaList.add(new Tarefa(descricao));
	}

	public void removerTarefa(String descricao) {
		Tarefa tarefaRemover = null;
		if (!tarefaList.isEmpty()) {
			for (Tarefa t : tarefaList) {
				if (t.getDescricao().equalsIgnoreCase(descricao)) {
					tarefaRemover = t;
					break;
				} else {
					System.out.println("Tarefa não encontrada!");
				}
			}
			tarefaList.remove(tarefaRemover);
		} else {
			System.out.println("Lista esta vazia!!");
		}
	}

	public void exibirTarefas() {
		if (!tarefaList.isEmpty()) {
			System.out.println(tarefaList);
		} else {
			System.out.println("Sem tarefas no momento!");
		}
	}

	public int contarTarefas() {
		return tarefaList.size();
	}

	public Set<Tarefa> obterTarefasConcluidas() {
		Set<Tarefa> tarefasConcluidas = new HashSet<>();
		for (Tarefa e : tarefaList) {
			if (e.isConcluida() == true) {
				tarefasConcluidas.add(e);
			}
		}
		return tarefasConcluidas;
	}

	public Set<Tarefa> obterTarefasPendentes() {
		Set<Tarefa> tarefasPendentes = new HashSet<>();
		for (Tarefa e : tarefaList) {
			if (e.isConcluida() == false) {
				tarefasPendentes.add(e);
			}
		}
		return tarefasPendentes;
	}

	public void marcarTarefaConcluido(String descricao) {
		for (Tarefa t : tarefaList)
			if (t.getDescricao().equalsIgnoreCase(descricao)) {
				t.setConcluida(true);
				;
			}
	}

	public void marcarTarefaPendente(String descricao) {
		Tarefa tarefaPendentes = null;
		for (Tarefa t : tarefaList) {
			if (t.getDescricao().equalsIgnoreCase(descricao)) {
				tarefaPendentes = t;
				break;
			} 
		}
		if (tarefaPendentes != null) {
			if(tarefaPendentes.isConcluida()) {
				tarefaPendentes.setConcluida(false);
			}
		}
		else {
			System.out.println("Tarefa não encontrada na lista");
		}
		
	}

	public void limparListaTarefas() {
		tarefaList.clear();
	}

	public static void main(String[] args) {
		// Criando uma instância da classe ListaTarefas
		ListaTarefas listaTarefas = new ListaTarefas();

		// Adicionando tarefas à lista
		listaTarefas.adicionarTarefa("Estudar Java");
		listaTarefas.adicionarTarefa("Fazer exercícios físicos");
		listaTarefas.adicionarTarefa("Organizar a mesa de trabalho");
		listaTarefas.adicionarTarefa("Ler livro");
		listaTarefas.adicionarTarefa("Preparar apresentação");

		// Exibindo as tarefas na lista
		listaTarefas.exibirTarefas();

		// Removendo uma tarefa
		listaTarefas.removerTarefa("Fazer exercícios físicos");
		listaTarefas.exibirTarefas();

		// Contando o número de tarefas na lista
		System.out.println("Total de tarefas na lista: " + listaTarefas.contarTarefas());

		// Obtendo tarefas pendentes
		System.out.println(listaTarefas.obterTarefasPendentes());

		// Marcando tarefas como concluídas
		listaTarefas.marcarTarefaConcluido("Ler livro");
		listaTarefas.marcarTarefaConcluido("Estudar Java");

		// Obtendo tarefas concluídas
		System.out.println(listaTarefas.obterTarefasConcluidas());

		// Marcando tarefas como pendentes
		listaTarefas.marcarTarefaPendente("Estudar Java");
		listaTarefas.exibirTarefas();

		// Limpando a lista de tarefas
		listaTarefas.limparListaTarefas();
		listaTarefas.exibirTarefas();
	}

}
