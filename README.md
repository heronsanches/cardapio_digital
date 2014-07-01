 
 
Universidade	Federal	da	Bahia		
Instituto de Matemática 
Departamento de Ciência da Computação 
MAT A63 – Engenharia de Software II 
Professora Rita Suzana Pitangueira Maciel 
 
 
 
 
 
A. Objetivo do Trabalho: Especificar e desenvolver um projeto 
de software em acordo com os requisitos. 
B. Data Entrega: 3 de julho 
C. O que deve ser entregue: O documento (impresso e pdf) e a 
implementação de cinco requisitos 
D. Formato do Documento 
 
1. Objetivo do Documento 
 
Este documento apresenta as principais características e lista os requisitos de alto-nível 
do sistema Projeto X. Estas informações foram acordadas entre os principais 
patrocinadores do projeto e assume-se que serão de conhecimento de qualquer 
participante do mesmo. 
2. Contextualização do Sistema 
<Apresente aqui as principais características do sistema que será desenvolvido. 
Se o desenvolvimento caracterizar uma evolução de outro sistema, apresente as 
funcionalidades que serão incluídas e alteradas com relação ao sistema 
original.> 
Descrição	do	Problema	
Esta seção descreve de maneira geral o problema identificado pelo usuário. 
Observe que o problema é anterior à necessidade do sistema, logo o problema 
deve ser descrito em sua origem, não fazendo menção à solução encontrada. Este 
capítulo não pode ser removido, nem tampouco pode ser informada a expressão 
“Não se aplica”.] 
 
Caracterização dos Usuários do Sistema 
 
<Esta seção deve descrever a perspectiva dos usuários do sistema, 
caracterizando estes usuários e apresentando a forma como o 
sistema será utilizado por eles.><Quem são os potenciais usuários do 
sistema? Que tipo de trabalho eles realizam?> 
 
3.Funcionalidades do Sistema (30, sendo que 15 não CRUD) 
 
Descreva aqui em geral como será a sua solução (o sistema) para o 
contexto descrito no item anterior. 
 
a)Requisitos Funcionais de Sistema  
 
Um															UUniversidade	Federal	da	Bahia		
Instituto de Matemática 
Departamento de Ciência da Computação 
MAT A63 – Engenharia de Software II 
Professora Rita Suzana Pitangueira Maciel 
 
 
 
 
 
Elencar e fazer uma descrição rápida 
b)Requisitos Não Funcionais 
Elencar e fazer uma descrição rápida 
 
4.Especificação dos Requisitos – Diagramas UM 
 
Diagrama de Caso de Uso (por visão) 
Diagrama de Atividades para cada Visão 
Modelo Conceitual (Digrama de Classes) 
Diagrama de Sequencia Nível Elementar para cada caso de uso. 
Modelo Arquitetura (3 camadas, Diagrama de Pacotes) 
 
5.Tabela para Documentação de para cada requisitos do usuário 
Modelo e Exemplo. 
 
 
 
 
 
 
 
Exemplo: Documentação do Caso de Uso Abertura de Conta 
Comum 
 
 
Nome do Caso de Uso 
Caso de Uso Geral 
Ator Principal 
Atores Secundários 
Resumo 
Pré-Condições 
Pos-Condições 
Ações do Ator Ações do Sistema 
 
 
 
Restrições/Validações  
 
Um															UUniversidade	Federal	da	Bahia		
Instituto de Matemática 
Departamento de Ciência da Computação 
MAT A63 – Engenharia de Software II 
Professora Rita Suzana Pitangueira Maciel 
 
 
 
 
 
 
Nome do Caso de Uso Abertura Conta Comum 
Caso de Uso Geral 
Ator Principal Cliente 
Atores Secundários Funcionário 
Resumo Este caso de uso descreve as etapas percorridas por 
um cliente para abrir uma conta corrente comum 
Pré-Condições O pedido de abertura precisa ser aprovado 
Pos-Condições Conta aberta com saldo maior que zero 
Ações do Ator Ações do Sistema 
1. Solicitar Abertura de 
conta 
 
 2. Consultar cliente por seu CPF ou CPNJ 
 3. Se for necessário, gravar ou atualizar o cadastro do 
cliente. Se o cliente não possuir outras contas deve ser 
registrado como inativo 
 4. Avaliar o pedido do cliente 
 5. Aprovar o pedido 
6. Escolher a senha da 
conta 
 
 7. Abrir conta 
 8. Definir cliente como ativo 
9. Fornecer valor a ser 
depositado 
 
 10. Registrar depósito 
 11. Emitir cartão da conta 
Restrições/Validações 1. Para abrir uma conta corrente é preciso ser maior de 
idade 
3. O valor mínimo de depósito inicial é de R$ 5,00 
