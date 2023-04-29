package github.com.carloshenriquepere.localizacao.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
import javax.persistence.*;
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
>>>>>>> origin/main

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
<<<<<<< HEAD
@Table(name = "tb_cidade")
=======
@Table(name = " tb_cidade")

>>>>>>> origin/main
public class Cidade {

    @Id
    @Column(name ="id_cidade")
<<<<<<< HEAD
    private Long id;

=======

    private Long id;
>>>>>>> origin/main

    @Column(name = "nome", length = 50)
    private String nome;

<<<<<<< HEAD

=======
>>>>>>> origin/main
    @Column(name = "qtd_habitantes")
    private Long habitantes;
}
