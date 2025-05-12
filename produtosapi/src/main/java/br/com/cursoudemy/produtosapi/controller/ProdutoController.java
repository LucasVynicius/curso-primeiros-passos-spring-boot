package br.com.cursoudemy.produtosapi.controller;

import br.com.cursoudemy.produtosapi.model.Produto;
import br.com.cursoudemy.produtosapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;


    @PostMapping
    public Produto salvarProduto(@RequestBody Produto produto){
        System.out.println("Produto salvo: " + produto);

        var id = UUID.randomUUID().toString();
        produto.setId(id);

        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable("id") String id){
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletarPorIp(@PathVariable("id") String id){
        produtoRepository.deleteById(id);
    }

    @PutMapping
    public void atualizarProduto(@PathVariable("id") String id, @RequestBody Produto produto){
        produto.setId(id);
        produtoRepository.save(produto);
    }

}
