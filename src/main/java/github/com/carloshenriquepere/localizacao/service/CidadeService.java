package github.com.carloshenriquepere.localizacao.service;

import github.com.carloshenriquepere.localizacao.domain.entity.Cidade;
import github.com.carloshenriquepere.localizacao.domain.repository.CidadeRepository;
import static github.com.carloshenriquepere.localizacao.domain.repository.specs.CidadeSpecs.*;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

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

    public void listarCidadePorNomeSql(){
        repository
                .findByNomeSqlNativo("Porto Alegre")
                .stream()
                .map(cidadeProjection -> new Cidade(cidadeProjection.getId(), cidadeProjection.getNome(), null))
                .forEach(System.out::println);
    }

   public void listarCidadePorHabitantes(){
       repository.findByHabitantesLessThanAndNomeLike(80000L,"%t%").forEach(System.out::println);
    }

    void listarCidade(){
        repository.findAll().forEach(System.out::println);
    }

    public List<Cidade> filtroDinamico(Cidade cidade){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);
        Example<Cidade> example = Example.of(cidade, matcher);
       return repository.findAll(example);
    }

    public void listarCidadesByNomeSpec(){
        repository
                .findAll(nomeEqual("Porto Alegre")
                        .and(idEqual(6L)))
                .forEach(System.out::println);
    }

    void listarCidadesSpecsFiltroDinamico(Cidade filtro){
        Specification<Cidade> spec = Specification.where((root, query, cb) ->  cb.conjunction() );

        //select * from cidade where 1=1

        if (filtro.getId() != null){
            spec = spec.and(idEqual(filtro.getId()) );
        }
        if (StringUtils.hasText(filtro.getNome())){
            spec = spec.and(nomeLike(filtro.getNome()));
        }
        if (filtro.getHabitantes() != null){
            spec = spec.and(habitantesGreaterThan(filtro.getHabitantes()));
        }

        repository.findAll(spec).forEach(System.out::println);
    }

}
