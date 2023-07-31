package tp;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import myinputs.Ler;

public class GerirCursos {

    // menu dos cursos
    public static int menuC() { // Funcao do menu Curso
        int opcao;
        System.out.println("\n\n       ### Menu do Gerir Curso ###     ");
        System.out.println("   ===================================");
        System.out.println("   |     1 - Adicionar Curso         |");
        System.out.println("   |     2 - Remover Curso           |");
        System.out.println("   |     3 - Consultar Curso         |");
        System.out.println("   |     4 - Listar Cursos           |");
        System.out.println("   |     5 - Editar Curso            |");
        System.out.println("   |     0 - Sair                    |");
        System.out.println("   ===================================\n");
        System.out.print("   Qual a sua opção -> ");
        opcao = Ler.umInt();
        return opcao;
    }

    //Guardar cursos
    public static void guardarC(ArrayList<Curso> Curso) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\Users\\tiago\\OneDrive\\Ambiente de Trabalho\\UBI\\ANO_2\\1Semestre\\ProgramacaoOrientadaaObjetos\\TrabalhoPratico\\curso.dat"));
            // escrever o objeto Curso no ficheiro
            os.writeObject(Curso);
            os.flush(); // os dados são copiados de memória para o disco
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //ler ficheiro curso.dat e devolver o arraylist
    public static ArrayList lerC() {
        ArrayList<Curso> Cursos = new ArrayList();
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("C:\\Users\\tiago\\OneDrive\\Ambiente de Trabalho\\UBI\\ANO_2\\1Semestre\\ProgramacaoOrientadaaObjetos\\TrabalhoPratico\\curso.dat"));
            Cursos = (ArrayList<Curso>) is.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return Cursos;
    }

    //Vai mostrar um menuDia e perguntar qual dia quer adicionar as horas ect e chama o escolhe dia 
    public static ArrayList menuDia(Curso c) {
        ArrayList<Dia> ListaDias = new ArrayList<>();

        int selecao = (-1);
        while (selecao != 0) {
            //Definir os dias da semana em que o curso vai decorrer
            System.out.println("\n\n   ### Escolha um dia da semana ###     ");
            System.out.println("   ================================");
            System.out.println("   |     1 - Segunda-Feira        |");
            System.out.println("   |     2 - Terça-Feira          |");
            System.out.println("   |     3 - Quarta-Feira         |");
            System.out.println("   |     4 - Quinta-Feira         |");
            System.out.println("   |     5 - Sexta-Feira          |");
            System.out.println("   |     0 - Sair                 |");
            System.out.println("   ================================\n");
            System.out.print("   Qual a sua opção -> ");
            selecao = Ler.umInt();
            switch (selecao) {
                case 0:
                    break;
                case 1:
                    System.out.println("   Escolheu Segunda-Feira!");
                    // tenho de ver de acordo com a data de inicio qual a próxima segunda
                    //7 -> dias da semana 1,2...
                    escolheDia(selecao, ListaDias, c);

                    break;
/////////////////////////////////////////////////////////////////////////////////////////////
                case 2:
                    System.out.println("   Escolheu Terça-Feira!");
                    escolheDia(selecao, ListaDias, c);
/////////////////////////////////////////////////////////////////////////////////////////////////
                    break;
                case 3:
                    System.out.println("   Escolheu Quarta-Feira!");
                    escolheDia(selecao, ListaDias, c);
////////////////////////////////////////////////////////////////////////////////////////////////
                    break;
                case 4:
                    System.out.println("   Escolheu Quinta-Feira!");
                    escolheDia(selecao, ListaDias, c);
///////////////////////////////////////////////////////////////////////////////////////////////
                    break;
                case 5:
                    System.out.println("   Escolheu Sexta-Feira!");
                    escolheDia(selecao, ListaDias, c);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("   Opção inválida!");
                    break;
            }
        }
        return ListaDias;
    }

    //vai adicionar os dias de semana a semana
    public static void escolheDia(int selecao, ArrayList<Dia> ListaDias, Curso c) {
        boolean confirma;
        Dia d1 = new Dia();
        // tenho de ver de acordo com a data de inicio qual a próxima segunda
        //7 -> dias da semana 1,2...
        for (int i = 0; i < 7; i++) { // tem de ser 7 ou <=6
            // System.out.println(c.getDataInicio().getDayOfWeek().plus(i).getValue()); //devolve os dias da semana
            if (selecao == (c.getDataInicio().getDayOfWeek().plus(i).getValue())) {
                d1.setDia(c.getDataInicio().plusDays(i));
            }
        }
        //Escolher horas entre 9 e 18h
        System.out.print("   Escolha a hora de início (9-18): ");
        int horasIn = Ler.umInt();
        confirma = false;
        while (confirma != true) {
            if (horasIn < 9 || horasIn > 18) {
                System.out.println("   Hora não válida!");
                System.out.print("   Por favor introduza um novo valor: ");
                confirma = false;
                horasIn = Ler.umInt();
            } else {
                confirma = true;
            }
        }
        //Escolher horas entre 9 e 18h e condição em que a hora final tem de ser maior que a hora inicial
        System.out.print("   Escolha a hora do fim (9-18): ");
        int horasFinal = Ler.umInt();
        confirma = false;
        while (confirma != true) {
            if (horasFinal < 9 || horasFinal > 18) {
                System.out.println("   Hora não válida!");
                System.out.print("   Por favor introduza um novo valor: ");
                confirma = false;
                horasFinal = Ler.umInt();
            } else if (horasFinal <= horasIn) {
                System.out.println("   Hora não pode ser igual ou menor à hora inicial!");
                System.out.print("   Por favor introduza um novo valor: ");
                confirma = false;
                horasFinal = Ler.umInt();
            } else {
                confirma = true;
            }
        }
        // Criar ciclo em que faço a diferença de dias entre a data inicial e a final
        //Se o curso decorrer no mesmo ano
        if (c.getDataInicio().getYear() == c.getDataFim().getYear()) {
            // debug System.out.println(d1.getDia().getDayOfYear() + "," + c.getDataFim().getDayOfYear());
            for (int j = 0; j <= c.getDataFim().getDayOfYear() - d1.getDia().getDayOfYear(); j += 7) {
                //adiciona objetos "dia" de 7 em 7 dias
                ListaDias.add(new Dia(d1.getDia().plusDays(j), horasIn, horasFinal));
            }
        } else {
            //Se o curso decorrer entre dois anos (consecutivos)
            // numero de dias até ao fim do ano + dias até ao dia da data final
            for (int w = 0; w <= ((LocalDate.of(c.getDataInicio().getYear(), 12, 31).getDayOfYear() - d1.getDia().getDayOfYear()) + c.getDataFim().getDayOfYear()); w += 7) {
                //adiciona objetos "dia" de 7 em 7 dias
                ListaDias.add(new Dia(d1.getDia().plusDays(w), horasIn, horasFinal));
            }
        }
    }

    //usamos esta data para definir uma nova data ou de inicio ou fim, se for fim tem de ser o (curso c, 0, 0 ,0) 
    //e a data fim definirData(c, c.getDataInicio().getYear(), c.getDataInicio().getMonth().getValue(), c.getDataInicio().getDayOfMonth());
    public static void definirData(Curso c, int ano, int mes, int dia) {
        boolean confirma = false;
        boolean confirma2 = false;
        //Data fim
        if (ano == 0) {
            System.out.print("   Qual a data de inicio do curso? Introduza o ano: ");
        } else {
            System.out.print("   Qual a data de fim do curso? Introduza o ano: ");
        }
        int anof = Ler.umInt();
        //O ano tem de ser superior ou igual ao ano inicial
        while (confirma != true) {
            if (anof < ano) {
                System.out.println("   O ano do fim de curso não pode ser menor que o ano de início do curso!");
                System.out.print("   Por favor introduza um novo valor: ");
                confirma = false;
                anof = Ler.umInt();
            } else {
                confirma = true;
            }
        }
        //MES
        System.out.print("   Introduza o mês: ");
        int mesf = Ler.umInt();
        confirma = false;
        //Ver se o mes é valido
        while (confirma != true && confirma2 != true) {
            if (mesf < 1 || mesf > 12) {
                confirma = false;
            } else {
                confirma = true;
            }
            //O mes tem de ser superior ou igual ao ano inicial
            if (anof == ano && mesf < mes) {
                confirma2 = false;

            } else {
                confirma2 = true;
            }
            if (confirma == false) {

                confirma2 = false;
                System.out.println("   Mês não válido!");
                System.out.print("   Por favor introduza um novo valor: ");
                mesf = Ler.umInt();
            } else if (confirma == true && confirma2 == false) {
                confirma = false;
                System.out.println("   O mes do fim de curso não pode ser menor que o mes de início do curso!");
                System.out.print("   Por favor introduza um novo valor: ");
                mesf = Ler.umInt();
            }
        }
        System.out.print("   Introduza o dia: ");
        int diaf = Ler.umInt();
        //Ver se o dia é válido
        confirma = false;
        confirma2 = false;
        while (confirma != true && confirma2 != true) {

            //Meses com dia 31
            if (mesf == 1 || mesf == 3 || mesf == 5 || mesf == 7 || mesf == 8 || mesf == 10 || mesf == 12) {

                if (diaf < 1 || diaf > 31) {

                    confirma = false;

                } else {
                    confirma = true;
                }
            }
            //Meses com dia 30
            if (mesf == 4 || mesf == 6 || mesf == 9 || mesf == 11) {

                if (diaf < 1 || diaf > 30) {

                    confirma = false;

                } else {
                    confirma = true;
                }
            }
            //caso de fevereiro ano bissexto - 29 dias
            if (mesf == 2 && (anof % 400 == 0 || (anof % 4 == 0 && anof % 100 != 0))) {
                if (diaf < 1 || diaf > 29) {

                    confirma = false;

                } else {
                    confirma = true;
                }
            }
            if (mesf == 2 && !(anof % 400 == 0 || (anof % 4 == 0 && anof % 100 != 0))) {

                if (diaf < 1 || diaf > 28) {

                    confirma = false;

                } else {
                    confirma = true;
                }
            }
            //Caso o mes e ano sejam os mesmos, o dia tem de ser superior
            if (anof == ano && mesf == mes && diaf < dia) {

                confirma2 = false;

            } else {
                confirma2 = true;
            }
            if (confirma == false) {

                confirma2 = false;
                System.out.println("   Dia não válido!");
                System.out.print("   Por favor introduza um novo valor: ");
                diaf = Ler.umInt();
            } else if (confirma == true && confirma2 == false) {

                confirma = false;
                System.out.println("   O dia do fim de curso não pode ser menor que o dia de início do curso!");
                System.out.print("   Por favor introduza um novo valor: ");
                diaf = Ler.umInt();
            }
        }
        if (ano == 0) {
            c.setDataInicio(diaf, mesf, anof);
        } else {
            c.setDataFim(diaf, mesf, anof);
        }
    }

    // funcao para adicionar alunos a um determinado curso e verifica se esse professor ja nao tem agenda "cheia" nessa hora
    public static ArrayList adicionarAluno(ArrayList<Curso> Cursos, ArrayList<Aluno> Aluno, Curso c) {
        ArrayList<Aluno> ListaAluno = new ArrayList<>();
        ArrayList<Curso> tmpA ;
        int verifica1 = 0;
        System.out.print("   Escolha o número do aluno a adicionar ao curso: ");
        int Naluno = Ler.umInt();
        int contador = 0;
        //Temos que ver se o aluno está inscrito num curso que dê overlap de horas com outro
        while (Naluno != 0) {
            int verifica = 0; // verifica se o aluno ja foi adicionado
            for (Aluno aluns : ListaAluno) {
                if (Naluno == aluns.getNumA()) {
                    System.out.println("   O aluno já tinha sido adicionado!");
                    verifica = 1; // se ja foi marca a variavel como 1
                }
            }
            for (int i = 0; i < Aluno.size(); i++) {
                tmpA = new ArrayList<>(); // DAR reset a lista de cursos pois é temporaria
                if (Naluno == Aluno.get(i).getNumA()) {
                    verifica1 = 1;
                    //Tenho de ver os cursos em que o aluno está inscrito -> criar uma arrayList de curso?
                    //Para isso temos de fazer um corrimento da ArrayList dos Cursos            
                    for (int j = 0; j < Cursos.size(); j++) {
                        //Obter os curso que o aluno está inscrito para --->tmp   
                        for (int k = 0; k < Cursos.get(j).getListaA().size(); k++) {
                            if (Cursos.get(j).getListaA().get(k).getNumA() == Naluno) {
                                tmpA.add(Cursos.get(j)); //guarda o curso com este aluno la dentro
                            }
                        }
                    }

                    if (tmpA.size() > 0) {
                        //Ver se algum dia se interseta com os cursos do que o aluno está inscrito
                        for (int j = 0; j < tmpA.size(); j++) {

                            for (int k = 0; k < tmpA.get(j).getListaDias().size(); k++) {

                                for (int w = 0; w < c.getListaDias().size(); w++) { // curso que quer adicionar

                                    //Interseta os dias ( se os dias forem iguais entra para dentro do if)
//          debugging               System.out.println("ESTOU AQUI ::"+tmpA.get(j).getListaDias().get(k).getDia().compareTo(c.getListaDias().get(w).getDia()));
                                    if (tmpA.get(j).getListaDias().get(k).getDia().compareTo(c.getListaDias().get(w).getDia()) == 0) {
                                                // se os dias considirem vai ver as horas
                                        //Interseta as horas
//                  debugging           System.out.println(("k inicial " + tmpA.get(j).getListaDias().get(k).getHoraInicio() + "w final " + c.getListaDias().get(w).getHoraFim() + "k final " + tmpA.get(j).getListaDias().get(k).getHoraFim() + "w inical " + c.getListaDias().get(w).getHoraInicio()));
                                        if ((tmpA.get(j).getListaDias().get(k).getHoraInicio() <= c.getListaDias().get(w).getHoraFim() && tmpA.get(j).getListaDias().get(k).getHoraFim() >= c.getListaDias().get(w).getHoraInicio())) {
                                            contador++; // se incrementar quer dizer que houve intersecao de horas
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (contador != 0) {
                        System.out.println("   O aluno já se encontra inscrito num curso a essas horas!");
                        contador = 0;   // dar reset ao contador
                        
                    } else if (contador == 0 && verifica == 0) {

                        ListaAluno.add(Aluno.get(i));
                        System.out.println("   O aluno foi adicionado com sucesso!");
                    }
                }
 
            }
            if (verifica1 != 1) {
                System.out.println("   O aluno com esse número não existe!");
            }
            System.out.print("   Escolha um novo número de aluno, ou pressione 0 para sair: ");
            Naluno = Ler.umInt();

        }

        return ListaAluno;
    }

    // funcao para adicionar professores a um determinado curso e verifica se esse professor ja nao tem agenda "cheia" nessa hora
    public static ArrayList adicionarProfessor(ArrayList<Curso> Curso, ArrayList<Professor> Professor, Curso c) {
        int contador = 0;//resetar o contador e fazer o mesmo para o professor
        int verifica1 = 0;
        ArrayList<Curso> tmpP;
        ArrayList<Professor> ListaProfessor = new ArrayList<>();
        // Adicionar professor
        System.out.print("   Escolha o número do professor a adicionar ao curso: ");
        int Nprofessor = Ler.umInt();
        while (Nprofessor != 0) { //Temos que ver se o professor está inscrito num curso que dê overlap de horas com outro
            int verifica = 0; // verifica se o professor ja foi adicionado
            for (Professor profs : ListaProfessor) {
                if (Nprofessor == profs.getNumP()) {
                    System.out.println("   O professor já tinha sido adicionado!");
                    verifica = 1; // se ja foi marca a variavel como 1
                }
            }

            for (int i = 0; i < Professor.size(); i++) {
                tmpP = new ArrayList<>();
                if (Nprofessor == Professor.get(i).getNumP()) {
                    verifica1 = 1;
                    //Tenho de ver os cursos em que o prof está inscrito -> criar uma arrayList de curso -> tmp2
                    //Para isso temos de fazer um corrimento da ArrayList dos Cursos            
                    for (int j = 0; j < Curso.size(); j++) {

                        //Obter os curso que o professor está inscrito para --->tmp   
                        for (int k = 0; k < Curso.get(j).getListaP().size(); k++) {

                            if (Curso.get(j).getListaP().get(k).getNumP() == Nprofessor) {

                                tmpP.add(Curso.get(j));
                            }
                        }
                    }
                    // se ele estiver em mais que um curso vai verificar se o horario sobrepoem
                    if (tmpP.size() > 0) {

                        //Ver se algum dia se interseta com os cursos do que o aluno está inscrito
                        for (int j = 0; j < tmpP.size(); j++) {

                            for (int k = 0; k < tmpP.get(j).getListaDias().size(); k++) {

                                for (int w = 0; w < c.getListaDias().size(); w++) {

                                    //Interseta os dias
                                    if (tmpP.get(j).getListaDias().get(k).getDia().compareTo(c.getListaDias().get(w).getDia()) == 0) {

                                        //Interseta as horas
                                        if ((tmpP.get(j).getListaDias().get(k).getHoraInicio() <= c.getListaDias().get(w).getHoraFim() && tmpP.get(j).getListaDias().get(k).getHoraFim() >= c.getListaDias().get(w).getHoraInicio())) {
                                            contador++; // se incrementar quer dizer que houve intersecao de horas
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (contador == 0 && verifica == 0) {

                        ListaProfessor.add(Professor.get(i));
                        System.out.println("   O professor foi adicionado com sucesso!");
                    }
                    if (contador != 0) {
                        System.out.println("   O professor já se encontra a lecionar a essa hora!");
                        contador = 0;
                    }
                }
            }
            if (verifica1 != 1) {
                System.out.println("   O professor com esse número não existe!");
            }
            System.out.print("   Escolha um novo número de professor, ou pressione 0 para sair: ");
            Nprofessor = Ler.umInt();
        }
        return ListaProfessor;
    }

    //Insere um novo curso na arraylist
    public static void inserirCurso(ArrayList<Curso> Cursos, ArrayList<Aluno> Aluno, ArrayList<Professor> Professor) {
        System.out.print("   Qual o código do Curso: ");
        int cod = Ler.umInt();
        //Verifica se este código já existe
        for (int i = 0; i < Cursos.size(); i++) {
            if (Cursos.get(i).getCodigo() == cod) {
                System.out.println("   Já existe um curso com esse código!");
                return;
            }
        }

        //Obter dados do curso; instanciar o objeto Curso
        Curso c;
        ArrayList<Dia> ListaDias = new ArrayList<>();

        //Nome
        System.out.print("   Qual o nome do curso? ");
        String nome = Ler.umaString();
        c = new Curso(cod, nome);
        //Data Inicio
        definirData(c, 0, 0, 0);
        //Data Fim
        definirData(c, c.getDataInicio().getYear(), c.getDataInicio().getMonth().getValue(), c.getDataInicio().getDayOfMonth());

        ListaDias = menuDia(c);
        //Perguntar ao utilizador se quer adicionar alunos e professores
        System.out.print("   Quer adicionar alunos e professores? [s/n] ");
        String opcao = Ler.umaString();

        // Caso não, inserimos o código, nome, listaDias, e datas
        if (!opcao.equalsIgnoreCase("s")) {

            c.setListaDias(ListaDias);

        } else if (opcao.equalsIgnoreCase("s")) {
            c = new Curso(cod, nome);
            c.setListaDias(ListaDias);
            //cursos.get(i).setListaA(adicionarAluno(cursos, alunos, cursos.get(i))); 
            c.setListaP(adicionarProfessor(Cursos, Professor, c));
            c.setListaA(adicionarAluno(Cursos, Aluno, c));
        }
        // adicionar o novo curso à lista -----> não tem profs nem alunos
        Cursos.add(c);
        // atualizar ficheiro
        GerirCursos.guardarC(Cursos);

    }

    // Remover Curso
    public static void apagarCurso(ArrayList<Curso> Cursos) {

        System.out.print("   Qual o código do Curso que deseja apagar: ");
        int cod = Ler.umInt(); //pede o código do curso que quer remover
        int verifica = 0;
        for (int i = 0; i < Cursos.size(); i++) {
            if (Cursos.get(i).getCodigo() == cod) { // verifica se existe e se existir remove e guarda a atualização no ficheiro

                Cursos.remove(i);
                guardarC(Cursos);
                verifica = 2;
                System.out.println("   Curso removido com sucesso!");
            }
        }
        if (verifica == 0) {
            System.out.println("   Curso não exsite!");
        }

    }

    //Consulta curso
    public static void verificaCurso(ArrayList<Curso> Curso) {

        System.out.print("   Qual o nome do Curso: ");
        String nome = Ler.umaString();
        int verificacurso = 0;
        for (int i = 0; i < Curso.size(); i++) { // Percorre o arraylist a ver se encontra o curso

            if (Curso.get(i).getNome().equalsIgnoreCase(nome)) { // se encontrar o curso faz print dele

                System.out.println(Curso.get(i));
                verificacurso = 1;
            }
        }
        if (verificacurso != 1) {
            System.out.println("   O curso com o nome " + nome + " não existe!");
        }
    }

    // Lista todos os cursos
    public static void listarCursos(ArrayList<Curso> Curso) {
        for (int i = 0; i < Curso.size(); i++) {
            System.out.println(Curso.get(i));
            if (i > (-1)) {
                System.out.print("   Pressione uma tecla para continuar a visualizar mais cursos ou 'q / Q' para sair: ");
                String teste = Ler.umaString();
                if (teste.equalsIgnoreCase("q")) {
                    return;
                }
            }
        }
    }

    //alterar nome do curso 
    public static void alteraCurso(ArrayList<Curso> cursos, ArrayList<Aluno> alunos, ArrayList<Professor> professores) { ////////////
        int j;
        int verifica = 0;
        System.out.print("   Qual o código do curso que quer editar: "); //pergunta o nome do curso que quer alterar
        int codigo = Ler.umInt();

        for (int i = 0; i < cursos.size(); i++) { //Percorre e ve se encontra o nome do curso

            if (cursos.get(i).getCodigo() == codigo) {
                verifica = 1;
                do { // se encontrar imprime este painel em baixo
                    System.out.println("\n\n      ### Opções para Alterar ao curso ###   ");
                    System.out.println("   ==========================================");
                    System.out.println("   |     1 - Nome do Curso                  |");
                    System.out.println("   |     2 - Código do Curso                |");
                    System.out.println("   |     3 - Refazer Horário do Curso       |");
                    System.out.println("   |     4 - Adicionar Aluno                |");
                    System.out.println("   |     5 - Remover Aluno                  |");
                    System.out.println("   |     6 - Adicionar Professor            |");
                    System.out.println("   |     7 - Remover Professor              |");
                    System.out.println("   |     0 - Sair                           |");
                    System.out.println("   ==========================================\n");
                    System.out.print("   Qual a sua opção -> ");
                    j = Ler.umInt();
                    switch (j) {
                        case 0:
                            break;
                        default:
                            System.out.println("   Opção inválida!");
                            break;
                        case 1:
                            // Editar nome
                            System.out.print("   Introduza o novo nome: ");
                            cursos.get(i).setNome(Ler.umaString());
                            break;

                        case 2:
                            // Editar codigo
                            System.out.print("   Introduza o novo código: ");
                            cursos.get(i).setCodigo(Ler.umInt());
                            break;

                        case 3: // alterar horario ******************************************************************
                            // remover horas dum determinado dia
                            // adicionar horas num determinado dias
                            definirData(cursos.get(i), 0, 0, 0);
                            definirData(cursos.get(i), cursos.get(i).getDataInicio().getYear(), cursos.get(i).getDataInicio().getMonth().getValue(), cursos.get(i).getDataInicio().getDayOfMonth());
                            cursos.get(i).setListaDias(menuDia(cursos.get(i)));
                            break;

                        case 4://adicionar aluno
                            cursos.get(i).setListaA(adicionarAluno(cursos, alunos, cursos.get(i)));
                            break;

                        case 5:// remover aluno 
                            System.out.print("\n   Qual é o número do aluno que quer remover: ");
                            int rem = Ler.umInt();
                            // Procura o aluno na lista do curso e se tiver lá remove o!
                            for (int x = 0; x < cursos.get(i).getListaA().size(); x++) {
                                if (cursos.get(i).getListaA().get(x).getNumA() == rem) {
                                    cursos.get(i).getListaA().remove(x);
                                    System.out.println("   Aluno removido com sucesso!");
                                }
                            }
                            break;
                        case 6:// adicionar professor, tem o mesmo funcionamente do adicionar aluno mas simplesmente muda a listaA para listaP
                            cursos.get(i).setListaP(adicionarProfessor(cursos, professores, cursos.get(i)));
                            break;
                        case 7:// remover professor, tem o mesmo funcionamente do adicionar aluno mas simplesmente muda a listaA para listaP
                            System.out.print("\n   Qual é o número do professor que quer remover: ");
                            int rem1 = Ler.umInt();
                            int verificapr = 0;
                            for (int x = 0; x < cursos.get(i).getListaP().size(); x++) {
                                if (cursos.get(i).getListaP().get(x).getNumP() == rem1) {
                                    cursos.get(i).getListaP().remove(x);
                                    System.out.println("   Professor removido com sucesso!");
                                    verificapr = 1;
                                }
                            }
                            if (verificapr != 1) {
                                System.out.println("   Professor não encontrado!");
                            }
                            break;
                    }

                } while (j != 0);
                guardarC(cursos);
            }
        }
        if (verifica == 0) {
            System.out.println("   O nome do curso que quer alterar não existe!");
        }

    }

}
