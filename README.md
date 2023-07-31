<a name="readme-top"></a>

<div align="center">

<!--
# INVESTIGAÇÃO


# ![Header](images/logo.png)
-->

</div>

# Software da Escola Profissional de Hotelaria de Manteigas

<table>
<tr>
<td>

> Este projeto, consistiu em desenhar e implementar uma aplicação, em
Java, que permita gerir os recursos de uma escola de formação profissional,
que oferece cursos numa determinada área, no nosso caso Hotelaria. A escola
oferece vários cursos, que têm um certo número de horas, uma data de
início e de fim, um horário, professores que lecionam os cursos e alunos que
os frequentam.

> Além da gestão de cursos, alunos e professores, neste trabalho, pretende-se
que seja possível produzir estatísticas sobre o desempenho de cada escola,
bem como manter a persistência dos dados armazenados.

</td>
</tr>
</table>

### Ferramentas e Tecnologias

[![Java][Java]][Java-url] [![NetBeans][NetBeans]][NetBeans-url] [![Discord][Discord]][Discord-url] [![LaTeX][LaTeX]][LaTeX-url] [![Overleaf][Overleaf]][Overleaf-url]

<!-- 
[![Java][Java]][Java-url] [![JavaFX][JavaFX]][JavaFX-url] [![NetBeans][NetBeans]][NetBeans-url] [![Spring][Spring]][Spring-url] [![PostgreSQL][PostgreSQL]][PostgreSQL-url] [![MySQL][MySQL]][MySQL-url] [![SQLite][SQLite]][SQLite-url] [![Oracle][Oracle]][Oracle-url] [![Microsoft-SQL-Server][Microsoft-SQL-Server]][Microsoft-SQL-Server-url] [![LaTeX][LaTeX]][LaTeX-url] [![Overleaf][Overleaf]][Overleaf-url]
 
[![Cisco][Cisco]][Cisco-url] [![Linux][Linux]][Linux-url] [![LaTeX][LaTeX]][LaTeX-url] [![Overleaf][Overleaf]][Overleaf-url]

[![OCaml][OCaml]][OCaml-url] [![JetBrains][JetBrains]][JetBrains-url]

[![Assembly][Assembly]][Assembly-url] [![logisim-evolution][logisim-evolution]][logisim-evolution-url]

[![C++][C++]][C++-url] [![VS-Code][VS-Code]][VS-Code-url] [![LaTeX][LaTeX]][LaTeX-url] [![Makefile][Makefile]][Makefile-url]

[![Next][Next.js]][Next-url] [![React][React.js]][React-url] [![Bootstrap][Bootstrap.com]][Bootstrap-url] [![JQuery][JQuery.com]][JQuery-url]
-->

### Repositório GitHub

Após a entrega deste projeto ficará publico :  https://github.com/tiago-barreiros/Software-da-Escola-Profissional-de-Hotelaria-de-Manteigas

<!-- 
## Limites

![](images/jogo1.png)

## Exemplo de Entrada

![](images/jogo2.png)

## Exemplo de Saída

![](images/jogo3.png)

-->

## Especificação de Testes

> O objeto "Pessoa", permiti-nos dar uso a uma das aprendizagens obtidas
nas aulas teóricas, a herança, usada sobre os objetos "Professor"e "Aluno".
Após criarmos o que seria a "base" de todo o projeto, procedemos à criação
da classe "Curso" e uma classe temporária "Data", a qual usámos para realizar
testes enquanto não chegávamos a uma ideia definitiva acerca do horário.
A seguir as classes "GerirProfessor", "GerirAluno", "GerirCursos" e
"GerirEstatisticas" foram criadas para realizarmos testes a nível da main.

> No final, criámos a atual classe "Dia"que veio substituir a "Data" e aventuramo-nos
nos testes de aprimoramento.

## Análise dos Resultados e Aprimoramentos

> Observámos que no número de aluno e de professor podíamos usar uma
variável static que incrementava cada vez que instanciávamos (género contador).
Criámos uma função que verifica se os professores estão a lecionar mais
de um curso ao mesmo tempo, outra que calcula as horas de um curso, após
criação do horário, bem como calcular o professor que deu mais horas.

> Quando removemos umprofessor, e se ele for o único a lecionar um curso,
pergunta se queremos adicionar um professor ou eliminar o curso e quando
removemos um aluno, temos de atualizar a lista do curso. Colocámos os professores
e os alunos a serem alterados pelo seu número, comparamos o Cartão
de Cidadão (CC) que queremos introduzir com os já existentes.

> Fizemos aprimoramentos no horário e colocámos o mesmo por ordem.
Quando queremos renovar o horário para um determinado curso, é apagado
o arraylist que existe e é chamada novamente a função.

> Em termos estéticos criamos uma "cadeia" de menus e usamos Case Sensitive.
Finalmente, chegámos a um consenso em relação ao horário e decidimos
criar a class "Dia", esta permitia aprimorar todas as classes anteriormente criadas,
tornando desnecessária a existencia de um objeto "data", pois elabora
um arraylist dias com as horas das aulas e os dias que decorrem.

<!-- 
### Menu introdutório
<div align="center">

![](images/menu.png)

</div>

### Jogo
<div align="center">

![](images/jogo.png)

</div>
-->

<!-- 
### Página de Login

![](src/images/readme/login2.png)

### Página de Registo

![](src/images/readme/registar.png)

### Recuperar Password

![](src/images/readme/reporSenha.png)

### Landing Page

![](src/images/readme/landingPageWireframe.png)

### Contratos

![](src/images/readme/contratos.png)

### Feedbacks

![](src/images/readme/scroll.png)
![](src/images/readme/personalizado.png)

### Página Pessoal

![](src/images/readme/perfil2.png)

### Reservar

![](src/images/readme/escolherCowork.png)
![](src/images/readme/filtrarReserva.png)
![](src/images/readme/guardadasReservas.png)

### Calendário

![](src/images/readme/calendario.png)

### Planta do Cowork

![](src/images/readme/planta3.png)

### Ambiente da Administração

![](src/images/readme/admin.png)
![](src/images/readme/tabelas.png)
![](src/images/readme/pesquisa.png)

### Alguns Recursos

![](src/images/readme/modal.png)
![](src/images/readme/toasts.png)
![](src/images/readme/exposicao.png)
-->

<!-- 
### Como usar executar App?

- O acesso ao SQL Server é feito através de um protocolo presente na Network
  Configuration, onde está encapsulado o protocolo TCP/IP.
  Este é um modelo robusto, rápido e confiável, sendo na atualidade praticamente
  indispensável.

- Deverá ser compilado utilizando o comando:
   ```sh
   gcc -o qqsm main main.c -Wall -std=c99
   ```
-->

<!-- 
- Acede ao website no URL de um browser: https://cowork-fundao.web.app/
-->

## Documentação

- [Java](https://docs.oracle.com/en/java/javase/16/)
- [NetBeans](https://netbeans.apache.org/kb/index.html)
- [LaTeX](https://www.latex-project.org/help/documentation/)
- [Overleaf](https://www.overleaf.com/learn)

> A restante documentação encontra-se no extenso Relatório Técnico estruturado mediante o desenvolvimento deste projeto.

<!-- 
- [React](https://reactjs.org/docs/getting-started.html)
- [react-router-dom](https://reactrouter.com/web/guides/quick-start)
- [npm](https://www.npmjs.com/)
- [DataPicker](https://hypeserver.github.io/react-date-range/)
- [Date and Time Pickers - Validation](https://mui.com/x/react-date-pickers/validation/)
- [headless UI](https://headlessui.com/)
- [tailwindcss](https://v2.tailwindcss.com/docs/installation)
- [Firebase](https://firebase.google.com/docs)
-->

## Equipa de Desenvolvimento

[![Diogo Santos](https://avatars.githubusercontent.com/u/96886187?s=100&v=4)](https://github.com/DidiTuga)| [![Simão Farias](https://cdn.discordapp.com/attachments/1050105332891926569/1135694728726315058/206467396_1916519531848686_4405081195803514986_n.jpg)](https://github.com/Usidhis) |[![Tiago Barreiros](https://avatars.githubusercontent.com/u/78179371?s=100&v=4)](https://github.com/tiago-barreiros)
---|-------------------------------------------------------------------------------------------------------------|---
[Diogo Santos](https://github.com/DidiTuga)| [Simão Farias](https://github.com/Usidhis)                                                                  |[Tiago Barreiros](https://github.com/tiago-barreiros)

# Orientação

## [Prof. Doutora Paula Prata](https://www.di.ubi.pt/~pprata/)

## *Programação Orientada a Objetos* @[Universidade da Beira Interior](https://www.ubi.pt/).

<!-- 
### Installation

_Below is an example of how you can instruct your audience on installing and setting up your app. This template doesn't rely on any external dependencies or services._

1. Get a free API Key at [https://example.com](https://example.com)
2. Clone the repo
   ```sh
   git clone https://github.com/your_username_/Project-Name.git
   ```
3. Install NPM packages
   ```sh
   npm install
   ```
4. Enter your API in `config.js`
   ```js
   const API_KEY = 'ENTER YOUR API';
   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>
-->

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<!-- CONTACT -->
## Contact

<div> 
   <a href = "mailto:tiago.m.barreiros@gmail.com"><img src="https://img.shields.io/badge/-Gmail-%23333?style=for-the-badge&logo=gmail&logoColor=white" target="_blank"></a>
  <a href="https://www.linkedin.com/in/tiago-barreiros/" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a> 
   <a href="https://discord.gg/537381363486031873" target="_blank"><img src="https://img.shields.io/badge/Discord-7289DA?style=for-the-badge&logo=discord&logoColor=white" target="_blank"></a>
</div>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=for-the-badge
[contributors-url]: https://github.com/othneildrew/Best-README-Template/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/othneildrew/Best-README-Template.svg?style=for-the-badge
[forks-url]: https://github.com/othneildrew/Best-README-Template/network/members
[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=for-the-badge
[stars-url]: https://github.com/othneildrew/Best-README-Template/stargazers
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge
[issues-url]: https://github.com/othneildrew/Best-README-Template/issues
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]: https://github.com/othneildrew/Best-README-Template/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/othneildrew
[Next.js]: https://img.shields.io/badge/next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white
[Next-url]: https://nextjs.org/
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[C++]: https://img.shields.io/badge/C++-00599C?style=for-the-badge&logo=cplusplus&logoColor=white
[C++-url]: https://www.cplusplus.com/
[VS-Code]: https://img.shields.io/badge/VS_Code-0078D4?style=for-the-badge&logo=visualstudiocode&logoColor=white
[VS-Code-url]: https://code.visualstudio.com/
[Vue.js]: https://img.shields.io/badge/Vue.js-35495E?style=for-the-badge&logo=vuedotjs&logoColor=4FC08D
[Vue-url]: https://vuejs.org/
[Angular.io]: https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white
[Angular-url]: https://angular.io/
[Svelte.dev]: https://img.shields.io/badge/Svelte-4A4A55?style=for-the-badge&logo=svelte&logoColor=FF3E00
[Svelte-url]: https://svelte.dev/
[Laravel.com]: https://img.shields.io/badge/Laravel-FF2D20?style=for-the-badge&logo=laravel&logoColor=white
[Laravel-url]: https://laravel.com
[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com
[JQuery.com]: https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white
[JQuery-url]: https://jquery.com 
[LaTex]: https://img.shields.io/badge/LaTeX-47A141?style=for-the-badge&logo=latex&logoColor=white
[LaTex-url]: https://www.latex-project.org/
[Makefile]: https://img.shields.io/badge/Makefile-003366?style=for-the-badge&logo=gnu&logoColor=white
[Makefile-url]: https://www.gnu.org/software/make/
[Assembly]: https://img.shields.io/badge/Assembly-000000?style=for-the-badge&logo=assemblyscript&logoColor=white
[Assembly-url]: https://www.assemblyscript.org/
[logisim-evolution]: https://img.shields.io/badge/Logisim_Evolution-FF2D20?style=for-the-badge&logo=logisim&logoColor=white
[logisim-evolution-url]: https://www.logisim.org/
[OCaml]: https://img.shields.io/badge/OCaml-EC6813?style=for-the-badge&logo=ocaml&logoColor=white
[OCaml-url]: https://ocaml.org/
[JetBrains]: https://img.shields.io/badge/JetBrains-000000?style=for-the-badge&logo=jetbrains&logoColor=white
[JetBrains-url]: https://www.jetbrains.com/
[Overleaf]: https://img.shields.io/badge/Overleaf-47A141?style=for-the-badge&logo=overleaf&logoColor=white
[Overleaf-url]: https://www.overleaf.com/
[Linux]: https://img.shields.io/badge/Linux-FCC624?style=for-the-badge&logo=linux&logoColor=black
[Linux-url]: https://www.linux.org/
[Cisco]: https://img.shields.io/badge/Cisco-1BA0D7?style=for-the-badge&logo=cisco&logoColor=white
[Cisco-url]: https://www.cisco.com/
[Arduino]: https://img.shields.io/badge/Arduino-00979D?style=for-the-badge&logo=arduino&logoColor=white
[Arduino-url]: https://www.arduino.cc/
[Scanner]: https://img.shields.io/badge/Scanner-000000?style=for-the-badge&logo=scanner&logoColor=white
[Scanner-url]: https://www.scanner.com/
[Java]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white
[Java-url]: https://www.java.com/
[JavaFX]: https://img.shields.io/badge/JavaFX-ED8B00?style=for-the-badge&logo=java&logoColor=white
[JavaFX-url]: https://openjfx.io/
[NetBeans]: https://img.shields.io/badge/NetBeans-1B6AC6?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white
[NetBeans-url]: https://netbeans.apache.org/
[Spring]: https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white
[Spring-url]: https://spring.io/
[PostgreSQL]: https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white
[PostgreSQL-url]: https://www.postgresql.org/
[MySQL]: https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white
[MySQL-url]: https://www.mysql.com/
[SQLite]: https://img.shields.io/badge/SQLite-07405E?style=for-the-badge&logo=sqlite&logoColor=white
[SQLite-url]: https://www.sqlite.org/
[Oracle]: https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white
[Oracle-url]: https://www.oracle.com/
[Microsoft-SQL-Server]: https://img.shields.io/badge/Microsoft_SQL_Server-CC2927?style=for-the-badge&logo=microsoft-sql-server&logoColor=white
[Microsoft-SQL-Server-url]: https://www.microsoft.com/en-us/sql-server
[Python]: https://img.shields.io/badge/Python-3776AB?style=for-the-badge&logo=python&logoColor=white
[Python-url]: https://www.python.org/
[Audacity]: https://img.shields.io/badge/Audacity-0000CC?style=for-the-badge&logo=audacity&logoColor=white
[Audacity-url]: https://www.audacityteam.org/
[Discord]: https://img.shields.io/badge/Discord-7289DA?style=for-the-badge&logo=discord&logoColor=white
[Discord-url]: https://discord.com/
