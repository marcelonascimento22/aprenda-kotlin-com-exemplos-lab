// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)


enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

//Usuário
class Usuario(
    val nome: String,
    val idade: Int,
    val telefone: Int,
    val endereco: String
    )

//Conteúdo
data class ConteudoEducacional(
    val nome: String,
    val duracao: Int = 60,
    val nivel: Nivel = Nivel.BASICO
)

// Interface
interface Matriculavel {
    fun matricular(usuario: Usuario)
}

//Formacao
class Formacao(
    val nome: String,
    private val conteudos: List<ConteudoEducacional>
) : Matriculavel {

    private val inscritos = mutableListOf<Usuario>()

    override fun matricular(usuario: Usuario) {
        if (usuario in inscritos) {
            println("Usuário ${usuario.nome} já está matriculado!")
            return
        }
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação \"$nome\".")
    }

    fun listarConteudos() = conteudos.toList()
    fun listarInscritos() = inscritos.toList()
}


// Aplicação


class MatriculaService {

    fun realizarMatricula(formacao: Matriculavel, usuario: Usuario) {
        formacao.matricular(usuario)
    }
}

//relatórios
class RelatorioService {

    fun gerarRelatorioFormacao(formacao: Formacao) {
        println("\n=== RELATÓRIO: ${formacao.nome} ===")

        println("\nConteúdos:")
        formacao.listarConteudos().forEach {
            println("- ${it.nome} | ${it.duracao}min | Nível: ${it.nivel}")
        }

        println("\nInscritos:")
        formacao.listarInscritos().forEach {
            println("- ${it.nome}")
        }
    }
}

//Cadastro Aluno
class ConsultarAluno{
    fun consultar(aluno: Usuario){
        println("\n=== CADASTRO DO ALUNO: ${aluno.nome} ===")
        println("\nNome: ${aluno.nome}")
        println("\nIdade: ${aluno.idade}")
        println("\nTelefone: ${aluno.telefone}")
        println("\nEndereço: ${aluno.endereco}")
    }
}


fun main() {
    val matriculaService = MatriculaService()
    val relatorioService = RelatorioService()
    val consultarAluno = ConsultarAluno()

    // Usuários
    val u1 = Usuario("Marcelo", 31, 1234567, "Rua da casa")
    val u2 = Usuario("Ana", 22, 11111111, "Rua da casa")
    val u3 = Usuario("Carlos", 19, 55555555, "Rua da casa")

    // Conteúdos
    val c1 = ConteudoEducacional("Introdução ao Kotlin", 90, Nivel.BASICO)
    val c2 = ConteudoEducacional("Orientação a Objetos", 120, Nivel.INTERMEDIARIO)
    val c3 = ConteudoEducacional("Corrotinas", 180, Nivel.AVANCADO)

    // Formação
    val formacaoKotlin = Formacao(
        nome = "Formação Kotlin Developer",
        conteudos = listOf(c1, c2, c3)
    )

    // Matrículas usando Service (DIP)
    matriculaService.realizarMatricula(formacaoKotlin, u1)
    matriculaService.realizarMatricula(formacaoKotlin, u2)
    matriculaService.realizarMatricula(formacaoKotlin, u1) // teste usuário repetido
    matriculaService.realizarMatricula(formacaoKotlin, u3)

    // Relatório
    relatorioService.gerarRelatorioFormacao(formacaoKotlin)

    consultarAluno.consultar(u1)
    consultarAluno.consultar(u2)
    consultarAluno.consultar(u3)

}