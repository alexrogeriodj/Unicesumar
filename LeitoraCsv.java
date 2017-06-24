/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**Aqui é declarado as Strings do leitor de CSV e os objetos de  Importações de bibliotecas, 
 * que serão utilizadas, 
 * para referência do documento  EmpresaCSV, referente á empresa ou seja sua entidade, 
 * bem como os objetos que receberão
 * as informações a serem recebidas e enviadas, os objetos foram separadas conforme
 * os códigos referenciados, também o mesmo receberá um ArrayList que carregaráos
 * objetos selecionados, onde busca no CSV Empresa  e CNAE as informações cadastradas 
 * e que são armazenadas e nas telas da aplicação criada Empresa.java e Cnae.java
 * referenciadas no documento.
 *
 * @author Alex Rogério
 */
package Leitor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class LeitoraCsv {
 public BufferedReader br;
    public String line;
    public String caminhoArq;
    public String separador;
    public int qtdColunas;
    public ArrayList<String> arr;
    
    public LeitoraCsv(String caminhoArq, String separador, int qtdColunas) throws FileNotFoundException {
        this.caminhoArq = caminhoArq;
        this.separador = separador;
        this.qtdColunas = qtdColunas;
        this.arr = new ArrayList();
        
        
        this.br = new BufferedReader(new FileReader(caminhoArq));
    }
      
    public ArrayList lerArquivo() throws IOException{
        int cont = 0;
        this.line = "";
        String linhaFormada = "";
        while((line = this.br.readLine()) != null){
            String[] row = line.split(this.separador);
            for(int x = 0; x < this.qtdColunas; x++){
                linhaFormada += row[x] + " "; 
                //System.out.println("Linha: " + x +" Conteudo: " + row[x]);
            }
            
            this.arr.add(linhaFormada);
            linhaFormada = "";
            cont++;
        }
        return arr;
    } 
           
}   

