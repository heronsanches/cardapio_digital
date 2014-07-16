 <h1> Trabalho de Engenharia de Software II - Implementação de Casos de Uso </h1>
 
 
 <h1>Instruções</h1>
 <h2> Requisitos de configuração do sistema</h2>
 --Apache TomCat v7<br>
 --JAVA v1.6 ou 1.7<br>
 --Banco de Dados Mysql 5.5.35<br>
 
 <h2> Utilização do Banco de Dados na aplicação</h2>
 --Criar banco de dados mysql com o nome "cardapio_digital"<br>
 --Executar script para criar tabelas do banco de dados <a href="https://github.com/heronsanches/cardapio_digital/blob/master/doc/database.sql"> database.sql</a><br>
 OBS.: No momento, este script não cria todas as tabela que são necessárias para a implementação dos 30 casos de uso.<br>
 --Setar atributos na classe <a href="https://github.com/heronsanches/cardapio_digital/blob/master/cardapio_digital/src/org/eng2/model/DataBase.java">DataBase.java</a><br>
 --Atributos:<br>
````java
private static DataBase db = null;
private static String user = "root"; 
private static String password = ""; //senha do banco de dados mysql
private static String url = "jdbc:mysql://localhost/cardapio_digital";
private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
````
 <br>
 <h3><a href="https://github.com/heronsanches/cardapio_digital/blob/master/doc/Documentocasodeuso.pdf?raw=true">Documento de caso de uso, clique aqui </a></h3>
 
 <h2>Dicas para o trabalho</h2>
 --Caso tenha dificuldade de utilizar o git, você pode fazer o download do projeto clicando no botão "Download ZIP,"<br>
 localizado no sidebar do lado direito da página inicial.
 --Caso não exista a tabela no banco de dados para a funcionalidade que você irá implementar, pode-se criar a tabela e os devidos relacionamentos para tal.<br>
 --Caso necessite de um valor de um campo de uma tabela, na qual não exista view no sistema para populá-la você pode inserir <br>
 manualmente tais valores no banco de dados, por exemplo, uma tabela que tem relação de depêndencia de chave estrangeira.<br>
 E a partir daí fazer suas implementações e testes!<br>
