package github.com.carloshenriquepere.localizacao.service;

import github.com.carloshenriquepere.localizacao.domain.entity.Cidade;
import github.com.carloshenriquepere.localizacao.domain.repository.CidadeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CidadeService {

    private CidadeRepository repository;

    public CidadeService(CidadeRepository repository) {
        this.repository = repository;
    }

    @Transactional
    void salvarCidade(){
        var cidade = new Cidade(1L, "Sao Paulo", 12368596L);
        repository.save(cidade);
    }

     public void listarCidadePorNome(){

         repository.findByNomeLike("%a%", Sort.by("habitantes")).forEach(System.out::println);
    }

   public void listarCidadePorHabitantes(){

       repository.findByHabitantesLessThanAndNomeLike(80000L,"%t%").forEach(System.out::println);
    }

    void listarCidade(){
        repository.findAll().forEach(System.out::println);
    }

}
