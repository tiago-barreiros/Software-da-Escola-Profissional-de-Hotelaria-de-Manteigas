package tp;

import java.io.*;
import java.util.ArrayList;
import myinputs.Ler;

public class GerirProfessor {

    //menu professor
    public static int menuP() { // Funcao do menu Professor
        int opcao;
        System.out.println("\n\n       ### Menu do Gerir Professor ###     ");
        System.out.println("   =======================================");
        System.out.println("   |     1 - Adicionar Professor         |");
        System.out.println("   |     2 - Remover Professor           |");
        System.out.println("   |     3 - Listar Professores          |");
        System.out.println("   |     4 - Consultar Professor         |");
        System.out.println("   |     5 - Editar Professor            |");
        System.out.println("   |     0 - Sair                        |");
        System.out.println("   =======================================\n");
        System.out.print("   Qual a sua opção -> ");
        opcao = Ler.umInt();
        return opcao;
    }

    //Funcao guardar o ficheiro de professor
    private static void guardarP(ArrayList<Professor> professores) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\Users\\tiago\\OneDrive\\Ambiente de Trabalho\\UBI\\ANO_2\\1Semestre\\ProgramacaoOrientadaaObjetos\\TrabalhoPratico\\professor.dat"));
            // escrever o objeto professor no ficheiro 
            os.writeObject(professores);
            os.writeInt(Professor.getUltimo());
            os.flush(); // os dados são copiados de memória para o disco
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //ler o ficheiro professor.dat e devolve a arraylist e define o ultimo número de professor
    public static ArrayList LerP() {
        ArrayList<Professor> professores = new ArrayList();
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("C:\\Users\\\\tiago\\\\OneDrive\\\\Ambiente de Trabalho\\\\UBI\\\\ANO_2\\\\1Semestre\\\\ProgramacaoOrientadaaObjetos\\\\TrabalhoPratico\\\\professor.dat"));
            professores = (ArrayList) is.readObject();
            int ult = is.readInt();
            Professor.setUltimo(ult);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return professores;
    }

    // Verifica se o numero de cartao cidadao ja existe (Funciona para aluno e professor)
    public static int VerificaCC(ArrayList<Professor> professores, ArrayList<Aluno> alunos) {
        System.out.print("   Cartao de cidadão: ");
        int cc = Ler.umInt();
        int teste = 0;
        do {
            teste = 0;
            for (Aluno aluno : alunos) {
                if (aluno.getCC() == cc) {
                    System.out.println("   Já existe uma pessoa com esse número de cartão de cidadão!");
                    System.out.print("   Insira novamente o cartao de cidadão: ");
                    cc = Ler.umInt();
                    teste = 1;
                }
            }
            for (Professor professor : professores) {
                if (professor.getCC() == cc) {
                    System.out.println("   Já existe uma pessoa com esse número de cartão de cidadão!");
                    System.out.print("   Insira novamente o cartao de cidadão: ");
                    cc = Ler.umInt();
                    teste = 1;
                }
            }
        } while (teste != 0);

        return cc;
    }

    //inserir professor no arraylist professor
    public static void inserirProfessor(ArrayList<Professor> professores, ArrayList<Aluno> alunos) {

        System.out.println("   Preencha os seguintes dados:");

        int cc = VerificaCC(professores, alunos);

        //Verifica se existe alguem com esse cc
        System.out.print("   Nome: ");
        String nome = Ler.umaString();
        System.out.print("   Morada: ");
        String morada = Ler.umaString();
        System.out.print("   Telemóvel: ");
        int tele = Ler.umInt();

        Pessoa c = new Pessoa(cc, nome, morada, tele);
        Professor l = new Professor(c); // Cria o objeto professor usando a pessoa c
        // adicionar a nova pessoa  à lista
        professores.add(l); // adicionar o novo professor à lista

        // atualizar ficheiro
        guardarP(professores);

    }

    //Lista Professor de 5 em 5
    public static void listarProfessores(ArrayList<Professor> professores) {
        for (int i = 0; i < professores.size(); i++) {
            System.out.println(professores.get(i));
            if (i % 5 == 0 && i != 0) {
                System.out.println("   Pressione uma tecla para continuar a visualizar mais professores ou 'q / Q' para sair.");
                String teste = Ler.umaString();
                if (teste.equalsIgnoreCase("q")) {
                    return;
                }
            }
        }
    }

    //remover professor do professores e cursos
    public static void removerProfessor(ArrayList<Professor> professores, ArrayList<Curso> Cursos) {
        System.out.print("   Qual é o número do professor que quer remover: ");
        int s1 = Ler.umInt();
        int verifica = 0;
        // validar nome do professor
        for (int i = 0; i < professores.size(); i++) {
            if (professores.get(i).getNumP() == s1) {
                professores.remove(professores.get(i));
                System.out.println("   O professor com o número " + s1 + " foi eliminado com sucesso.");
                verifica = 1;
            }
        }
        if (verifica == 0) {
            System.out.println("   O professor com o número " + s1 + " não existe.");
        } else {
            // atualizar ficheiro
            guardarP(professores);
            ArrayList<Professor> Professor_curso;
            for (int i = 0; i < Cursos.size(); i++) {
                Professor_curso = Cursos.get(i).getListaP();        //Procura o professor em todas as listas de professor de todos os cursos existentes e elimina-o
                for (int j = 0; j < Professor_curso.size(); j++) {

                    if (Professor_curso.get(j).getNumP() == s1) {
                        Professor_curso.remove(j);
                    }
                }
                Cursos.get(i).setListaP(Professor_curso);
            }
            GerirCursos.guardarC(Cursos);    //Guarda as alterações nas listas dos professor dos cursos no ficheiro
        }
    }

    //verifica se o professor exsite e dá print a informação dele se exsitir
    public static void verificaProfessor(ArrayList<Professor> professores) {
        System.out.print("   Qual é o nome do professor procura: ");
        String s2 = Ler.umaString();
        int verifica = 0;
        // validar nome do professor
        for (int i = 0; i < professores.size(); i++) {
            if (professores.get(i).getNome().equalsIgnoreCase(s2)) { //nao importa estar em maiusculas ou minusculas, se existir dá print dele
                verifica = 1;
                System.out.println(professores.get(i));
                return;
            }
        }
        if (verifica == 0) {
            
            System.out.println("   Não existe professores com esse nome : " + s2);
        }
    }

    //editar o nome/morada do professor e atualiza nos cursos
    public static void alterarProfessor(ArrayList<Professor> professores, ArrayList<Curso> Cursos) {

        System.out.println("   Qual o número do professor que quer alterar: ");
        int xD = Ler.umInt();
        int w = 0;
        int check = 0;                                  // Variavel que verifica a existencia do professor
        for (int i = 0; i < professores.size(); i++) {
            if (professores.get(i).getNumP()== xD) {         // Se o professor existir guarda a posição na variavel w
                w = i;
                check = 1;
            }
        }
        if (check == 0) {
            System.out.println("   O professor não existe");     // Mensagem caso o professor não exista
        } else {
            System.out.println("   O que deseja editar:\n   1 - Nome\n   2 - Morada\n");
            int escolha = Ler.umInt();
            switch (escolha) {
                case 1:// Alterar nome
                    System.out.println("   Insira o novo nome: ");
                    String A = Ler.umaString();
                    professores.get(w).setNome(A);
                    break;
                case 2:// Alterar morada
                    System.out.println("   Insira a nova morada: ");
                    String M = Ler.umaString();
                    professores.get(w).setMorada(M);
                    break;
                default:
                    System.out.println("   Opção inválida!");
                    break;
            }
            guardarP(professores);
            ArrayList<Professor> Professor_curso;
            for (int i = 0; i < Cursos.size(); i++) {
                Professor_curso = Cursos.get(i).getListaP();        //Procura o professor em todas as listas de professor de todos os cursos existentes e elimina-o
                                                                    // e mete o novo professor editado
                for (int j = 0; j < Professor_curso.size(); j++) {

                    if (Professor_curso.get(j).getNumP() == xD) {
                        Professor_curso.remove(j);
                        Professor_curso.add(professores.get(w));
                    }
                }
                Cursos.get(i).setListaP(Professor_curso);
            }
            GerirCursos.guardarC(Cursos);    //Guarda as alterações nas listas dos professor dos cursos no ficheiro
        }
    }
}
