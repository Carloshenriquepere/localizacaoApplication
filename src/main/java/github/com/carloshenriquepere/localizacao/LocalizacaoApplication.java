package github.com.carloshenriquepere.localizacao;

import github.com.carloshenriquepere.localizacao.domain.entity.Cidade;
import github.com.carloshenriquepere.localizacao.domain.repository.CidadeRepository;
<<<<<<< HEAD
import github.com.carloshenriquepere.localizacao.service.CidadeService;
=======
>>>>>>> origin/main
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;


<<<<<<< HEAD
=======

>>>>>>> origin/main
@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
<<<<<<< HEAD
	private CidadeService service;

	@Override
	public void run(String... args) throws Exception {
		service.listarCidadePorNome();

=======
	private CidadeRepository cidadeRepository;

	@Override
	public void run(String... args) throws Exception {
		salvarCidade();
		listarCidade();
	}

	@Transactional
	void salvarCidade(){
		var cidade = new Cidade(1L, "Sao Paulo", 12368596L);
		cidadeRepository.save(cidade);
	}
	void listarCidade(){
		cidadeRepository.findAll().forEach(System.out::println);
>>>>>>> origin/main
	}

	public static void main(String[] args) {

		SpringApplication.run(LocalizacaoApplication.class, args);
	}

}
