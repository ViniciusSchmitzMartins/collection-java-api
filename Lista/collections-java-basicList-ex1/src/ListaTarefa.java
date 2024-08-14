import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
	
	private List<Tarefa> listaTarefa;
	
	
	public ListaTarefa(List<Tarefa> listaTarefa) {
		this.listaTarefa = new ArrayList<>();
	}
	
	public void addTarefa(String descricao) {
		listaTarefa.add(new Tarefa(descricao));
	}
	
	public void removeTarefa(String descricao) {
		List<Tarefa> tarefasParaRemover = new ArrayList<>();
		for (Tarefa e: listaTarefa) {
			if (e.getDescricao().equalsIgnoreCase(descricao))
				tarefasParaRemover.add(e);
		}
		listaTarefa.removeAll(tarefasParaRemover);
	}

	public Integer obterNumeroTotalDeTarefas() {
		return listaTarefa.size();  // retorna a quantidade de elementos de uma linta 
	}
	
	
	public void obterDescricoesTarefas() {
		System.out.println(listaTarefa);
	}

}
