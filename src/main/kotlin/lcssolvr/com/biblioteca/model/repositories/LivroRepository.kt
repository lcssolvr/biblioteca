package lcssolvr.com.biblioteca.model.repositories
import org.springframework.data.jpa.repository.JpaRepository
import lcssolvr.com.biblioteca.model.entity.Livro

interface LivroRepository : JpaRepository<Livro, Long> {
    
}
