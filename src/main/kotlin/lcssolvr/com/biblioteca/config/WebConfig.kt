package lcssolvr.com.biblioteca.config
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig {
    
    @Bean
    fun corsConfigurer(): WebMvcConfigurer {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(regisrty: CorsRegistry) {
                regisrty.addMapping("/**")
                    .allowedOrigins("http://localhost:8081")
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            }
        }
    }
}