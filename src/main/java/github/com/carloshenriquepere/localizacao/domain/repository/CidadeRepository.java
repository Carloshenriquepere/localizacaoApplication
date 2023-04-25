package github.com.carloshenriquepere.localizacao.domain.repository;

import github.com.carloshenriquepere.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository  extends JpaRepository<Cidade, Long> {
}
