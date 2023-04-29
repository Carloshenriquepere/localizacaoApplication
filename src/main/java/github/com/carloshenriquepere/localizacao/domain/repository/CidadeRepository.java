package github.com.carloshenriquepere.localizacao.domain.repository;

import github.com.carloshenriquepere.localizacao.domain.entity.Cidade;
<<<<<<< HEAD
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CidadeRepository  extends JpaRepository<Cidade, Long> {

    //Busca pelo nome correto
    List<Cidade> findByNome(String nome);

    //Usando o Like(%)
    @Query(" select c from Cidade c where upper(c.nome) like upper(?1) ")
    List<Cidade> findByNomeLike(String nome, Sort sort);

    //Busca pelo nome començando por aquele pedaço
    List<Cidade> findByNomeStartingWith(String nome);

    //Busca pelo nome terminando por aquele pedaço
    List<Cidade> findByNomeEndingWith(String nome);

    //Busca pelo nome contendo aquele pedaço
    List<Cidade> findByNomeContaining(String nome);


    List<Cidade> findByHabitantes(Long habitantes);

    //Menor que
    List<Cidade> findByHabitantesLessThan(Long habitantes);

    //Maior que
    List<Cidade> findByHabitantesGreaterThan(Long habitantes);

    //Menor ou igual
    List<Cidade> findByHabitantesLessThanEqual(Long habitantes);

    //Menor que e o Like(%)
    List<Cidade> findByHabitantesLessThanAndNomeLike(Long habitantes, String nome);


=======
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository  extends JpaRepository<Cidade, Long> {
>>>>>>> origin/main
}
