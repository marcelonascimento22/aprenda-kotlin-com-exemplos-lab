# 📘 Sistema de Matrículas em Kotlin

Implementa um sistema simples de **gestão de formação educacional**, permitindo cadastrar usuários, matriculando em uma formação, consultar seus dados e gerar relatórios.  
O código foi desenvolvido utilizando os princípios de **orientação a objetos**, **encapsulamento**, **interfaces**, **enumerações** e **separação de responsabilidades**.

---

## 🚀 Funcionalidades

- Cadastro de usuários (alunos)
- Cadastro de conteúdos educacionais
- Criação de formações compostas por vários conteúdos
- Matrícula de usuário
- Prevenção de matrícula duplicada
- Consulta individual do aluno
- Geração de relatório da formação

---

## 🧩 Estrutura do Projeto

### 🔹 **Enum: `Nivel`**
Define os níveis de dificuldade:
- **BASICO**
- **INTERMEDIARIO**
- **AVANCADO**

### 🔹 **Classe `Usuario`**
Representa os dados do aluno:
- Nome  
- Idade  
- Telefone  
- Endereço  

### 🔹 **Data Class `ConteudoEducacional`**
Define uma formação:
- Nome  
- Duração (padrão 60 min)  
- Nível  

### 🔹 **Interface `Matriculavel`**
Define o contrato para objetos que permitem matrícula de usuários.

### 🔹 **Classe `Formacao`**
Contém:
- Nome da formação  
- Lista de conteúdos  
- Lista interna de alunos inscritos  

Implementa:
- Método `matricular()`  
- Métodos de listagem dos conteúdos e dos inscritos  

### 🔹 **`MatriculaService`**
Responsável por executar o processo de matrícula.

### 🔹 **`RelatorioService`**
Gera relatórios sobre:
- Conteúdos da formação  
- Alunos matriculados  

### 🔹 **`ConsultarAluno`**
Exibe os dados de um aluno específico.

### 🔹 **Função `main()`**
Simula a aplicação criando:
- Usuários  
- Conteúdos  
- Formação  
- Matrículas  
- Relatório  
- Consultas individuais  

---


## 📄 Saída (Console)

<img src="image/Captura de tela 2025-12-04 005137.png">