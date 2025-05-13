# Sudoku

Projeto simples em Java que implementa o jogo Sudoku no terminal. Permite que o usuário resolva um tabuleiro de Sudoku com validações para garantir que os números inseridos respeitem as regras do jogo.

## Estrutura

* **Sudoku**: classe principal, responsável pela lógica do jogo.
* **Tabuleiro**: representação do tabuleiro de 9x9, onde são armazenados os números e as posições fixas.

## Funcionalidades

* Exibir o tabuleiro de Sudoku no terminal.
* Permitir que o usuário insira números nas posições vazias.
* Validar as entradas de acordo com as regras do Sudoku (linha, coluna e bloco 3x3).
* Impedir alterações em números fixos (preenchidos inicialmente).
* Sair do jogo a qualquer momento.

## Exemplo de uso

Ao executar `Sudoku.java`, o programa:

1. Exibe um tabuleiro de Sudoku com alguns números já preenchidos.
2. Permite ao usuário inserir valores nas posições vazias.
3. Valida se a jogada está correta e mostra o tabuleiro atualizado.
4. O usuário pode sair a qualquer momento digitando `sair`.

### Exemplo de entrada:

```
0,0,4
1,1,7
5,6,9
sair
```

### Saída esperada:

O tabuleiro será exibido após cada jogada. Exemplo de tabuleiro:

```
   0 1 2 3 4 5 6 7 8
0  4 . . . . . . . .
1  7 . . . . . . . .
2  . . 9 . . . . . .
3  5 . . . . . . . .
4  8 . . . . . . . .
5  6 . 9 . . . . . .
6  . . . . . . . . .
7  3 . . . . . . . .
8  1 . . . . . . . .
```

Após a entrada do usuário, o tabuleiro será atualizado e validado.

## Como rodar

1. Crie uma pasta chamada `sudoku`.
2. Salve o código em um arquivo `Sudoku.java` dentro da pasta.
3. Compile e execute com:

   ```bash
   javac sudoku/Sudoku.java
   java sudoku.Sudoku
   ```

## Saída esperada

Após o usuário inserir as jogadas, a saída será algo como:

```java
\=== Tabuleiro Atual ===
0 1 2 3 4 5 6 7 8
4 . . . . . . . .
7 . . . . . . . .
. . 9 . . . . . .
5 . . . . . . . .
8 . . . . . . . .
6 . 9 . . . . . .
. . . . . . . . .
3 . . . . . . . .
1 . . . . . . . .
```

## Tecnologias utilizadas

* Java 8+
* Programação orientada a objetos
* Validação de Sudoku (linhas, colunas e blocos 3x3)
  
