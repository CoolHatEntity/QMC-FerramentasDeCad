# Quine-McCluskey - Ferramentas de CAD 
&middot; ![GitHub top language](https://img.shields.io/github/languages/top/CoolHatEntity/QMC-FerramentasDeCad) ![Repo Size](https://img.shields.io/github/languages/code-size/CoolHatEntity/QMC-FerramentasDeCad) ![License](https://img.shields.io/github/license/CoolHatEntity/QMC-FerramentasDeCad)
## Sobre o projeto
### 1. Introdução
Este projeto foi criado para o trabalho final de minha matéria de Ferramentas de CAD, o trabalho pediu para que seja feita a implementação
do algoritmo de Quine-McCluskey, um algoritimo para simplificação de álgebra booleana. <br />
O algoritmo de Quine-McCluskey, possui uma funcionalidade análoga á do mapeamento de Karnaugh, porém sua forma
tabular o torna mais eficiente para aplicações em algoritmos de computadores, sendo assim útil para
Ferramentas de CAD. O algoritmo em si possui dois passos principais:
1. Encontrar todos os prime implicants da função dada.
2. Os usar para encontrar os prime implicants essenciais e todos aqueles que serão necessários, para completar o que falta da função
### 2. Partes do projeto
O projeto possui vários métodos e classes que contribuem para o resultado final, porém deles alguns se mostram mais relevantes, sendo eles:
1. Classe ```StringUtil```, ela é responsável pelos métodos que lidam com String do projeto, como ```fillString()```, usada para fins estéticos, ```replaceChar()``` que 
participa do processo de otimização ao devolver o binário que representa a combinação de dois minitermos, ou ```diffString()``` que verifica a diferença entre as Strings dadas.
2. ```getPrime()``` ele obtém os Prime Implicants essenciais
3. ```groupTermos()``` realiza o processo de otimização
4. ```findCoverage()``` obtém a cobertura de uma dada lista de minitermos

## Getting Started

Seguindo os passos a seguir, será possível poder executar o projeto em sua máquina, assim podendo o executar e testar sua funcionalidade

### Compilando a partir da fonte

1. Faça uma cópia do repositório:
   ```sh
   git clone https://github.com/CoolHatEntity/QMC-FerramentasDeCad.git
   ```
2. Navegue até onde a cópia do repositório foi feita
3. Navegue até cd ```src\com```
   ```shell
   cd src\com
   ```
4. Compile o código
   ```shell
   javac -classpath . executavel/Main.java util/StringUtil.java util/Termo.java util/TermoUtil.java
   ```
### Usando uma versão já compilada
Basta executar a release mais recente por terminal
  ```shell
   java -jar QMC_FerramentasCAD.jar
   ```
## Licença

Distribuído sobre a licença GNU Affero General Public License v3.0.


## Meios de contato

Para poder me contatar, use este e-mail [matheus17menezes@gmail.com](mailto:matheus17menezes@gmail.com).

