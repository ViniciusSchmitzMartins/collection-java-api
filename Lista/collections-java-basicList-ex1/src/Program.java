
public class Program {

	public static void main(String[] args) {
		
		Tarefa tarefa = new Tarefa("Fazer café");
		ListaTarefa listaTarefa = new ListaTarefa(null);
		
		System.out.println("O numero total de tarefas: " + listaTarefa.obterNumeroTotalDeTarefas());
		
		listaTarefa.addTarefa("Tarefa 1: ");
		listaTarefa.addTarefa("Tarefa 2: ");
		listaTarefa.addTarefa("Tarefa 2: ");
		System.out.println("O numero total de tarefas: " + listaTarefa.obterNumeroTotalDeTarefas());
		listaTarefa.removeTarefa("Tarefa 1: ");
		System.out.println("O numero total de tarefas: " + listaTarefa.obterNumeroTotalDeTarefas());
		listaTarefa.obterDescricoesTarefas();
	}

}
