# PROJETO TO-DO LIST EM JAVA - ACC ZG
<br/>

Esse é um projeto do programa Acelera ZG 6.0, aonde foi necessário criar uma TO-DO LIST em java utilização de frameworks.
Minha visão com o projeto foi construir soluções simples e funcionais, porém ainda com grande margem de melhora, que irá acontecer ao aprofundar os meus conhecimentos no tema.

<br/>


## Tecnologias utilizadas:
Java 8.8.0.17
<br/>

<br/>


## Instruções para rodar o projeto

1) Primeiramente, clone o projeto através do comando 

````bash
git clone git@github.com:vhprestes/TODO-List.git
````

Então: 
2) Certifique-se de estar no diretório correto
**/to-do

3) Aqui o diretório bin será criado para armazenar o arquivo compilado:

````bash
mkdir -p bin
````
4) Compilar o Java :

````bash
javac -d bin src/main/java/org/interfaces/*.java src/main/java/org/todo/*.java
````

5) Antes de rodar o projeto, é necessário mudar o endereço hardcoded na linha 26 para a localização do arquivo file.txt no seu computador. Esse arquivo pode ser um txt em branco, mas no clone ja vai um exemplo

6) Rode o comando para executar a aplicação:
````bash
java -cp bin org.todo.Main
````
