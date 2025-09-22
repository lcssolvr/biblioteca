package lcssolvr.com.biblioteca.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import lcssolvr.com.biblioteca.model.entity.Livro;
import lcssolvr.com.biblioteca.model.repositories.LivroRepository;

@RestController
@RequestMapping("/livros")
class LivroResource(private val livroRepository: LivroRepository) {

    @GetMapping
    fun getAll(): kotlin.collections.List<Livro> {
        return livroRepository.findAll()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Livro> {
        val livro = livroRepository.findById(id)
        return if (livro.isPresent) {
            ResponseEntity.ok(livro.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun create(@RequestBody @Valid livro: Livro): ResponseEntity<Livro> {
        val saved = livroRepository.save(livro)
        return ResponseEntity.status(HttpStatus.CREATED).body(saved)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody @Valid livro: Livro): ResponseEntity<Livro> {
        val opcional = livroRepository.findById(id)
        if (opcional.isEmpty) {
            return ResponseEntity.notFound().build()
        }

        val updated = opcional.get().copy(
            titulo = livro.titulo,
            autor = livro.autor,
            dataPublicacao = livro.dataPublicacao,
            isbn = livro.isbn,
            paginas = livro.paginas,
            capa = livro.capa,
            idioma = livro.idioma
        )

        return ResponseEntity.ok(livroRepository.save(updated))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        return if (livroRepository.existsById(id)) {
            livroRepository.deleteById(id)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}

