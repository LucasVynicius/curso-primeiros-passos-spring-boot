package br.com.cursoudemy.produtosapi.controller;

import br.com.cursoudemy.produtosapi.model.Produto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @PostMapping
    public Produto salvarProduto(@RequestBody Produto produto){
        System.out.println("Produto salvo: " + produto);

        return produto;
    }
}
