package tp;

import java.io.IOException;
import java.util.ArrayList;
import myinputs.Ler;

public class EscolaMain {

    //Menu Principal, este vai ser o primeiro menu aparecer
    public static int menu() {
        int opcao;
        System.out.println("\n         ### Menu Principal ###      ");
        System.out.println("   ==================================");
        System.out.println("   |     1 - Gerir Curso            |");
        System.out.println("   |     2 - Gerir Aluno            |");
        System.out.println("   |     3 - Gerir Professor        |");
        System.out.println("   |     4 - Estatisticas           |");
        System.out.println("   |     0 - Sair                   |");
        System.out.println("   ==================================\n");
        System.out.print("   Qual a sua opção -> ");
        opcao = Ler.umInt();
        return opcao;
    }

    public static void main(String[] args) {
        int escolha;
        int escolha1, escolha2, escolha3, escolha4;
        Escola Hotelaria = new Escola("Escola Profissional de Hotelaria de Manteigas", "Manteigas");
        //ler o ficheiro curso.dat e guarda nos "cursos"
        ArrayList<Curso> Cursos = (ArrayList<Curso>) GerirCursos.lerC().clone();

        ArrayList<Aluno> alunos = (ArrayList<Aluno>) GerirAluno.LerA().clone();

        //Ler o ficheiro professor.dat e guarda nos "professores"
        ArrayList<Professor> professores = (ArrayList<Professor>) GerirProfessor.LerP().clone();

        //COMEÇO DO PROGRAMA  --- MENUS
        do {
            System.out.println("\n\n            ### Bem-Vindo ao software da ###       ");
            System.out.println(" ### " + Hotelaria.getNomeE() + " ###");
            escolha = menu();
            switch (escolha) {
                case 0:
                    break;
                default:
                    System.out.println("   Opção inválida!");
                    break;
                case 1:
                    //gerir curso
                    do {
                        escolha1 = GerirCursos.menuC();
                        switch (escolha1) {
                            case 0:
                                break;
                            default:
                                System.out.println("   Opção inválida!");
                                break;
                            case 1: // Adicionar curso
                                GerirCursos.inserirCurso(Cursos, alunos, professores);
                                break;

                            case 2: // remover curso
                                GerirCursos.apagarCurso(Cursos);
                                break;

                            case 3: // pesquisa de curso
                                GerirCursos.verificaCurso(Cursos);
                                break;

                            case 4: // Listar cursos
                                GerirCursos.listarCursos(Cursos);
                                break;

                            case 5: // Editar curso
                                GerirCursos.alteraCurso(Cursos, alunos, professores);
                                break;
                        }

                    } while (escolha1 != 0);
                    break;

                case 2:
                    // gerir aluno
                    do {
                        escolha2 = GerirAluno.menuA();
                        switch (escolha2) {
                            case 0:
                                break;
                            default:
                                System.out.println("   Opção inválida!");
                                break;
                            case 1: //adicionar aluno
                                GerirAluno.inserirAluno(alunos, professores);
                                break;

                            case 2: //remover aluno
                                GerirAluno.RemoveAluno(alunos, Cursos);
                                break;

                            case 3: //listar aluno
                                GerirAluno.ListarAlunos(alunos);
                                break;

                            case 4: // consultar aluno
                                System.out.print("   Qual o nome do aluno que deseja consultar: ");
                                GerirAluno.verificaAluno(alunos, Ler.umaString());
                                break;

                            case 5: //Editar aluno
                                GerirAluno.editarAluno(alunos, Cursos);
                                break;

                        }
                    } while (escolha2 != 0);
                    break;

                case 3:
                    // gerir professor
                    do {
                        escolha3 = GerirProfessor.menuP();
                        switch (escolha3) {
                            case 0:
                                break;
                            default:
                                System.out.println("   Opção inválida!");
                                break;
                            case 1://adicionar professor
                                GerirProfessor.inserirProfessor(professores, alunos);
                                break;

                            case 2: // remover professor
                                GerirProfessor.removerProfessor(professores, Cursos);
                                break;

                            case 3: // Listar professor
                                GerirProfessor.listarProfessores(professores);
                                break;

                            case 4: // consultar professor
                                GerirProfessor.verificaProfessor(professores);
                                break;

                            case 5: // editar professor
                                GerirProfessor.alterarProfessor(professores, Cursos);
                                break;
                        }

                    } while (escolha3 != 0);
                    break;

                case 4:
                    do {
                        escolha4 = GerirEstatisticas.menuE();
                        switch (escolha4) { //Estatisticas
                            case 0:
                                break;
                            default:
                                System.out.println("   Opção inválida!");
                                break;
                            case 1: //Alunos que moram na mesma cidade da escola
                                GerirEstatisticas.MoraOnde(alunos);
                                break;

                            case 2://Cursos lecionados por mais que um professor
                                GerirEstatisticas.DoisOuMaisProfs(Cursos);
                                break;

                            case 3: // Cursos mais frequentado
                                GerirEstatisticas.MaisAlunos(Cursos);
                                break;

                            case 4:// curso com mais horas
                                GerirEstatisticas.cursoMaisHoras(Cursos);
                                break;

                            case 5: // professor com mais horas
                                GerirEstatisticas.ProfessorMaisHoras(professores, Cursos);
                                break;
                            case 6:
                                GerirEstatisticas.alunoInscritoM(alunos, Cursos);
                                break;

                        }

                    } while (escolha4 != 0);
                    break;

            }
        } while (escolha != 0);
    }

}
