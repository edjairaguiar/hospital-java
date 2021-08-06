package projetohospital;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.IOException;

public class FachadaHospital {

    Scanner ler = new Scanner(System.in);
    String opção;
    String opçãoAdm;
    String cPF;
    RegistroHospital bdhospital = new RegistroHospital();
    Agendamento agenda = new Agendamento();
    AtendimentoGreen atendimento1 = new AtendimentoGreen();
    AtendimentoYllw atendimento2 = new AtendimentoYllw();
    AtendimentoRed atendimento3 = new AtendimentoRed();
    Consulta cons = new Consulta();
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate date;

    @SuppressWarnings("empty-statement")
    public void menu() throws IOException {
        boolean continueLoop;
        do {
            System.out.println("\n\n\n\t\t\t\tL'HOSPITAL LOVELACE-TURING\n");
            System.out.println("---------------------------------------------");
            System.out.println("\t\tMENU PRINCIPAL");
            System.out.println("---------------------------------------------");
            System.out.println("Por favor, selecione uma opção: ");
            System.out.println("\t1 - Cadastro de Paciente");
            System.out.println("\t2 - Agendamento de Consulta");
            System.out.println("\t3 - Pronto Atendimento");
            System.out.println("\t4 - Área do Administrador");
            System.out.println("\t5 - Cancelamento de Consulta");
            System.out.println("\t0 - Sair");
            System.out.println("Opção: ");
            opção = ler.nextLine();
            switch (opção) {
                case "1": {
                    do {
                        try {
                            System.out.println("\n----------------------------------------------------");
                            System.out.println("\t\tCADASTRO DE PACIENTE");
                            System.out.println("----------------------------------------------------");
                            System.out.println("Digite o CPF do cliente: \t");
                            cPF = ler.nextLine();
                            if (cPF.length() != 11) {
                                throw new Exception();
                            };

                        } catch (Exception ex) {
                            System.out.println("\tERRO 0x1 (CPF Inválido). \n\n");
                            System.out.println("Retornando à tela de cadastro...\nPressione enter para continuar.\n");
                            System.in.read();
                            continueLoop = true;
                            //break;
                        }

                        continueLoop = false;
                    } while (continueLoop);

                    if (bdhospital.verificarRegistroPacientes(cPF)) {
                        System.out.println("\tERRO 0x2 (Paciente já cadastrado). ");
                        System.out.println("Retornando à tela...\nPressione enter para continuar.\n");
                        System.in.read();
                    } else {
                        String atividade;
                        String convenio;
                        String nome;
                        String bairro;
                        String cidade;
                        String cpf = cPF;
                        String dataNascimento;
                        String email;
                        String estado;
                        String estadoCivil;
                        String nomeDaMae;
                        int numero;
                        String rg;
                        String rua;
                        String sexo;
                        String telefone;

                        System.out.println("Nome: ");
                        nome = ler.nextLine();
                        System.out.println("Sexo (F/M)");
                        sexo = ler.nextLine();
                        System.out.println("RG: ");
                        rg = ler.nextLine();
                        System.out.println("Data de Nascimento (dd/mm/aaaa): ");
                        dataNascimento = ler.nextLine();
                        date = LocalDate.parse(dataNascimento, formatador);
                        System.out.println("Nome da mãe: ");
                        nomeDaMae = ler.nextLine();
                        System.out.println("Telefone: ");
                        telefone = ler.nextLine();
                        System.out.println("E-mail: ");
                        email = ler.nextLine();
                        System.out.println("Estado civil: ");
                        estadoCivil = ler.nextLine();
                        System.out.println("Ocupação: ");
                        atividade = ler.nextLine();
                        System.out.println("\n\t\tENDEREÇO");
                        System.out.println("Estado: ");
                        estado = ler.nextLine();
                        System.out.println("Cidade: ");
                        cidade = ler.nextLine();
                        System.out.println("Bairro: ");
                        bairro = ler.nextLine();
                        System.out.println("Rua: ");
                        rua = ler.nextLine();
                        System.out.println("Número: ");
                        numero = ler.nextInt();
                        System.out.println("\n\t\tCONVÊNIO");
                        System.out.println("\tSelecione o convênio: ");
                        System.out.println("1 - Central Unimed");
                        System.out.println("2 - Bradesco Saúde");
                        System.out.println("3 - Amil Saúde");
                        System.out.println("4 - Porto Seguro");
                        System.out.println("5 - Caixa Saúde");
                        System.out.println("6 - Interclínicas Saúde");
                        System.out.println("7 - Care Plus");
                        System.out.println("Opção: ");
                        int opção1 = ler.nextInt();

                        String c = null;

                        switch (opção1) {
                            case 1:
                                c = "Central Unimed";
                                break;
                            case 2:
                                c = "Bradesco Saúde";
                                break;
                            case 3:
                                c = "Amil Saúde";
                                break;
                            case 4:
                                c = "Porto Seguro";
                                break;
                            case 5:
                                c = "Caixa Saúde";
                                break;
                            case 6:
                                c = "Interclínicas Saúde";
                                break;
                            case 7:
                                c = "Care Plus";
                                break;
                        }

                        convenio = c;

                        Paciente p = new Paciente(atividade,
                                convenio,
                                nome,
                                bairro,
                                cidade,
                                cpf,
                                date,
                                email,
                                estado,
                                estadoCivil,
                                nomeDaMae,
                                numero,
                                rg,
                                rua,
                                sexo,
                                telefone);
                        bdhospital.registrar(p);

                        System.out.println("\t\nPaciente cadastrado com sucesso. Retornando ao menu... \nPressione enter para continuar.\n");
                        ler.nextLine();
                    }
                    break;
                }

                case "2": {
                    String nomeProf;
                    String especialidade;
                    String data;
                    int op;
                    System.out.println("\n----------------------------------------------------");
                    System.out.println("\t\tAGENDAMENTO DE CONSULTA");
                    System.out.println("----------------------------------------------------");
                    do {
                        System.out.println("Digite o CPF do cliente: \t");
                        cPF = ler.nextLine();
                        if (cPF.length() != 11) {
                            continueLoop = true;
                            System.out.println("\tERRO 0x1 (CPF Inválido). \n\n");
                            System.out.println("Retornando à tela de cadastro...\nPressione enter para continuar.\n");
                            System.in.read();
                        } else {
                            continueLoop = false;
                        }
                    } while (continueLoop);
                    cons.setCpfPac(cPF);
                    if (bdhospital.verificarRegistroPacientes(cPF)) {
                        System.out.println("\t\nMarcar consulta com: ");
                        System.out.println("1 - Fisioterapeuta");
                        System.out.println("2 - Médico");
                        op = ler.nextInt();
                        switch (op) {
                            case 1: {
                                agenda.selecionarEspecialista("Fisioterapeuta");
                                break;
                            }
                            case 2: {
                                agenda.selecionarEspecialista("Médico");
                                break;
                            }
                            default:
                                System.out.println("ERRO 0X10 (Opção inválida). \nRetornando ao menu...\nPressione enter para continuar.\n");
                                System.in.read();
                                break;
                        }
                        System.out.println("\tSelecione a especialidade: ");
                        agenda.mostrarEspecialidade();
                        especialidade = ler.nextLine();
                        System.out.println("\tSelecione o profissional de sua preferência: ");
                        agenda.mostrarFuncionarios(especialidade);
                        nomeProf = ler.nextLine();
                        System.out.println("\tDigite a data da consulta: ");
                        data = ler.nextLine();
                        date = LocalDate.parse(data, formatador);
                        cons.setNomeProf(nomeProf);
                        cons.setEspecialidade(especialidade);
                        cons.setDataC(date);
                        bdhospital.registrar(cons);
                        System.out.println("\tConsulta marcada com sucesso para o dia " + cons.getDataC());
                    } else {
                        System.out.println("\tERRO 0X9 (Paciente não cadastrado).");
                        System.out.println("Retornando à tela...\nPressione enter para continuar.\n");
                        System.in.read();
                    }

                    break;

                }
                case "3": {
                    String profissional;
                    String problema;
                    String nivel;
                    System.out.println("\n----------------------------------------------------");
                    System.out.println("\t\tPRONTO ATENDIMENTO");
                    System.out.println("----------------------------------------------------");
                    System.out.println("\tPor favor, escolha o problema do paciente: ");
                    atendimento1.mostrarProblemasMedicos();
                    System.out.println("\tOpção: ");
                    problema = ler.nextLine();
                    atendimento2.selecionarProblema(problema);
                    nivel = atendimento3.verificarNivelAtendimento();

                    switch (nivel) {
                        case "verde":
                            do {
                                System.out.println("Digite o CPF do cliente: \t");
                                cPF = ler.nextLine();
                                if (cPF.length() != 11) {
                                    continueLoop = true;
                                    System.out.println("\tERRO 0x1 (CPF Inválido). \n\n");
                                    System.out.println("Retornando à tela...\nPressione enter para continuar.\n");
                                    System.in.read();
                                } else {
                                    continueLoop = false;
                                }

                            } while (continueLoop);
                            if (!(bdhospital.verificarRegistroPacientes(cPF))) {
                                System.out.println("\tERRO 0x9 (Paciente não cadastrado). \n\n");
                                System.out.println("Retornando à tela...\nPressione enter para continuar.\n");
                                System.in.read();
                            } else {
                                System.out.println("Selecione o profissional que atenderá o paciente: ");
                                atendimento1.ProfissionalParaAtender();
                                System.out.println("Escolha o profissional: ");
                                profissional = ler.nextLine();
                                atendimento1.atender(profissional);
                            }//chamar metodos verdes
                            break;

                        case "amarelo":
                            do {
                                System.out.println("Digite o CPF do cliente: \t");
                                cPF = ler.nextLine();
                                if (cPF.length() != 11) {
                                    continueLoop = true;
                                    System.out.println("\tERRO 0x1 (CPF Inválido). \n\n");
                                    System.out.println("Retornando à tela de cadastro...\nPressione enter para continuar.\n");
                                    System.in.read();
                                } else {
                                    continueLoop = false;
                                }
                            } while (continueLoop);
                            if (!(bdhospital.verificarRegistroPacientes(cPF))) {
                                System.out.println("\tERRO 0x9 (Paciente não cadastrado). \n\n");
                                System.out.println("Retornando à tela...\nPressione enter para continuar.\n");
                                System.in.read();
                            } else {
                                System.out.println("Selecione o profissional que atenderá o paciente: ");
                                atendimento2.ProfissionalParaAtender();
                                System.out.println("Escolha o profissional: ");
                                profissional = ler.nextLine();
                                atendimento2.atender(profissional);
                            }
                            break;

                        case "vermelho":
                            System.out.println("Selecione o profissional que atenderá o paciente: ");
                            atendimento3.ProfissionalParaAtender();
                            System.out.println("Profissional: ");
                            profissional = ler.nextLine();
                            atendimento3.atender(profissional);
                            break;
                        default:
                            break;
                    }
                    break;
                }
                case "4": {
                    menuAdm();
                    break;
                }
                case "5": {
                    System.out.println("\n----------------------------------------------------");
                    System.out.println("\t\tDESMARCAR CONSULTA");
                    System.out.println("----------------------------------------------------");
                    do {
                        System.out.println("Digite o CPF do paciente que deseja desmarcar consulta: ");
                        cPF = ler.nextLine();
                        if (cPF.length() != 11) {
                            continueLoop = true;
                            System.out.println("\tERRO 0x1 (CPF Inválido). \n\n");
                            System.out.println("Retornando à tela...\nPressione enter para continuar.\n");
                            System.in.read();
                        } else {
                            continueLoop = false;
                        }
                    } while (continueLoop);

                    String x;
                    System.out.println("\nDeseja realmente desmarcar a consulta? (s/n)");
                    x = ler.nextLine();

                    if (x.equals("s")) {
                        bdhospital.remover(cPF);
                    } else {
                        System.out.println("Processo cancelado! \nRetornando à tela...\nPressione enter para continuar.\n");
                        System.in.read();
                        break;
                    }
                    break;
                }

                default:
                    System.out.println("Erro! tente novamente");
                    break;

            }
        } while (!"0".equals(opção));

    }

    public void menuAdm() throws IOException {
        boolean continueLoop;
        do {
            System.out.println("\n----------------------------------------------------");
            System.out.println("\t\tÁREA DO ADMNISTRADOR");
            System.out.println("----------------------------------------------------");
            System.out.println("Por favor, selecione uma opção: ");
            System.out.println("\t1 - Cadastrar Funcionário");
            System.out.println("\t2 - Desligar Funcionario");
            System.out.println("\t0 - Sair");
            System.out.println("Opção: ");
            opçãoAdm = ler.nextLine();
            switch (opçãoAdm) {
                case "1": {
                    String opçãoCadas;
                    do {
                        Medico m = null;
                        Enfermeiro enf;
                        Fisioterapeuta f;
                        System.out.println("\n----------------------------------------------------");
                        System.out.println("\t\tCADASTRO DE FUNCIONÁRIO");
                        System.out.println("----------------------------------------------------");
                        System.out.println("Por favor, selecione o tipo de funcionário: ");
                        System.out.println("\t1 - Médico");
                        System.out.println("\t2 - Fisioterapeuta");
                        System.out.println("\t3 - Enfermeiro(a)");
                        System.out.println("\t0 - Sair");
                        System.out.println("Opção: ");
                        opçãoCadas = ler.nextLine();

                        switch (opçãoCadas) {
                            case "1": {
                                System.out.println("\n----------------------------------------------------");
                                System.out.println("\t\tCADASTRO DE MÉDICOS");
                                System.out.println("----------------------------------------------------");
                                do {
                                    System.out.println("Entre com o CPF:");
                                    cPF = ler.nextLine();
                                    if (cPF.length() != 11) {
                                        continueLoop = true;
                                        System.out.println("\tERRO 0x1 (CPF Inválido). \n\n");
                                        System.out.println("Retornando à tela de cadastro...\nPressione enter para continuar.\n");
                                        System.in.read();
                                    } else {
                                        continueLoop = false;
                                    }
                                } while (continueLoop);

                                if (bdhospital.verificarRegistroMedicos(cPF)) {
                                    System.out.println("\tERRO 0x3 (Médico já cadastrado). \n\n");
                                    System.out.println("Retornando à tela de cadastro...\nPressione enter para continuar.\n");
                                    System.in.read();
                                } else {
                                    String especialidade;
                                    int crm;
                                    boolean plantao;
                                    String nome;
                                    String bairro;
                                    String cidade;
                                    String cpf = cPF;
                                    String dataNascimento;
                                    String email;
                                    String estado;
                                    String estadoCivil;
                                    String nomeDaMae;
                                    int numero;
                                    String rg;
                                    String rua;
                                    String sexo;
                                    String telefone;

                                    System.out.println("Nome: ");
                                    nome = ler.nextLine();
                                    System.out.println("Sexo (F/M): ");
                                    sexo = ler.nextLine();
                                    System.out.println("RG: ");
                                    rg = ler.nextLine();
                                    System.out.println("Data de Nascimento: ");
                                    dataNascimento = ler.nextLine();
                                    date = LocalDate.parse(dataNascimento, formatador);
                                    System.out.println("Nome da mãe: ");
                                    nomeDaMae = ler.nextLine();
                                    System.out.println("Telefone: ");
                                    telefone = ler.nextLine();
                                    System.out.println("Email: ");
                                    email = ler.nextLine();
                                    System.out.println("Estado civil: ");
                                    estadoCivil = ler.nextLine();
                                    System.out.println("\n\t\tENDEREÇO");
                                    System.out.println("Estado: ");
                                    estado = ler.nextLine();
                                    System.out.println("Cidade: ");
                                    cidade = ler.nextLine();
                                    System.out.println("Bairro: ");
                                    bairro = ler.nextLine();
                                    System.out.println("Rua: ");
                                    rua = ler.nextLine();
                                    System.out.println("Número: ");
                                    numero = ler.nextInt();
                                    System.out.println("\n\t\tPROFISSIONAL");
                                    System.out.println("CRM: ");
                                    crm = ler.nextInt();
                                    System.out.println("Especialidade: ");
                                    especialidade = ler.nextLine();
                                    System.out.println("Atendimento Geral/Plantão: ");
                                    plantao = ler.nextBoolean();

                                    Medico med = new Medico(
                                            especialidade,
                                            crm,
                                            plantao,
                                            nome,
                                            bairro,
                                            cidade,
                                            cpf,
                                            date,
                                            email,
                                            estado,
                                            estadoCivil,
                                            nomeDaMae,
                                            numero,
                                            rg,
                                            rua,
                                            sexo,
                                            telefone);
                                }
                                break;
                            }
                            case "2": {
                                System.out.println("\n----------------------------------------------------");
                                System.out.println("\t\tCADASTRO DE FISIOTERAPEUTA");
                                System.out.println("----------------------------------------------------");
                                do {
                                    System.out.println("Entre com o CPF:");
                                    cPF = ler.nextLine();
                                    if (cPF.length() != 11) {
                                        continueLoop = true;
                                        System.out.println("\tERRO 0x1 (CPF Inválido). \n\n");
                                        System.out.println("Retornando à tela de cadastro...\nPressione enter para continuar.\n");
                                        System.in.read();
                                    } else {
                                        continueLoop = false;
                                    }
                                } while (continueLoop);

                                if (bdhospital.verificarRegistroFisio(cPF)) {
                                    System.out.println("\tERRO 0x4 (Fisioterapeuta já cadastrado). \n\n");
                                    System.out.println("Retornando à tela de cadastro...\nPressione enter para continuar.\n");
                                    System.in.read();
                                } else {
                                    String especialidade;
                                    String nome;
                                    String bairro;
                                    String cidade;
                                    String cpf = cPF;
                                    String dataNascimento;
                                    String email;
                                    String estado;
                                    String estadoCivil;
                                    String nomeDaMae;
                                    int numero;
                                    String rg;
                                    String rua;
                                    String sexo;
                                    String telefone;

                                    System.out.println("Nome: ");
                                    nome = ler.nextLine();
                                    System.out.println("Sexo (F/M): ");
                                    sexo = ler.nextLine();
                                    System.out.println("RG: ");
                                    rg = ler.nextLine();
                                    System.out.println("Data de Nascimento: ");
                                    dataNascimento = ler.nextLine();
                                    date = LocalDate.parse(dataNascimento, formatador);
                                    System.out.println("Nome da mãe: ");
                                    nomeDaMae = ler.nextLine();
                                    System.out.println("Telefone: ");
                                    telefone = ler.nextLine();
                                    System.out.println("Email: ");
                                    email = ler.nextLine();
                                    System.out.println("Estado civil: ");
                                    estadoCivil = ler.nextLine();
                                    System.out.println("\n\t\tENDEREÇO");
                                    System.out.println("Estado: ");
                                    estado = ler.nextLine();
                                    System.out.println("Cidade: ");
                                    cidade = ler.nextLine();
                                    System.out.println("Bairro: ");
                                    bairro = ler.nextLine();
                                    System.out.println("Rua: ");
                                    rua = ler.nextLine();
                                    System.out.println("Número: ");
                                    numero = ler.nextInt();
                                    System.out.println("\n\t\tPROFISSIONAL");
                                    System.out.println("Especialidade: ");
                                    especialidade = ler.nextLine();
                                    System.in.read();

                                    Fisioterapeuta fisio = new Fisioterapeuta(especialidade,
                                            nome,
                                            bairro,
                                            cidade,
                                            cpf,
                                            date,
                                            email,
                                            estado,
                                            estadoCivil,
                                            nomeDaMae,
                                            numero,
                                            rg,
                                            rua,
                                            sexo,
                                            telefone);
                                }
                                break;
                            }
                            case "3": {
                                System.out.println("\n----------------------------------------------------");
                                System.out.println("\t\tCADASTRO DE ENFERMEIRO");
                                System.out.println("----------------------------------------------------");
                                do {
                                    System.out.println("Entre com o CPF:");
                                    cPF = ler.nextLine();
                                    if (cPF.length() != 11) {
                                        continueLoop = true;
                                        System.out.println("\tERRO 0x1 (CPF Inválido). \n\n");
                                        System.out.println("Retornando à tela de cadastro...\nPressione enter para continuar.\n");
                                        System.in.read();
                                    } else {
                                        continueLoop = false;
                                    }
                                } while (continueLoop);

                                if (bdhospital.verificarRegistroEnfermeiros(cPF)) {
                                    System.out.println("\tERRO 0x5 (Enfermeiro já cadastrado). \n\n");
                                    System.out.println("Retornando à tela de cadastro...\nPressione enter para continuar.\n");
                                    System.in.read();
                                } else {
                                    boolean plantao;
                                    int cre;
                                    String nome;
                                    String bairro;
                                    String cidade;
                                    String cpf = cPF;
                                    String dataNascimento;
                                    String email;
                                    String estado;
                                    String estadoCivil;
                                    String nomeDaMae;
                                    int numero;
                                    String rg;
                                    String rua;
                                    String sexo;
                                    String telefone;

                                    System.out.println("Nome: ");
                                    nome = ler.nextLine();
                                    System.out.println("Sexo (F/M): ");
                                    sexo = ler.nextLine();
                                    System.out.println("RG: ");
                                    rg = ler.nextLine();
                                    System.out.println("Data de Nascimento: ");
                                    dataNascimento = ler.nextLine();
                                    date = LocalDate.parse(dataNascimento, formatador);
                                    System.out.println("Nome da mãe: ");
                                    nomeDaMae = ler.nextLine();
                                    System.out.println("Telefone: ");
                                    telefone = ler.nextLine();
                                    System.out.println("Email: ");
                                    email = ler.nextLine();
                                    System.out.println("Estado civil: ");
                                    estadoCivil = ler.nextLine();
                                    System.out.println("\n\t\tENDEREÇO");
                                    System.out.println("Estado: ");
                                    estado = ler.nextLine();
                                    System.out.println("Cidade: ");
                                    cidade = ler.nextLine();
                                    System.out.println("Bairro: ");
                                    bairro = ler.nextLine();
                                    System.out.println("Rua: ");
                                    rua = ler.nextLine();
                                    System.out.println("Número: ");
                                    numero = ler.nextInt();
                                    System.out.println("\n\t\tPROFISSIONAL");
                                    System.out.println("CRE: ");
                                    cre = ler.nextInt();
                                    System.out.println("Atendimento Geral/Plantão: ");
                                    plantao = ler.nextBoolean();

                                    Enfermeiro enfer = new Enfermeiro(
                                            plantao,
                                            cre,
                                            nome,
                                            bairro,
                                            cidade,
                                            cpf,
                                            date,
                                            email,
                                            estado,
                                            estadoCivil,
                                            nomeDaMae,
                                            numero,
                                            rg,
                                            rua,
                                            sexo,
                                            telefone);
                                }
                                break;
                            }
                        }
                    } while (!"0".equals(opçãoCadas));
                    break;
                }
                
                case "2": {
                    String opçãoDesl;
                    do {
                        Medico m = null;
                        Enfermeiro enf;
                        Fisioterapeuta f;
                        System.out.println("\n----------------------------------------------------");
                        System.out.println("\t\tDESLIGAMENTO DE FUNCIONÁRIO");
                        System.out.println("----------------------------------------------------");
                        System.out.println("Por favor, selecione o tipo de funcionário: ");
                        System.out.println("1 - Médico");
                        System.out.println("2 - Fisioterapeuta");
                        System.out.println("3 - Enfermeiro");
                        System.out.println("0 - Sair");
                        System.out.println("Opção: ");
                        opçãoDesl = ler.nextLine();

                        switch (opçãoDesl) {
                            case "1": {
                                do {
                                    System.out.println("Entre com o CPF do profissional a ser desligado:");
                                    cPF = ler.nextLine();
                                    if (cPF.length() != 11) {
                                        continueLoop = true;
                                        System.out.println("\tERRO 0x1 (CPF Inválido). \n\n");
                                        System.out.println("Retornando à tela...\nPressione enter para continuar.\n");
                                        System.in.read();
                                    } else {
                                        continueLoop = false;
                                    }
                                } while (continueLoop);

                                if (bdhospital.verificarRegistroMedicos(cPF)) {
                                    if (bdhospital.verificarRegistroMedicos(cPF)) {
                                        int index = 0;
                                        for (int i = 0; i < bdhospital.registroMedicos.size(); i++) {
                                            if (bdhospital.registroMedicos.get(i).cpf.equals(cPF)) {
                                                index = i;

                                            }
                                            bdhospital.registroMedicos.remove(index);

                                        }
                                    }
                                } else {
                                    System.out.println("\tERRO 0x6 (Médico não encontrado). \n\n");
                                    System.out.println("Retornando à tela...\nPressione enter para continuar.\n");
                                    System.in.read();
                                }
                                break;
                            }

                            case "2": {
                                System.out.println("Entre com o CPF do profissional a ser desligado:");
                                cPF = ler.nextLine();
                                do {
                                    if (cPF.length() != 11) {
                                        continueLoop = true;
                                        System.out.println("\tERRO 0x1 (CPF Inválido). \n\n");
                                        System.out.println("Retornando à tela...\nPressione enter para continuar.\n");
                                        System.in.read();
                                    } else {
                                        continueLoop = false;
                                    }
                                } while (continueLoop);
                                if (bdhospital.verificarRegistroFisio(cPF)) {
                                    if (bdhospital.verificarRegistroFisio(cPF)) {
                                        int index = 0;
                                        for (int i = 0; i < bdhospital.registroFisioterapeutas.size(); i++) {
                                            if (bdhospital.registroFisioterapeutas.get(i).cpf.equals(cPF)) {
                                                index = i;
                                            }

                                        }
                                        bdhospital.registroFisioterapeutas.remove(index);
                                    }
                                } else {
                                    System.out.println("\tERRO 0x7 (Fisioterapeuta não encontrado). \n\n");
                                    System.out.println("Retornando à tela...\nPressione enter para continuar.\n");
                                    System.in.read();
                                }
                                break;
                            }
                            case "3": {
                                do {
                                    System.out.println("Entre com o CPF do profissional a ser desligado:");
                                    cPF = ler.nextLine();
                                    if (cPF.length() != 11) {
                                        continueLoop = true;
                                        System.out.println("\tERRO 0x1 (CPF Inválido). \n\n");
                                        System.out.println("Retornando à tela...\nPressione enter para continuar.\n");
                                        System.in.read();
                                    } else {
                                        continueLoop = false;
                                    }
                                } while (continueLoop);
                                if (bdhospital.verificarRegistroEnfermeiros(cPF)) {
                                    int index = 0;
                                    for (int i = 0; i < bdhospital.registroEnfermeiros.size(); i++) {
                                        if (bdhospital.registroEnfermeiros.get(i).cpf.equals(cPF)) {
                                            index = i;

                                        }
                                    }
                                    bdhospital.registroEnfermeiros.remove(index);

                                } else {
                                    System.out.println("\tERRO 0x8 (Enfermeiro não encontrado). \n\n");
                                    System.out.println("Retornando à tela...\nPressione enter para continuar.\n");
                                    System.in.read();
                                }
                                break;
                            }
                            default:
                                System.out.println("\nERRO 0X11 (Opção Inválida)");
                            break;
                            
                        }
                    } while (!"0".equals(opçãoDesl));
                break;
                }
                default:
                    System.out.println("\nERRO 0X11 (Opção Inválida)");
                    System.out.println("Retornando à tela...\nPressione enter para continuar.\n");
                    System.in.read();
                    break;
            }
        } while (!"0".equals(opçãoAdm));

    }

}
