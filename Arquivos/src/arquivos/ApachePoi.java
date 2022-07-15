package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {

	public static void main(String[] args) throws IOException {

		File file = new File("C:\\workspaces-java\\Arquivos\\src\\arquivos\\arquivo_Excel.xls");

		if (!file.exists()) {
			file.createNewFile();
		}

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
		
		Pessoa pessoa4 = new Pessoa();
		pessoa4.setNome("Maria");
		pessoa4.setEmail("pessoa4@gmail.com");
		pessoa4.setIdade(24);

		// Pode vir de um bando de dados
		List<Pessoa> pessoas = new ArrayList<>();

		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		pessoas.add(pessoa4);


		HSSFWorkbook planilha = new HSSFWorkbook();// Usado para escrever a planilha
		HSSFSheet linhasPessoa = planilha.createSheet("Planilhas de pessoa JdevTreinamento");// Criar a planilha

		int numLinha = 0;
		for (Pessoa p : pessoas) {
			Row linha = linhasPessoa.createRow(numLinha++);// criando a linha da planilha

			int celula = 0;

			Cell celNome = linha.createCell(celula++);// celula 01
			celNome.setCellValue(p.getNome());

			Cell celEmail = linha.createCell(celula++);// celula 02
			celEmail.setCellValue(p.getEmail());

			Cell celIdade = linha.createCell(celula++);// celula 03
			celIdade.setCellValue(p.getIdade());

		}//Terminio de montar a planilha
		
		FileOutputStream saida = new FileOutputStream(file);
		planilha.write(saida);
		saida.flush();
		saida.close();
		System.out.println("Planilha foi criada");
	}

}
