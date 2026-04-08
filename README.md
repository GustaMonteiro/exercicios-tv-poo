# Simulador de TVs

Exemplo de implementação de uma lista de exercícios para a disciplina de **Programação Orientada a Objetos (POO)**. O projeto simula um sistema de televisores controlados por um controle remoto universal.

## Sobre o projeto

O sistema modela diferentes tipos de televisores, cada um com sua própria lógica de cadastro de canais, e um controle remoto capaz de gerenciar múltiplos aparelhos simultaneamente.

### Conceitos de POO abordados

- **Herança** — `SmartTV` e `TVHD` estendem a classe abstrata `Televisao`
- **Classes abstratas e métodos abstratos** — `Televisao` define o contrato `cadastrarCanais()`
- **Polimorfismo** — cada subclasse implementa `cadastrarCanais()` de forma diferente
- **Encapsulamento** — atributos privados acessados via getters/setters

## Classes

| Classe | Descrição |
|---|---|
| `Televisao` | Classe abstrata base. Gerencia volume, canal atual e navegação entre canais. |
| `SmartTV` | Estende `Televisao`. Cadastra todos os canais disponíveis. Possui atributo de tamanho em polegadas. |
| `TVHD` | Estende `Televisao`. Cadastra apenas canais em HD. Possui atributo de modelo do display. |
| `Canal` | Representa um canal com número, nome e flag de qualidade (HD/SD). |
| `ControleRemoto` | Agrega múltiplos televisores e propaga comandos de volume e troca de canal. |
| `App` | Ponto de entrada. Inicializa os televisores e exibe um menu interativo. |

## Estrutura de pastas

```
src/   → código-fonte Java
bin/   → arquivos compilados (gerados automaticamente)
lib/   → dependências externas
```

## Como executar

### VS Code

Abra o projeto no VS Code com a extensão **Extension Pack for Java** instalada e execute a classe `App`.

### Terminal

```bash
# Compilar
javac -d bin $(find src -name "*.java")

# Executar
java -cp bin App
```

## Comportamento ao executar

O programa inicializa 4 televisores (2 `SmartTV` e 2 `TVHD`) com canais sorteados aleatoriamente e exibe um menu interativo:

```
1 - Aumentar volume
2 - Diminuir volume
3 - Próximo canal
4 - Voltar canal
5 - Mostrar informações básicas
6 - Mostrar informações completas
0 - Sair
```

Cada comando é propagado simultaneamente para todos os televisores gerenciados pelo `ControleRemoto`. O volume varia de `0` a `10` e a navegação entre canais é circular.
