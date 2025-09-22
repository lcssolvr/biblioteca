package lcssolvr.com.biblioteca.model.entity

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDate

@Entity
data class Livro(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:NotBlank
    @field:Size(min = 1, max = 255, message = "Título é obrigatório e deve ter entre 1 e 255 caracteres")
    @Column(length = 255)
    val titulo: String = "",

    @field:NotBlank
    @field:Size(min = 1, max = 255, message = "Autor é obrigatório e deve ter entre 1 e 255 caracteres")
    @Column(length = 255)
    val autor: String = "",

    @field:NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "data_publicacao")
    val dataPublicacao: LocalDate = LocalDate.now(),

    @field:NotBlank
    @field:Size(min = 13, max = 13, message = "ISBN é obrigatório e deve ter 13 caracteres")
    @Column(unique = true)
    val isbn: String = "",

    val paginas: Int = 0,

    @field:Size(min = 1, max = 255, message = "Capa/Gênero precisa ter entre 1 e 255 caracteres")
    @Column(length = 255)
    val capa: String? = null,

    @field:NotBlank
    @field:Size(min = 1, max = 255, message = "Idioma precisa ter entre 1 e 255 caracteres")
    @Column(length = 255)
    val idioma: String = ""
)
