import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//01618839 - Manuella Jatobá de Figueirêdo
//01618931 - Amanda Kawanne De Oliveira Lima

public class LeituraArquivoFila {

    public static void gravarProdutoLeitura(int codigo, String nome, Double valor, int qtd, int categoria){
        Queue<RegProduto> filaDeProdutos = new LinkedList<>();
        filaDeProdutos.add(new RegProduto(codigo, nome, valor, qtd, categoria));
        System.out.println("Topo: " + filaDeProdutos.peek());
        for (RegProduto produto : filaDeProdutos) {
            System.out.println(produto.produtoInfo());
        }
    }
    public static void main(String[] args) {
        String caminhoArquivo = "C:\\Users\\manue\\projects\\java\\projeto-estrutura-de-dados\\leitura\\Produto.txt";
        int codigo=0;
        String nome;
        String valores;
        double valor=0;
        int qtd = 0;
        int categoria =0;
        double total=0;
        try {
            File arquivo = new File(caminhoArquivo);
            Scanner leitor = new Scanner(arquivo);
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                codigo = Integer.parseInt(linha.substring(0,2));
                nome=linha.substring(3,34);
                valores=linha.substring(36,41);
                valor=Double.parseDouble(valores);
                valor = valor /100;
                qtd=Integer.parseInt(linha.substring(43,45));
                categoria=Integer.parseInt(linha.substring(46,47));
                gravarProdutoLeitura(codigo, nome, valor, qtd, categoria);
                total = total + (valor * qtd);
            }
            System.out.println("O total foi: " + total);
            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + caminhoArquivo);
        }
    }

}
