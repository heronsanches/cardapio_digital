 
 <h1>Instruções</h1>
 <h2> Requisitos de configuração do sistema</h2>
 --Apache TomCat v7<br>
 --JAVA v1.6 ou 1.7<br>
 --Banco de Dados Mysql 5.5.35<br>
 
 <h2> Utilização do Banco de Dados na aplicação</h2>
 --Criar banco de dados mysql com o nome "cardapio_digital"<br>
 --Executar script para criar tabelas do banco de dados <a href="https://github.com/heronsanches/cardapio_digital/blob/master/doc/database.sql"> database.sql</a><br>
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
 <h2><a href="https://github.com/heronsanches/cardapio_digital/blob/master/doc/Documentocasodeuso.pdf?raw=true">Documento de caso de uso </a></h2>
