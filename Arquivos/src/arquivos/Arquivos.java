package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {

	public static void main(String[] args) throws IOException {
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("Jose Rurze");
		pessoa1.setEmail("pessoa1@gmail.com");
		pessoa1.setIdade(37);
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setNome("Jose Alves");
		pessoa2.setEmail("pessoa2@gmail.com");
		pessoa2.setIdade(40);

		Pessoa pessoa3 = new Pessoa();
		pessoa3.setNome("Alex");
		pessoa3.setEmail("pessoa3@gmail.com");
		pessoa3.setIdade(32);
		
		List<Pessoa> pessoas = new ArrayList<>();
		
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);

		File arquivo = new File("C:\\workspaces-java\\Arquivos\\src\\arquivos\\arquivo.csv");

		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);
		
		for (Pessoa p : pessoas) {
		
			escrever_no_arquivo.write(p.getNome()+";"+p.getEmail()+";"+p.getIdade()+"\n");
		}
		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();
	}
}
